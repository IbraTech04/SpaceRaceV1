import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Planet2 extends Actor
{
    int damageToPlayer = 2; //Damage to Player 
    int movementSpeed = -2;
    public Planet2(){ //Image and scaling
        GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }

    public void act() 
    {
        move(movementSpeed);    //Movement and collision
        if (getX() == 0){
            setLocation(600,Greenfoot.getRandomNumber(50));
        }
        if (isTouching(Player.class)){
            damagePlayer(damageToPlayer);
            Planet2 newPlanet = new Planet2();
            getWorld().addObject(newPlanet,600,Greenfoot.getRandomNumber(50));
            getWorld().removeObject(this);       
        }
    }    

    void damagePlayer(int damage){ //Function that damages player
        levelOne lo = (levelOne) getWorld();
        Player player = lo.getPlayer();
        player.damage(damage);
    }   
}

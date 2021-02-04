import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Planet1 extends Actor
{
    public int speed = -1; //Planet speed
    int damageToPlayer = 5; //Planet damage to player
    public Planet1(){ //Image and scaling 
        GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }

    public void act() 
    {
        move(-2);  //Movement and collision
        if (getX() == 0){
            setLocation(600,Greenfoot.getRandomNumber(50));
        }
        if (isTouching(Player.class)){
            damagePlayer();
            Planet1 newPlanet = new Planet1();
            getWorld().addObject(newPlanet,600,Greenfoot.getRandomNumber(50));
            getWorld().removeObject(this);  
        }
    }    

    void damagePlayer(){ //Function to damage player
        levelOne lo = (levelOne) getWorld();
        Player player = lo.getPlayer();
        player.damage(damageToPlayer);
    }

}

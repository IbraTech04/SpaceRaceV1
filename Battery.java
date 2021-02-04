import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Battery extends Actor
{
    public int type = 0; //integer that defines type of healable
    public int movementSpeed = -4; //Affects movement speed
    public int[] health = {25,50,35}; //Defines each health given by different healables
    GreenfootImage[] images = {new GreenfootImage("images/wrench.png"),new GreenfootImage("images/toolbox.png"), new GreenfootImage("images/BatteryAsset 3dead.png")}; //Images for each healable
    String[] types = {"wrench","toolbox","battery"};

    public Battery(){ //Chooses heal type randomly
        type = Greenfoot.getRandomNumber(images.length); 
        setImage(images[type]);
    }

    public void act() //movement logic
    {
        move(movementSpeed);
        if (isTouching(Player.class) || getX() == 0){
            if (isTouching(Player.class)){
                addHealth();
                Player.score += 50;
            }
            getWorld().removeObject(this);
        }

    }    

    public void addHealth(){ //Adds health to player
        if(Player.health < 150){
            Player.addHealth(health[type]);
        }
        else{
            Player.invent.add(types[type]);
            PrefLoader.saveInvent(Player.invent);

        }
    }
}

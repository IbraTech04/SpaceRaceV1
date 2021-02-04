import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class L2 extends Actor
{
    static boolean isUnlocked = PrefLoader.level2();
    GreenfootImage[] images = {new GreenfootImage("images/2.png"),new GreenfootImage("images/2lock.png")};

    public L2(){ //level 2 unlocker
        isUnlocked = PrefLoader.level2();
        if (!isUnlocked){
            setImage(images[1]);
        }
    }

    public void act() 
    {
        if (Greenfoot.mousePressed(this) && isUnlocked) //Level 2 button
        {
            Greenfoot.setWorld(new levelTwo());
        }    
    }    
}

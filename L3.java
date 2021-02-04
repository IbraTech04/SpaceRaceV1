import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class L3 extends Actor
{
    static boolean isUnlocked;
    GreenfootImage[] images = {new GreenfootImage("images/3.png"),new GreenfootImage("images/3lock.png")};
    
    public L3(){ //level 3 unlocker
        isUnlocked = PrefLoader.level3();
        if (!isUnlocked){
            setImage(images[1]);
        }
    }

    public void act() 
    {
        if (Greenfoot.mousePressed(this) && isUnlocked) //Level 3 button
        {
            Greenfoot.setWorld(new levelThree());
        }    
    }    
}

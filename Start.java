import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Start extends Actor
{
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) //Start button
        {
            Greenfoot.setWorld(new levelSelect()); //Switch to level select screen
        }    
    }    
}

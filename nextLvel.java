import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class nextLvel extends Actor
{
    public void act() 
    {
        if (Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new levelSelect()); //When pressed, switch to the level select screen
        }
    }    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Controls extends Actor
{
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) //Opens menu that explains controls
        {
            Greenfoot.setWorld(new ControlsScreen());
        }  
    }    
}

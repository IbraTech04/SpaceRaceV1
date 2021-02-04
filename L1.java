import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class L1 extends Actor
{
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) //Level 1 button
        {
            Greenfoot.setWorld(new levelOne());
        }      
    }    
}

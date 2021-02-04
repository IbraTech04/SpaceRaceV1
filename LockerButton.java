import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LockerButton extends Actor
{
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) //locker button
        {
            Greenfoot.setWorld(new Locker());
        } 
    }    
}

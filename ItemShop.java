import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ItemShop extends Actor
{
    public ItemShop(){
    }

    public void act() 
    {
        if (Greenfoot.mousePressed(this)) //locker button
        {
            Greenfoot.setWorld(new Shop());
        }   
    }    
}

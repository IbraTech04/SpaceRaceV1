import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class playAgain extends Actor
{
    public void act() 
    {
        if (Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new mainScreen()); //When pressed, return to main menu
        }
    }    
}

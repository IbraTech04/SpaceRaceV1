import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Back extends Actor
{
    public Back(){ //Sends you back to the main menu
        GreenfootImage image = getImage();
        image.scale(75, 75);
    }

    public void act() 
    {
        if (Greenfoot.mousePressed(this)) //Clickable button
        {
            Greenfoot.setWorld(new mainScreen());
        }       
    }    
}

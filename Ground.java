import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ground extends Actor
{
    GreenfootImage[] grounds = {new GreenfootImage("images/ground.png"),new GreenfootImage("images/groundl2.png"),new GreenfootImage("images/ground3.png")}; //all 3 ground types
 

    public void act() 
    {
        if (getWorld() instanceof levelOne){ //level one ground
            setImage(grounds[0]);
        }

        else if (getWorld() instanceof levelTwo){ //level two ground
            setImage(grounds[1]);
        }
        else {
            setImage(grounds[2]); //level three ground
        }
    }    
}

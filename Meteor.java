import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Meteor extends Actor
{
    int movementSpeed = 3;
    
    public Meteor(){ //meteor image
        GreenfootImage image = getImage();
        image.scale(100, 100);
    }
    
    public void act() 
    {
        setLocation(getX(),getY()+movementSpeed); //meteor speed, damage, and removal
        if (isTouching(Player.class)|| isTouching(Ground.class)){
            if (isTouching(Player.class)){
                Player.damage(7);
            }
            getWorld().removeObject(this);
        }
    }

}

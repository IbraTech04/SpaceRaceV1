import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Ice extends Actor
{
    int movementSpeed = 5;
    public void act() 
    {
        setLocation(getX(),getY()+movementSpeed); //ice speed, damage and removal
        if (isTouching(Player.class)|| isTouching(Ground.class)){
            if (isTouching(Player.class)){
                Player.damage(7);
            }
            getWorld().removeObject(this);
        }    }    
}

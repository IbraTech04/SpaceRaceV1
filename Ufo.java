import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ufo extends Actor
{
    int movementSpeed = -5; //Movement Speed
    public void act() 
    {
        move(movementSpeed); //Movement
        if (isTouching(Player.class) || getX() == 0){ //Collision
            if (isTouching(Player.class)){
                damagePlayer();
            }
            getWorld().removeObject(this);
        }
    }
    public void damagePlayer() { //Functions that damages player
        Player.damage(10);
    }
}

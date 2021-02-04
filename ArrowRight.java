import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class ArrowRight extends Actor
{
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) //Changes player's costume
        {
            Locker l = (Locker) getWorld();
            CopyOfPlayer copyOfPlayer = l.getPlayer();
            copyOfPlayer.changeCostumeRight();
        }  
    }    
}

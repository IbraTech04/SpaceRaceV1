import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class invent extends Actor
{
    //Loading images for all the possible inventory slots
    GreenfootImage[] images = {new GreenfootImage("images/invent.png"),new GreenfootImage("images/inventT.png"), new GreenfootImage("images/inventB.png"),new GreenfootImage("images/inventW.png")};

    public void act() 
    {
        if (Player.invent.size() > 0){ //Image setting
            if (Player.invent.get(0).equals("battery")){
                setImage(images[2]);
            }
            else if(Player.invent.get(0).equals("wrench")){
                setImage(images[3]);
            }
            else if (Player.invent.get(0).equals("toolbox")){
                setImage(images[1]);
            }
        }
        else{
            setImage(images[0]); //If there is nothing in the inventory set the image as blank
        }
    }
}

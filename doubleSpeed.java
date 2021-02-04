import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class doubleSpeed extends Actor
{
    //Images for two possible states: Bought or not bought
    GreenfootImage[] images = {new GreenfootImage("images/For faster Mobility.png"),new GreenfootImage("images/For faster MobilityP.png"), new GreenfootImage("images/BatteryAsset 3dead.png")};
    public static boolean isBought = PrefLoader.getMoreSpeed(); //Loads from text file and returns if player has bought
    public void act() 
    {
        if (isBought){ //Image setting
            setImage(images[1]);
        }
        else{
            setImage(images[0]);  
        }
        if (Greenfoot.mousePressed(this)&&!isBought){ //Purchasing logic
            if (PrefLoader.getCoins() >= 250){
                isBought = true;
                PrefLoader.toRemove = 250;
                PrefLoader.updateFile();
                PrefLoader.updateReadFile();
            }
        }
    }

    public static boolean checkBuyStat(){ //Returns whether player has bought or not
        return isBought;
    }
}

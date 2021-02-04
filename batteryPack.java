import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class batteryPack extends Actor
{
    //Image array that holds the two possible states: Purchased and not purchased
    GreenfootImage[] images = {new GreenfootImage("images/Keep going longer.png"),new GreenfootImage("images/Keep going longerP.png"), new GreenfootImage("images/BatteryAsset 3dead.png")};
    public static boolean isBought = PrefLoader.getMoreBattery(); //Boolean which defines whether user has bought the upgrade

    public void act() 
    {
        if (isBought){ //Image setting
            setImage(images[1]);
        }
        else{
            setImage(images[0]);  
        }
        if (Greenfoot.mousePressed(this) && !isBought){ //Purchasing logic
            if (PrefLoader.getCoins() >= 150){
                isBought = true;
                PrefLoader.toRemove = 150;
                PrefLoader.updateFile();
                PrefLoader.updateReadFile();
            }
        }
    }    

    public static boolean checkBuyStat(){ //Returns whether player has bought this item or not
        return isBought;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Shop extends World
{
    public static GreenfootSound shopMusic = new GreenfootSound("sounds/shop.wav");

    public Shop()
    {    
        super(600, 400, 1); 
        prepare();
    }

    private void prepare(){
        doubleSpeed doubleSpeed = new doubleSpeed(); //Spawning item shop items
        addObject(doubleSpeed,230,326);
        doubleSpeed.setLocation(294,332);
        batteryPack batteryPack = new batteryPack();
        addObject(batteryPack,273,217);
        doubleSpeed.setLocation(258,317);
        doubleSpeed.setLocation(155,336);
        doubleSpeed.setLocation(241,327);
        Back back = new Back(); //Back button
        addObject(back,87,298);
        back.setLocation(50,348);
    }

    public void act(){
        String coins = String.valueOf(PrefLoader.getCoins()); //Returns coin value from file
        showText("Coins: " + coins,300,105); //Shows the amount of coins
        mainScreen.mainMusic.stop(); //Stops main screen music

        if (!shopMusic.isPlaying()){
            shopMusic.play(); //Plays shop music
        }
    }
}

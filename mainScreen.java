import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class mainScreen extends World
{
    public static GreenfootSound mainMusic = new GreenfootSound("sounds/main.wav");

    public mainScreen()
    {    
        super(600, 400, 1); 
        prepare();
    }


    private void prepare()
    {
        Start start = new Start();
        addObject(start,291,164);
        ItemShop itemShop = new ItemShop();
        addObject(itemShop,293,223);
        itemShop.setLocation(291,271);
        LockerButton lockerButton = new LockerButton();
        addObject(lockerButton,291,222);
        mainMusic.setVolume(40);
        start.setLocation(291,135);
        lockerButton.setLocation(291,187);
        itemShop.setLocation(292,237);
        Controls controls = new Controls();
        addObject(controls,291,281);
        highScores highScores = new highScores();
        addObject(highScores,285,318);
    }

    public void act(){
        Shop.shopMusic.stop(); //STops shop music
        Locker.lockerMusic.stop(); //Stops locker music
        if (!mainMusic.isPlaying()){
            mainMusic.playLoop(); //Plays main music
        }
    }
}

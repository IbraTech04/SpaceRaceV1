import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Locker extends World
{
    public static GreenfootSound lockerMusic = new GreenfootSound("sounds/locker.wav");
    /**
     * Constructor for objects of class Locker.
     * 
     */
    CopyOfPlayer copyOfPlayer = new CopyOfPlayer();
    static int costume = PrefLoader.getCostume();
    public Locker()
    {    
        super(600, 400, 1); 
        costume = PrefLoader.getCostume(); //Getting costume from text file
        prepare();
    }

    private void prepare()
    {
        ArrowLeft arrowLeft = new ArrowLeft(); //Left Arrow
        addObject(arrowLeft,46,209);
        ArrowRight arrowRight = new ArrowRight(); //Right Arrow
        addObject(arrowRight,553,205);
        arrowRight.setLocation(549,202);
        Back back = new Back(); //Back Button
        addObject(back,128,295);
        back.setLocation(44,349);
        addObject(copyOfPlayer,327,218); //Costume Preview
        copyOfPlayer.setLocation(280,233);
    }

    public void act(){
        mainScreen.mainMusic.stop(); //Stopping the main music

        if (!lockerMusic.isPlaying()){
            lockerMusic.playLoop(); //Looping the locker music
        }
    }

    public CopyOfPlayer getPlayer()
    {
        return copyOfPlayer; //Function to return player object
    }

    static int getCostume(){
        return CopyOfPlayer.costume; //Function to return the selected costume
    }

    static void updateCostume(int toUpdate){
        costume = toUpdate; //Function to update player costume
    }
}

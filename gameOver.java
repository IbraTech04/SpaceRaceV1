import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class gameOver extends World
{

    /**
     * Constructor for objects of class gameOver.
     * 
     */
    public gameOver()
    {    
        super(600, 400, 1); 
        prepare();
    }

    public void act(){
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        playAgain playAgain = new playAgain(); //Play again button
        addObject(playAgain,311,255); 
        playAgain.setLocation(311,269);
    }
}

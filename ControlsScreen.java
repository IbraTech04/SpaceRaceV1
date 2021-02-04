import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ControlsScreen extends World
{

    /**
     * Constructor for objects of class ControlsScreen.
     * 
     */
    public ControlsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Back back = new Back(); //Spawning Back button
        addObject(back,329,312);
        back.setLocation(57,361);
    }
}

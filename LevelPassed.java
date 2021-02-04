import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelPassed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelPassed extends World
{

    /**
     * Constructor for objects of class LevelPassed.
     * 
     */
    public LevelPassed()
    {    
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        nextLvel nextLvel = new nextLvel(); //Spawning Next Level Button
        addObject(nextLvel,299,243);
    }
}

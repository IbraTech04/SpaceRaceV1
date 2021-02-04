import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class levelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class levelTwo extends World
{
    int timer = 0; //Level Timer
    int meteorTimer = 0; //Timer for meteor 
    int ufoTimer = 0; //Timer for UFO
    int healTimer = 0; //Timer for heals spawning
    int batterySpawnRate = 1100; //Heal spawn rate
    int coinTimer = 0; //Coin Timer
    static boolean isComplete; //Returns whether level is complete
    
    public levelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    Player player = new Player();

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(player,185,196);
        player.setLocation(71,271);
        Ground ground = new Ground();
        addObject(ground,300,360);
        invent invent = new invent();
        addObject(invent,300,375);
    }

    public void act(){  
        showText("Score: " + Player.score,500,10); //Shows Player Score
        showText("Coin: " + Player.money,250,10); //Shows Player Coins
        timer++;
        meteorTimer++;
        healTimer++;
        ufoTimer++;
        coinTimer++;
        if (meteorTimer == 205) { //Spawns Meteors 
            Meteor meteor = new Meteor();
            meteorTimer = 0;
            int temp = Greenfoot.getRandomNumber(300) + 50;
            addObject(meteor,temp, 0);
        }
        if (ufoTimer == 150){ //Spawns UFOs
            Ufo ufo = new Ufo();
            ufoTimer = 0;
            int temp = Greenfoot.getRandomNumber(300) + 50;
            while (temp != player.getY()){
                temp = Greenfoot.getRandomNumber(300) + 50;
            }
            addObject(ufo,600,temp);
        }
        if (coinTimer == 400) { //Spawns coins
            Coin coin = new Coin();
            coinTimer = 0;
            int temp = Greenfoot.getRandomNumber(300) + 50;
            addObject(coin,600,temp);
        }
        if (healTimer == batterySpawnRate){ //Spanws heals
            healTimer = 0;
            Battery battery = new Battery();
            int temp = Greenfoot.getRandomNumber(300) + 50;
            while (temp == player.getY()){
                temp = Greenfoot.getRandomNumber(300) + 50;
            }
            addObject(battery,600,temp);
        }
        if (timer == 5000){ //Ends the level
            Player.score+=500;
            isComplete = true;
            PrefLoader.updateFile(true,true);
            PrefLoader.updateReadFile();
            endFlag endFlag = new endFlag();
            addObject(endFlag,600,200);
        }
    }

    public Player getPlayer() //Returns player
    {
        return player;
    }

    public static boolean isCompleted(){ //REturns whether level is completed
        return isComplete;
    }
}

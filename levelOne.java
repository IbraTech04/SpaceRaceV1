import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class levelOne extends World
{
    int timer = 0; //Level timer
    int healTimer = 0; //Heals timer
    int batterySpawnRate = 1000; //Spawn rate for healables 
    int ufoTimer = 0; //Timer for UFOs
    int coinTimer = 0; //Timer for coins
    static boolean isComplete = false; //Whether the level is completed

    public static boolean spawnBattery = false;
    public levelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        Player.score = 0;
    }

    Player player = new Player(); //Spawns player

    public void prepare()
    {
        addObject(player,141,252);
        player.setLocation(85,273);
        player.setLocation(113,278);
        Planet1 planet1 = new Planet1();
        addObject(planet1,217,107);
        planet1.setLocation(88,64);
        Planet2 planet2 = new Planet2();
        addObject(planet2,541,48);
        planet2.setLocation(495,44);
        Ground ground = new Ground();
        addObject(ground,300,359);
        invent invent = new invent();
        addObject(invent,300,375);
    }

    public void act(){
        showText("Score: " + Player.score,500,10); //Displayes player score
        showText("Coin: " + Player.money,250,10); //Shows player coins
        timer++; 
        healTimer++;
        ufoTimer++;
        coinTimer++;
        if (healTimer == batterySpawnRate){ //Spawns heals
            healTimer = 0;
            Battery battery = new Battery();
            int temp = Greenfoot.getRandomNumber(300) + 50;
            while (temp == player.getY()){
                temp = Greenfoot.getRandomNumber(300) + 50;
            }
            addObject(battery,600,temp);
        }
        if (ufoTimer == 750) { //Spwans UFOs
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
        if (timer == 5000){ //Ends the level
            isComplete = true;
            PrefLoader.updateFile();
            PrefLoader.updateReadFile();
            endFlag endFlag = new endFlag();
            Player.score+=500;
            addObject(endFlag,600,200);
        }
    }

    public Player getPlayer() //Returns Player
    {
        return player;
    }

    public static boolean isCompleted(){ //Returns whether level is complete or not
        return isComplete;
    }
    
}


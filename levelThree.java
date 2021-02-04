import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class levelThree extends World
{
    int timer = 0; //Level Timer
    int iceTimer = 0; //Timer for ice pellets
    int ufoTimer = 0; //Timer for UFO
    int healTimer = 0; //Timer for heals spawning
    int batterySpawnRate = 175; //Heal spawn rate
    int coinTimer = 0; //Coin Timer
    Player player = new Player();

    public levelThree()
    {    
        super(600, 400, 1); 
        prepare();
    }

    public void prepare(){
        Ground ground = new Ground();
        addObject(ground,300,375);
        addObject(player,208,200);
        player.setLocation(65,285);
        invent invent = new invent();
        addObject(invent,300,375);
    }

    public void act(){
        showText("Score: " + Player.score,500,10); //Shows player score
        showText("Coin: " + Player.money,250,10); //Shows player coins
        iceTimer++;
        ufoTimer++;
        healTimer++;
        coinTimer++;
        timer++;
        if (iceTimer == 100){ //Spans ice
            Ice ice = new Ice();
            iceTimer = 0;
            int temp = Greenfoot.getRandomNumber(300) + 50;
            addObject(ice,temp, 0);
        }
        if (ufoTimer == 150){ //Spawns UFO
            Ufo ufo = new Ufo();
            ufoTimer = 0;
            int temp = Greenfoot.getRandomNumber(300) + 50;
            while (temp != player.getY()){
                temp = Greenfoot.getRandomNumber(300) + 50;
            }
            addObject(ufo,600,temp);
        }
        if (coinTimer == 400) {
            Coin coin = new Coin();
            coinTimer = 0;
            int temp = Greenfoot.getRandomNumber(300) + 50;
            addObject(coin,600,temp);
        }
        if (healTimer == batterySpawnRate){ //Spawns batteries
            healTimer = 0;
            Battery battery = new Battery();
            int temp = Greenfoot.getRandomNumber(300) + 50;
            while (temp == player.getY()){
                temp = Greenfoot.getRandomNumber(300) + 50;
            }
            addObject(battery,600,temp);
        }
        if (timer == 5000){ //Ends the level
            PrefLoader.updateFile(true,true);
            PrefLoader.updateReadFile();
            endFlag endFlag = new endFlag();
            addObject(endFlag,600,200);
            Player.score+=500;
            PrefLoader.sortHighScores();
            Player.score = 0;
        }
    }
}

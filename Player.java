import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Player extends Actor
{
    static int health = 100;
    boolean gameIsOver = false;
    boolean isPlaying = false;
    static int money = PrefLoader.getCoins();
    static int costume = Locker.getCostume();
    int vspeed = 0;
    int acceleration = 1;
    int jumpHeight = -17;
    int movementSpeed = 3;
    static int score = 0; //Score variable
    //Arrays for costumes
    GreenfootImage[] black = {new GreenfootImage("images/yellow.png"),new GreenfootImage("images/red.png"), new GreenfootImage("images/green.png"), new GreenfootImage("images/nopower.png")};
    GreenfootImage[] red = {new GreenfootImage("images/red2.png"),new GreenfootImage("images/red3.png"), new GreenfootImage("images/red1.png"), new GreenfootImage("images/red4.png")};
    GreenfootImage[] green = {new GreenfootImage("images/green2.png"),new GreenfootImage("images/red.png"), new GreenfootImage("images/green1.png"), new GreenfootImage("images/green4.png")};
    GreenfootImage[] blue = {new GreenfootImage("images/blue2.png"),new GreenfootImage("images/blue3.png"), new GreenfootImage("images/blue1.png"), new GreenfootImage("images/blue4.png")};

    static ArrayList<String> invent = PrefLoader.loadFile("saves/invent.txt"); //Loading inventory 
    //Sounds
    public static GreenfootSound gameOver = new GreenfootSound("sounds/gameOver.wav");

    GreenfootImage[][] robotImages = {black,red,green,blue}; //Array within an array for costumes
    public Player(){
        invent = PrefLoader.loadFile("saves/invent.txt"); //Loading inventory
        health = 100; //Setting health
        GreenfootImage image = getImage(); //Image and scaling
        image.scale(100, 100);
        for (int i = 0; i < robotImages.length; i++){
            for (int j = 0; j < black.length; j++){
                robotImages[i][j].scale(100, 100);
            }
        }
        costume = Locker.getCostume(); //Setting costume
        if (PrefLoader.getMoreSpeed()){ //Upgrade settings
            movementSpeed = 6;
            jumpHeight = -20;
        }
        if (PrefLoader.getMoreBattery()){
            health = 150;
        }
    }

    public void act() 
    {
        if (gameIsOver){
            mainScreen.mainMusic.stop();
            if (!isPlaying){
                isPlaying = true;
                gameOver.play();
            }
            Greenfoot.setWorld(new gameOver());
        }
        else{
            getWorld().showText("Health: " + health,50,10);
            if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("W")){
                if (onGround() == true) {
                    GreenfootSound jump = new GreenfootSound("sounds/jump.wav");
                    jump.setVolume(80); //Changing music volume
                    jump.play();
                    vspeed = jumpHeight;
                    fall();
                }
            }
            if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("A")){
                setLocation(getX()-movementSpeed,getY());
            }
            if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D")){
                setLocation(getX()+movementSpeed,getY());
            }
            if ((Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("down")) && !onGround()){
                vspeed = 35;
            }
            if (Greenfoot.isKeyDown("space") && invent.size() > 0 && health < 150){
                useItem();
                PrefLoader.saveInvent(invent);
                GreenfootSound oneUp = new GreenfootSound("sounds/1up.wav"); //Sound played when player contacts a healable
                oneUp.play();
                if (health > 150){
                    health = 150;
                }
                Greenfoot.delay(2);
            }
            if (health <=0){
                gameIsOver = true;
                setImage(robotImages[costume][3]);
            }
            else if (health <= 25){
                setImage(robotImages[costume][1]);
            }
            else if (health <= 50){
                setImage(robotImages[costume][0]);
            }
            else{
                setImage(robotImages[costume][2]);
            }
            if (isTouching(endFlag.class)){
                Greenfoot.setWorld(new LevelPassed());
            }
            checkFalling();
        }    
    }

    public void useItem(){ //Uses an item in the inventory
        if (invent.get(0).equals("battery")){
            health+=35;
            invent.remove(0);
        } else if (invent.get(0).equals("wrench")){
            health+=25;
            invent.remove(0);
        } else if (invent.get(0).equals("toolbox")){
            health+=50;
            invent.remove(0);
        }
    }

    static void damage(int toRemove){ //Damages the player
        health -=toRemove;
    }

    void fall() { //Funtion that makes the player fall
        setLocation(getX(), getY() + vspeed);
        vspeed += acceleration;
    }

    boolean onGround() { //Checks to see if player is on ground
        Actor under = getOneObjectAtOffset(0,getImage().getHeight()/2,Ground.class);
        return under != null;
    }

    public void checkFalling() { //Checks if the player is falling. If so, it calls the fall function
        if (onGround() == false){
            fall();
        }
    }

    static void addHealth(int healthToAdd){ //Adds to player health
        health += healthToAdd;
        if (health > 150){
            health = 150;
        }
        else{
            GreenfootSound oneUp = new GreenfootSound("sounds/1up.wav"); //Sound played when player contacts a healable
            oneUp.play();
        }
    }

    public static int getCoins(){ //Returns player coins
        return money;
    }

    public static void upgradeBought(int toRemove){ //Removes from coins (for when upgrades are bought)
        money-=toRemove;
    }
}
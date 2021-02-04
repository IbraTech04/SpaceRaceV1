import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Coin extends Actor
{
    GreenfootImage[] images = {new GreenfootImage("images/starCoin.png"),new GreenfootImage("images/coin.png"), new GreenfootImage("images/megaCoin.png")}; //Coin images
    int[] speed = {-5,-7,-4}; //different coin speeds
    int type; //coin type
    int[] toAdd = {5,10,1}; //Value of different coins
    public Coin(){ //Randomly spawns different coins
        type = Greenfoot.getRandomNumber(images.length);
        setImage(images[type]);
    }

    public void act() //Changes amount of coins the player has
    {
        move(speed[type]);
        if (isTouching(Player.class) || getX() == 0){
            if (isTouching(Player.class)){
                addCoins();
                Player.score += 5;
                if (PrefLoader.level3()){
                    PrefLoader.updateFile(true,true);
                }
                else if (PrefLoader.level2()){
                    PrefLoader.updateFile(true,false);
                }
                else{
                    PrefLoader.updateFile();
                }
            }
            getWorld().removeObject(this);
        }
    }

    public void addCoins() { //adds coins to the player balance
        Player.money += toAdd[type];
    }
}    


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class CopyOfPlayer extends Actor
{
    static int costume= PrefLoader.getCostume(); //Gets costume from text file
    //Arrays with all the costumes
    GreenfootImage[] black = {new GreenfootImage("images/yellow.png"),new GreenfootImage("images/red.png"), new GreenfootImage("images/green.png"), new GreenfootImage("images/nopower.png")}; //Black Robot costume
    GreenfootImage[] red = {new GreenfootImage("images/red2.png"),new GreenfootImage("images/red3.png"), new GreenfootImage("images/red1.png"), new GreenfootImage("images/red4.png")}; //red robot costume
    GreenfootImage[] green = {new GreenfootImage("images/green2.png"),new GreenfootImage("images/red.png"), new GreenfootImage("images/green1.png"), new GreenfootImage("images/green4.png")}; //green robot costume
    GreenfootImage[] blue = {new GreenfootImage("images/blue2.png"),new GreenfootImage("images/blue3.png"), new GreenfootImage("images/blue1.png"), new GreenfootImage("images/blue4.png")}; //blue robot costume
    Shop theShop = new Shop(); //Shop World
    GreenfootImage[][] robotImages = {black,red,green,blue}; //Array within an array
    public CopyOfPlayer(){ //Loads and scales the images
        for (int i = 0; i < robotImages.length; i++){
            for (int j = 0; j < black.length; j++){
                robotImages[i][j].scale(300, 300);
            }
        }
        costume = PrefLoader.getCostume(); //Sets costume according to file
        setImage(robotImages[costume][2]);
    }

    public void act() 
    {
        setImage(robotImages[costume][2]); 
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){ //moves left and right in locker screen
            changeCostumeLeft();
        }
        else if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            changeCostumeRight();
        }
    }

    public void changeCostumeLeft(){ //changes to the robot on the left
        if(costume == 0){
            costume = 3;
        }
        else{
            costume--;
        }
        Locker.updateCostume(costume);
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

    public void changeCostumeRight(){ //changes to the robot on the right
        if(costume == 3){
            costume = 0;
        }
        else{
            costume ++;
        }
        Locker.updateCostume(costume);
        PrefLoader.updateFile();

    }
}

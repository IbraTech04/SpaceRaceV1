import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class highScoreScreen extends World
{
    String[] highScores = new String[10]; //Loads from file and holds highscore values

    public highScoreScreen()
    {    
        super(600, 400, 1); 
        prepare();
        highScores = PrefLoader.loadFile("saves/hs.txt").toArray(highScores);

    }

    private void prepare()
    {
        Back back = new Back(); //Back button
        addObject(back,226,278);
        back.setLocation(55,364);
    }

    public void act(){
        for (int i = 0; i < 10; i++){
            int num = i+1;
            showText(String.valueOf(num) + " : " + highScores[i],250,i*30 + 100); //Displays scores
        }
    }
}

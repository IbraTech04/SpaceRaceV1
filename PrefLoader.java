import greenfoot.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PrefLoader extends World
{
    List<String> saveData = new ArrayList<String>(); //Save data arraylist
    static String[] saves;
    public static int toRemove; //Integer used for the shop
    public PrefLoader()
    {    
        super(600, 400, 1); 
    }

    public void act(){ //Initalizes the world and loads initial data
        saves = new String[3];
        saves = loadFile("saves/save.txt").toArray(saves);
        Greenfoot.setWorld(new mainScreen());   
    }

    public static void updateReadFile(){ //Updates the data in memory
        saves = new String[3];
        saves = loadFile("saves/save.txt").toArray(saves);
    }

    public static java.util.ArrayList<String> loadFile(String filename) { //Function to load files from a specified file location
        ArrayList<String> fileText = new ArrayList<String>();
        BufferedReader saveFile = null;
        try {
            saveFile = new BufferedReader(new FileReader(filename));
            String input;
            while ((input = saveFile.readLine()) != null) {
                fileText.add(input);
            }
        }
        catch (FileNotFoundException fnfe) {
            return null;
        }
        catch (IOException ioe) {
            return null;
        }
        finally {
            try {
                saveFile.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (NullPointerException npe) {
            }
        }
        return fileText;
    }

    public static void updateFile() { //Function to update the save file
        BufferedWriter saveFile = null;
        try {
            saveFile = new BufferedWriter(new FileWriter("saves/save.txt"));
            saveFile.write("SpaceRaceV1.0 Save File");
            saveFile.write('\n');
            saveFile.write("Costume:" + Locker.getCostume());
            saveFile.write('\n');
            saveFile.write("Coins:" + (Player.getCoins() - toRemove));
            saveFile.write('\n');
            Shop tempShop = new Shop();
            saveFile.write("morePower:" + batteryPack.checkBuyStat());
            saveFile.write('\n');
            saveFile.write("moreSpeed:" + doubleSpeed.checkBuyStat());
            saveFile.write('\n');
            saveFile.write("level2unlock:" + levelOne.isCompleted());
            saveFile.write('\n');
            saveFile.write("level3unlock:" + levelTwo.isCompleted());
            saveFile.close();
            loadFile("saves/save.txt");

        }
        catch (IOException ioe) {
        }
    }

    public static void updateFile(boolean a, boolean b) { //Function to update the text file
        BufferedWriter saveFile = null;
        try {
            saveFile = new BufferedWriter(new FileWriter("saves/save.txt"));
            saveFile.write("SpaceRaceV1.0 Save File");
            saveFile.write('\n');
            saveFile.write("Costume:" + Locker.getCostume());
            saveFile.write('\n');
            saveFile.write("Coins:" + (Player.getCoins() - toRemove));
            saveFile.write('\n');
            Shop tempShop = new Shop();
            saveFile.write("morePower:" + batteryPack.checkBuyStat());
            saveFile.write('\n');
            saveFile.write("moreSpeed:" + doubleSpeed.checkBuyStat());
            saveFile.write('\n');
            saveFile.write("level2unlock:" + a);
            saveFile.write('\n');
            saveFile.write("level3unlock:" + b);
            saveFile.close();
            loadFile("saves/save.txt");

        }
        catch (IOException ioe) {
        }
    }

    public static void saveInvent(java.util.List<String> fileText) { //Function to save player inventory
        BufferedWriter file = null;
        try {
            file = new BufferedWriter(new FileWriter("saves/invent.txt"));

            for (String output : fileText) {
                file.write(output);
                file.write('\n');
            }
            file.close();
        }
        catch (IOException ioe) {
        }
        finally {
            try {
                file.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (NullPointerException npe) {
            }
        }
    }

    public static void saveHighScores(int[] fileText) { //Function to save player leaderboards
        BufferedWriter file = null;
        try {
            file = new BufferedWriter(new FileWriter("saves/hs.txt"));

            for (int i = 0; i < 10; i++) {
                file.write(String.valueOf(fileText[i]));
                file.write('\n');
            }
            file.close();
        }
        catch (IOException ioe) {
        }
        finally {
            try {
                file.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (NullPointerException npe) {
            }
        }
    }

    static int getCostume(){ //Returns player costume from file
        String[] temp = saves[1].split(":");
        int toReturn = Integer.parseInt(temp[1]);
        return toReturn;
    }

    static int getCoins(){ //Returns player coins from files
        String[] temp = saves[2].split(":");
        int toReturn = Integer.parseInt(temp[1]);
        return toReturn;
    }

    static boolean getMoreBattery(){ //Returns whether player has purchased battery upgrade
        String[] temp = saves[3].split(":");
        String toReturn = temp[1];
        return toReturn.equals("true");
    }

    static boolean getMoreSpeed(){ //Returns whether player has purchased speed update
        String[] temp = saves[4].split(":");
        String toReturn = temp[1];
        return toReturn.equals("true");
    }

    static boolean level2(){ //Returns whether player has unlocked level 2
        String[] temp = saves[5].split(":");
        String toReturn = temp[1];
        return toReturn.equals("true");
    }

    static boolean level3(){//Returns whether player has unlocked level 3
        String[] temp = saves[6].split(":");
        String toReturn = temp[1];
        return toReturn.equals("true");
    }

    public static void sortHighScores(){ //Function to update and sort high scores
        String[] highScores = new String[10];
        highScores = loadFile("saves/hs.txt").toArray(highScores);
        int[] finalHighScores = new int[11];
        for (int i = 0; i < 10; i++){
            finalHighScores[i] = Integer.parseInt(highScores[i]);
        }
        finalHighScores[10] = Player.score;

        Arrays.sort(finalHighScores);
        
        for(int i = 0; i < finalHighScores.length / 2; i++)
        {
            int temp = finalHighScores[i];
            finalHighScores[i] = finalHighScores[finalHighScores.length - i - 1];
            finalHighScores[finalHighScores.length - i - 1] = temp;
        }
        saveHighScores(finalHighScores);
    }
}

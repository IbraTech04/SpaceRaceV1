import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class levelSelect extends World
{

    public levelSelect()
    {    
        super(600, 400, 1); 
        prepare();
    }

    private void prepare()
    {
        Back back = new Back(); //Back button
        addObject(back,114,302);
        back.setLocation(53,356);
        L1 l1 = new L1(); //Level select buttons
        addObject(l1,99,225);
        l1.setLocation(92,219);
        L2 l2 = new L2();
        addObject(l2,294,218);
        L3 l3 = new L3();
        addObject(l3,514,214);
        L2.isUnlocked = PrefLoader.level2(); //Loads whether level is complete from files
        L3.isUnlocked = PrefLoader.level3();
    }

    public void act(){
    }
}

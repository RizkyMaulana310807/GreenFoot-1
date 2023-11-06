import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author (Rizky Maulana) 
 * @version (a version number or a date)
 */
public class RobotWorld extends World
{
    private int currentMaxTurnSpeed = 2;
    private int currentLevel = 1;
    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        gameDiMulai();
        prepare();
    }

    public void setUpLevel(){
        if(currentLevel == 2){
            addObject(new Block(currentMaxTurnSpeed), 571, 348);
            addObject(new Pizza(), 433, 38);
            addObject(new Pizza(), 183, 302);
            addObject(new Pizza(), 682, 312);
            addObject(new Pizza(), 417, 537);
            addObject(new Pizza(), 720, 46);
            addObject(new heart(), 171, 575);
            addObject(new heart(), 764, 42);
        } else if(currentLevel == 3){
            currentMaxTurnSpeed++;
            addObject(new Block(currentMaxTurnSpeed), 571, 348);
            addObject(new Pizza(), 433, 38);
            addObject(new Pizza(), 183, 302);
            addObject(new Pizza(), 682, 312);
            addObject(new Pizza(), 417, 537);
            addObject(new Pizza(), 720, 46);
            addObject(new heart(), 171, 575);
            addObject(new heart(), 764, 42);
        } else if(currentLevel == 4){
            currentMaxTurnSpeed++;
            addObject(new Block(currentMaxTurnSpeed), 571, 348);
            addObject(new Pizza(), 433, 38);
            addObject(new Pizza(), 183, 302);
            addObject(new Pizza(), 682, 312);
            addObject(new Pizza(), 417, 537);
            addObject(new Pizza(), 720, 46);
            addObject(new heart(), 171, 575);
            addObject(new heart(), 764, 42);
        }
    }

    public void increaseLevel(){
        currentLevel++;
        setUpLevel();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void gameDiMulai()
    {
        addObject(new Robot(), 48, 50);
        addObject(new Wall(), 52, 147);
        addObject(new Wall(), 159, 147);
        addObject(new Wall(), 266, 147);
        addObject(new Wall(), 587, 147);
        addObject(new Wall(), 692, 147);
        addObject(new Wall(), 791, 146);
        addObject(new Wall(), 54, 413);
        addObject(new Wall(), 367, 414);
        addObject(new Block(2), 427, 132);
        addObject(new Block(3), 210,410);
        addObject(new Home(), 751, 552);
        addObject(new Scorepanel(), 71, 554);
        addObject(new Pizza(), 720, 46);
        addObject(new Pizza(), 433, 38);
        addObject(new Pizza(), 183, 302);
        addObject(new Pizza(), 682, 312);
        addObject(new Pizza(), 417, 537);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}

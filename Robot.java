import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage robotimage1;
    private GreenfootImage robotimage2;
    private GreenfootImage gameoverimage;
    private int lives;
    private int score;
    private int pizzaEaten;
    private int animateCounter;
    private int timer;
    private final int MAXTIMER = 1000;
    public Robot(){
        robotimage1 = new GreenfootImage("man01.png");
        robotimage2 = new GreenfootImage("man02.png");
        gameoverimage = new GreenfootImage("gameover.png");
        lives = 3;
        score = 0;
        pizzaEaten = 0;
        animateCounter = 0;
        timer = MAXTIMER;
    }
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        robotMovement();
        detectWallCollision();
        detectBlockCollision();
        detectHome();
        eatPizza();
        showStatus();
        updateTimer();
        eatHeart();
    }
    public void updateTimer(){
        timer--;
        getWorld().showText("Timer Left : "+timer, 70, 580);
        if(timer < 1){
            removeLife();
            resetTimer();
        }
    }
    public void resetTimer(){
        timer = MAXTIMER;
    }
    public void resetPosition(){
        setLocation(48, 50);
    }

    public void showStatus(){
        getWorld().showText("Lives : " + lives, 70, 540);
        getWorld().showText("Score : " + score, 70, 560);
    }
    public void increaseScore(){
        score++;
        showStatus();
    }
    public void removeLife(){
        lives--;
        testEndGame();
        showStatus();
        resetPosition();
    }
    
    public void testEndGame(){
        if(lives <= 0){
            setImage(gameoverimage);
            Greenfoot.stop();
        }
    }
    
    public void animate(){
        animateCounter++;
        if(animateCounter > 5){
            animateCounter = 0;
            if(getImage() == robotimage1){
                setImage(robotimage2);
                Greenfoot.playSound("walk.wav");
            } else{
                setImage(robotimage1);
            }
        }
    }
    
    public void eatPizza(){
        if(isTouching(Pizza.class)){
        Greenfoot.playSound("eat.wav");
        removeTouching(Pizza.class);
        pizzaEaten++;
        increaseScore();
        timer += 200;
        }
    }
    public void eatHeart(){
         if(isTouching(heart.class)){
            Greenfoot.playSound("eat.wav");
            removeTouching(heart.class);
            lives++;        
            showStatus();
            }
    }
    public void detectHome(){
        if(pizzaEaten == 5 && isTouching(Home.class)){
        Greenfoot.playSound("yippie.wav");
        //setLocation(48, 50);
        pizzaEaten = 0;
        increaseScore();

        RobotWorld myworld = (RobotWorld)getWorld();
        myworld.increaseLevel();
        resetTimer();
        resetPosition();
    }
    }
    
    public void detectBlockCollision(){
        if(isTouching(Block.class)){
            Greenfoot.playSound("hurt.wav");
            //setLocation(48, 50);
            removeLife();
        }
    }
    
    public void detectWallCollision(){
        if(isTouching(Wall.class)){
        Greenfoot.playSound("hurt.wav");
        //setLocation(48, 50);
        removeLife();
        }
    }
    
    public void robotMovement()
    {
        if(Greenfoot.isKeyDown("right")){
        setLocation(getX()+3,getY());
        animate();
        }
        if(Greenfoot.isKeyDown("left"))
        {
        setLocation(getX()-3,getY());
        animate();
        }
        if(Greenfoot.isKeyDown("down"))
        {
        setLocation(getX(),getY()+3);
        animate();
        }
        if(Greenfoot.isKeyDown("up"))
        {
        setLocation(getX(),getY()-3);
        animate();
        }
    }
}

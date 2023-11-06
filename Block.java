import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    private int turnspeed;
    
        public Block(int maxturnspeed){
        turnspeed = Greenfoot.getRandomNumber(2*maxturnspeed)-(maxturnspeed);
        if(turnspeed == 0){
            turnspeed = 1;
        }
    }
    
    public void act()
    {
        turn(turnspeed);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StoneT2 extends Actor implements Runnable //setrotation
{
    private MyWorld world;
    
    public StoneT2(MyWorld world){
        this.world = world;
    }
    
    public void run()
    {
        while(true){
            world.checkForStone();
        }
    }
}

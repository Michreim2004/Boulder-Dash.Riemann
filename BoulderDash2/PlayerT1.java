import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayerT1 extends Actor implements Runnable //setRotation
{
    private MyWorld world;
    
    public PlayerT1(MyWorld world){
        this.world = world;
    }
    
    public void run()
    {
        while(true){
            world.movePlayer();
            //world.schieben();
            world.grab();
            //world.white();
            Greenfoot.delay(2);
            //world.reset();
        }
    }
}

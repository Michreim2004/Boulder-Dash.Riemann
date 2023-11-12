import greenfoot.GreenfootImage;

public class StoneMover implements Runnable 
{
    //private GreenfootImage img;
    private MyWorld world; 

    public StoneMover()
    {
        
    }

    public void run(){
        while(true){
            world.checkForStone();
            try {
                Thread.sleep(18);
            } catch (Exception e) {
                break;
            }
        }
    }
}
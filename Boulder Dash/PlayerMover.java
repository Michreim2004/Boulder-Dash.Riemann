import greenfoot.GreenfootImage;

public class PlayerMover implements Runnable 
{
    //private GreenfootImage img;
    private MyWorld world;//new...
    

    public PlayerMover()
    {
        
    }

    public void run(){
        while(true){
            world.movePlayer();
            try {
                Thread.sleep(18);
            } catch (Exception e) {
                break;
            }
        }
    }
}

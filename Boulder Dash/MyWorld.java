import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(608, 400, 1); 
        //Player player = new Player();
        //addObject(player, 94, 94);
        
        //Erde erde = new Erde();
        //addObject(erde,erde.getImage().getWidth(),erde.getImage().getHeight());
        
        Erde[][] erde = new Erde[30][20];
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 20; y++) {
                erde[x][y] = new Erde();
                addObject(erde[x][y], x * 21+10, y * 21+11);
            }
        }
        
        for(int i=0;i<23;i++){
            Wand wand = new Wand();
            addObject(wand, i * wand.getImage().getWidth()+10, 114);
        }
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);
    }
    
    public void act() {
        
    }
}

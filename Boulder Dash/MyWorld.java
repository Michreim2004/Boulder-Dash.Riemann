import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{
    GreenfootImage w = new GreenfootImage("wall.png");
    GreenfootImage p = new GreenfootImage("PLAYER.png");
    GreenfootImage s = new GreenfootImage("stone.png");
    GreenfootImage e = new GreenfootImage("ground.png");
    GreenfootImage b = new GreenfootImage("blank.png");
    GreenfootImage g = new GreenfootImage("gold.png");
    GreenfootImage c = new GreenfootImage("crystal.png");
    GreenfootImage end = new GreenfootImage("portal.png");
    GreenfootImage bot = new GreenfootImage("bot.png");
    private GreenfootImage[][] images ={
        {e,e,e,e,e,e,e,s,e,e,e,b,e,e,e,s,e,s,e,e,e,e,b,e,e,s,e,e,e},
        {e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,c,s,e,e,e,e,e,b,e,e,e,b,e},
        {e,e,e,p,e,e,e,e,e,e,e,e,e,e,e,e,s,e,e,e,e,e,e,e,e,s,e,e,e},
        {e,e,e,e,e,e,e,e,e,s,e,e,e,b,b,e,e,e,e,e,e,s,e,e,s,e,e,e,b},
        {e,e,e,e,e,e,e,e,e,s,s,e,e,s,s,s,e,e,e,s,e,e,e,e,e,s,e,s,e},
        {s,e,e,e,b,b,e,e,e,e,e,s,e,e,e,s,e,s,e,e,e,e,e,e,e,s,e,s,s},
        {w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,e,e,e,e,e,s,e,e,s},
        {e,e,e,s,s,e,e,e,e,e,s,e,e,s,e,e,e,e,e,e,e,e,e,e,e,e,e,e,s},
        {e,e,e,e,c,e,e,e,e,e,e,e,e,e,e,e,e,s,e,s,c,b,e,e,e,e,e,e,e},
        {e,e,b,e,s,e,e,e,e,e,e,e,e,e,e,e,e,s,e,s,s,e,e,e,e,e,e,e,e},
        {e,e,s,e,s,e,e,b,b,e,s,s,e,e,e,e,e,s,e,e,e,e,e,c,e,e,e,b,e},
        {e,e,e,s,e,e,e,e,e,e,s,e,s,e,e,e,e,e,e,e,e,e,e,s,e,e,e,s,e},
        {e,e,e,s,e,e,e,e,e,e,e,s,s,s,e,e,e,e,e,e,e,e,e,e,e,e,e,e,s},
        {b,b,e,e,e,e,e,e,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w},
        {s,b,e,e,e,e,e,e,e,e,b,c,e,s,e,e,e,s,e,e,e,e,s,e,e,b,e,e,e},
        {c,s,e,e,e,e,e,e,e,e,s,s,e,e,e,e,e,e,b,b,e,e,e,s,e,s,e,e,e},
        {e,e,e,e,s,e,e,e,e,e,e,e,s,e,e,e,e,e,s,e,s,c,e,e,e,e,e,e,e},
        {e,e,e,e,s,c,b,e,e,e,e,e,s,e,s,s,e,e,s,e,s,c,e,e,e,e,end,e,e},
        {e,c,e,e,e,e,s,e,e,e,e,e,e,e,e,e,e,e,s,e,e,c,e,e,e,e,e,e,e},
    };
    
    public MyWorld()
    {    
        super(608, 399, 1); 
        int x=0;
        int y=0;
        for(int j=0;j<images.length;j++){
            for(int i=0;i<29;i++){ //oder bis images[j].length
                    getBackground().drawImage(images[j][i],x,y);
                    x = x+21;
                }
            y += 21;
            x = 0;
        }
        
        //setBackground(..);für evtl. lvl. 2
    }
    
    public void act() {
        
    }
}

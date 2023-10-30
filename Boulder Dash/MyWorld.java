import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{
    GreenfootImage w = new GreenfootImage("wall.png");
    GreenfootImage p = new GreenfootImage("PLAYER.png");
    GreenfootImage s = new GreenfootImage("stone.png");
    GreenfootImage e = new GreenfootImage("ground.png");
    GreenfootImage b = new GreenfootImage("blank.png");
    private GreenfootImage[][] images ={
        {e,e,e,e,e,e,e,s,e,e,e,b,e,e,e,s,e,s,e,e,e,e,b,e,e,s,e,e,e},
        {e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,s,e,e,e,e,e,b,e,e,e,b,e},
        {e,e,e,p,e,e,e,e,e,e,e,e,e,e,e,e,s,e,e,e,e,e,e,e,e,s,e,e,e},
        {e,e,e,e,e,e,e,e,e,s,e,e,e,b,b,e,e,e,e,e,e,s,e,e,s,e,e,e,b},
        {e,e,e,e,e,e,e,e,e,s,s,e,e,s,s,s,e,e,e,s,e,e,e,e,e,s,e,s,e},
        {s,e,e,e,b,b,e,e,e,e,e,s,e,e,e,s,b,s,e,e,e,e,e,e,e,s,e,s,s},
        {w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,e,e,e,e,e,s,e,e,s},
        {e,e,e,s,s,e,e,e,e,e,s,e,e,s,e,e,e,e,e,e,e,e,e,e,e,e,e,e,s},
        {e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,s,e,s,b,b,e,e,e,e,e,e,e},
        {e,e,b,e,s,e,e,e,e,e,e,e,e,e,e,e,e,s,e,s,s,e,e,e,e,e,e,e,e},
        {e,e,s,e,s,e,e,b,b,e,s,s,e,e,e,e,e,s,e,e,e,e,e,e,e,e,e,b,e},
        {e,e,e,s,e,e,e,e,e,e,s,e,s,e,e,e,e,e,e,e,e,e,e,s,e,e,e,s,e},
        {e,e,e,s,e,e,e,e,e,e,e,s,s,s,e,e,e,e,e,e,e,e,e,e,e,e,e,e,s},
        {b,b,e,e,e,e,e,e,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w},
        {s,b,e,e,e,e,e,e,e,e,b,e,e,s,e,e,e,s,e,e,e,e,s,e,e,b,e,e,e},
        {e,s,e,e,e,e,e,e,e,e,s,s,e,e,e,e,e,e,b,b,e,e,e,s,e,s,e,e,e},
        {e,e,e,e,s,e,e,e,e,e,e,e,s,e,e,e,e,e,s,e,s,e,e,e,e,e,e,e,e},
        {e,e,e,e,s,e,b,e,e,e,e,e,s,e,s,s,e,e,s,e,s,e,e,e,e,e,e,e,e},
        {e,e,e,e,e,e,s,e,e,e,e,e,e,e,e,e,e,e,s,e,e,e,e,e,e,e,e,e,e},
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
        
        //Player player = new Player();
        //addObject(player, 94, 94);
        
        //Erde erde = new Erde();
        //addObject(erde,erde.getImage().getWidth(),erde.getImage().getHeight());
        
        /*Erde[][] erde = new Erde[30][20];
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 20; y++) {
                erde[x][y] = new Erde();
                addObject(erde[x][y], x * 21+10, y * 21+11);
            }
        }
        
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.fill();
        setBackground(bg);*/
    }
    
    public void act() {
        
    }
}

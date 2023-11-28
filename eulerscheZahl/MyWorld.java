import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    boolean pl = true;//überprüft ob images[][] an p übergeben wurde
    Wall w = new Wall();
    Player p = new Player();
    Stone s = new Stone();
    Ground e = new Ground();
    Blank b = new Blank();
    Gold g = new Gold();
    Crystal c = new Crystal(); //lvl.1,11
    Portal end = new Portal();
    Bot bot = new Bot();
    public Actor[][] images = {
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
        {e,c,e,e,e,e,s,e,e,e,e,e,e,e,e,e,e,e,s,e,e,c,e,e,e,e,e,e,e}
    };
    
    public MyWorld()
    {    
        super(609, 399, 1);//29,19 (%21) 
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        /*for (int row = 0; row < images.length; row++) {
            for (int col = 0; col < images[row].length; col++) {
                if (images[row][col] instanceof Ground) {
                    e = (Ground)images[row][col];
                    addObject(e,col*21+9,row*21+9);
                }else if (images[row][col] instanceof Stone) {
                     s = (Stone)images[row][col];
                     addObject(s,col*21+9,row*21+9);
                    }
                else if (images[row][col] instanceof Wall) {
                     w = (Wall)images[row][col];
                     addObject(w,col*21+9,row*21+9);
                    }
                else if (images[row][col] == p) {
                     p = (Player)images[row][col];
                     addObject(p,col*21+9,row*21+9);
                    }
                else if (images[row][col] instanceof Blank) {
                     b = (Blank)images[row][col];
                     addObject(b,col*21+9,row*21+9);
                    }
                else if (images[row][col] instanceof Bot) {
                     bot = (Bot)images[row][col];
                     addObject(bot,col*21+9,row*21+9);
                    }
                else if (images[row][col] instanceof Crystal) {
                     c = (Crystal)images[row][col];
                     addObject(c,col*21+9,row*21+9);
                    }
                else if (images[row][col] instanceof Portal) {
                     end = (Portal)images[row][col];
                     addObject(end,col*21+9,row*21+9);
                    }
                else if (images[row][col] instanceof Gold) {
                     g = (Gold)images[row][col];
                     addObject(g,col*21+9,row*21+9);
                }
            }
        }*/
        for (int row = 0; row < images.length; row++) {
            for (int col = 0; col < images[row].length; col++) {
                if (images[row][col] instanceof Ground) { 
                    e = new Ground();
                    addObject(e,col*21+9,row*21+9);
                    images[row][col] = e;
                }else if (images[row][col] instanceof Stone) { 
                     s = new Stone();
                     addObject(s,col*21+9,row*21+9);
                     images[row][col] = s;
                    }
                else if (images[row][col] instanceof Wall) { 
                     w = new Wall();
                     addObject(w,col*21+9,row*21+9);
                     images[row][col] = w;
                    }
                else if (images[row][col] instanceof Player) { //==p
                     Player p = new Player();
                     addObject(p,col*21+9,row*21+9);
                     images[row][col] = p;
                    }
                else if (images[row][col] instanceof Blank) { 
                     b = new Blank();
                     addObject(b,col*21+9,row*21+9);
                     images[row][col] = b;
                    }
                else if (images[row][col] instanceof Bot) {
                     bot = new Bot();
                     addObject(bot,col*21+9,row*21+9);
                     images[row][col] = bot;
                    }
                else if (images[row][col] instanceof Crystal) {
                     c = new Crystal();
                     addObject(c,col*21+9,row*21+9);
                     images[row][col] = c;
                    }
                else if (images[row][col] instanceof Portal) {
                     end = new Portal();
                     addObject(end,col*21+9,row*21+9);
                     images[row][col] = end;
                    }
                else if (images[row][col] instanceof Gold) {
                     g = new Gold();
                     addObject(g,col*21+9,row*21+9);
                     images[row][col] = g;
                }
            }
        }
    }
    
    public void act(){
        while(pl == true){
            images();
        }
    }
    
    /*public Actor[][] getImages(){
        return images;
    }*/
    
    public void images(){
        if(images== null){
            System.out.println("a");
        }
        if(images!= null){
            System.out.println("a1");
        }
        p.setImages(images);
        pl = false;
    }
}

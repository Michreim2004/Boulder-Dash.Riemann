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
    GreenfootImage c = new GreenfootImage("crystal.png"); //lvl.1,11
    GreenfootImage end = new GreenfootImage("portal.png");
    GreenfootImage bot = new GreenfootImage("bot.png");
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean active = false;
    private int crystalCount = 0;
    private int currentPlayerX = 3;//static
    private int currentPlayerY = 2;
    private int sX = 0;
    private int sY = 0;//Steinpos.
    //Thread playerThread = new Thread(new PlayerMover());
    //Thread stoneThread = new Thread(new StoneMover());
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
        {e,c,e,e,e,e,s,e,e,e,e,e,e,e,e,e,e,e,s,e,e,c,e,e,e,e,e,e,e}
    };
    
    public MyWorld()
    {    
        super(609, 399, 1);//29,19 (%21) 
        int x=0;
        int y=0;
        /*for(int j=0;j<images.length;j++){
            for(int i=0;i<29;i++){ //oder bis images[j].length
                    getBackground().drawImage(images[j][i],x,y);
                    x = x+21;
                }
            y += 21;
            x = 0;
        }*/
        
        for(int j=0;j<19;j++){
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
        movePlayer();
        checkForStone();
        //stone();
    }
    
    /*public boolean isTouching(GreenfootImage i, GreenfootImage target){
        int x = getX(i);
        int y = getY(i);
        int targetX = getX(target);
        int targetY = getY(target);
        int dx = Math.abs(x - targetX);
        int dy = Math.abs(y - targetY);
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }
    
    /*public boolean isBelow(GreenfootImage i, GreenfootImage target){
        int x = getX(i);
        int targetX = getX(target);
        int dx = x - targetX;
        return (dx == -1);
    }*/

    /*public int getX(GreenfootImage img){
        for(int j=0;j<images.length;j++){
            for(int i=0;i<images[j].length;i++){
                    GreenfootImage currentImage = new GreenfootImage(images[j][i]);
                    if(currentImage.equals(img)){
                        return i;
                    }
                }
        }
        return 0;
    }

    public int getY(GreenfootImage img){
        for(int j=0;j<images.length;j++){
            for(int i=0;i<images[j].length;i++){
                    GreenfootImage currentImage = new GreenfootImage(images[j][i]);
                    if(currentImage.equals(img)){
                        return j;
                    }
                }
        }
        return 0;
    }*/

    private void checkKeys() {
        if (Greenfoot.isKeyDown("up") && !downPressed && !leftPressed && !rightPressed) {
            upPressed = true;
            downPressed = false;
            leftPressed = false;
            rightPressed = false;
        } else if (Greenfoot.isKeyDown("down") && !upPressed && !leftPressed && !rightPressed) {
            upPressed = false;
            downPressed = true;
            leftPressed = false;
            rightPressed = false;
        } else if (Greenfoot.isKeyDown("left") && !upPressed && !downPressed && !rightPressed) {
            upPressed = false;
            downPressed = false;
            leftPressed = true;
            rightPressed = false;
        } else if (Greenfoot.isKeyDown("right") && !upPressed && !downPressed && !leftPressed) {
            upPressed = false;
            downPressed = false;
            leftPressed = false;
            rightPressed = true;
        }
        else{
            upPressed = false;
            downPressed = false;
            leftPressed = false;
            rightPressed = false;
        }
    }

    public void movePlayer() {
        if(currentPlayerY>0){
            if (upPressed) {
                if(images[currentPlayerY - 1][currentPlayerX]!=s&&images[currentPlayerY - 1][currentPlayerX]!=w){
                    images[currentPlayerY][currentPlayerX] = b;
                    images[currentPlayerY - 1][currentPlayerX] = p;
                    getBackground().drawImage(images[currentPlayerY - 1][currentPlayerX],currentPlayerX*21,(currentPlayerY*21) - 21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    if(currentPlayerY!=0){
                        currentPlayerY -= 1;
                    }
                    Greenfoot.delay(9);
                }
            }
        }
        if(currentPlayerY<18){
            if (downPressed) {
                if(images[currentPlayerY + 1][currentPlayerX]!=s&&images[currentPlayerY + 1][currentPlayerX]!=w){
                    if(active!=true){
                        if(currentPlayerY!=0){
                            if(images[currentPlayerY - 1][currentPlayerX]==s){
                                sX = currentPlayerX;
                                sY = currentPlayerY - 1;
                                active=true;
                                //stone();
                            }
                        }
                    }
                    images[currentPlayerY][currentPlayerX] = b;
                    images[currentPlayerY + 1][currentPlayerX] = p;
                    getBackground().drawImage(images[currentPlayerY + 1][currentPlayerX],currentPlayerX*21,(currentPlayerY*21) + 21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    currentPlayerY += 1;
                    Greenfoot.delay(9);
                }
            }
        }
        if(currentPlayerX>0){
            if (leftPressed) {
                if(images[currentPlayerY][currentPlayerX - 1]!=s&&images[currentPlayerY][currentPlayerX - 1]!=w){
                    if(active!=true){
                        if(currentPlayerY!=0){
                            if(images[currentPlayerY - 1][currentPlayerX]==s){
                                sX = currentPlayerX;
                                sY = currentPlayerY - 1;
                                active=true;
                                //stone();
                            }
                        }
                    }
                    images[currentPlayerY][currentPlayerX] = b;
                    images[currentPlayerY][currentPlayerX - 1] = p;
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX - 1],(currentPlayerX*21) - 21,currentPlayerY*21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    if(currentPlayerX!=0){
                        currentPlayerX -= 1;
                    }
                    Greenfoot.delay(9);
                }
            }
        }
        if(currentPlayerX<28){
            if (rightPressed) {
                if(images[currentPlayerY][currentPlayerX + 1]!=s&&images[currentPlayerY][currentPlayerX + 1]!=w){
                    if(active!=true){
                        if(currentPlayerY!=0){
                            if(images[currentPlayerY - 1][currentPlayerX]==s){
                                sX = currentPlayerX;
                                sY = currentPlayerY - 1;
                                active=true;
                                //stone();
                            }
                        }
                    }
                    images[currentPlayerY][currentPlayerX] = b;
                    images[currentPlayerY][currentPlayerX + 1] = p;
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX + 1],(currentPlayerX*21) + 21,currentPlayerY*21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    currentPlayerX += 1;
                    Greenfoot.delay(9);
                }
            }
        }
        checkKeys();
    }

    public void checkForStone() {
        while(active == true){  //if,while
                for(int i=0;i<11;i++){
                        if(images[sY + 1][sX]!=s&&images[sY + 1][sX]!=w&&images[sY + 1][sX]!=e&&images[sY + 1][sX]!=p){ //while
                        images[sY][sX] = b;
                        images[sY + 1][sX] = s;
                        getBackground().drawImage(images[sY + 1][sX],sX*21,(sY*21) + 21);
                        getBackground().drawImage(images[sY][sX],sX*21,sY*21);
                        if(sY<17){
                            sY ++;
                        }
                        Greenfoot.delay(36);
                        if(images[sY + 1][sX]==p){
                            images[sY][sX] = b;
                            images[sY + 1][sX] = s;
                            getBackground().drawImage(images[sY + 1][sX],sX*21,(sY*21) + 21);
                            getBackground().drawImage(images[sY][sX],sX*21,sY*21);
                            //reset();
                        }
                }
                else{
                    active = false;
                }
            }
            active = false;
        }
    }
    
    //public void stone(){
        //if(active == true){
            /*stoneThread.start();
            playerThread.start();
            if(active != true){
                stoneThread.stop();
                playerThread.stop();
            }
        }
    }*/
    
    public void reset(){ //static void
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
        active = false;
        currentPlayerX = 3;
        currentPlayerY = 2;
        int x=0;
        int y=0;
        GreenfootImage[][] images ={
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
        for(int j=0;j<19;j++){
            for(int i=0;i<29;i++){ //oder bis images[j].length
                    getBackground().drawImage(images[j][i],x,y);
                    x = x+21;
                }
            y += 21;
            x = 0;
        }
    }
}

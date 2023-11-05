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
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    private int currentPlayerX = 3;
    private int currentPlayerY = 2;
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
        super(609, 399, 1);//29,19 (%21) 
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
        /*if (isTouching(Player.class)) {
            getWorld.getBackground.drawImage(b,getXe(),getYe());
        }*/
        movePlayer();
        checkKeys();
        checkForStone();
        //test:images[currentPlayerX][currentPlayerY] = b;
        //test:getBackground().drawImage(images[currentPlayerX][currentPlayerY],currentPlayerX*21,currentPlayerY*21);
    }
    
    public boolean isTouching(GreenfootImage i, GreenfootImage target){
        int x = getX(i);
        int y = getY(i);
        int targetX = getX(target);
        int targetY = getY(target);
        int dx = Math.abs(x - targetX);
        int dy = Math.abs(y - targetY);
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }

    public int getX(GreenfootImage img){
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
    }

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

    private void movePlayer() {
        int x = getX(p);
        int y = getY(p);
        //while(-1<currentPlayerY&&currentPlayerY>19&&-1<currentPlayerX&&currentPlayerX>29){
            if (upPressed) {
                images[currentPlayerX][currentPlayerY] = b;
                images[currentPlayerX][currentPlayerY - 1] = p;
                /*getBackground().drawImage(images[currentPlayerX][currentPlayerY],x,y);
                getBackground().drawImage(images[currentPlayerX][currentPlayerY - 1],x,y);
                currentPlayerY -= 1;*/
                getBackground().drawImage(images[currentPlayerX][currentPlayerY],currentPlayerX*21,currentPlayerY*21);
                getBackground().drawImage(images[currentPlayerX][currentPlayerY - 1],currentPlayerX*21,(currentPlayerY*21) - 21);
                currentPlayerY -= 1;
                Greenfoot.delay(10);
            }
            if (downPressed) {
                images[currentPlayerX][currentPlayerY] = b;
                images[currentPlayerX][currentPlayerY + 1] = p;
                currentPlayerY += 1;
            }
            if (leftPressed) {
                images[currentPlayerX][currentPlayerY] = b;
                images[currentPlayerX - 1][currentPlayerY] = p;
                currentPlayerX -= 1;
            }
            if (rightPressed) {
                images[currentPlayerX][currentPlayerY] = b;
                images[currentPlayerX + 1][currentPlayerY] = p;
                currentPlayerX += 1;
            }
        //}
    }

    private void checkForStone() {
        if (isTouching(p,s)) {
            //remove Player
        }
    }
}

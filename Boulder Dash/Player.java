import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    /*3private GreenfootImage[] images;
    private int currentImageIndex;*/
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    private static final int BLOCK_SIZE = 94;
    private int x = 21;
    private int y = 21;
    
    /*3public Player(){
        images = new GreenfootImage[10];
        images[0] = new GreenfootImage("PLAYER.png"); 
    }*/
    //Player[][] player = new Player[30][20];
    //setLocation(player[1][1],player[1][1]);

    public void act() {
        move();
        checkKeys();
        checkForStone();
        //int x = getX();
        //int y = getY();
        
        /*2// Überprüfen Sie, ob die Position des Spielers auf einem gültigen Feld liegt
        if (x % BLOCK_SIZE == 0 && y % BLOCK_SIZE == 0) {
            move();
            checkKeys();
            checkForStone();
        }
        else{
           x = 
           y =
        }*/
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
    
    private void move() {
        Player[][] player = new Player[30][20];
        player[x][y] = new Player();
        //addObject(player[x][y], x * 21+10, y * 21+11);
        
        if (upPressed) {
            player[x][y] = player[x][y-1];
        }
        if (downPressed) {
            player[x][y] = player[x][y+1];
        }
        if (leftPressed) {
            player[x][y] = player[x-1][y];
        }
        if (rightPressed) {
            player[x][y] = player[x+1][y];
        }
        /*2if (upPressed) {
            setLocation(getX(), getY() - 3);
        }
        if (downPressed) {
            setLocation(getX(), getY() + 3);
        }
        if (leftPressed) {
            setLocation(getX() - 3, getY());
        }
        if (rightPressed) {
            setLocation(getX() + 3, getY());
        }*/
    }
    
    private void checkForStone() {
        if (isTouching(Stein.class)) {
            getWorld().removeObject(this);
        }
    }
}

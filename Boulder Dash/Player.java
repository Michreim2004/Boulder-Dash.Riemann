import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    private static final int BLOCK_SIZE = 94;
    private int x = 21;
    private int y = 21;
    
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
        
        if (upPressed) {
            images[x][y] = images[x][y-1];
        }
        if (downPressed) {
            images[x][y] = images[x][y+1];
        }
        if (leftPressed) {
            images[x][y] = images[x-1][y];
        }
        if (rightPressed) {
            images[x][y] = images[x+1][y];
        }
    }
    
    private void checkForStone() {
        if (isTouching(Stein.class)) {
            getWorld().removeObject(this);
        }
    }
}

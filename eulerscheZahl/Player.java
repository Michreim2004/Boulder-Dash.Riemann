import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    MyWorld world = (MyWorld) getWorld();
    Actor [][] images = world.getImages();
    Wall w = world.w;
    Player p = world.p;
    Stone s = world.s;
    Ground e = world.e;
    Blank b = world.b;
    Gold g = world.g;
    Crystal c = world.c;
    Portal end = world.end;
    Bot bot = world.bot;
    GreenfootImage background = world.getBackground();
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean active = false;
    private int crystalCount = 0;
    private int currentPlayerX = 3;
    private int currentPlayerY = 2;
    
    public void act()
    {
        
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
    
    public void movePlayer() {
        if(currentPlayerY>0){
            if (upPressed) {
                if(images[currentPlayerY - 1][currentPlayerX]!=s&&images[currentPlayerY - 1][currentPlayerX]!=w){
                    if(images[currentPlayerY - 1][currentPlayerX]==c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY - 1][currentPlayerX]==end&&crystalCount == 11){
                        crystalCount = 0;
                    }
                    world.removeObject(images[currentPlayerY][currentPlayerX]);
                    images[currentPlayerY][currentPlayerX] = b;
                    images[currentPlayerY - 1][currentPlayerX] = p;
                    if(currentPlayerY!=0){
                        currentPlayerY -= 1;
                    }
                    //(images[currentPlayerY - 1][currentPlayerX],currentPlayerX*21,(currentPlayerY*21) - 21);
                    setLocation(currentPlayerX*21, (currentPlayerY*21)-21);
                    
                    Greenfoot.delay(9);
                }
            }
        }
        /*if(currentPlayerY<18){
            if (downPressed) {
                if(images[currentPlayerY + 1][currentPlayerX]!=s&&images[currentPlayerY + 1][currentPlayerX]!=w){
                    if(images[currentPlayerY + 1][currentPlayerX]==c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY + 1][currentPlayerX]==end&&crystalCount == 11){
                        crystalCount = 0;
                    }
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
                    background.drawImage(images[currentPlayerY + 1][currentPlayerX],currentPlayerX*21,(currentPlayerY*21) + 21);
                    background.drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    currentPlayerY += 1;
                    Greenfoot.delay(9);
                }
            }
        }
        if(currentPlayerX>0){
            if (leftPressed) {
                if(images[currentPlayerY][currentPlayerX - 1]!=s&&images[currentPlayerY][currentPlayerX - 1]!=w){
                    if(images[currentPlayerY][currentPlayerX - 1]==c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY][currentPlayerX - 1]==end&&crystalCount == 11){
                        crystalCount = 0;
                    }
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
                    background.drawImage(images[currentPlayerY][currentPlayerX - 1],(currentPlayerX*21) - 21,currentPlayerY*21);
                    background.drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
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
                    if(images[currentPlayerY][currentPlayerX + 1]==c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY][currentPlayerX + 1]==end&&crystalCount == 11){
                        crystalCount = 0;
                    }
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
                    background.drawImage(images[currentPlayerY][currentPlayerX + 1],(currentPlayerX*21) + 21,currentPlayerY*21);
                    background.drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    currentPlayerX += 1;
                    Greenfoot.delay(9);
                }
            }
        }*/
        checkKeys();
    }
}
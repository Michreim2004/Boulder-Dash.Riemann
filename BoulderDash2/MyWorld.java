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
    GreenfootImage z = new GreenfootImage("portal.png");
    GreenfootImage o = new GreenfootImage("bot.png");
    GreenfootImage white = new GreenfootImage("white.png");
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean active = false;//static
    private int crystalCount = 0;
    private int currentPlayerX = 3;
    private int currentPlayerY = 2;
    private int sX = 0;
    private int sY = 0;//Steinpos.
    private boolean above = false;
    private int countFall = 0;
    private boolean whiteX = false;
    private Thread t1;
    private Thread t2;
    private Thread t3;
    private Thread t4;
    private GreenfootImage[][] images ={ //Level 1
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
        {e,e,e,e,s,c,b,e,e,e,e,e,s,e,s,s,e,e,s,e,s,c,e,e,e,e,z,e,e},
        {e,c,e,e,e,e,s,e,e,e,e,e,e,e,e,e,e,e,s,e,e,c,e,e,e,e,e,e,e}
    };
    
    
    public MyWorld()
    {    
        super(609, 399, 1);//29,19 (%21) 
        
        int x=0;
        int y=0;
        for(int j=0;j<19;j++){
            for(int i=0;i<29;i++){ //oder bis images[j].length
                    getBackground().drawImage(images[j][i],x,y);
                    x += 21;
                }
            y += 21;
            x = 0;
        }
        t1 = new Thread(new PlayerT1(this));
        t2 = new Thread(new StoneT2(this));
        t3 = new Thread(new CrystalT3(this));
        t4 = new Thread(new BotT4(this));
        t1.start();
        //t2.start();
        //setBackground(..);für evtl. lvl. 2
    }
    
    public void act(){
        white();
        checkForStone();
        //schieben();
    }
    
    /*public void act() {
        checkForNextLVL();
        checkForStone();
        countFall = 0;
        stone();
    }*/
    
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
                if(images[currentPlayerY - 1][currentPlayerX]!=s&&images[currentPlayerY - 1][currentPlayerX]!= w){
                    if(images[currentPlayerY - 1][currentPlayerX]== c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY - 1][currentPlayerX]== z &&crystalCount == 11){
                        crystalCount = 0;
                    }
                    images[currentPlayerY][currentPlayerX] = b;
                    images[currentPlayerY - 1][currentPlayerX] = p;
                    getBackground().drawImage(images[currentPlayerY - 1][currentPlayerX],currentPlayerX*21,(currentPlayerY*21) - 21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    if(currentPlayerY!=0){
                        currentPlayerY -= 1;
                    }
                    Greenfoot.delay(6);
                }
            }
        }
        if(currentPlayerY<18){
            if (downPressed) {
                if(images[currentPlayerY + 1][currentPlayerX]!=s&&images[currentPlayerY + 1][currentPlayerX]!= w){
                    if(images[currentPlayerY + 1][currentPlayerX]== c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY + 1][currentPlayerX]== z &&crystalCount == 11){
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
                    getBackground().drawImage(images[currentPlayerY + 1][currentPlayerX],currentPlayerX*21,(currentPlayerY*21) + 21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    currentPlayerY += 1;
                    Greenfoot.delay(6);
                }
            }
        }
        if(currentPlayerX>0){
            if (leftPressed) {
                if(images[currentPlayerY][currentPlayerX - 1]!=s&&images[currentPlayerY][currentPlayerX - 1]!= w){
                    if(images[currentPlayerY][currentPlayerX - 1]== c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY][currentPlayerX - 1]== z &&crystalCount == 11){
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
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX - 1],(currentPlayerX*21) - 21,currentPlayerY*21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    if(currentPlayerX!=0){
                        currentPlayerX -= 1;
                    }
                    Greenfoot.delay(6);
                }
            }
        }
        if(currentPlayerX<28){
            if (rightPressed) {
                if(images[currentPlayerY][currentPlayerX + 1]!=s&&images[currentPlayerY][currentPlayerX + 1]!= w){
                    if(images[currentPlayerY][currentPlayerX + 1]== c){
                        crystalCount++;
                    }
                    if(images[currentPlayerY][currentPlayerX + 1]== z &&crystalCount == 11){
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
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX + 1],(currentPlayerX*21) + 21,currentPlayerY*21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX],currentPlayerX*21,currentPlayerY*21);
                    currentPlayerX += 1;
                    Greenfoot.delay(6);
                }
            }
        }
        checkKeys();
    }
    
    public void white(){
        if(whiteX==false){
              if(crystalCount==9){
                    int x=0;
                    int y=0;
                    for(int j=0;j<19;j++){
                        for(int i=0;i<29;i++){
                                if(images[j][i]==b){
                                    images[j][i]=white;
                                }
                            }
                    }
                    for(int j=0;j<19;j++){
                        for(int i=0;i<29;i++){
                                getBackground().drawImage(images[j][i],x,y);
                                x += 21;
                            }
                        y += 21;
                        x = 0;
                    }
                    Greenfoot.delay(6);
                    x=0;
                    y=0;
                    for(int j=0;j<19;j++){
                        for(int i=0;i<29;i++){
                                if(images[j][i]== white){
                                    images[j][i]=b;
                                }
                            }
                    }
                    for(int j=0;j<19;j++){
                        for(int i=0;i<29;i++){
                                getBackground().drawImage(images[j][i],x,y);
                                x += 21;
                            }
                        y += 21;
                        x = 0;
                    }
                    whiteX = true;
                }
        }
    }

    public void checkForStone() {
            while(active == true){  //if,while
                if(sY>-1){
                    for(int i=0;i<11;i++){
                    if(images[sY + 1][sX]!=s&&images[sY + 1][sX]!= w &&images[sY + 1][sX]!= e &&images[sY + 1][sX]!=p){ //while
                        images[sY][sX] = b;
                        images[sY + 1][sX] = s;
                        if(sY>0){
                            if(images[sY - 1][sX]==s){
                                above = true;
                            }
                        }
                        getBackground().drawImage(images[sY + 1][sX],sX*21,(sY*21) + 21);
                        getBackground().drawImage(images[sY][sX],sX*21,sY*21);
                        if(sY<17){
                            sY ++;
                            countFall++;
                        }
                        Greenfoot.delay(36);
                        if(images[sY + 1][sX]==p){
                            images[sY][sX] = b;
                            images[sY + 1][sX] = s;
                            getBackground().drawImage(images[sY + 1][sX],sX*21,(sY*21) + 21);
                            getBackground().drawImage(images[sY][sX],sX*21,sY*21);
                            explosion();
                            Greenfoot.delay(99);
                            reset();
                        }
                    }
                    /*else{
                        active = false;
                    }*/
                }
                if(above){
                            sY=sY-countFall;
                            //countFall = 0;
                            above = false;
                            checkForStone();
                        }
                //countFall = 0;
                active = false;
            }
        }
    }
    
    public void explosion(){
        for(int i=0;i<3;i++){
            for(int j=-1;j<2;j++){
                images[sY+j][sX+i]=white;
                getBackground().drawImage(images[sY+j][sX+i],(sX*21)+21*j,(sY*21)+21*i);
            }
        }
        Greenfoot.delay(5);
        for(int i=0;i<3;i++){
            for(int j=-1;j<2;j++){
                images[sY+j][sX+i]=c;
                getBackground().drawImage(images[sY+j][sX+i],(sX*21)+21*j,(sY*21)+21*i);
            }
        }
    }
    
    public void grab(){
        while(Greenfoot.isKeyDown("space")){
                if (Greenfoot.isKeyDown("up")&&images[currentPlayerY-1][currentPlayerX]==e) {
                images[currentPlayerY-1][currentPlayerX]=b;
                getBackground().drawImage(images[currentPlayerY-1][currentPlayerX],currentPlayerX*21,currentPlayerY*21-21);
            } else if (Greenfoot.isKeyDown("down")&&images[currentPlayerY+1][currentPlayerX]==e) {
                images[currentPlayerY+1][currentPlayerX]=b;
                getBackground().drawImage(images[currentPlayerY + 1][currentPlayerX],currentPlayerX*21,currentPlayerY*21+21);
            } else if (Greenfoot.isKeyDown("left")&&images[currentPlayerY][currentPlayerX-1]==e) {
                images[currentPlayerY][currentPlayerX-1]=b;
                getBackground().drawImage(images[currentPlayerY][currentPlayerX - 1],(currentPlayerX*21) - 21,currentPlayerY*21);
            } else if (Greenfoot.isKeyDown("right")&&images[currentPlayerY][currentPlayerX+1]==e) {
                images[currentPlayerY][currentPlayerX+1]=b;
                getBackground().drawImage(images[currentPlayerY][currentPlayerX + 1],(currentPlayerX*21) + 21,currentPlayerY*21);
            }
        }
    }
    
    public void schieben(){
        while(Greenfoot.isKeyDown("left")){ //&&images[currentPlayerY][currentPlayerX-1]==s||images[currentPlayerY+1][currentPlayerX-2]==b
            Greenfoot.delay(8);
            if(currentPlayerX>1){
                if(images[currentPlayerY][currentPlayerX-1]==s&&images[currentPlayerY][currentPlayerX-2]==b){
                    images[currentPlayerY][currentPlayerX-1]=p;
                    images[currentPlayerY][currentPlayerX-2]=s;
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX - 1],(currentPlayerX*21) - 21,currentPlayerY*21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX - 2],(currentPlayerX*21) - 42,currentPlayerY*21);
                }
            }
            if(images[currentPlayerY+1][currentPlayerX-2]==b){
                sX = currentPlayerX-2;
                sY = currentPlayerY+1;
                active=true;
                checkForStone();
            }
            Greenfoot.delay(8);
        }
        while(Greenfoot.isKeyDown("right")){
            Greenfoot.delay(8);
            if(currentPlayerX<27){
                if(images[currentPlayerY][currentPlayerX+1]==s&&images[currentPlayerY][currentPlayerX+2]==b){
                    images[currentPlayerY][currentPlayerX+1]=p;
                    images[currentPlayerY][currentPlayerX+2]=s;
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX + 1],(currentPlayerX*21) + 21,currentPlayerY*21);
                    getBackground().drawImage(images[currentPlayerY][currentPlayerX + 2],(currentPlayerX*21) + 42,currentPlayerY*21);
                }
            }
            if(images[currentPlayerY+1][currentPlayerX+2]==b){
                sX = currentPlayerX+2;
                sY = currentPlayerY+1;
                active=true;
                checkForStone();
            }
            Greenfoot.delay(8);
        }
    }
    
    /*public void stone(){
        //if(active == true){
            /*stoneThread.start();
            playerThread.start();
            if(active != true){
                stoneThread.stop();
                playerThread.stop();
            }
        }
    }*/
    
    public void reset(){ 
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
        int crystalCount = 0;
        active = false;
        currentPlayerX = 3;
        currentPlayerY = 2;
        int sX = 0;
        int sY = 0;//Steinpos.
        int x=0;
        int y=0;
        GreenfootImage[][] images ={ //Level 1
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
            {e,e,e,e,s,c,b,e,e,e,e,e,s,e,s,s,e,e,s,e,s,c,e,e,e,e,z,e,e},
            {e,c,e,e,e,e,s,e,e,e,e,e,e,e,e,e,e,e,s,e,e,c,e,e,e,e,e,e,e}
        };
        for(int j=0;j<19;j++){
            for(int i=0;i<29;i++){ //oder bis images[j].length
                    getBackground().drawImage(images[j][i],x,y);
                    x += 21;
                }
            y += 21;
            x = 0;
        }
        /*t1 = new Thread(new PlayerT1(this));
        t2 = new Thread(new StoneT2(this));
        t3 = new Thread(new CrystalT3(this));
        t4 = new Thread(new BotT4(this));
        t1.start();
        t2.start();*/
    }
    
    public void stop(){
        t1.stop();
        t2.stop();
    }
    
    public void checkForNextLVL(){
        if(crystalCount>=9&&currentPlayerX==27&&currentPlayerY==18){
            GreenfootImage[][] images ={
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,p,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,b,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,c,b,e,e,e,e,e,e,e},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {w,w,w,w,w,w,w,w,w,w,w,g,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,z,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g},
            {g,g,g,g,g,g,g,g,g,g,g,g,g,w,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g}
            };
            int x = 0;
            int y = 0;
            for(int j=0;j<19;j++){
                for(int i=0;i<29;i++){
                        getBackground().drawImage(images[j][i],x,y);
                        x += 21;
                    }
                y += 21;
                x = 0;
                }
        }
        crystalCount = 0;
    }
}

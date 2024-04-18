package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN VARIABLES
    public final int defaultTileSize = 16; // 16x16 block tile
    public final int scale = 3; // for scaling size

    public final int  tileSize =  defaultTileSize * scale;

    // BLOCKS ON THE SCREEN
    public final int maxScreenColumn = 16;
    public final int maxScreenRow = 12;

    // SCREEN SIZE
    public final int screenWidth = tileSize * maxScreenColumn;
    public final int screenHeight = tileSize * maxScreenRow;

    // WORLD SETTING
    public final int maxWorldCol = 60;
    public final int maxWorldRow = 60;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldCol;

    // DRAW WATER
    public boolean drawWater=false;

    // FRAME PER SECOND
    int FPS=60;

    // GAME THREAD
    KeyHandler keyHandle = new KeyHandler();
    Thread gameThread;

    // COLLISION CHECKER
    public CollisionChecker cChecker = new CollisionChecker(this);

    // MAP CREATOR
    TileManager tileManager = new TileManager(this);

    // SETTING OBJECTS
    public AssetSetter aSetter = new AssetSetter(this);

    // PLAYER
    public Player player1= new Player(this,keyHandle);

    // OBJECT
    public SuperObject obj[] = new SuperObject[10];



    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true);

    }

    public void setupGame(){

        aSetter.setObject();


    }

    public void startGameThread(){
        gameThread= new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;

        // FPS COUNTER VARIABLE
        long timer=0;
        long drawCount=0;

        while(gameThread != null){

            currentTime=System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if(delta >=1){

                // UPDATE VARIABLE/INFORMATION
                update();

                // DRAW SCREEN UPDATE
                repaint();
                drawCount++;
                delta--;
            }

            if(timer>= 1000000000){

                //System.out.println("FPS: "+drawCount);
                timer=0;
                drawCount=0;
            }

        }
    }

    // UPDATES
    public void update(){

        player1.update();

    }

    // DRAW UPDATES
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // TILE DRAW
        tileManager.draw(g2);

        // OBJECT DRAW
        for(int i = 0; i< obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        // PLAYER DRAW
        player1.draw(g2);

        g2.dispose();

    }

}

package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    // PREVIOUS KEY PRESS
    public int idleNumber=1;

    public Player(GamePanel gp,KeyHandler keyHandler){

        this.gp=gp;
        this.keyHandler=keyHandler;

        screenX= gp.screenWidth/2 - (gp.tileSize/2);
        screenY= gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 15;
        solidArea.y = 27;
        solidArea.width = 18;
        solidArea.height = 20;

        setDefaultValues();
        getPlayerImage();
        direction="down";
    }

    public void setDefaultValues() {
        worldx= gp.tileSize * 19;
        worldy= gp.tileSize * 12;
        speed=4;
    }

    public void getPlayerImage(){

        try{
            /*
            down1= ImageIO.read(getClass().getResourceAsStream("/player/Character_Down1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/player/Character_Down2.png"));
            up1= ImageIO.read(getClass().getResourceAsStream("/player/Character_Up1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/player/Character_Up2.png"));
             */

            down1= ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Down1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Down2.png"));
            up1= ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Up1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Up2.png"));
            left1=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Left1.png"));
            left2=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Left2.png"));
            right1=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Right1.png"));
            right2=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Right2.png"));
            idle1=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Idle.png"));
            idle2=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Idle1.png"));
            idle3=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Left2.png"));
            idle4=ImageIO.read(getClass().getResourceAsStream("/ei/Raiden_Right2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public void update(){

        if(keyHandler.upPress==true || keyHandler.downPress==true || keyHandler.leftPress==true || keyHandler.rightPress==true) {

            if (keyHandler.upPress == true) {
                direction = "up";
                idleNumber=2;
            } else if (keyHandler.downPress == true) {
                direction = "down";
                idleNumber=1;
            } else if (keyHandler.leftPress == true) {
                direction = "left";
                idleNumber=3;
            } else if (keyHandler.rightPress == true) {
                direction = "right";
                idleNumber=4;
            }

            // COLLISION CHECKER
            collisionOn= false;
            gp.cChecker.checkTile(this);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn==false){

                switch (direction) {
                    case "up":    worldy -= speed; break;
                    case "down":  worldy += speed; break;
                    case "left":  worldx -= speed; break;
                    case "right": worldx += speed; break;

                }

            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }else{
            direction= "idle";
        }

    }

    public void draw(Graphics2D g2){

        // COLOR
        //g2.setColor(Color.white);

        // DIMENSION AND LOCATION OF PLAYER
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image=null;

        switch(direction){
            case "up":
                if(spriteNum==1){
                    image=up1;
                }else if(spriteNum==2){
                    image=up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                    image=down1;
                }else if(spriteNum==2){
                    image=down2;
                }
                break;
            case "left":
                if(spriteNum==1){
                    image=left1;
                }else if(spriteNum==2){
                    image=left2;
                }
                break;
            case "right":
                if(spriteNum==1){
                    image=right1;
                }else if(spriteNum==2){
                    image=right2;
                }
                break;
            case "idle":
                if(idleNumber==1){
                    image=idle1;
                }else if(idleNumber==2){
                    image=idle2;
                }else if(idleNumber==3){
                    image=idle3;
                }else if(idleNumber==4){
                    image=idle4;
                }
                break;


        }
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);


    }

}

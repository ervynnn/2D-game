package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2, GamePanel gamePanel){

        int screenX = worldX - gamePanel.player1.worldx + gamePanel.player1.screenX;
        int screenY = worldY - gamePanel.player1.worldy + gamePanel.player1.screenY;

        if (worldX + gamePanel.tileSize> gamePanel.player1.worldx - gamePanel.player1.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player1.worldx + gamePanel.player1.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player1.worldy - gamePanel.player1.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player1.worldy + gamePanel.player1.screenY){

                g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }

    }

}

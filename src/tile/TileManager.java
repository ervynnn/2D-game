package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gamePanel;
    public Tile[] tile;
    public int mapTileNumDeco[][];
    public int mapTileNumPlane[][];

    public TileManager(GamePanel gp){

        this.gamePanel=gp;

        tile=new Tile[100];
        mapTileNumDeco = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        mapTileNumPlane = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/map01_Plane.txt","/maps/map01_Decoration.txt");

    }

    public void getTileImage(){

        try{

            // PLANE TILES

            tile[0]= new Tile();

            // GRASS
            tile[1]= new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Grass.png"));

            // ROADS
            tile[2]= new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadVertical.png"));

            tile[3]= new Tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadHorizontal.png"));

            // SAND
            tile[4]= new Tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Sand.png"));

            // ROADS
            tile[5]= new Tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadLeft.png"));

            tile[6]= new Tile();
            tile[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadRight.png"));

            // PLAIN WATER
            tile[7]= new Tile();
            tile[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Water.png"));

            // ISLAND THINGY
            tile[8]= new Tile();
            tile[8].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Islandright.png"));
            tile[8].collision = true;

            tile[9]= new Tile();
            tile[9].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Islandleft.png"));
            tile[9].collision = true;

            tile[10]= new Tile();
            tile[10].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Islanddown.png"));
            tile[10].collision = true;

            tile[11]= new Tile();
            tile[11].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslanddownR.png"));
            tile[11].collision = true;

            tile[12]= new Tile();
            tile[12].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslanddownL.png"));
            tile[12].collision = true;

            tile[13]= new Tile();
            tile[13].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Islandup.png"));
            tile[13].collision = true;

            tile[14]= new Tile();
            tile[14].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslandupR.png"));
            tile[14].collision = true;

            tile[15]= new Tile();
            tile[15].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslandupL.png"));
            tile[15].collision = true;

            tile[16]= new Tile();
            tile[16].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslandRdownR.png"));
            tile[16].collision = true;

            tile[17]= new Tile();
            tile[17].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslandRdownL.png"));
            tile[17].collision = true;

            tile[18]= new Tile();
            tile[18].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslandRupR.png"));
            tile[18].collision = true;

            tile[19]= new Tile();
            tile[19].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_IslandRupL.png"));
            tile[19].collision = true;

            // END OF THE CLIFFS

            tile[20]= new Tile();
            tile[20].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadCurveDR.png"));

            tile[21]= new Tile();
            tile[21].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadCurveDL.png"));

            tile[22]= new Tile();
            tile[22].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadCurveUL.png"));

            tile[23]= new Tile();
            tile[23].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadCurveUR.png"));

            tile[24]= new Tile();
            tile[24].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadUp.png"));

            tile[25]= new Tile();
            tile[25].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_RoadDown.png"));

            // DECORATIONS

            // TREE DEFAULT
            tile[51]= new Tile();
            tile[51].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Tree.png"));
            tile[51].collision = true;

            // ROCK BIG
            tile[52]= new Tile();
            tile[52].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Rock.png"));
            tile[52].collision = true;

            // ROCK SMALL
            tile[53]= new Tile();
            tile[53].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Rock1.png"));

            // ROCK CLUSTER
            tile[54]= new Tile();
            tile[54].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Rock2.png"));

            // ROCK CLUSTER + GRASS
            tile[55]= new Tile();
            tile[55].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Rock3.png"));

            // GRASS DECORATION
            tile[56]= new Tile();
            tile[56].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_GrassDeco.png"));

            // CHEST
            tile[57]= new Tile();
            tile[57].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Chest.png"));
            tile[57].collision = true;

            // BUSH
            tile[58]= new Tile();
            tile[58].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tile_Bush.png"));
            tile[58].collision = true;


        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void loadMap(String filepath, String filepath1){

        try{
            InputStream ISmap1_Plane = getClass().getResourceAsStream(filepath);
            InputStream ISmap1_Decoration = getClass().getResourceAsStream(filepath1);
            BufferedReader BRmap1_Plane = new BufferedReader(new InputStreamReader(ISmap1_Plane));
            BufferedReader BRmap1_Decoration = new BufferedReader(new InputStreamReader(ISmap1_Decoration));

            int col = 0;
            int row = 0;

            while( col < gamePanel.maxWorldCol && row <gamePanel.maxWorldRow){

                String line = BRmap1_Plane.readLine();
                String line1 = BRmap1_Decoration.readLine();

                while(col < gamePanel.maxWorldCol) {

                    String numbersPlane[] = line.split(" ");
                    String numbersDecoration[] = line1.split(" ");

                    int numPlane = Integer.parseInt(numbersPlane[col]);
                    int numDecoration = Integer.parseInt(numbersDecoration[col]);

                    mapTileNumPlane[col][row]=numPlane;
                    mapTileNumDeco[col][row]=numDecoration;
                    col++;
                }

                if(col== gamePanel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            BRmap1_Plane.close();

        }catch(Exception e){

        }

    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol<gamePanel.maxWorldCol && worldRow< gamePanel.maxWorldRow) {

            int tileNum = mapTileNumPlane[worldCol][worldRow];
            int tileNum1 = mapTileNumDeco[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player1.worldx + gamePanel.player1.screenX;
            int screenY = worldY - gamePanel.player1.worldy + gamePanel.player1.screenY;

            if (worldX + gamePanel.tileSize> gamePanel.player1.worldx - gamePanel.player1.screenX &&
                    worldX - gamePanel.tileSize < gamePanel.player1.worldx + gamePanel.player1.screenX &&
                    worldY + gamePanel.tileSize > gamePanel.player1.worldy - gamePanel.player1.screenY &&
                    worldY - gamePanel.tileSize < gamePanel.player1.worldy + gamePanel.player1.screenY){

                if (tileNum != 0) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                }
                if (tileNum1 != 0) {
                g2.drawImage(tile[tileNum1].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                }

        }

            worldCol++;

                if (worldCol == gamePanel.maxWorldCol) {
                    worldCol = 0;
                    worldRow++;

                }

        }

    }

}

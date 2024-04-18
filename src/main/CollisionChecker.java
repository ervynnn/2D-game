package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp= gp;


    }

    public void checkTile(Entity entity){

        int entityLeftWorldX = entity.worldx + entity.solidArea.x;
        int entityRightWorldX = entity.worldx + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldy + entity.solidArea.y;
        int entityBottomWorldY = entity.worldy + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1=0, tileNum2=0;
        int counter=0;

        while(counter<2) {

                switch (entity.direction) {
                    case "up":
                        entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;

                        if(counter==0) {
                            tileNum1 = gp.tileManager.mapTileNumDeco[entityLeftCol][entityTopRow];
                            tileNum2 = gp.tileManager.mapTileNumDeco[entityRightCol][entityTopRow];
                        }else if(counter==1){
                            tileNum1 = gp.tileManager.mapTileNumPlane[entityLeftCol][entityTopRow];
                            tileNum2 = gp.tileManager.mapTileNumPlane[entityRightCol][entityTopRow];
                        }

                        if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true){
                            entity.collisionOn=true;
                        }
                        break;
                    case "down":
                        entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;

                        if(counter==0) {
                            tileNum1 = gp.tileManager.mapTileNumDeco[entityLeftCol][entityBottomRow];
                            tileNum2 = gp.tileManager.mapTileNumDeco[entityRightCol][entityBottomRow];
                        }else if(counter==1){
                            tileNum1 = gp.tileManager.mapTileNumPlane[entityLeftCol][entityBottomRow];
                            tileNum2 = gp.tileManager.mapTileNumPlane[entityRightCol][entityBottomRow];

                        }

                        if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true){

                                if(tileNum1 == 52 || tileNum2 == 52){

                                    if(entityBottomWorldY>=(entityBottomRow*gp.tileSize)+19){
                                        entity.collisionOn=true;
                                    }
                                }else if(tileNum1 == 58 || tileNum2 == 58){

                                    if(entityBottomWorldY>=(entityBottomRow*gp.tileSize)+7){
                                        entity.collisionOn=true;
                                    }
                                }else{
                                    entity.collisionOn=true;
                                }

                        }
                        break;
                    case "left":
                        entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                        if(counter==0) {
                            tileNum1 = gp.tileManager.mapTileNumDeco[entityLeftCol][entityTopRow];
                            tileNum2 = gp.tileManager.mapTileNumDeco[entityLeftCol][entityBottomRow];
                        }else if(counter==1){
                            tileNum1 = gp.tileManager.mapTileNumPlane[entityLeftCol][entityTopRow];
                            tileNum2 = gp.tileManager.mapTileNumPlane[entityLeftCol][entityBottomRow];
                        }

                        if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {

                            if (tileNum1 == 52 || tileNum2 == 52) {
                                if (entityBottomWorldY > (entityBottomRow * gp.tileSize) + 19) {
                                    entity.collisionOn = true;
                                }
                            }else if(tileNum1 == 58 || tileNum2 == 58){

                                if(entityBottomWorldY>=(entityBottomRow*gp.tileSize)+9){
                                    entity.collisionOn=true;
                                }
                            } else {
                                entity.collisionOn = true;

                            }
                        }
                        break;
                    case "right":
                        entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                        if(counter==0){
                            tileNum1 = gp.tileManager.mapTileNumDeco[entityRightCol][entityTopRow];
                            tileNum2 = gp.tileManager.mapTileNumDeco[entityRightCol][entityBottomRow];
                        }else if(counter==1){
                            tileNum1 = gp.tileManager.mapTileNumPlane[entityRightCol][entityTopRow];
                            tileNum2 = gp.tileManager.mapTileNumPlane[entityRightCol][entityBottomRow];
                        }

                        if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {

                            if (tileNum1 == 52 || tileNum2 == 52 ) {
                                if (entityBottomWorldY > (entityBottomRow * gp.tileSize) + 19) {
                                    entity.collisionOn = true;
                                }
                            }else if(tileNum1 == 58 || tileNum2 == 58){

                                if(entityBottomWorldY>=(entityBottomRow*gp.tileSize)+9){
                                    entity.collisionOn=true;
                                }
                            } else {
                                entity.collisionOn = true;
                            }
                        }
                        break;
                }
        counter++;

        }

    }
}

package main;

import object.OBJ_Chest;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_Chest();
        gp.obj[0].worldX = 14 * gp.tileSize;
        gp.obj[0].worldY = 9 * gp.tileSize;

        gp.obj[1] = new OBJ_Chest();
        gp.obj[1].worldX = 8 * gp.tileSize;
        gp.obj[1].worldY = 51 * gp.tileSize;

    }

}

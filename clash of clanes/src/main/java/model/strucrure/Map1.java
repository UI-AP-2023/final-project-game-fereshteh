package model.strucrure;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Map1 extends Map {
    //------------------------------
  public Map1(double x, double y, int solider, ImageView imageView){
      super(x,y,solider,imageView);
      super.addBuilding(firstBlackWall);
      firstBlackWall.setLayoutX(327);
      firstBlackWall.setLayoutY(317);
      super.addBuilding(secondBlackWall);
      super.addBuilding(firstBlueWall);
      super.addBuilding(archerBuilding);
      super.addBuilding(canoonBuilding);
  }
  ///---------------------------------
    BlackWall firstBlackWall=new BlackWall("normal",20,0);

    BlackWall secondBlackWall=new BlackWall("normal",20,0);
    BlueWall firstBlueWall=new BlueWall("normal",20,0);
    ArcherBuilding archerBuilding=new ArcherBuilding("Defensive",20,20);
    CanoonBuilding canoonBuilding=new CanoonBuilding("Defensive",20,15);
    //-------------------------

}

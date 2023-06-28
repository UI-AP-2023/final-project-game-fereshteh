package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.strucrure.*;
import model.strucrure.Map;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map1Controller  implements Initializable  {
    @FXML
    private ImageView blackWall2_img;

    @FXML
    private ImageView blueBuliding_image;

    @FXML
    private ImageView canoonBuliding_img;

    @FXML
    private ImageView archerBuilding_img;

    @FXML
    private ImageView blackWall_img;
    @FXML
    private ImageView backgorond;
    ArrayList<Building>buildings=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map map=new Map(buildings,20,backgorond);

    }
    //add building
    public void setBuildings(){
        BlackWall firstBlackWall=new BlackWall("normal",20,0,blackWall2_img,blackWall2_img.getLayoutX(),blackWall2_img.getLayoutY());
        BlackWall secondBlackWall=new BlackWall("normal",20,0,blackWall_img,blackWall_img.getLayoutX(),blackWall_img.getLayoutY());
        BlueWall firstBlueWall=new BlueWall("normal",20,0,blueBuliding_image,blueBuliding_image.getLayoutX(),blueBuliding_image.getLayoutY());
        ArcherBuilding archerBuilding=new ArcherBuilding("Defensive",20,20,archerBuilding_img,archerBuilding_img.getLayoutX(),archerBuilding_img.getLayoutY());
        CanoonBuilding canoonBuilding=new CanoonBuilding("Defensive",20,15,canoonBuliding_img,canoonBuliding_img.getLayoutX(),canoonBuliding_img.getLayoutY());
        buildings.add(firstBlackWall);
        buildings.add(secondBlackWall);
        buildings.add(firstBlueWall);
        buildings.add(archerBuilding);
        buildings.add(canoonBuilding);
    }
}

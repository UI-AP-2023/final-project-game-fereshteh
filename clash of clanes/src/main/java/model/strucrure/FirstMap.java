package model.strucrure;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FirstMap {
    @FXML
    private ImageView blueBuliding_image;

    @FXML
    private ImageView canoonBuliding_img;

    @FXML
    private ImageView archerBuilding_img;

    @FXML
    private ImageView blackWall_img;
    //------------------------------
    private ArrayList<Building> buildings=new ArrayList<>();
    private   double x;
    private   double y;
    private int soldiers;
    //------------------------------------


    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
    //------------------------------------

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    //------------------------------------


    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    //------------------------------------


    public int getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }
    //------------------------------------

}

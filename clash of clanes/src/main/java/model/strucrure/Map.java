package model.strucrure;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Map extends ImageView {
    private ArrayList<Building> buildings=new ArrayList<>();
    private   double x;
    private   double y;
    private int soldiers;

    //------------------------------------
    ImageView imageView = new ImageView();
    //----------------

    public Map( double x, double y, int soldiers, ImageView imageView) {
        this.buildings = buildings;
        this.x = x;
        this.y = y;
        this.soldiers = soldiers;
        this.imageView = imageView;
    }

    public Map(String s, ArrayList<Building> buildings, double x, double y, int soldiers, ImageView imageView) {
        super(s);
        this.buildings = buildings;
        this.x = x;
        this.y = y;
        this.soldiers = soldiers;
        this.imageView = imageView;
    }

    public Map( ArrayList<Building> buildings, int soldiers, ImageView imageView) {
        this.buildings = buildings;
        this.soldiers = soldiers;
        this.imageView = imageView;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
    //------------------------------------
    public void addBuilding(Building building){
        buildings.add(building);
    }
    //---------------------------------------
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
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

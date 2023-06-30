package model.strucrure;

import javafx.scene.image.ImageView;
import model.hero.Hero;

import java.util.ArrayList;

public class Map extends ImageView {
    private ArrayList<Building> buildings=new ArrayList<>();
    public ArrayList<Hero>heroes=new ArrayList<>();
    private   double x;
    private   double y;
    private int numberOfSoldiers;

    //------------------------------------
    ImageView imageView = new ImageView();
    //----------------



    public Map( ArrayList<Building> buildings, int soldiers, ImageView imageView) {
        this.buildings = buildings;
        this.numberOfSoldiers = soldiers;
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


    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }
    //-----------------------------------

    public int getNumberOfSoldiers() {
        return numberOfSoldiers;
    }

    public void setNumberOfSoldiers(int numberOfSoldiers) {
        this.numberOfSoldiers = numberOfSoldiers;
    }
    //------------------------------------

}

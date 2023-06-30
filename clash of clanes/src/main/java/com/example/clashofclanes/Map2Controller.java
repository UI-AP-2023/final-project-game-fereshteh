package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.hero.Hero;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map2Controller implements Initializable {
    @FXML
    private ImageView blackWall2_img;

    @FXML
    private ImageView blackWall1_img;

    @FXML
    private ImageView blackWall3_img;

    @FXML
    private ImageView archerBuilding1_img;

    @FXML
    private ImageView canoon1_img;

    @FXML
    private ImageView canoon2_img;

    @FXML
    private ImageView archerBulding2_img;
    private   static ArrayList<Hero> heroes = new ArrayList<>();
    //-------------------------------


    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static void setHeroes(ArrayList<Hero> heroes) {
        Map2Controller.heroes = heroes;
    }
    public static void addHero(Hero hero){
        heroes.add(hero);}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

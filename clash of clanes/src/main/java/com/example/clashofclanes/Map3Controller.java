package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.hero.Hero;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map3Controller implements Initializable {
    @FXML
    private ImageView cackGround_img;

    @FXML
    private ImageView archerBuilding1_img;

    @FXML
    private ImageView archerBuilding2_img;

    @FXML
    private ImageView archerBuilding3_img;

    @FXML
    private ImageView archerBuilding4_img;

    @FXML
    private ImageView blackWall1_img;

    @FXML
    private ImageView blueWall_img;

    @FXML
    private ImageView canonBuilding1_img;

    @FXML
    private ImageView blackWall2_img;

    @FXML
    private ImageView canonBuiding2_img;
    private   static ArrayList<Hero> heroes = new ArrayList<>();
    //-------------------------------


    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static void setHeroes(ArrayList<Hero> heroes) {
        Map3Controller.heroes = heroes;
    }
    public static void addHero(Hero hero){
        heroes.add(hero);}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

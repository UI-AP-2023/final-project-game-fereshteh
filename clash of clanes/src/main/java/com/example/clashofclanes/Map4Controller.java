package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.hero.Hero;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map4Controller implements Initializable {

    @FXML
    private ImageView backGround;
    @FXML
    private ImageView canoon4_img;

    @FXML
    private ImageView canoon3_img;

    @FXML
    private ImageView canoon2_img;

    @FXML
    private ImageView canoon1_img;

    @FXML
    private ImageView archer2_img;

    @FXML
    private ImageView archer3_img;

    @FXML
    private ImageView archer4_img;

    @FXML
    private ImageView archer1_img;

    @FXML
    private ImageView blackWall2_img;

    @FXML
    private ImageView blackWall3_img;

    @FXML
    private ImageView blueWall2_img;

    @FXML
    private ImageView bueWall1_img;

    @FXML
    private ImageView blackWall1_img;

    @FXML
    private ImageView blackWall4_img;

    @FXML
    private ImageView blueWall3_img;
    private   static ArrayList<Hero> heroes = new ArrayList<>();
    //-------------------------------


    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static void setHeroes(ArrayList<Hero> heroes) {
        Map4Controller.heroes = heroes;
    }
    public static void addHero(Hero hero){
        heroes.add(hero);}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

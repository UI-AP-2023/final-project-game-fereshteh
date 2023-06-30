package com.example.clashofclanes;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.hero.Archer_Queen;
import model.hero.Hero;
import model.strucrure.*;
import model.strucrure.Map;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map1Controller implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView start_img;
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
    ArrayList<Building> buildings = new ArrayList<>();
  private   static ArrayList<Hero> heroes = new ArrayList<>();
    //-------------------------------


    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static void setHeroes(ArrayList<Hero> heroes) {
        Map1Controller.heroes = heroes;
    }
    public static void addHero(Hero hero){
    heroes.add(hero);}


    //------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map map = new Map(buildings, 20, backgorond);
        System.out.println("heros size:"+heroes.size());
        for(int i=0;i<heroes.size();i++){
            System.out.println(heroes.get(i).getX());
        }
    }

    //add building
    public void setBuildings() {
        BlackWall firstBlackWall = new BlackWall("normal", 20, 0, blackWall2_img, blackWall2_img.getLayoutX(), blackWall2_img.getLayoutY());
        BlackWall secondBlackWall = new BlackWall("normal", 20, 0, blackWall_img, blackWall_img.getLayoutX(), blackWall_img.getLayoutY());
        BlueWall firstBlueWall = new BlueWall("normal", 20, 0, blueBuliding_image, blueBuliding_image.getLayoutX(), blueBuliding_image.getLayoutY());
        ArcherBuilding archerBuilding = new ArcherBuilding("Defensive", 20, 20, archerBuilding_img, archerBuilding_img.getLayoutX(), archerBuilding_img.getLayoutY());
        CanoonBuilding canoonBuilding = new CanoonBuilding("Defensive", 20, 15, canoonBuliding_img, canoonBuliding_img.getLayoutX(), canoonBuliding_img.getLayoutY());
        buildings.add(firstBlackWall);
        buildings.add(secondBlackWall);
        buildings.add(firstBlueWall);
        buildings.add(archerBuilding);
        buildings.add(canoonBuilding);
    }
    //---------------------------------
    public void startGame() {
        for (Hero hero : heroes) {

            for (Building building : this.buildings) {

                if (hero.Target(building)) {
                    while (hero.getHealth() > 0 && building.getHealth() > 0) {

                        hero.setHealth(hero.getHealth() - building.getAttack_power());
                        building.setHealth(building.getHealth() - hero.getPower());

                        if (hero.getHealth() <= 0) {


                            this.pane.getChildren().remove(hero.getImageView());
                            //building.getImageView().setLayoutX(building.getImageView().getLayoutX() - (building.getSpeed() / 100));
                            //TAScores = TAScores + 10;
                            //TAScore.setText(String.valueOf(TAScores));

                        }
                        if (building.getHealth() <= 0) {
                            pane.getChildren().remove(building.getImageView());
                            //hero.getImageView().setLayoutX((hero.getImageView().getLayoutX() + (hero.getSpeed() / 100)));

                        }
                    }
                }}}
    }


//                if (hero.getImageView().getLayoutX() < 750) {
//                    hero.getImageView().setLayoutX((hero.getImageView().getLayoutX() + (hero.getSpeed() / 100)));
//                }
//
//                if (building.getImageView().getLayoutX() <= 155) {
//                    GamePageController.timer.stop();
//                    JOptionPane.showMessageDialog(null, "TEAM TA WON");
//
//                }
//                if (StudentScores== scoreWin) {
//                    building.getImageView().setVisible(false);
//                    GamePageController.timer.stop();
//                    JOptionPane.showMessageDialog(null, "TEAM STUDENT WON");
//
//                } else {
//                    building.getImageView().setLayoutX(building.getImageView().getLayoutX() - (building.getSpeed() / 100));
//                    hero.getImageView().setLayoutX((hero.getImageView().getLayoutX() + (hero.getSpeed() / 100)));


    //------------------------
    Timeline timer;

    @FXML
    void click_Start(MouseEvent event) {
        timer.play();

    }

    void initTimer() {

        timer = new Timeline(
                new KeyFrame(
                        Duration.seconds(0.1),
                        e -> startGame()
                )
        );
        timer.setCycleCount(Animation.INDEFINITE);
    }
    //---------------------
    public ImageView makeCopy(ImageView imageView, double x, double y,Hero hero) {

        imageView.setFitWidth(45);
        imageView.setFitHeight(90);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        this.pane.getChildren().add(imageView);
        hero.drag(imageView);

        return imageView;
    }
    //-----------------------
//    @FXML
//    public void dragArcher(MouseEvent event){
//        Archer_Queen archerQueen=new Archer_Queen();
//        stu_coffee.setImageView(makeCopy( ar, 156, 103));
//
//        GamePage.root.getChildren().add(stu_coffee);
//        playGroundHeroesStu.add(stu_coffee);
//


}






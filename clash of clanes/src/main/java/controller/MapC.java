package controller;

import com.example.clashofclanes.Map1;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import model.hero.Hero;
import model.strucrure.Building;

import javax.swing.*;
import java.util.ArrayList;

public class MapC {
    private ArrayList<Building> buildings;
    private ArrayList<Hero> heroes;

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    //------------------------------
    //------------------------------
    private static MapC instance;

    private MapC() {

    }

    public static MapC getInstance() {
        if (instance == null) {
            instance = new MapC() {

            };
        }
        return instance;
    }

    //--------------------------------------
    void initTimer() {

        timer = new Timeline(
                new KeyFrame(
                        Duration.seconds(0.1),
                        e -> startGame()

                )
        );
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
        System.out.println("timer start");

    }

    //--------------------------------------
    static Timeline timer;

    public void GamePageController() {
        initTimer();

    }

    //-------------------
    static double deltaX = 1000;
    static double deltaY = 1000;
    static double speed;
    static boolean negativeX = false;
    static boolean negativeY = false;

    public static void startGame() {
        TranslateTransition tt = new TranslateTransition();
      //  tt.setDelay(Duration.seconds(.01));

        for (Hero hero : instance.heroes) {

            for (Building building : instance.buildings) {
                if (deltaX < Math.abs(hero.getLayoutX() - building.getLayoutX()) && deltaY < Math.abs(hero.getLayoutY() - building.getLayoutY())) {
                    deltaX = Math.abs(hero.getLayoutX() - building.getLayoutX());
                    deltaY = Math.abs(hero.getLayoutY() - building.getLayoutY());
                    if ((hero.getLayoutX() - building.getLayoutX()) < 0) {
                        negativeX = true;
                    }
                    if ((hero.getLayoutY() - building.getLayoutY()) < 0) {
                        negativeY = true;
                    }
                    while (!hero.Target(building)) {

                        speed = hero.getSpeed();
                        tt.setNode(hero);
                        System.out.println("deltaX"+deltaX);
                        System.out.println("deltaY"+deltaY);
                        if (negativeX) {
                            tt.setToX(-deltaX / speed);
                            tt.play();
                        } else {
                            tt.setToX(deltaX / speed);
                            tt.play();
                        }
                        if (negativeY) {
                            tt.setToY(-deltaY / speed);
                            tt.play();
                        } else {
                            tt.setToY(deltaY / speed);
                            tt.play();
                        }
                    }
                        while (hero.getHealth() > 0 && building.getHealth() > 0) {
                            hero.setHealth(hero.getHealth() - building.getAttack_power());
                            building.setHealth(hero.getHealth() - hero.getPower());


                            if (hero.getHealth() <= 0) {


                                Map1.root.getChildren().remove(hero.getImageView());
                                // hero1.getImageView().setLayoutX(hero1.getImageView().getLayoutX() - (hero1.getSpeed() / 100));

                            }
                            if (building.getHealth() <= 0) {
                                Map1.root.getChildren().remove(building.getImageView());
                                //hero.getImageView().setLayoutX((hero.getImageView().getLayoutX() + (hero.getSpeed() / 100)));

                            }
                        }
                    }
                }
//                    if (hero.getImageView().getLayoutX() < 750) {
//                        hero.getImageView().setLayoutX((hero.getImageView().getLayoutX() + (hero.getSpeed() / 100)));
//                    }
//
//                    if (hero1.getImageView().getLayoutX() <= 155) {
//                        GamePageController.timer.stop();
//                        JOptionPane.showMessageDialog(null, "TEAM TA WON");
//
//                    }
//                    if (StudentScores == scoreWin) {
//                        hero1.getImageView().setVisible(false);
//                        GamePageController.timer.stop();
//                        JOptionPane.showMessageDialog(null, "TEAM STUDENT WON");
//
//                    } else {
//                        hero1.getImageView().setLayoutX(hero1.getImageView().getLayoutX() - (hero1.getSpeed() / 100));
//                        hero.getImageView().setLayoutX((hero.getImageView().getLayoutX() + (hero.getSpeed() / 100)));
//
//                    }


            }

        }

    }





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
//    private static MapC instance;
//
//    private MapC() {
//
//    }
//
//    public static MapC getInstance() {
//        if (instance == null) {
//            instance = new MapC() {
//
//            };
//        }
//        return instance;
//    }

    int i = 0;

    //--------------------------------------
    void initTimer() throws InterruptedException {
        for (i = 0; i < heroes.size(); i++) {
            ThreadController thread = new ThreadController();
            thread.heroes=heroes;
            thread.buildings=buildings;
            thread.hero=heroes.get(i);
            thread.attckbuilding=attckbuilding;

            thread.username=heroes.get(i).getName();
            System.out.println(" thread username ");
            System.out.println(thread.username);
            thread.start();
           }
            System.out.println("timer start");
        }

    //--------------------------------------
    static Timeline timer;

    public void GamePageController() throws InterruptedException {
        initTimer();

    }

    //-------------------
    static double deltaX = 10000;
    static double deltaY = 10000;
    static double speed;
    static boolean negativeX = false;
    static boolean negativeY = false;

    public  void startGame() {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(1));
        // tt.setDelay(Duration.seconds(.01));
        System.out.println("instance hero size" +heroes.size());
        System.out.println("instance buiding size " + buildings.size());

        for (Hero hero :heroes) {

            for (Building building : buildings) {
                System.out.println("layoutX hero  " + hero.getImageView().getLayoutX());
                System.out.println("layiutX bulding   " + building.getImageView().getLayoutX());
                if (deltaX > Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()) && deltaY > Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY())) {
                    deltaX = Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX());
                    deltaY = Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY());
                    System.out.println("deltaX" + deltaX);
                    System.out.println("deltaY" + deltaY);
                    if ((hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()) < 0) {
                        negativeX = true;
                    }
                    if ((hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()) < 0) {
                        negativeY = true;
                    }


                    speed = hero.getSpeed();
                    tt.setNode(hero.getImageView());
                    double resultX;
                    double resultY;

//                    System.out.println(" while deltaY  " + deltaY);
                    if (negativeX) {
                        resultX = -deltaX;
//                        System.out.println(" whilw deltaX  " + deltaX);
                    } else {
                        resultX = deltaX;

                    }
                    if (negativeY) {
                        resultY = -deltaY;

                    } else {
                        resultY = deltaY;
                    }
                    // while (Math.abs((hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()) )>50 ||Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX())>50){
                    System.out.println("new while");
                    tt.setToX(resultX);
                    tt.setToY(resultY);
                    tt.play();


//                        while (hero.getHealth() > 0 && building.getHealth() > 0) {
//                            hero.setHealth(hero.getHealth() - building.getAttack_power());
//                            building.setHealth(hero.getHealth() - hero.getPower());
//
//
//                            if (hero.getHealth() <= 0) {
//
//
//                                Map1.root.getChildren().remove(hero.getImageView());
//                                // hero1.getImageView().setLayoutX(hero1.getImageView().getLayoutX() - (hero1.getSpeed() / 100));
//
//                            }
//                            if (building.getHealth() <= 0) {
//                                Map1.root.getChildren().remove(building.getImageView());
//                                //hero.getImageView().setLayoutX((hero.getImageView().getLayoutX() + (hero.getSpeed() / 100)));
//
//                            }
//                        }
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

    //--------------------------
    public Building attckbuilding;
     Hero attackhero;

    public  void startGameTaki(Hero hero) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(3000));
        // tt.setDelay(Duration.seconds(.01));
        System.out.println("instance hero size" + heroes.size());
        System.out.println("instance buiding size " + buildings.size());


        for (Building building : buildings) {
            System.out.println("layoutX hero  " + hero.getImageView().getLayoutX());
            System.out.println("layiutX bulding   " + building.getImageView().getLayoutX());
            if (deltaX > Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()) && deltaY > Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY())) {
                deltaX = Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX());
                deltaY = Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY());
                attckbuilding = building;
                attackhero = hero;
                System.out.println("deltaX" + deltaX);
                System.out.println("deltaY" + deltaY);
                if ((hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()) < 0) {
                    negativeX = true;
                }
                if ((hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()) < 0) {
                    negativeY = true;
                }
            }
        }

        speed = hero.getSpeed();
        tt.setNode(hero.getImageView());
        double resultX;
        double resultY;

//                    System.out.println(" while deltaY  " + deltaY);
        if (negativeX) {
            resultX = deltaX;
//                        System.out.println(" whilw deltaX  " + deltaX);
        } else {
            resultX = -deltaX;

        }
        if (negativeY) {
            resultY = deltaY;

        } else {
            resultY = -deltaY;
        }
        // while (Math.abs((hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY()) )>50 ||Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX())>50) {
        System.out.println("new while");
        tt.setToX(resultX);
        tt.setToY(resultY);
        tt.play();
        // }}
    }

    public boolean target(Hero hero) {


        if (Math.abs((hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY())) > 50 || Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX()) > 50) {
            return false;

        }
        return true;
    }
}







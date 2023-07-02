package controller;

import com.example.clashofclanes.Map1Controller;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.util.Duration;
import model.hero.Hero;
import model.strucrure.*;

import java.util.ArrayList;

public class ThreadController extends Thread {
    ArrayList<Hero> heroes = new ArrayList<>();
    ArrayList<Building> buildings = new ArrayList<>();
    public static ArrayList<Double> locations = new ArrayList<>();
    double deltaX = 10000;
    double deltaY = 10000;
    double speed;
    boolean negativeX = false;
    TranslateTransition tt = new TranslateTransition();
    ;
    boolean negativeY = false;
    Hero hero;
    String username;
    double loutX;
    double loutY;
    double stopX;
    double stopY;
    double boundX;
    double boundY;

    @Override
    public void run() {
        nearBuilding(hero);
        //startGameTaki(hero);
//        startGameTaki(hero);
     while (!boundTarget()) {
            try {
                synchronized (this) {
                    startGameTaki(hero);
                    wait(1000);
                    loutX += 70;
                    loutY += 70;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }}
        stopX=hero.getImageView().getLayoutX();
        stopY=hero.getImageView().getLayoutY();
        System.out.println(" start attack ");
        attack();
    }
    Building attckbuilding;
    Hero attackhero;
    public void startGameTaki(Hero hero) {

        tt.setDuration(Duration.millis(3000));
       // tt.setDelay(Duration.seconds(4));
        if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) > Math.sqrt(Math.pow(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX(), 2) + Math.pow(hero.getImageView().getLayoutY() -
                attckbuilding.getImageView().getLayoutY(), 2))) {
            deltaX = Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX());
            deltaY = Math.abs(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY());
            System.out.println("deltaX" + deltaX);
            System.out.println("deltaY" + deltaY);
            if ((hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX()) < 0) {
                negativeX = true;
            }
            if ((hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY()) < 0) {
                negativeY = true;
            }
        }
        tt.setNode(hero.getImageView());
        double resultX;
        double resultY;
        if (negativeX) {
            resultX = deltaX;
        } else {
            resultX = -deltaX;
        }
        if (negativeY) {
            resultY = deltaY;
        } else {
            resultY = -deltaY;
        }
        tt.setToX(resultX);
        tt.setToY(resultY);
        tt.play();
    }

    public boolean target(Hero hero) {
        if (Math.sqrt(Math.pow((hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY()), 2) +
                Math.pow(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX(), 2)) > 100) {
            System.out.println("false target");
            tt.stop();
            return false;
        } else if (Math.abs(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY()) < 100) {
            tt.stop();

            return true;
        } else if (Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX()) < 100) {
            tt.stop();

            return true;
        }

        return true;
    }

    public boolean boundTarget() {
        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxX()  - attckbuilding.getImageView().getBoundsInParent().getMinX())<=10) {
                tt.stop();
            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMinY()  - attckbuilding.getImageView().getBoundsInParent().getMaxY())<=10) {
           tt.stop();
            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMinX() - attckbuilding.getImageView().getBoundsInParent().getMaxX())<=10) {
          tt.stop();
            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxY()- attckbuilding.getImageView().getBoundsInParent().getMinY())<=10) {
           tt.stop();
            return true;
        }
        //------------------------------------
//        if (Math.abs(hero.getBoundsInParent().getMaxX() - attckbuilding.getBoundsInParent().getMinX())>=10) {
//
//            return true;
//        }
//        if (Math.abs(hero.getBoundsInParent().getMinY() - attckbuilding.getBoundsInParent().getMaxY())>=10) {
//            return true;
//        }
//        if (Math.abs(hero.getBoundsInParent().getMinX() - attckbuilding.getBoundsInParent().getMaxX())>=10) {
//            return true;
//        }
//        if (Math.abs(hero.getBoundsInParent().getMaxY() - attckbuilding.getBoundsInParent().getMinY())>=10) {
//            return true;
//        }

        return false;
    }
    //---------------------
    public boolean withoutImageViewBoundTarget() {
        if (hero.getBoundsInParent().getMaxX()  == attckbuilding.getBoundsInParent().getMinX()) {
            tt.stop();
            return true;
        }
        if (hero.getBoundsInParent().getMinY()  == attckbuilding.getBoundsInParent().getMaxY()) {
            tt.stop();
            return true;
        }
        if (hero.getBoundsInParent().getMinX() == attckbuilding.getBoundsInParent().getMaxX()) {
            tt.stop();
            return true;
        }
        if (hero.getBoundsInParent().getMaxY()== attckbuilding.getBoundsInParent().getMinY()) {
            tt.stop();
            return true;
        }
        //------------------------------------
        if (hero.getBoundsInParent().getMaxX() +2== attckbuilding.getBoundsInParent().getMinX()) {
            return true;
        }
        if (hero.getBoundsInParent().getMinY() -2 == attckbuilding.getBoundsInParent().getMaxY()) {
            return true;
        }
        if (hero.getBoundsInParent().getMinX() -2== attckbuilding.getBoundsInParent().getMaxX()) {
            return true;
        }
        if (hero.getBoundsInParent().getMaxY() +2== attckbuilding.getBoundsInParent().getMinY()) {
            return true;
        }

        return false;
    }

    public boolean targetlayout(Hero hero) {
        if (Math.sqrt(Math.pow((loutY - attckbuilding.getImageView().getLayoutY()), 2) +
                Math.pow(loutX - attckbuilding.getImageView().getLayoutX(), 2)) > 50) {
            System.out.println("false target");
            System.out.println(loutX);
            tt.stop();
            return false;
        } else if (Math.abs(loutY - attckbuilding.getImageView().getLayoutY()) < 50) {
            tt.stop();

            return true;
        } else if (Math.abs(loutX - attckbuilding.getImageView().getLayoutX()) < 50) {
            tt.stop();

            return true;
        }

        return true;
    }

//        public void nearBuilding(Hero hero) {
//            for (Building building : buildings) {
//                if (Math.sqrt(Math.pow(hero.getImageView().getLayoutY() - deltaY, 2) + Math.pow(hero.getImageView().getLayoutX() - deltaX, 2)) > Math.sqrt(Math.pow(Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()), 2) + Math.pow(Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()), 2))) {
//                    deltaX = Math.abs(building.getImageView().getLayoutX());
//                    deltaY = Math.abs(building.getImageView().getLayoutY());
//                    attckbuilding = building;
//                }
//
//            }
//        }

    public void nearBuilding(Hero hero) {
        loutX = hero.getImageView().getLayoutX();
        loutY = hero.getImageView().getLayoutY();
        for (Building building : buildings) {
            if (Math.sqrt(Math.pow(hero.getImageView().getLayoutY() - deltaY, 2) + Math.pow(hero.getImageView().getLayoutX() - deltaX, 2)) > Math.sqrt(Math.pow(Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()), 2) + Math.pow(Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()), 2))) {
                deltaX = Math.abs(building.getImageView().getLayoutX());
                deltaY = Math.abs(building.getImageView().getLayoutY());
                attckbuilding = building;
            }
            //System.out.println(hero.getName());
            // System.out.println(attckbuilding);

        }
    }

    boolean contourne = true;

    public void attack() {
        System.out.println("attack");
        while (contourne) {
            if (hero.getHealth() > 0 || attckbuilding.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - attckbuilding.getAttack_power());
                attckbuilding.setHealth(attckbuilding.getHealth() - hero.getPower());
                hero.getShotHer0Img().setLayoutX(hero.getImageView().getLayoutX());
                TranslateTransition transition=new TranslateTransition();
                transition.setNode(hero.getShotHer0Img());
//                tt.setToX(hero.getImageView().getLayoutX());
//                tt.setToY(hero.getImageView().getLayoutY());
//                tt.setDuration(Duration.millis(1000));
                //tt.play();
                transition.setToX(hero.getImageView().getLayoutX());
                transition.setToY(hero.getImageView().getLayoutY());
                transition.play();
                hero.getShotHer0Img().setVisible(true);

            }
            if (hero.getHealth() <= 0 || attckbuilding.getHealth() <= 0) {
                contourne = false;
            }
        }
    }

    //---------------------------
//    @FXML
//    void shot(Hero hero){
//        TranslateTransition tt=new TranslateTransition(Duration.millis(2000));
//        tt.setDelay(Duration.seconds(4));
//        tt.setDuration(Duration.seconds(3));
//        shot_img.setVisible(true);
//        tt.setNode(shot_img);
//        shot_img.setTranslateX(hero.getImageView().getTranslateX());
//        shot_img.setTranslateY(hero.getImageView().getTranslateY());
//        tt.setAutoReverse(true);
//        tt.setCycleCount(5);
//        tt.play();
//    }
    void showLocations() {
        while (this.isAlive())
            System.out.println(hero.getImageView().getLayoutX());

    }

}

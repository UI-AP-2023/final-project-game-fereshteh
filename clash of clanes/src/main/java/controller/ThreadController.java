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
    double deltaX = 10000;
    double deltaY = 10000;
    double speed;
    boolean negativeX = false;
    TranslateTransition tt= new TranslateTransition();;
    boolean negativeY = false;
    Hero hero;
    String username;

    @Override
    public void run() {
        nearBuilding(hero);
//        startGameTaki(hero);
        while (!target(hero)) {
            try {
                synchronized (this) {

                    startGameTaki(hero);
                    wait(1000);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //nearBuilding(hero);
            //startGameTaki(hero);
//            if (attckbuilding instanceof BlackWall) {
//                System.out.println("black wall");
//            } else if (attckbuilding instanceof BlueWall) {
//                System.out.println("blue wall");
//            } else if (attckbuilding instanceof CanoonBuilding) {
//                System.out.println("canoon building");
//            } else if (attckbuilding instanceof ArcherBuilding) {
//                System.out.println("archerBuilding");
//            }
        }
        attack();

//        try {
//            this.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }

    Building attckbuilding;
    Hero attackhero;

    public void startGameTaki(Hero hero) {

        tt.setDuration(Duration.millis(6000));
        if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) > Math.sqrt(Math.pow(hero.getImageView().getLayoutX() -
                attckbuilding.getImageView().getLayoutX(), 2) + Math.pow(hero.getImageView().getLayoutY() -
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
        }
        else if(Math.abs(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY())<100){
            tt.stop();

            return true;
        }
        else if(Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX())<100){
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
    boolean contourne=true;
    public void attack(){
        System.out.println("attack");
        while (contourne){
            if(hero.getHealth()>0 || attckbuilding.getHealth()>0){
                hero.setHealth(hero.getHealth()-attckbuilding.getAttack_power());
                attckbuilding.setHealth(attckbuilding.getHealth()-hero.getPower());
                hero.getShotHer0Img().setLayoutX(hero.getImageView().getLayoutX());
                hero.getShotHer0Img().setLayoutY(hero.getImageView().getLayoutY());
                hero.getShotHer0Img().setVisible(true);
            }
            if(hero.getHealth()<=0||attckbuilding.getHealth()<=0){
                contourne=false;
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

}

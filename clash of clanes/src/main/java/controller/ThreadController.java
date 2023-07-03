package controller;

import com.example.clashofclanes.Map1;
import com.example.clashofclanes.ProfileController;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import model.hero.Hero;
import model.strucrure.*;

import java.util.ArrayList;

public class ThreadController extends Thread {
    private ArrayList<Building> buildings = new ArrayList<>();
    private double deltaX = 10000;
    private double deltaY = 10000;
    double speed;
    private boolean negativeX = false;
    private TranslateTransition tt = new TranslateTransition();
    ;
    private boolean negativeY = false;
    private Hero hero;
    //-----------------

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Building getAttckbuilding() {
        return attckbuilding;
    }

    public void setAttckbuilding(Building attckbuilding) {
        this.attckbuilding = attckbuilding;
    }

    //-----------------


    @Override
    public void run() {
        nearBuilding(hero);
        walk(hero);
        while (!boundTarget()) {
            try {
                synchronized (this) {
                    walk(hero);
                    wait(1000);

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("  start attack  ");
        attack();
    }
    Building attckbuilding;

    public void walk(Hero hero) {

        tt.setDuration(Duration.millis(2000));
        // tt.setDelay(Duration.seconds(4));
        if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) > Math.sqrt(Math.pow(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX(), 2) + Math.pow(hero.getImageView().getLayoutY() -
                attckbuilding.getImageView().getLayoutY(), 2))) {
            deltaX = Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX()) - 25;
            deltaY = Math.abs(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY()) - 25;

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

    public boolean boundTarget() {
        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxX() - attckbuilding.getImageView().getBoundsInParent().getMinX()) <= 10) {

            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMinY() - attckbuilding.getImageView().getBoundsInParent().getMaxY()) <= 10) {

            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMinX() - attckbuilding.getImageView().getBoundsInParent().getMaxX()) <= 10) {

            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxY() - attckbuilding.getImageView().getBoundsInParent().getMinY()) <= 10) {

            return true;
        }
        //------------------------------------
//        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxX() - attckbuilding.getImageView().getBoundsInParent().getMinX())<=10) {
//
//            return true;
//        }
//        if (Math.abs(hero.getImageView().getBoundsInParent().getMinY() - attckbuilding.getImageView().getBoundsInParent().getMaxY())<=10) {
//            return true;
//        }
//        if (Math.abs(hero.getImageView().getBoundsInParent().getMinX() - attckbuilding.getImageView().getBoundsInParent().getMaxX())<=10) {
//            return true;
//        }
//        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxY() - attckbuilding.getImageView().getBoundsInParent().getMinY())<=10) {
//            return true;
//        }
        return false;
    }
    //---------------------
    public void nearBuilding(Hero hero) {
        for (Building building : buildings) {
            if (Math.sqrt(Math.pow(hero.getImageView().getLayoutY() - deltaY, 2) + Math.pow(hero.getImageView().getLayoutX() - deltaX, 2)) > Math.sqrt(Math.pow(Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()), 2) + Math.pow(Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()), 2))) {
                deltaX = Math.abs(building.getImageView().getLayoutX());
                deltaY = Math.abs(building.getImageView().getLayoutY());
                attckbuilding = building;
            }
        }
    }
    boolean contourne = true;
    public void attack() {
        int numberOfDiedBuilding=0;
        int numberOfDiedHero=0;
        boolean win = false;
        while (contourne) {
            if (hero.getHealth() > 0 || attckbuilding.getHealth() > 0) {
                shot(hero);
                hero.setHealth(hero.getHealth() - attckbuilding.getAttack_power());
                System.out.println("username :   "+hero.getName()+"health  :   " +hero.getHealth()+" before Attack");
                System.out.println("building name  "+attckbuilding.getName()+"health  :  "+attckbuilding.getHealth()+"  before attack ");

                attckbuilding.setHealth(attckbuilding.getHealth() - hero.getPower());
                hero.getShotHer0Img().setLayoutX(hero.getImageView().getBoundsInParent().getCenterX() + 10);
                hero.getShotHer0Img().setLayoutY(hero.getImageView().getBoundsInParent().getCenterY() + 10);

                System.out.println("username :   "+hero.getName()+"health  :   " +hero.getHealth()+" After Attack");
                System.out.println("building name  "+attckbuilding.getName()+"health  :  "+attckbuilding.getHealth()+"  after attack ");


              //  hero.getShotHer0Img().setVisible(true);

            }
            if(hero.getHealth()<=0){
                hero.getImageView().setVisible(false);
                hero.getShotHer0Img().setVisible(false);
                
            }
            if (attckbuilding.getHealth()<=0){
                attckbuilding.getImageView().setVisible(false);

            }
            if (hero.getHealth() <= 0 || attckbuilding.getHealth() <= 0) {
                MapC.attackConnection(ProfileController.getIndexOfAttack(), win);
                contourne = false;
            }
        }
    }
    //---------------------------
//    @FXML
    void shot(Hero hero) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
        tt.setDuration(Duration.millis(2000));
        tt.setDelay(Duration.millis(1000));
        hero.getShotHer0Img().setVisible(true);
        tt.setNode(hero.getShotHer0Img());
        tt.setToX(attckbuilding.getImageView().getBoundsInParent().getCenterX());
        tt.setToY(attckbuilding.getImageView().getBoundsInParent().getCenterY());
        tt.setAutoReverse(true);
        tt.setCycleCount(10);
        tt.play();
    }
}

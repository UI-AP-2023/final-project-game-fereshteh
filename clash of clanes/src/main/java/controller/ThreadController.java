package controller;

import com.example.clashofclanes.Map1;
import com.example.clashofclanes.Map1Controller;
import com.example.clashofclanes.ProfileController;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import model.hero.Archer_Queen;
import model.hero.Hero;
import model.strucrure.*;

import java.io.IOException;
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
            try {
                walk(hero);
                attack();
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
//    @Override
//    public void run() {
//        nearBuilding(hero);
//        try {
//            walk(hero);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("  start attack  ");
//        attack();
//    }

    Building attckbuilding;

    public void walk(Hero hero) throws InterruptedException {

        // tt.setDuration(Duration.millis(1000));
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
//        tt.setToX(resultX);
//        tt.setToY(resultY);
//        tt.play();

        int sumX = (int) (resultX / hero.getSpeed());
        int sumY = (int) (resultY / hero.getSpeed());
        boolean target = true;
        while (!boundTarget()) {
            tt.setDelay(Duration.millis(1000));
          //  Thread.sleep(1000);
            if (resultX > 0) {
                if (Math.abs(sumX) < Math.abs(resultX)) {

                    tt.setToX(sumX);
                    sumX += sumX;
                }

            }
            //  tt.setDelay(Duration.millis(500));
            if (resultX < 0) {
                tt.setToX(sumX);
                sumX -= sumX;
            }
            if (resultY > 0) {
                tt.setToY(sumY);
                sumY += sumY;
            } else if (resultY < 0) {
                tt.setToY(sumY);
                sumY -= sumY;
            }
            if(Math.abs(sumX)-Math.abs(resultX)<=10&& Math.abs(sumY)-Math.abs(resultY)<=10){
                target=false;
            }

            tt.play();

        }
       // tt.stop();
        System.out.println(hero.getName() + "برخورد");
    }

    public boolean boundTarget() {
        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxX() -
                attckbuilding.getImageView().getBoundsInParent().getMinX()) <= 5) {

            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMinY() -
                attckbuilding.getImageView().getBoundsInParent().getMaxY()) <= 5) {

            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMinX() -
                attckbuilding.getImageView().getBoundsInParent().getMaxX()) <= 5) {

            return true;
        }
        if (Math.abs(hero.getImageView().getBoundsInParent().getMaxY() -
                attckbuilding.getImageView().getBoundsInParent().getMinY()) <= 5) {

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
        if(buildings.size()!=0){
        for (Building building : buildings) {
            if (Math.sqrt(Math.pow(hero.getImageView().getLayoutY() - deltaY, 2) + Math.pow(hero.getImageView().getLayoutX() - deltaX, 2)) > Math.sqrt(Math.pow(Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()), 2) + Math.pow(Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()), 2))) {
                if (building.isVisible()) {
                    deltaX = Math.abs(building.getImageView().getLayoutX());
                    deltaY = Math.abs(building.getImageView().getLayoutY());
                    attckbuilding = building;
                }
            }
        }}

    }

    boolean contourne = true;

    public void attack() throws InterruptedException, IOException {
        int numberOfDiedBuilding = 0;
        int numberOfDiedHero = 0;
        boolean win = false;
        while (contourne) {
            if (hero.getHealth() > 0 || attckbuilding.getHealth() > 0) {
                shot(hero);
               // hero.getShotHer0Img().setVisible(true);
                System.out.println("username :   " + hero.getName() + "health  :   " + hero.getHealth() + " before Attack");
                hero.setHealth(hero.getHealth() - attckbuilding.getAttack_power());
                System.out.println("building name  " + attckbuilding.getName() + "health  :  " + attckbuilding.getHealth() + "  before attack ");
                attckbuilding.setHealth(attckbuilding.getHealth() - hero.getPower());
                hero.getShotHer0Img().setLayoutX(hero.getImageView().getBoundsInParent().getCenterX() + 10);
                hero.getShotHer0Img().setLayoutY(hero.getImageView().getBoundsInParent().getCenterY() + 10);
                System.out.println("username :   " + hero.getName() + "health  :   " + hero.getHealth() + " After Attack");
                System.out.println("building name  " + attckbuilding.getName() + "health  :  " + attckbuilding.getHealth() + "  after attack ");
                //  hero.getShotHer0Img().setVisible(true);
                tt.setDelay(Duration.millis(1000));
            }
            if (hero.getHealth() <= 0) {
                hero.getImageView().setVisible(false);
                hero.getShotHer0Img().setVisible(false);
                Map1Controller.removeHero(hero);
            }
            if (attckbuilding.getHealth() <= 0) {
                attckbuilding.getImageView().setVisible(false);
                if (attckbuilding instanceof ArcherBuilding ){
                    ((ArcherBuilding) attckbuilding).getShot().setVisible(false);
                }
                else if(attckbuilding instanceof CanoonBuilding){
                    ((CanoonBuilding) attckbuilding).getShot().setVisible(false);
                }


            }
            if (!attckbuilding.getImageView().isVisible()&& buildings.size()>0 ) {
                nearBuilding(hero);
            }
            if (Map1Controller.getHeroes().size() == 0 || Map1Controller.getBuildings().size() == 0) {

                if (Map1Controller.getHeroes().size() == 0) {
                    Map1Controller.setWin(false);

//                    if(attckbuilding instanceof CanoonBuilding){
//
//                    }
//                    else if(attckbuilding instanceof BlueWall){
//
//                    }
//                    else if(attckbuilding instanceof BlackWall){
//
//                    }
//                    else if(attckbuilding instanceof ArcherBuilding){
//
//                    }
                    // MapC.attackConnection(ProfileController.getIndexOfAttack(), win);
                    contourne = false;
                    break;
                } else {
                    Map1Controller.setWin(true);
                     MapC.attackConnection(ProfileController.getIndexOfAttack(), win);
                    contourne = false;
                    break;
                }
            }
     // Thread.sleep(2000);  }
    }}

    //---------------------------
//    @FXML
    void shot(Hero hero) {
        tt.setDelay(Duration.millis(3000));
        TranslateTransition tt = new TranslateTransition();
       // tt.setDuration(Duration.millis(2000));
        tt.setDelay(Duration.millis(500));
        if(hero instanceof Archer_Queen){
        hero.getShotHer0Img().setVisible(true);}
        tt.setNode(hero.getShotHer0Img());
        tt.setToX(attckbuilding.getImageView().getBoundsInParent().getCenterX());
        tt.setToY(attckbuilding.getImageView().getBoundsInParent().getCenterY());
        tt.setAutoReverse(true);
        tt.setCycleCount(10);
        tt.play();
    }
}

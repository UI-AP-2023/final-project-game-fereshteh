package controller;

import com.example.clashofclanes.Map1;
import com.example.clashofclanes.Map1Controller;
import com.example.clashofclanes.ProfileController;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.hero.*;
import model.strucrure.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
    private static ArrayList<Hero> heroes = new ArrayList<>();

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static void setHeroes(ArrayList<Hero> heroes) {
        ThreadController.heroes = heroes;
    }

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

    boolean isContourne = true;

    @Override
    public void run() {
        nearBuilding(hero);
        try {
            walk(hero);
            attack();
//            nearBuilding(hero);
//            walk(hero);
            for (int i = 0; i < heroes.size(); i++) {
                if (heroes.get(i).getHealth() > 0) {
                    MapC.addThread(hero);
                }


            }
            ProfileController.show = true;
            // System.out.println("walk 2+++++++++++++++++++++++++++++++++++");
            if (Map1Controller.getHeroes().size() == 0 || Map1Controller.getBuildings().size() == 0) {

                if (Map1Controller.getHeroes().size() == 0) {
                    Label label = new Label("fail");
                    label.setLayoutY(516);
                    label.setLayoutY(324);
                    Map1.root.getChildren().add(label);
                    ProfileController.addFailure();
                    ProfileController.show = true;
                    // break;
                } else {
                    Label label = new Label("win");
                    Map1.root.getChildren().add(label);
                    ProfileController.addSuccess();
                    // MapC.attackConnection(ProfileController.getIndexOfAttack(), win);
                    // contourne = false;
                    // break;
                }
            }

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    Building attckbuilding;

    public void walk(Hero hero) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(4000));
        if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) > Math.sqrt(Math.pow(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX(), 2) + Math.pow(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY(), 2))) {
            deltaX = Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX());
            deltaY = Math.abs(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY());
//            System.out.println("deltaX" + deltaX);
//            System.out.println("deltaY" + deltaY);
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
        if (hero instanceof Barbarian_King || hero instanceof Wizard || hero instanceof Grand_Warden) {
            tt.setToX(resultX);
            tt.setToY(resultY);
            tt.play();
        }

        try {
            sleep(3000);
        } catch (InterruptedException z) {
            z.printStackTrace();
        }
        //System.out.println(hero.getName() + "برخورد");
    }

    public void walk2(Hero hero) throws InterruptedException {
        TranslateTransition tt = new TranslateTransition();
        // tt.setDuration(Duration.millis(4000));
        deltaX = 10000;
        deltaY = 10000;
        negativeX = false;
        negativeY = false;
        if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) > Math.sqrt(Math.pow(hero.getImageView().getLayoutX()
                - attckbuilding.getImageView().getLayoutX(), 2) + Math.pow(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY(), 2))) {
            deltaX = Math.abs(hero.getImageView().getLayoutX() - attckbuilding.getImageView().getLayoutX());
            deltaY = Math.abs(hero.getImageView().getLayoutY() - attckbuilding.getImageView().getLayoutY());

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
        //sleep(1000);
        tt.play();
        try {
            sleep(300);
        } catch (InterruptedException z) {
            z.printStackTrace();
        }

        // System.out.println(hero.getName() + "برخورد 2 ");

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

        return false;
    }

    //---------------------
    public void nearBuilding(Hero hero) {
        if (buildings.size() != 0) {
            for (Building building : buildings) {
                if (building.isVisible()) {
                    if (Math.sqrt(Math.pow(hero.getImageView().getLayoutY() - deltaY, 2) + Math.pow(hero.getImageView().getLayoutX() - deltaX, 2)) > Math.sqrt(Math.pow(Math.abs(hero.getImageView().getLayoutX() - building.getImageView().getLayoutX()), 2) + Math.pow(Math.abs(hero.getImageView().getLayoutY() - building.getImageView().getLayoutY()), 2))) {
                        if (building.isVisible()) {
                            deltaX = Math.abs(building.getImageView().getLayoutX());
                            deltaY = Math.abs(building.getImageView().getLayoutY());
                            attckbuilding = building;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    boolean contourne = true;

    public void attack() throws InterruptedException, IOException {
        int numberOfDiedBuilding = 0;
        int numberOfDiedHero = 0;
        boolean win = false;
        while (contourne) {
            if (hero.getHealth() > 0 && attckbuilding.getHealth() > 0) {
                if (hero instanceof Archer_Queen) {
                    hero.getShotHer0Img().setVisible(true);}
//                if (hero instanceof Archer_Queen)
                shot(hero);
                // hero.getShotHer0Img().setVisible(true);
                //System.out.println("username :   " + hero.getName() + "health  :   " + hero.getHealth() + " before Attack");
                hero.setHealth(hero.getHealth() - attckbuilding.getAttack_power());
                System.out.println("building name  " + attckbuilding.getName() + "health  :  " + attckbuilding.getHealth() + "  before attack ");
                attckbuilding.setHealth(attckbuilding.getHealth() - hero.getPower());
                //  System.out.println("username :   " + hero.getName() + "health  :   " + hero.getHealth() + " After Attack");
                //  System.out.println("building name  " + attckbuilding.getName() + "health  :  " + attckbuilding.getHealth() + "  after attack ");
                sleep(500);
                //  hero.getShotHer0Img().setVisible(true);
            }
            if (hero.getHealth() <= 0) {
                hero.getImageView().setVisible(false);
                hero.getShotHer0Img().setVisible(false);
                Map1Controller.removeHero(hero.getImageView().getImage());
            }
            if (attckbuilding.getHealth() <= 0) {
                //++++++++++++++++++++
                attckbuilding.getImageView().setVisible(false);
                buildings.remove(attckbuilding);
                Map1Controller.removeHero(hero.getImageView().getImage());


//                if(buildings.size()>0){
//                    nearBuilding(hero);
//                }
                if (attckbuilding instanceof ArcherBuilding) {
                    ((ArcherBuilding) attckbuilding).getShot().setVisible(false);
                    ((ArcherBuilding) attckbuilding).getShot2().setVisible(false);

                    break;

                } else if (attckbuilding instanceof CanoonBuilding) {
                    ((CanoonBuilding) attckbuilding).getShot().setVisible(false);
                    break;
                }
//                if (hero instanceof Archer_Queen) {
//                    hero.getShotHer0Img().setVisible(false);
//                }
//                tt.stop();
//                walk2(hero);

            }
//            if (!attckbuilding.getImageView().isVisible() && buildings.size() > 0) {
//                nearBuilding(hero);
//            }

            // Thread.sleep(2000);  }
        }
    }

    //---------------------------
//    @FXML
    void shot(Hero hero) throws InterruptedException {
//        TranslateTransition tt=new TranslateTransition();
//        boolean negativeXX = false;
//        double locationY = 10000;
//        double locationX =10000;
//        boolean negativeYY = false;
//        if(hero instanceof Archer_Queen){
//            hero.getShotHer0Img().setVisible(true);}
//
//        if (hero instanceof Archer_Queen) {
//            hero.getShotHer0Img().setVisible(true);
//        }
//        tt.setNode(hero.getShotHer0Img());
//        tt.setToX(attckbuilding.getImageView().getBoundsInParent().getCenterX());
//        tt.setToY(attckbuilding.getImageView().getBoundsInParent().getCenterY());
//        tt.setToX(attckbuilding.getImageView().getLayoutX());
//        tt.setToY(attckbuilding.getImageView().getLayoutY());
//        tt.setAutoReverse(true);
//        tt.setCycleCount(10);
//        tt.setCycleCount(40);
//        tt.play();
//    }


//        hero.getShotHer0Img().setLayoutX(hero.getImageView().getLayoutX());
//        hero.getShotHer0Img().setLayoutY(hero.getImageView().getLayoutY());
//
//
//        tt.setToX(attckbuilding.getImageView().getBoundsInParent().getMaxX() + 20);
//        tt.setToY(attckbuilding.getImageView().getBoundsInParent().getMaxY() + 20);
//        tt.setCycleCount(5);
//        sleep(1000);
//        tt.setAutoReverse(true);
//        tt.play();


//---------------------------
//    @FXML
//    void shot(Hero hero) {
//
//        TranslateTransition tt = new TranslateTransition();
//


        if (hero instanceof Archer_Queen) {
            hero.getShotHer0Img().setVisible(true);

            tt.setNode(hero.getShotHer0Img());
            tt.setToX(attckbuilding.getImageView().getBoundsInParent().getCenterX());
            tt.setToY(attckbuilding.getImageView().getBoundsInParent().getCenterY());
            tt.setToX(attckbuilding.getImageView().getLayoutX());
            tt.setToY(attckbuilding.getImageView().getLayoutY());
            tt.setAutoReverse(true);
            tt.setCycleCount(40);
            //   tt.setCycleCount(40);
            tt.play();
        }
    }
}
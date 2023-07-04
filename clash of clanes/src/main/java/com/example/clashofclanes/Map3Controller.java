package com.example.clashofclanes;

import controller.MapC;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.hero.*;
import model.strucrure.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.clashofclanes.Map1Controller.setBuildings;

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

    @FXML
    private AnchorPane meno_pane;

    @FXML
    private ImageView GrandWarden_img;

    @FXML
    private ImageView barbarianKing_img;

    @FXML
    private ImageView Wizard_img;

    @FXML
    private ImageView archerQueen_img;

    @FXML
    private ImageView startGame_img;

    @FXML
    private ImageView shot_img;

    @FXML
    private ImageView tirArcher_img;

    @FXML
    private ImageView tirGarden_img;

    @FXML
    private ImageView tirBarbarian_img;

    @FXML
    private ImageView tirBlueWall_img;

    @FXML
    private ImageView tirCanoon_img;
    private   static ArrayList<Hero> heroes = new ArrayList<>();
    private static ArrayList<Building> buildings = new ArrayList<>();
    Wizard wizard;
    Archer_Queen archerQueen;
    Barbarian_King barbarianKing;
    Grand_Warden grandWarden;
    Building attackBuilding;
    //-------------------------------


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


        Map map = new Map(buildings, 20, cackGround_img);
        setHero();
        setBuildings();

        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(heroes.get(i).getName());
        }
        if (wizard == null) {
            Wizard_img.setVisible(false);
        } else {
            Wizard_img.setVisible(true);
        }
        if (grandWarden == null) {
            GrandWarden_img.setVisible(false);
        } else {
            GrandWarden_img.setVisible(true);
        }
        if (archerQueen == null) {
            barbarianKing_img.setVisible(false);
        }
        if (barbarianKing == null) {
            archerQueen_img.setVisible(false);
        }
        //---------------------------------
        meno_pane.setLayoutX(-450);
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
        tt.setDelay(Duration.seconds(2));
        //tt.setDuration(Duration.seconds(3));
        tt.setNode(meno_pane);
        tt.setToX(450);
        tt.setToZ(-200);
        tt.play();
        numberOfHeros();
        //-----------------------------
        TranslateTransition buildingShot = new TranslateTransition(Duration.millis(500));
        buildingShot.setNode(tirCanoon_img);
        buildingShot.setByX(100);
        buildingShot.setByY(100);
        buildingShot.setAutoReverse(true);
        buildingShot.setCycleCount(50);
        buildingShot.play();
        //-------------------------------
        TranslateTransition archerBuildingShot = new TranslateTransition(Duration.millis(500));
        archerBuildingShot.setNode(tirBlueWall_img);
        archerBuildingShot.setByX(100);
        archerBuildingShot.setByY(100);
        archerBuildingShot.setAutoReverse(true);
        archerBuildingShot.setCycleCount(50);
        archerBuildingShot.play();
    }
    public void setBuildings() {
        BlackWall firstBlackWall = new BlackWall("normal", 130, 10, blackWall2_img, blackWall2_img.getLayoutX(), blackWall2_img.getLayoutY());
        firstBlackWall.setName("black wall2");
        BlackWall secondBlackWall = new BlackWall("normal", 160, 10, blackWall1_img, blackWall1_img.getLayoutX(), blackWall1_img.getLayoutY());
        secondBlackWall.setName("black wall1");

        ArcherBuilding archerBuilding = new ArcherBuilding("Defensive", 150, 15, archerBuilding1_img, archerBuilding1_img.getLayoutX(), archerBuilding1_img.getLayoutY());
        archerBuilding.setName("archerBuilding");

        ArcherBuilding archerBuilding2 = new ArcherBuilding("Defensive", 150, 15, archerBuilding2_img, archerBuilding2_img.getLayoutX(), archerBuilding2_img.getLayoutY());
        archerBuilding2.setName("archerBuilding");

        ArcherBuilding archerBuilding3 = new ArcherBuilding("Defensive", 150, 15, archerBuilding3_img, archerBuilding3_img.getLayoutX(), archerBuilding3_img.getLayoutY());
        archerBuilding3.setName("archerBuilding");

        ArcherBuilding archerBuilding4 = new ArcherBuilding("Defensive", 150, 15, archerBuilding4_img, archerBuilding4_img.getLayoutX(), archerBuilding4_img.getLayoutY());
        archerBuilding4.setName("archerBuilding");



        CanoonBuilding canoonBuilding = new CanoonBuilding("Defensive", 120, 12, canonBuilding1_img, canonBuilding1_img.getLayoutX(), canonBuilding1_img.getLayoutY());
        canoonBuilding.setName("canoon bulding");

        CanoonBuilding canoonBuilding2 = new CanoonBuilding("Defensive", 120, 12, canonBuiding2_img, canonBuiding2_img.getLayoutX(), canonBuiding2_img.getLayoutY());
        canoonBuilding2.setName("canoon bulding");

        canoonBuilding.setShot(tirCanoon_img);
        archerBuilding.setShot(tirArcher_img);

        buildings.add(firstBlackWall);
        buildings.add(secondBlackWall);

        buildings.add(archerBuilding);
        buildings.add(archerBuilding4);
        buildings.add(archerBuilding2);
        buildings.add(archerBuilding3);
        buildings.add(canoonBuilding2);
        buildings.add(canoonBuilding);


        Map1.root.getChildren().add(firstBlackWall);
        Map1.root.getChildren().add(secondBlackWall);
        Map1.root.getChildren().add(archerBuilding);
        Map1.root.getChildren().add(archerBuilding2);
        Map1.root.getChildren().add(archerBuilding3);
        Map1.root.getChildren().add(archerBuilding4);
        Map1.root.getChildren().add(canoonBuilding);
        Map1.root.getChildren().add(canoonBuilding2);
        attackBuilding = firstBlackWall;

    }
    @FXML
    void click_Start(MouseEvent event) throws InterruptedException {
        MapC m=new MapC();
        m.setHeroes(draggedHero);
        m.setBuildings(buildings);
        m.attckbuilding=attackBuilding;

        m.GamePageController();


    }
    public static ImageView makeCopy(String path, ImageView imageView, double x, double y) {

        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        imageView.setFitWidth(45);
        imageView.setFitHeight(90);

        imageView.setLayoutX(x);
        imageView.setLayoutY(y);

        Map3.root.getChildren().add(imageView);
        DraggableMaker.makeDraggable(imageView);

        return imageView;
    }

    //-------------------------------
    @FXML
    public static ImageView shotObject=new ImageView();

    public ImageView  makeShotImage(String path, ImageView imageView, double x, double y) {

        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        //  Map1.root.getChildren().add(imageView);
        imageView.setVisible(false);

        return imageView;
    }
    //----------------------------------

    int counterWizard = 0;
    @FXML
    public static ImageView wizardImagviewObject = new ImageView();

    @FXML
    void click_Wizard(MouseEvent event) {
        if (counterWizard < numberOfWizard) {
            System.out.println("yes");
            Wizard wizard2 = new Wizard(wizard.getPower(), wizard.getSpeed(), wizard.getHealth(), Wizard_img, wizard.getRadiosOfAttack());
            wizard2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\wizard.png", wizardImagviewObject, Wizard_img.getLayoutX(), Wizard_img.getLayoutY()));

            //   wizard2.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\tir3.png",shotObject,shot_img.getLayoutX(),shot_img.getLayoutY()));
            Map3.root.getChildren().add(wizard2);


            draggedHero.add(wizard2);
            Map3.root.getChildren().add(shotObject);
            wizardImagviewObject = new ImageView();
            shotObject=new ImageView();
            counterWizard++;
        }
    }//---------------------------------




    //-----------------------------------
    int counterArcher = 0;
    @FXML
    public static ImageView archerImageViewObject = new ImageView();
    @FXML
    public static ImageView shotArcherObject=new ImageView();

    @FXML
    void click_Archer(MouseEvent event) {

        if (counterArcher < numberOfArcher) {
            Archer_Queen archer_queen = new Archer_Queen(archerQueen.getPower(), archerQueen.getSpeed(), archerQueen.getHealth(), archerQueen_img, archerQueen.getRadiosOfAttack());
            archer_queen.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1687789713888.png", archerImageViewObject, archerQueen_img.getLayoutX(), archerQueen_img.getLayoutY()));
            archer_queen.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\tirArcher.png",shotArcherObject,tirArcher_img.getLayoutX(),tirArcher_img.getLayoutY()));

            Map3.root.getChildren().add(archer_queen);
            Map3.root.getChildren().add(shotArcherObject);

            draggedHero.add(archer_queen);

//            RotateTransition rotate=new RotateTransition();
//            rotate.setAxis(Rotate.Z_AXIS);
//            rotate.setByAngle(180);
//            rotate.setCycleCount(20);
//            rotate.setDuration(Duration.millis(1000));
//            rotate.setAutoReverse(true);
//            rotate.setNode(archer_queen.getShotHer0Img());
//            archer_queen.getShotHer0Img().setVisible(false);
//            rotate.play();

            archerImageViewObject = new ImageView();
            shotArcherObject=new ImageView();
            counterArcher++;

        }
    }

    //----------------------------------
    int counterBarbarian = 0;
    @FXML
    public static ImageView barbarianObject = new ImageView();
    @FXML
    public static ImageView shotBarbarianObject=new ImageView();


    @FXML
    void click_Barbarian(MouseEvent event) {

        if (counterBarbarian < numberOfBarbarian) {
            Barbarian_King barbarianKing2 = new Barbarian_King(barbarianKing.getPower(), barbarianKing.getSpeed(), barbarianKing.getHealth(), barbarianKing_img, barbarianKing.getRadiosOfAttack());
            barbarianKing2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1687789713960.png", barbarianObject, barbarianKing_img.getLayoutX(), barbarianKing_img.getLayoutY()));
            //   barbarianKing2.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\16880344472962nuj.png",shotBarbarianObject,tirBarbarian_img.getLayoutX(),tirBarbarian_img.getLayoutY()));

            Map3.root.getChildren().add(barbarianKing2);
            Map3.root.getChildren().add(shotBarbarianObject);
            draggedHero.add(barbarianKing2);

            // playGroundHeroesTA.add(ta_music);

            barbarianObject = new ImageView();
            shotBarbarianObject=new ImageView();
            counterBarbarian++;

        }
    }

    //----------------------------------
    int counterGrand = 0;
    @FXML
    public static ImageView grandObject = new ImageView();
    @FXML
    public static ImageView shotGrandObject=new ImageView();

    ArrayList<Hero>draggedHero=new ArrayList<>();
    @FXML
    void click_Grand(MouseEvent event) {
        if (counterGrand < numberOfGrand) {
            Grand_Warden grandWarden2 = new Grand_Warden(grandWarden.getPower(), grandWarden.getSpeed(), grandWarden.getHealth(), GrandWarden_img, grandWarden.getRadiosOfAttack());
            grandWarden2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\ikinh.png", grandObject, GrandWarden_img.getLayoutX(), GrandWarden_img.getLayoutY()));
            // grandWarden2.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1688034447296gcvg.png",shotGrandObject,tirGarden_img.getLayoutX(),tirGarden_img.getLayoutY()));

            Map3.root.getChildren().add(grandWarden2);
            draggedHero.add(grandWarden2);
            Map3.root.getChildren().add(shotGrandObject);

            grandObject = new ImageView();
            shotGrandObject=new ImageView();
            counterGrand++;

        }
    }
    //-------------------------------------
    private static boolean win;

    public static boolean isWin() {
        return win;
    }

    public static void setWin(boolean win) {
        Map3Controller.win = win;
    }

    @FXML
    public   void setWinWon(MouseEvent event) throws IOException {
        if(win){


            ProfileController.setWin("you Win");}
        else {
            ProfileController.setWin("you faild");
        }
        new Profile().start((Stage) cackGround_img.getScene().getWindow());

    }
    public void setHero() {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i) instanceof Wizard) {
                wizard = (Wizard) heroes.get(i);
            } else if (heroes.get(i) instanceof Grand_Warden) {
                grandWarden = (Grand_Warden) heroes.get(i);
            } else if (heroes.get(i) instanceof Archer_Queen) {
                archerQueen = (Archer_Queen) heroes.get(i);

            } else if (heroes.get(i) instanceof Barbarian_King) {
                barbarianKing = (Barbarian_King) heroes.get(i);
            }
        }

    }
    int numberOfWizard = 0;
    int numberOfArcher = 0;
    int numberOfGrand = 0;
    int numberOfBarbarian = 0;

    public void numberOfHeros() {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i) instanceof Wizard) {
                numberOfWizard++;
            } else if (heroes.get(i) instanceof Grand_Warden) {
                numberOfGrand++;
            } else if (heroes.get(i) instanceof Archer_Queen) {
                numberOfArcher++;

            } else if (heroes.get(i) instanceof Barbarian_King) {
                numberOfBarbarian++;
            }
        }
//        System.out.println("number wizard" + numberOfWizard);
//        System.out.println("number archer" + numberOfArcher);
//        System.out.println("number barbarian" + numberOfBarbarian);
//        System.out.println("number grand" + numberOfGrand);


    }
}

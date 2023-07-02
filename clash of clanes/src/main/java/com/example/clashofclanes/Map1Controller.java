package com.example.clashofclanes;

import controller.MapC;
import controller.ThreadController;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import model.hero.*;
import model.strucrure.*;
import model.strucrure.Map;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map1Controller implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView shot_img;
    Building attackBuilding;

    @FXML
    private ImageView backgorond;

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
    private ImageView start_img;

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
    private static ArrayList<Building> buildings = new ArrayList<>();
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private static ArrayList<ImageView>shotImages=new ArrayList<>();
    //-------------------------------


    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static void setHeroes(ArrayList<Hero> heroes) {
        Map1Controller.heroes = heroes;
    }

    public static void addHero(Hero hero) {
        heroes.add(hero);
    }


    //------------------------------

    public static ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static void setBuildings(ArrayList<Building> buildings) {
        Map1Controller.buildings = buildings;
    }

    //------------------------------
    Wizard wizard;
    Archer_Queen archerQueen;
    Barbarian_King barbarianKing;
    Grand_Warden grandWarden;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map map = new Map(buildings, 20, backgorond);
        wizard=new Wizard(10,3,5,Wizard_img,20);
        grandWarden=new Grand_Warden(10,10,3,GrandWarden_img,5);
        barbarianKing=new Barbarian_King(10,20,2,barbarianKing_img,5);
        archerQueen=new Archer_Queen(10,20,20,archerQueen_img,5);
        heroes.add(wizard);
        heroes.add(grandWarden);
        heroes.add(barbarianKing);
        heroes.add(archerQueen);

        Map1.root.getChildren().add(map);

        setHero();
        setBuildings();
        System.out.println("heros size:" + heroes.size());
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
        }
        else {
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

    }

    //--------------------------------------------------


    //add building
    public void setBuildings() {
        BlackWall firstBlackWall = new BlackWall("normal", 20, 0, blackWall2_img, blackWall2_img.getLayoutX(), blackWall2_img.getLayoutY());
        firstBlackWall.setName("black wall2");
        BlackWall secondBlackWall = new BlackWall("normal", 20, 0, blackWall_img, blackWall_img.getLayoutX(), blackWall_img.getLayoutY());
        secondBlackWall.setName("black wall1");
        BlueWall firstBlueWall = new BlueWall("normal", 20, 0, blueBuliding_image, blueBuliding_image.getLayoutX(), blueBuliding_image.getLayoutY());
        firstBlueWall.setName("blueWall");
        ArcherBuilding archerBuilding = new ArcherBuilding("Defensive", 20, 20, archerBuilding_img, archerBuilding_img.getLayoutX(), archerBuilding_img.getLayoutY());
        archerBuilding.setName("archerBuilding");
        CanoonBuilding canoonBuilding = new CanoonBuilding("Defensive", 20, 15, canoonBuliding_img, canoonBuliding_img.getLayoutX(), canoonBuliding_img.getLayoutY());
        canoonBuilding.setName("canoon bulding");
        buildings.add(firstBlackWall);
        buildings.add(secondBlackWall);
        buildings.add(firstBlueWall);
        buildings.add(archerBuilding);
        buildings.add(canoonBuilding);
        Map1.root.getChildren().add(firstBlackWall);
        Map1.root.getChildren().add(secondBlackWall);
        Map1.root.getChildren().add(firstBlueWall);
        Map1.root.getChildren().add(archerBuilding);
        Map1.root.getChildren().add(canoonBuilding);
        attackBuilding=firstBlackWall;
        //------------------------
        System.out.println("building size"+buildings.size());
       // firstBlackWall.getImageView().setX(blackWall_img.getX());
//        firstBlackWall.getImageView().setLayoutX(blackWall2_img.getLayoutX());
//        secondBlackWall.getImageView().setLayoutX(blackWall_img.getLayoutX());
//        archerBuilding.getImageView().setLayoutX(archerBuilding_img.getLayoutX());
//        canoonBuilding.getImageView().setLayoutX(canoonBuliding_img.getLayoutX());
        //--------------------------
//        RotateTransition rotate=new RotateTransition();
//        rotate.setAxis(Rotate.Z_AXIS);
//        rotate.setByAngle(180);
//        rotate.setCycleCount(20);
//        rotate.setDuration(Duration.millis(1000));
//        rotate.setAutoReverse(true);
//        rotate.setNode(firstBlackWall.getImageView());
//        rotate.play();



        System.out.println("first black class x");
        System.out.println(firstBlackWall.getImageView().getLayoutX());
        System.out.println("first black  image x");
        System.out.println(blackWall2_img.getLayoutX());
        System.out.println("//--------------------------------------------");

//        System.out.println("second black x");
//        System.out.println(secondBlackWall.getImageView().getLayoutX());
//        System.out.println("blue x");
//        System.out.println(firstBlueWall.getImageView().getLayoutX());
    }

    //------------------------------------------
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

    //---------------------------------------------------------
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
        System.out.println("number wizard" + numberOfWizard);
        System.out.println("number archer" + numberOfArcher);
        System.out.println("number barbarian" + numberOfBarbarian);
        System.out.println("number grand" + numberOfGrand);


    }

    //---------------------------------
    double deltaX = 1000;
    double deltaY = 1000;
    //------------------------
    static  Timeline timer;


    @FXML
    void click_Start(MouseEvent event) throws InterruptedException {
        MapC m=new MapC();
        m.setHeroes(draggedHero);
       m.setBuildings(buildings);
        m.attckbuilding=attackBuilding;

        m.GamePageController();


    }


    //---------------------


    //-----------------------
    ArrayList<Hero>draggedHero=new ArrayList<>();


    public static ImageView makeCopy(String path, ImageView imageView, double x, double y) {

        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        imageView.setFitWidth(45);
        imageView.setFitHeight(90);

        imageView.setLayoutX(x);
        imageView.setLayoutY(y);

        Map1.root.getChildren().add(imageView);
        DraggableMaker.makeDraggable(imageView);

        return imageView;
    }

    //-------------------------------
    public ImageView  makeShotImage(String path, ImageView imageView, double x, double y) {

        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        imageView.setFitWidth(45);
        imageView.setFitHeight(90);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        Map1.root.getChildren().add(imageView);
        imageView.setVisible(false);
         shotImages.add(imageView);
         return imageView;
    }
    //----------------------------------
    int counterWizard = 0;
    @FXML
    public static ImageView wizardImagviewObject = new ImageView();
    @FXML
    public static ImageView shotObject=new ImageView();

    @FXML
    void click_Wizard(MouseEvent event) {
        if (counterWizard < numberOfWizard) {
            System.out.println("yes");
            Wizard wizard2 = new Wizard(wizard.getPower(), wizard.getSpeed(), wizard.getHealth(), Wizard_img, wizard.getRadiosOfAttack());
            wizard2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\wizard.png", wizardImagviewObject, Wizard_img.getLayoutX(), Wizard_img.getLayoutY()));

          wizard2.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\tir3.png",shotObject,Wizard_img.getLayoutX(),Wizard_img.getLayoutY()));
            Map1.root.getChildren().add(wizard2);
          //  Map1.root.getChildren().add(shotObject);
            draggedHero.add(wizard2);
            // playGroundHeroesTA.add(ta_music);

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
    void click_Archer(MouseEvent event) {

        if (counterArcher < numberOfArcher) {
            Archer_Queen archer_queen = new Archer_Queen(archerQueen.getPower(), archerQueen.getSpeed(), archerQueen.getHealth(), archerQueen_img, archerQueen.getRadiosOfAttack());
            archer_queen.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1687789713888.png", archerImageViewObject, archerQueen_img.getLayoutX(), archerQueen_img.getLayoutY()));

            Map1.root.getChildren().add(archer_queen);
            draggedHero.add(archer_queen);
            // playGroundHeroesTA.add(ta_music);

            archerImageViewObject = new ImageView();
            counterArcher++;

        }
    }

    //----------------------------------
    int counterBarbarian = 0;
    @FXML
    public static ImageView barbarianObject = new ImageView();

    @FXML
    void click_Barbarian(MouseEvent event) {

        if (counterBarbarian < numberOfBarbarian) {
            Barbarian_King barbarianKing2 = new Barbarian_King(barbarianKing.getPower(), barbarianKing.getSpeed(), barbarianKing.getHealth(), barbarianKing_img, barbarianKing.getRadiosOfAttack());
            barbarianKing2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1687789713960.png", barbarianObject, barbarianKing_img.getLayoutX(), barbarianKing_img.getLayoutY()));

            Map1.root.getChildren().add(barbarianKing2);
            draggedHero.add(barbarianKing2);
            // playGroundHeroesTA.add(ta_music);

            barbarianObject = new ImageView();
            counterBarbarian++;

        }
    }

    //----------------------------------
    int counterGrand = 0;
    @FXML
    public static ImageView grandObject = new ImageView();

    @FXML
    void click_Grand(MouseEvent event) {
        if (counterGrand < numberOfGrand) {
            Grand_Warden grandWarden2 = new Grand_Warden(grandWarden.getPower(), grandWarden.getSpeed(), grandWarden.getHealth(), GrandWarden_img, grandWarden.getRadiosOfAttack());
            grandWarden2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\ikinh.png", grandObject, GrandWarden_img.getLayoutX(), GrandWarden_img.getLayoutY()));

            Map1.root.getChildren().add(grandWarden2);
            draggedHero.add(grandWarden2);
            // playGroundHeroesTA.add(ta_music);

            grandObject = new ImageView();
            counterGrand++;

        }
    }
    //-------------------------------------
    @FXML
    void shot(Hero hero){
        TranslateTransition tt=new TranslateTransition(Duration.millis(2000));
        tt.setDelay(Duration.seconds(4));
        tt.setDuration(Duration.seconds(3));
        shot_img.setVisible(true);
        tt.setNode(shot_img);
        shot_img.setTranslateX(hero.getImageView().getTranslateX());
        shot_img.setTranslateY(hero.getImageView().getTranslateY());
        tt.setAutoReverse(true);
        tt.setCycleCount(5);
        tt.play();
    }

}






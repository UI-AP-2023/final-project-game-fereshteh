package com.example.clashofclanes;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map map = new Map(buildings, 20, backgorond);
        setHero();
        setBuildings();
        numberOfHeros();
        System.out.println("heros size:" + heroes.size());
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(heroes.get(i).getName());
        }
        if (numberOfWizard == 0) {
            Wizard_img.setVisible(false);
        }
        else {
            Wizard_img.setVisible(true);
        }
        if (numberOfGrand == 0) {
            GrandWarden_img.setVisible(false);
        }
        if (numberOfBarbarian == 0) {
            barbarianKing_img.setVisible(false);
        }
        if (numberOfArcher == 0) {
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
        //------------------------------
        //wizard=new Wizard(10,10,10,Wizard_img,10);
       // archerQueen=new Archer_Queen(10,20,20,archerQueen_img,10);
//        Wizard_img.setOnMouseClicked(event -> Dragg(wizard));
        //------------------------------


    }

    //--------------------------------------------------
    Wizard wizard;
    Archer_Queen archerQueen;
    Barbarian_King barbarianKing;
    Grand_Warden grandWarden;

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
        System.out.println("number wizard"+numberOfWizard);
        System.out.println("number archer"+numberOfArcher);
        System.out.println("number barbarian"+numberOfBarbarian);
        System.out.println("number grand"+numberOfGrand);


    }

    //---------------------------------
    double deltaX = 1000;
    double deltaY = 1000;

    public void startGame() {
        for (Hero hero : heroes) {

            for (Building building : buildings) {


                if (hero.Target(building)) {
                    while (hero.getHealth() > 0 && building.getHealth() > 0) {
                        if (deltaX < Math.abs(hero.getLayoutX() - building.getLayoutX()) && deltaY < Math.abs(hero.getLayoutY() - building.getLayoutY())) {
                            deltaX = (hero.getLayoutX() - building.getLayoutX());
                            deltaY = (hero.getLayoutY() - building.getLayoutY());
                            if (deltaX < 0) {
                                TranslateTransition tt = new TranslateTransition(Duration.millis(2000));

                            }
                            hero.setHealth(hero.getHealth() - building.getAttack_power());
                            building.setHealth(building.getHealth() - hero.getPower());

                            if (hero.getHealth() <= 0) {


                                this.pane.getChildren().remove(hero.getImageView());

                            }
                            if (building.getHealth() <= 0) {
                                pane.getChildren().remove(building.getImageView());

                            }
                        }
                    }
                }
            }
        }
    }

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


    //-----------------------


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
    int counterWizard = 0;
    @FXML
    public static ImageView wizardImagviewObject = new ImageView();

    @FXML
    void click_Wizard(MouseEvent event) {
        if (counterWizard < numberOfWizard) {
            System.out.println("yes");
            Wizard wizard2 = new Wizard(wizard.getPower(), wizard.getSpeed(), wizard.getHealth(), Wizard_img, wizard.getRadiosOfAttack());
            wizard2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\wizard.png", wizardImagviewObject, Wizard_img.getLayoutX(), Wizard_img.getLayoutY()));

            Map1.root.getChildren().add(wizard2);
            // playGroundHeroesTA.add(ta_music);

            wizardImagviewObject = new ImageView();
            counterWizard++;
        }//---------------------------------
    }









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
            // playGroundHeroesTA.add(ta_music);

            grandObject = new ImageView();
            counterGrand++;

        }
    }
    //-------------------------------------

}






package com.example.clashofclanes;

import controller.MapC;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.hero.*;
import model.strucrure.*;
import model.strucrure.Map;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map1Controller implements Initializable {
    @FXML
    private AnchorPane pane;
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
    Building attackBuilding;

    @FXML
    private ImageView backgorond;

    @FXML
    private ImageView blackWall2_img;
    @FXML
    private Label lableWin2;

    @FXML
    private Label lablWin3;

    @FXML
    private Label lableWin4;


    @FXML
    private ImageView blueBuliding_image;

    @FXML
    private ImageView canoonBuliding_img;

    @FXML
    private static Label win_lbl;

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
    private ImageView tirArcher2_img;
    @FXML
    private ImageView barbarianKing_img;

    @FXML
    private ImageView Wizard_img;
    @FXML
    private Label result_lbl;


    @FXML
    private ImageView archerQueen_img;
    private static ArrayList<Building> buildings = new ArrayList<>();
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private static ArrayList<ImageView>shotImages=new ArrayList<>();
    private static ArrayList<Double>locations=new ArrayList<>();
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
    public static void removeBuilding(Building building){
        buildings.remove(building);
    }
    public static void removeHero(Image hero){
        heroes.remove(hero);
    }

    //------------------------------
    Wizard wizard;
    Archer_Queen archerQueen;
    Barbarian_King barbarianKing;
    Grand_Warden grandWarden;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map map = new Map(buildings, 20, backgorond);
        wizard=new Wizard(10,10,190,Wizard_img,20);
        grandWarden=new Grand_Warden(20,5,200,GrandWarden_img,5);
        barbarianKing=new Barbarian_King(25,3,200,barbarianKing_img,5);
        archerQueen=new Archer_Queen(5,7,80,archerQueen_img,5);
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
        tt.setDelay(Duration.seconds(13));
        //tt.setDuration(Duration.seconds(3));
        tt.setNode(meno_pane);
        tt.setToX(450);
        tt.setToZ(-200);
        tt.play();
        numberOfHeros();
        //-----------------------------
        TranslateTransition buildingShot = new TranslateTransition(Duration.millis(1200));
        buildingShot.setNode(tirCanoon_img);
        buildingShot.setByX(40);
        buildingShot.setByY(40);
        buildingShot.setAutoReverse(true);
        buildingShot.setCycleCount(50);
        buildingShot.play();
        //-------------------------------
        TranslateTransition archerBuildingShot = new TranslateTransition(Duration.millis(1200));
        archerBuildingShot.setNode(tirBlueWall_img);
        archerBuildingShot.setByX(50);
        archerBuildingShot.setByY(50);
        archerBuildingShot.setAutoReverse(true);
        archerBuildingShot.setCycleCount(50);
        archerBuildingShot.play();
        //--------------------------------------------------
        TranslateTransition archerBuildingShot2 = new TranslateTransition(Duration.millis(1200));
        archerBuildingShot2.setNode(tirArcher2_img);
        archerBuildingShot2.setToX(50);
        archerBuildingShot2.setToY(50);
        archerBuildingShot2.setAutoReverse(true);
        archerBuildingShot2.setCycleCount(50);
        archerBuildingShot2.play();
        //--------------------------------------------------
        backgorond.setOnMouseClicked(event -> {
            try {
                new WinPage().start((Stage) backgorond.getScene().getWindow());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

    }



    //add building
    public void setBuildings() {
        BlackWall firstBlackWall = new BlackWall("normal", 130, 10, blackWall2_img, blackWall2_img.getLayoutX(), blackWall2_img.getLayoutY());
        firstBlackWall.setName("black wall2");
        BlackWall secondBlackWall = new BlackWall("normal", 160, 10, blackWall_img, blackWall_img.getLayoutX(), blackWall_img.getLayoutY());
        secondBlackWall.setName("black wall1");
        BlueWall firstBlueWall = new BlueWall("normal", 150, 10, blueBuliding_image, blueBuliding_image.getLayoutX(), blueBuliding_image.getLayoutY());
        firstBlueWall.setName("blueWall");
        ArcherBuilding archerBuilding = new ArcherBuilding("Defensive", 180, 25, archerBuilding_img, archerBuilding_img.getLayoutX(), archerBuilding_img.getLayoutY());
        archerBuilding.setName("archerBuilding");
        CanoonBuilding canoonBuilding = new CanoonBuilding("Defensive", 120, 12, canoonBuliding_img, canoonBuliding_img.getLayoutX(), canoonBuliding_img.getLayoutY());
        canoonBuilding.setName("canoon bulding");

        canoonBuilding.setShot(tirCanoon_img);
        archerBuilding.setShot(tirArcher2_img);
        archerBuilding.setShot2(tirBlueWall_img);

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
        for(int i=0;i<buildings.size();i++){
            locations.add(buildings.get(i).getImageView().getLayoutX());
            locations.add(buildings.get(i).getImageView().getLayoutY());
        }

        //------------------------
        //System.out.println("building size"+buildings.size());
       // firstBlackWall.getImageView().setX(blackWall_img.getX());
//        firstBlackWall.getImageView().setLayoutX(blackWall2_img.getLayoutX());
//        secondBlackWall.getImageView().setLayoutX(blackWall_img.getLayoutX());
//        archerBuilding.getImageView().setLayoutX(archerBuilding_img.getLayoutX());
//        canoonBuilding.getImageView().setLayoutX(canoonBuliding_img.getLayoutX());
        //--------------------------
        RotateTransition rotate=new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(180);
        rotate.setCycleCount(20);
        rotate.setDuration(Duration.millis(1000));
        rotate.setAutoReverse(true);
        rotate.setNode(firstBlackWall.getImageView());
        rotate.setCycleCount(100);
        rotate.play();

        RotateTransition secondTT=new RotateTransition();
        secondTT.setAxis(Rotate.Z_AXIS);
        secondTT.setByAngle(180);
        secondTT.setCycleCount(100);
        secondTT.setDuration(Duration.millis(1000));
        secondTT.setAutoReverse(true);
        secondTT.setNode(secondBlackWall.getImageView());
        secondTT.play();



//        System.out.println("first black class x");
//        System.out.println(firstBlackWall.getImageView().getLayoutX());
//        System.out.println("first black  image x");
//        System.out.println(blackWall2_img.getLayoutX());
//        System.out.println("//--------------------------------------------");

//        System.out.println("second black x");
//        System.out.println(secondBlackWall.getImageView().getLayoutX());
//        System.out.println("blue x");
//        System.out.println(firstBlueWall.getImageView().getLayoutX());

    }

    public void setAttackBuilding(Building building){
        if(building.getAttack_power()>0){
            RotateTransition secondTT=new RotateTransition();
            secondTT.setAxis(Rotate.Z_AXIS);
            secondTT.setByAngle(180);
            secondTT.setCycleCount(20);
            secondTT.setDuration(Duration.millis(1000));
            secondTT.setAutoReverse(true);
            secondTT.setNode(building.getImageView());
            secondTT.play();
        }

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
//        System.out.println("number wizard" + numberOfWizard);
//        System.out.println("number archer" + numberOfArcher);
//        System.out.println("number barbarian" + numberOfBarbarian);
//        System.out.println("number grand" + numberOfGrand);


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
       // Map1.root.getChildren().add(imageView);
        imageView.setVisible(false);
         shotImages.add(imageView);
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
            wizard2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\16888407921022.png", wizardImagviewObject, 306,601));

          wizard2.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\tir3.png",shotObject,shot_img.getLayoutX(),shot_img.getLayoutY()));

            Map1.root.getChildren().add(wizard2);


            draggedHero.add(wizard2);
            Map1.root.getChildren().add(shotObject);
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
            archer_queen.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1687789713888.png", archerImageViewObject, 196, 601));
            archer_queen.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\tirArcher.png",shotArcherObject,tirArcher_img.getLayoutX(),tirArcher_img.getLayoutY()));

          //  Map1.root.getChildren().add(archer_queen);
            Map1.root.getChildren().add(shotArcherObject);

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
            barbarianKing2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1687789713960.png", barbarianObject, 103, 601));
           barbarianKing2.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\16880344472962nuj.png",shotBarbarianObject,tirBarbarian_img.getLayoutX(),tirBarbarian_img.getLayoutY()));

          //  Map1.root.getChildren().add(barbarianKing2);
            Map1.root.getChildren().add(shotBarbarianObject);
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


    @FXML
    void click_Grand(MouseEvent event) {
        if (counterGrand < numberOfGrand) {
            Grand_Warden grandWarden2 = new Grand_Warden(grandWarden.getPower(), grandWarden.getSpeed(), grandWarden.getHealth(), GrandWarden_img, grandWarden.getRadiosOfAttack());
            grandWarden2.setImageView(makeCopy("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\ikinh.png", grandObject, 33, 601));
           grandWarden2.setShotHer0Img(makeShotImage("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\1688034447296gcvg.png",shotGrandObject,tirGarden_img.getLayoutX(),tirGarden_img.getLayoutY()));

          //  Map1.root.getChildren().add(grandWarden2);
            draggedHero.add(grandWarden2);
            Map1.root.getChildren().add(shotGrandObject);

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
        Map1Controller.win = win;
    }

    @FXML
    public   void setWinWon(MouseEvent event) throws IOException {
        if(win){


        ProfileController.setWin("you Win");}
        else {
            ProfileController.setWin("you faild");
        }
        MapC.choosePerson(ProfileController.getIndexOfAttack(),win);
        new Profile().start((Stage) backgorond.getScene().getWindow());

    }
}






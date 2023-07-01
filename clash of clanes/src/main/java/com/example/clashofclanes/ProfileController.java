package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.hero.*;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private ImageView backGround_img;

    @FXML
    private AnchorPane profile_pane;

    @FXML
    private ImageView username_img;

    @FXML
    private Label username_lbl;

    @FXML
    private ImageView knight_img;

    @FXML
    private Label win1_lbl;

    @FXML
    private Label failure1_lbl;

    @FXML
    private Label win2_lbl;

    @FXML
    private Label failure2_lbl;

    @FXML
    private Label level1_lbl;

    @FXML
    private Label level2_lbl;

    @FXML
    private Label passwod_lbl;

    @FXML
    private Button profile_btn;

    @FXML
    private Button hero_btn;

    @FXML
    private Button signOut_btn;

    @FXML
    private AnchorPane Heros_pane;

    @FXML
    private AnchorPane Hero_pane1;

    @FXML
    private Rectangle rec_p1;

    @FXML
    private ImageView barbarianKing_img;

    @FXML
    private Label speed_lbl_p1;

    @FXML
    private ImageView harm_img_p1;

    @FXML
    private ImageView speed_img_p1;

    @FXML
    private Label speedText_lbl_p1;

    @FXML
    private Label power_lbl_p1;

    @FXML
    private ImageView knight_img_p1;

    @FXML
    private Label healph_lbl_p1;

    @FXML
    private ImageView radios_img_p1;

    @FXML
    private Label radios_lbl_p1;

    @FXML
    private ImageView health_img_p1;

    @FXML
    private Label running_lbl_p1;

    @FXML
    private AnchorPane hero_pane2;

    @FXML
    private Rectangle rec_p2;

    @FXML
    private ImageView GrandWarden_img_p2;

    @FXML
    private ImageView harm_img_p2;

    @FXML
    private ImageView speed_img_p2;

    @FXML
    private ImageView knight_img_p2;

    @FXML
    private ImageView radios_img_p2;

    @FXML
    private ImageView health_img_p2;

    @FXML
    private Label speed_lbl_p2;

    @FXML
    private Label speedText_lbl_p2;

    @FXML
    private Label power_lbl_p2;

    @FXML
    private Label health_lbl_p2;

    @FXML
    private Label radios_lbl_p2;

    @FXML
    private Label running_lbl_p2;

    @FXML
    private AnchorPane hero_pane3;

    @FXML
    private Rectangle rec_p3;

    @FXML
    private ImageView wizard_img_p3;

    @FXML
    private ImageView harm_img_p3;

    @FXML
    private ImageView speed_img_p3;

    @FXML
    private ImageView knight_img_p3;

    @FXML
    private ImageView radios_img_p3;

    @FXML
    private ImageView health_img_p3;

    @FXML
    private Label speed_lbl_p3;

    @FXML
    private Label speedText_lbl_p3;

    @FXML
    private Label power_lbl_p3;

    @FXML
    private Label health_lbl_p3;

    @FXML
    private Label radios_lbl_p3;

    @FXML
    private Label running_lbl_p3;

    @FXML
    private AnchorPane hero_pane4;

    @FXML
    private Rectangle rec_p4;

    @FXML
    private ImageView archer_img_p4;

    @FXML
    private ImageView harm_img_p4;

    @FXML
    private ImageView speed_img_p4;

    @FXML
    private ImageView knight_img_p4;

    @FXML
    private ImageView radios_img_p4;

    @FXML
    private ImageView health_img_p4;

    @FXML
    private Label speed_lbl_p4;

    @FXML
    private Label speedText_lbl_p4;

    @FXML
    private Label power_lbl_p4;

    @FXML
    private Label health_lbl_p4;

    @FXML
    private Label radios_lbl_p4;

    @FXML
    private Label running_lbl_p4;

    @FXML
    private Label next_lbl;

    @FXML
    private Label last_lbl;

    @FXML
    private AnchorPane Attack_pane;

    @FXML
    private Rectangle showHeros_rec;

    @FXML
    private Rectangle numberOfHeros_rec;

    @FXML
    private ImageView archer_attack_img;

    @FXML
    private ImageView burburian_attack_img;

    @FXML
    private ImageView GrandWarden_attack_img;

    @FXML
    private ImageView wizard_attack_img;

    @FXML
    private Label maxHeroText_lbl;

    @FXML
    private Label maxHero_lbl;

    @FXML
    private Label numberOfArcher_lbl;

    @FXML
    private Label numberOfGrand_lbl;

    @FXML
    private Label numberOfBarbarian_lbl;

    @FXML
    private Label numberOfWizard_lbl;

    @FXML
    private Label selectedText_lbl;

    @FXML
    private Label selected_lbl;

    @FXML
    private Label nextHeroAttack_lbl;

    @FXML
    private Label lastHeroAttack_lbl;

    @FXML
    private AnchorPane Maps_pane;

    @FXML
    private AnchorPane map_pane2;

    @FXML
    private ImageView map2_img;

    @FXML
    private ImageView blackWall2_img_p2;

    @FXML
    private ImageView blackWall1_img_p2;

    @FXML
    private ImageView blackWall3_img_p2;

    @FXML
    private ImageView archerBuilding1_img_p2;

    @FXML
    private ImageView canoon1_img_p2;

    @FXML
    private ImageView canoon2_img_p2;

    @FXML
    private ImageView archerBulding2_img_p2;

    @FXML
    private AnchorPane mapPan1;

    @FXML
    private ImageView map1_img;
    @FXML
    private AnchorPane map4_pane;

    @FXML
    private ImageView canoonBuliding_img_p1;

    @FXML
    private ImageView blackWall2_img_p1;

    @FXML
    private ImageView blueBuliding_image_p1;

    @FXML
    private ImageView archerBuilding_img_p1;

    @FXML
    private ImageView blackWall_img_p1;

    @FXML
    private AnchorPane map3_pane;

    @FXML
    private ImageView map3_img;

    @FXML
    private ImageView blueWall_img_p3;

    @FXML
    private ImageView archerBuilding2_img_p3;

    @FXML
    private ImageView canonBuilding1_img_p3;

    @FXML
    private ImageView blackWall2_img_p3;

    @FXML
    private ImageView blackWall1_img_p3;

    @FXML
    private ImageView archerBuilding4_img_p3;

    @FXML
    private ImageView canonBuiding2_img_p3;

    @FXML
    private ImageView archerBuilding3_img_p3;

    @FXML
    private ImageView archerBuilding1_img_p3;

    @FXML
    private ImageView map4_img;

    @FXML
    private ImageView canoon4_img_p4;

    @FXML
    private ImageView canoon3_img_p4;

    @FXML
    private ImageView canoon2_img_p4;

    @FXML
    private ImageView canoon1_img_p4;

    @FXML
    private ImageView archer2_img_p4;

    @FXML
    private ImageView archer3_img_p4;

    @FXML
    private ImageView archer4_img_p4;

    @FXML
    private ImageView archer1_img_p4;

    @FXML
    private ImageView blackWall1_img_p4;

    @FXML
    private ImageView blackWall3_img_p4;

    @FXML
    private ImageView blueWall2_img_p4;

    @FXML
    private ImageView bueWall1_img_p4;

    @FXML
    private ImageView blackWall2_img_p4;

    @FXML
    private ImageView blackWall4_img_p4;

    @FXML
    private ImageView blueWall3_img_p4;

    @FXML
    private Button next_btn;

    @FXML
    private Button last_btn;

    @FXML
    private Button StartGame_btn;

    @FXML
    private Button attack_btn;

    //--------------------------------
    private static String username;
    private static String password;
    //------------------------------


    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ProfileController.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ProfileController.password = password;
    }

    //---------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void showFirstHero(MouseEvent event) {
        profile_pane.setVisible(false);
        Heros_pane.setVisible(true);
        Hero_pane1.setVisible(true);
        last_lbl.setVisible(true);
        next_lbl.setVisible(true);
    }

    //---------------------------------
    int check = 0;

    @FXML
    public void nextPane(MouseEvent event) {

        if (check == 0) {
            Hero_pane1.setVisible(true);
            check++;
        } else if (check == 1) {
            Hero_pane1.setVisible(false);
            hero_pane2.setVisible(true);
            check++;
        } else if (check == 2) {
            hero_pane2.setVisible(false);
            hero_pane3.setVisible(true);
            check++;
        } else if (check == 3) {
            hero_pane3.setVisible(false);
            hero_pane4.setVisible(true);
            check++;
        } else if (check == 4) {
            hero_pane4.setVisible(false);
            Hero_pane1.setVisible(true);
            check = 1;
        }
    }

    //------------------------------------------
    @FXML
    public void lastPane(MouseEvent event) {
        if (check == 0) {
            Hero_pane1.setVisible(false);
            hero_pane4.setVisible(true);
            check = 4;
        } else if (check == 1) {
            Hero_pane1.setVisible(false);
            hero_pane4.setVisible(true);
            check--;
        } else if (check == 2) {
            hero_pane2.setVisible(false);
            Hero_pane1.setVisible(true);
            check--;
        } else if (check == 4) {
            hero_pane4.setVisible(false);
            hero_pane3.setVisible(true);
            check--;
        } else if (check == 3) {
            hero_pane3.setVisible(false);
            hero_pane2.setVisible(true);
            check--;
        }
    }

    //-------------------------------------
    @FXML
    public void showProfile(MouseEvent event) {
        Heros_pane.setVisible(false);
        profile_pane.setVisible(true);
    }

    //----------------------------------------
    @FXML
    public void signOut(MouseEvent event) throws IOException {
        new Login().start((Stage) signOut_btn.getScene().getWindow());
    }

    //-----------------------------------------
    @FXML
    public void showUsername(MouseEvent event) {
        username_lbl.setText(ProfileController.username);
    }

    //-------------------------------------------
    @FXML
    public void showPassword(MouseEvent event) {
        passwod_lbl.setText(ProfileController.password);
    }

    //----------------------------------------------
    int max = 4;
    int min = 1;
    int result;
    private static int indexOfAttack;
    private ArrayList<Hero> heroes = new ArrayList<>();

    //-----------------------------------


    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public static int getIndexOfAttack() {
        return indexOfAttack;
    }

    public static void setIndexOfAttack(int indexOfAttack) {
        ProfileController.indexOfAttack = indexOfAttack;
    }

    //------------------------------------

    @FXML
    public void showMaps(MouseEvent event) throws Exception {
        if (Maps_pane.isVisible()) {
            if (mapPan1.isVisible()) {
                indexOfAttack = 0;
                mapPan1.setVisible(false);
            } else if (map_pane2.isVisible()) {
                indexOfAttack = 1;
                map_pane2.setVisible(false);
            } else if (map3_pane.isVisible()) {
                indexOfAttack = 2;
                map3_pane.setVisible(false);
            } else if (map4_pane.isVisible()) {
                indexOfAttack = 3;
                map4_pane.setVisible(false);
            }
            //--------------------
            Maps_pane.setVisible(false);
            Attack_pane.setVisible(true);
            System.out.println(indexOfAttack);
            //------------------------------
            if (RegisterController.getIndexMap() == 0) {
                maxHero_lbl.setText("2");
            } else if (RegisterController.getIndexMap() == 1) {
                maxHero_lbl.setText("4");
            } else if (RegisterController.getIndexMap() == 2) {
                maxHero_lbl.setText("6");
            } else if (RegisterController.getIndexMap() == 3) {
                maxHero_lbl.setText("10");
            }

            //----------------------------
        } else if (Attack_pane.isVisible()&&Integer.parseInt(selected_lbl.getText())!=0) {
            if (indexOfAttack == 0) {
                new Map1().start((Stage) attack_btn.getScene().getWindow());
            }
            else if(indexOfAttack==1){
                new Map2().start((Stage) attack_btn.getScene().getWindow());
            }
            else if(indexOfAttack==2){
                new Map3().start((Stage) attack_btn.getScene().getWindow());
            }
            else if(indexOfAttack==3){
                new Map4().start((Stage) attack_btn.getScene().getWindow());
            }
            System.out.println("max");
        }
        //-----------
        else {
            Heros_pane.setVisible(false);
            profile_pane.setVisible(false);
            Attack_pane.setVisible(false);
            mapPan1.setVisible(false);
            map_pane2.setVisible(false);
            map3_pane.setVisible(false);
            map4_pane.setVisible(false);
            //-------------------------
            Maps_pane.setVisible(true);
            Random rand = new Random();
            result = rand.nextInt((max - min) + 1) + min;
            if (result == 1) {
                mapPan1.setVisible(true);
                map_pane2.setVisible(false);
                map3_pane.setVisible(false);
                map4_pane.setVisible(false);
            } else if (result == 2) {
                mapPan1.setVisible(false);
                map3_pane.setVisible(false);
                map4_pane.setVisible(false);
                map_pane2.setVisible(true);
            } else if (result == 3) {
                mapPan1.setVisible(false);
                map4_pane.setVisible(false);
                map_pane2.setVisible(false);
                map3_pane.setVisible(true);
            } else if (result == 4) {
                mapPan1.setVisible(false);
                map_pane2.setVisible(false);
                map3_pane.setVisible(false);
                map4_pane.setVisible(true);
            }
        }

    }

    //-------------------------


    @FXML
    public void otherMap(MouseEvent event) {
        Random rand = new Random();
        if (result == 1) {
            if (mapPan1.isVisible()) {
                result = rand.nextInt((max - min) + 1) + min;
            } else {
                map4_pane.setVisible(false);
                map3_pane.setVisible(false);
                map_pane2.setVisible(false);
                mapPan1.setVisible(true);
            }
        }
        //-------------------
        else if (result == 2) {
            if (map_pane2.isVisible()) {
                result = rand.nextInt((max - min) + 1) + min;
            } else {
                mapPan1.setVisible(false);
                map4_pane.setVisible(false);
                map3_pane.setVisible(false);
                map_pane2.setVisible(true);
            }
        }
        //-----------------------
        else if (result == 3) {
            if (map3_pane.isVisible()) {
                result = rand.nextInt((max - min) + 1) + min;
            } else {
                mapPan1.setVisible(false);
                map_pane2.setVisible(false);
                map4_pane.setVisible(false);
                map3_pane.setVisible(true);
            }
        }
        //-----------------
        else if (result == 4) {
            if (map4_pane.isVisible()) {
                result = rand.nextInt((max - min) + 1) + min;
            } else {
                mapPan1.setVisible(false);
                map_pane2.setVisible(false);
                map3_pane.setVisible(false);
                map4_pane.setVisible(true);
            }
        }
    }


    //-----------------------------------------------
    private static int numberOfArcher = 0;
    private static int numberOfBarbarian = 0;
    private static int numberOfGrand = 0;
    private static int numberOfWizard = 0;
    private static int selected = 0;
    //-------------------------------------

    public ImageView getBackGround_img() {
        return backGround_img;
    }

    public void setBackGround_img(ImageView backGround_img) {
        this.backGround_img = backGround_img;
    }

    public static int getNumberOfArcher() {
        return numberOfArcher;
    }

    public static void setNumberOfArcher(int numberOfArcher) {
        ProfileController.numberOfArcher = numberOfArcher;
    }

    public static int getNumberOfBarbarian() {
        return numberOfBarbarian;
    }

    public static void setNumberOfBarbarian(int numberOfBarbarian) {
        ProfileController.numberOfBarbarian = numberOfBarbarian;
    }

    public static int getNumberOfGrand() {
        return numberOfGrand;
    }

    public static void setNumberOfGrand(int numberOfGrand) {
        ProfileController.numberOfGrand = numberOfGrand;
    }

    public static int getNumberOfWizard() {
        return numberOfWizard;
    }

    public static void setNumberOfWizard(int numberOfWizard) {
        ProfileController.numberOfWizard = numberOfWizard;
    }

    //-------------------------------------


    @FXML
    public void selectArcher(MouseEvent event) {
        if (Integer.parseInt(selected_lbl.getText()) < Integer.parseInt(maxHero_lbl.getText())) {
            numberOfArcher++;
            selected++;
            selected_lbl.setText(String.valueOf(selected));
            numberOfArcher_lbl.setText(String.valueOf(numberOfArcher));
            Archer_Queen archerQueen = new Archer_Queen(RegisterController.getIndexMap() * 10, RegisterController.getIndexMap() * 10, 20, archer1_img_p4, 40);
            heroes.add(archerQueen);
            //------------------------------
            if (indexOfAttack == 0) {
                Map1Controller.addHero(archerQueen);
            }
            //----------------------
            else if (indexOfAttack == 1) {
                Map2Controller.addHero(archerQueen);
            } else if (indexOfAttack == 2) {
                Map3Controller.addHero(archerQueen);
            } else if (indexOfAttack == 3) {
                Map4Controller.addHero(archerQueen);
            }
        } else {
            selectedText_lbl.setText("MAX");
        }
    }

    //------------------------
    @FXML
    public void selectWizard(MouseEvent event) {
        if (Integer.parseInt(selected_lbl.getText()) < Integer.parseInt(maxHero_lbl.getText())) {
            numberOfWizard++;
            selected++;
            selected_lbl.setText(String.valueOf(selected));
            numberOfWizard_lbl.setText(String.valueOf(numberOfWizard));
            Wizard royalChampion = new Wizard(RegisterController.getIndexMap() * 6, RegisterController.getIndexMap() * 4, 15, wizard_attack_img, 25);
            heroes.add(royalChampion);
            //---------------------
            if (indexOfAttack == 0) {
                Map1Controller.addHero(royalChampion);
            }
            //----------------------
            else if (indexOfAttack == 1) {
                Map2Controller.addHero(royalChampion);
            } else if (indexOfAttack == 2) {
                Map3Controller.addHero(royalChampion);
            } else if (indexOfAttack == 3) {
                Map4Controller.addHero(royalChampion);
            }
        } else {
            selectedText_lbl.setText("MAX");
        }
    }

    //---------------------------
    @FXML
    public void selectGrand(MouseEvent event) {
        if (Integer.parseInt(selected_lbl.getText()) < Integer.parseInt(maxHero_lbl.getText())) {
            numberOfGrand++;
            selected++;
            selected_lbl.setText(String.valueOf(selected));
            numberOfGrand_lbl.setText(String.valueOf(numberOfGrand));
            Grand_Warden grandWarden = new Grand_Warden(RegisterController.getIndexMap() * 7, RegisterController.getIndexMap() * 3, 12, GrandWarden_img_p2, 35);
            heroes.add(grandWarden);
            //-------------------
            if (indexOfAttack == 0) {
                Map1Controller.addHero(grandWarden);
            }
            //----------------------
            else if (indexOfAttack == 1) {
                Map2Controller.addHero(grandWarden);
            } else if (indexOfAttack == 2) {
                Map3Controller.addHero(grandWarden);
            } else if (indexOfAttack == 3) {
                Map4Controller.addHero(grandWarden);
            }
        } else {
            selectedText_lbl.setText("MAX");
        }
    }

    //--------------------------------
    @FXML
    public void selectBarbarian(MouseEvent event) {
        if (Integer.parseInt(selected_lbl.getText()) < Integer.parseInt(maxHero_lbl.getText())) {
            numberOfBarbarian++;
            selected++;
            selected_lbl.setText(String.valueOf(selected));
            numberOfBarbarian_lbl.setText(String.valueOf(numberOfBarbarian));
            Barbarian_King barbarianKing = new Barbarian_King(RegisterController.getIndexMap() * 5, RegisterController.getIndexMap() * 2, 10, barbarianKing_img, 30);
            heroes.add(barbarianKing);
            if (indexOfAttack == 0) {
                Map1Controller.addHero(barbarianKing);
            }
            //----------------------
            else if (indexOfAttack == 1) {
                Map2Controller.addHero(barbarianKing);
            } else if (indexOfAttack == 2) {
                Map3Controller.addHero(barbarianKing);
            } else if (indexOfAttack == 3) {
                Map4Controller.addHero(barbarianKing);
            }
        } else {
            selectedText_lbl.setText("MAX");
        }
    }
    //-----------------------------------


}

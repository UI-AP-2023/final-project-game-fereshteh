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


import java.io.IOException;
import java.net.URL;
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
    private Button attack_btn;

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
    //--------------------------------
    private static  String username;
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
    int check=0;
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
    public void showProfile(MouseEvent event){
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
    public void showUsername(MouseEvent event){
        username_lbl.setText(ProfileController.username);
    }
    //-------------------------------------------
    @FXML
    public void showPassword(MouseEvent event){
       passwod_lbl.setText(ProfileController.password);
    }
}

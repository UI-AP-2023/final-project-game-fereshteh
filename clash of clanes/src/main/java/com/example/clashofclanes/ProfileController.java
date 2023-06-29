package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

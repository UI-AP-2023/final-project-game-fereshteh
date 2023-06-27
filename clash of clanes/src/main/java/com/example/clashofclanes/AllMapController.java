package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AllMapController implements Initializable {
    @FXML
    private AnchorPane mapPane1;

    @FXML
    private ImageView map1_img;

    @FXML
    private ImageView canoonBuliding_img;

    @FXML
    private ImageView blackWall2_img;

    @FXML
    private ImageView blueBuliding_image;

    @FXML
    private ImageView archerBuilding_img;

    @FXML
    private ImageView blackWall_img;

    @FXML
    private Button last_btn;

    @FXML
    private Button next_btn;

    @FXML
    private AnchorPane mapPane2;

    @FXML
    private ImageView map2_img;

    @FXML
    private ImageView blackWall2_img1;

    @FXML
    private ImageView blackWall1_img;

    @FXML
    private ImageView blackWall3_img;

    @FXML
    private ImageView archerBuilding1_img;

    @FXML
    private ImageView canoon1_img;

    @FXML
    private ImageView canoon2_img;

    @FXML
    private ImageView archerBulding2_img;

    @FXML
    private AnchorPane mapPane3;

    @FXML
    private AnchorPane mapPane4;
    int check = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void nextPane(MouseEvent event) {

        if (check == 0) {
            mapPane1.setVisible(true);
            check++;
        } else if (check == 1) {
            mapPane1.setVisible(false);
            mapPane2.setVisible(true);
            check++;

        } else if (check == 2) {
            mapPane2.setVisible(false);
            mapPane3.setVisible(true);
            check++;
        } else if (check == 3) {
            mapPane3.setVisible(false);
            mapPane4.setVisible(true);
            check++;
        } else if (check == 4) {
            mapPane4.setVisible(false);
            mapPane1.setVisible(true);
            check = 0;
        }
    }

    //------------------------
    @FXML
    public void lastPane(MouseEvent event) {
        if (check == 0) {
            mapPane1.setVisible(false);
            mapPane4.setVisible(true);
            check = 6;
        } else if (check == 1) {
            mapPane1.setVisible(false);
            mapPane4.setVisible(true);
            check--;
        } else if (check == 2) {
            mapPane2.setVisible(false);
            mapPane1.setVisible(true);
            check--;
        } else if (check == 4) {
            mapPane4.setVisible(false);
            mapPane3.setVisible(true);
            check--;
        } else if (check == 3) {
            mapPane3.setVisible(false);
            mapPane2.setVisible(true);
            check--;

        }
    }
}

package com.example.clashofclanes;

import controller.LoginC;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllMapController implements Initializable {
    @FXML
    private AnchorPane mapPane1;

    @FXML
    private ImageView map1_img;

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
    private Button last_btn;

    @FXML
    private Button next_btn;

    @FXML
    private AnchorPane mapPane2;

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
    private AnchorPane mapPane3;

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
    private AnchorPane mapPane4;

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
    //--------------------------
    @FXML
    public void selectMap1(MouseEvent event) throws IOException {
        RegisterController.setIndexMap(0);
        LoginC.getInstance().insert(RegisterController.getUsername(),RegisterController.getPassword(),0,1);
        new Profile().start((Stage) map1_img.getScene().getWindow());
        ProfileController.setPassword(RegisterController.getPassword());
        System.out.println(RegisterController.getPassword());
        System.out.println(RegisterController.getUsername());
        ProfileController.setUsername(RegisterController.getUsername());
    }
    @FXML
    public void selectMap2(MouseEvent event) throws IOException {
        RegisterController.setIndexMap(1);
        LoginC.getInstance().insert(RegisterController.getUsername(),RegisterController.getPassword(),1,2);
        new Profile().start((Stage) map2_img.getScene().getWindow());
        ProfileController.setPassword(RegisterController.getPassword());
        ProfileController.setUsername(RegisterController.getUsername());

    }
    @FXML
    public void selectMap3(MouseEvent event) throws IOException {
        RegisterController.setIndexMap(2);
        LoginC.getInstance().insert(RegisterController.getUsername(),RegisterController.getPassword(),2,3);
        new Profile().start((Stage) map3_img.getScene().getWindow());
        ProfileController.setPassword(RegisterController.getPassword());
        ProfileController.setUsername(RegisterController.getUsername());

    }
    @FXML
    public void selectMap4(MouseEvent event) throws IOException {
        RegisterController.setIndexMap(3);
        LoginC.getInstance().insert(RegisterController.getUsername(),RegisterController.getPassword(),3,4);
        new Profile().start((Stage) map4_img.getScene().getWindow());
        ProfileController.setPassword(RegisterController.getPassword());
        ProfileController.setUsername(RegisterController.getUsername());

    }
    //---------------------------------------
}

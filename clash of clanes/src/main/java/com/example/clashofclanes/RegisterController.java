package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    //--------------------------------

    //--------------------------------
    @FXML
    private ImageView backGround_img;

    @FXML
    private AnchorPane login_pane;

    @FXML
    private Label userName_lbl;

    @FXML
    private Label Password_lbl;

    @FXML
    private TextField userName_txtField;

    @FXML
    private TextField password_txtField;

    @FXML
    private Button register_btn;

    @FXML
    private Button login_btn;
   private static String username;
  private  static String password;
  private  static int indexMap;
  private static int failure;
  private static int sucsses;
  //----------------------------

    public ImageView getBackGround_img() {
        return backGround_img;
    }

    public void setBackGround_img(ImageView backGround_img) {
        this.backGround_img = backGround_img;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        RegisterController.username = username;
    }

    public  static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        RegisterController.password = password;
    }

    public  static int getIndexMap() {
        return indexMap;
    }

    public  static void setIndexMap(int indexMap) {
        RegisterController.indexMap = indexMap;
    }

    public static int getFailure() {
        return failure;
    }

    public static void setFailure(int failure) {
        RegisterController.failure = failure;
    }

    public static int getSucsses() {
        return sucsses;
    }

    public static void setSucsses(int sucsses) {
        RegisterController.sucsses = sucsses;
    }
    //--------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    public void register(MouseEvent event) throws Exception {
        username=userName_txtField.getText();
        password=password_txtField.getText();
        new AllMap().start((Stage) register_btn.getScene().getWindow());
    }
    @FXML
    public void check(MouseEvent event)throws Exception{

    }

}

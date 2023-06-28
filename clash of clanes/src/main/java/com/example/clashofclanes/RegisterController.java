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
    private static RegisterController instance;
    private RegisterController() {

    }

    public static RegisterController getInstance() {
        if (instance == null) {
            instance = new RegisterController() {

            };
        }
        return instance;
    }
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
   private String username;
  private   String password;
  private int indexMap;
  //----------------------------

    public ImageView getBackGround_img() {
        return backGround_img;
    }

    public void setBackGround_img(ImageView backGround_img) {
        this.backGround_img = backGround_img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIndexMap() {
        return indexMap;
    }

    public void setIndexMap(int indexMap) {
        this.indexMap = indexMap;
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

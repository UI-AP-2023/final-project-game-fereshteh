package com.example.clashofclanes;

import controller.LoginC;
import detaBase.PlayersConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    //--------------------------------

    //--------------------------------
    @FXML
    private AnchorPane login_pane;
    @FXML
    private ImageView backGround_img;


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
    private static   String username;
    private static String password;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LoginController.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LoginController.password = password;
    }

    //-----------------------
    Player player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    public void login(MouseEvent event) throws Exception {
       if( LoginC.getInstance().check(userName_txtField.getText(),password_txtField.getText())){
           ProfileController.setFailure(PlayersConnection.getInstance().getFailure(username));
           ProfileController.setSuccess(PlayersConnection.getInstance().getSucsses(username));
           ProfileController.setPassword(password);
           ProfileController.setUsername(username);
           new Profile().start((Stage) login_btn.getScene().getWindow());
       }
       else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setContentText("wrong info");
           alert.show();
       }
       RegisterController.setUsername(username);
       RegisterController.setPassword(password);

    }
}

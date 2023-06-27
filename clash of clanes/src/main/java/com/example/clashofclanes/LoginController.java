package com.example.clashofclanes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
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

    //-----------------------
    Player player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

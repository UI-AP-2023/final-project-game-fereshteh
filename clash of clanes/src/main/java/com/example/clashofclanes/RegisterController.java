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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    public void register(MouseEvent event) throws Exception {
        new AllMap().start((Stage) register_btn.getScene().getWindow());
    }
}

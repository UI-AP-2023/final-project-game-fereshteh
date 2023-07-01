package com.example.clashofclanes;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import model.hero.Hero;
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

public class DraggableMaker {
    private static double mouseAnchorX;
    private static double mouseAnchorY;
    public static void makeDraggable(Node node){
        node.setOnMousePressed(mouseEvent ->{
            mouseAnchorX=mouseEvent.getX();
            mouseAnchorY=mouseEvent.getY();
        });
        node.setOnMouseDragged(mouseEvant->{
            node.setLayoutX(mouseEvant.getSceneX()-mouseAnchorX);
            node.setLayoutY(mouseEvant.getSceneY()-mouseAnchorY);
        });
    }


}

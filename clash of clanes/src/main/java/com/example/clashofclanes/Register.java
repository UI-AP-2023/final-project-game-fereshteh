package com.example.clashofclanes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.border.TitledBorder;
import java.io.IOException;

public class Register extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 823, 459);
        stage.setTitle("clash of clans !");

        stage.setAlwaysOnTop(false);
        stage.setScene(scene);
        stage.show();
    }
}










































































package com.example.clashofclanes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WinPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WinPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 931, 621);
        stage.setTitle("clash of clans !");
        stage.setScene(scene);
        stage.show();
    }
}

package com.example.clashofclanes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Map2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("map2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1150, 775);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}

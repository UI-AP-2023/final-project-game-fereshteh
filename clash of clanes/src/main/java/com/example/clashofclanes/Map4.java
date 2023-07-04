package com.example.clashofclanes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Map4 extends Application {
    public static Pane root = new Pane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
         root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("map4.fxml")));
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}

package com.example.clashofclanes;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.hero.Hero;
import model.strucrure.Building;

import java.io.IOException;
import java.util.Objects;

public class Map1 extends Application {
    Timeline timer;
    public static Pane root = new Pane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("map1.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }




}

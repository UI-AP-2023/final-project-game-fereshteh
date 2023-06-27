package com.example.clashofclanes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Meno extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Meno.class.getResource("meno.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 635, 432);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
}

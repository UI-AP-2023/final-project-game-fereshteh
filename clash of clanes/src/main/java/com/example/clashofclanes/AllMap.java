package com.example.clashofclanes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AllMap extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("allMap.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 985, 657);
        stage.setTitle("clash of clans !");
        stage.setScene(scene);
        stage.show();
    }
}

module com.example.clashofclanes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.clashofclanes to javafx.fxml;
    exports com.example.clashofclanes;
    exports com.example.clashofclanes.controller;
    opens com.example.clashofclanes.controller to javafx.fxml;
}
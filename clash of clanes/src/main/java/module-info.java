module com.example.clashofclanes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.clashofclanes to javafx.fxml;
    exports com.example.clashofclanes;
    exports controller;
    opens controller to javafx.fxml;
}
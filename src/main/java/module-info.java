module com.example.leaveapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;


    opens com.example.leaveapp to javafx.fxml;
    exports com.example.leaveapp;
}
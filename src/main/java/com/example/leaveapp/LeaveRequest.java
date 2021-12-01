package com.example.leaveapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaveRequest extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.leaveapp.LeaveRequest.class.getResource("LeaveRequest.fxml" ));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
            stage.setTitle("hi!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }


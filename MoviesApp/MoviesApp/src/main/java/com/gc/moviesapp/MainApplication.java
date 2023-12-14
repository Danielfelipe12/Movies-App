package com.gc.moviesapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainController.stage = stage;
        MainController.scene = scene;
        MainController.mainController = fxmlLoader.getController();

        stage.setTitle("Movie Application");
        stage.setScene(scene);
        stage.show();

        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("moviePage.fxml"));
        scene = new Scene(fxmlLoader.load());
        MoviePageController.scene = scene;
        MoviePageController.moviePageController = fxmlLoader.getController();
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.gc.moviesapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MovieDateAndButton {
    String name;
    String date;
    Button button;

    public MovieDateAndButton(String name, String date) {
        this.name = name;
        this.date = date;
        button = new Button();
        button.setText(name+" "+date);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String string = name.replaceAll(" ","%20");
                MoviePageController.moviePageController.fillFields(APIConnection.askMovieName(string));
                MainController.stage.setScene(MoviePageController.scene);
            }
        });
    }
}

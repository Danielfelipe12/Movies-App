package com.gc.moviesapp;

import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MoviePageController {
    static Scene scene;
    static  MoviePageController moviePageController;
    @FXML
    private ImageView imageView;
    @FXML
    private Label labelMovieName;
    @FXML
    private Label labelRated;
    @FXML
    private Label labelReleaseDate;
    @FXML
    private Label labelMovieTime;
    @FXML
    private Label labelGenre;
    @FXML
    private Label labelRatings;
    @FXML
    private Label labelPlot;

    @FXML
    protected void clickBackButton() {
        MainController.stage.setScene(MainController.scene);
    }

    public void fillFields( Movie movie ){

        imageView.setImage(movie.movieImage);

        labelMovieName.setText(movie.labelMovieName);
        labelRated.setText(movie.labelRated);
        labelReleaseDate.setText(movie.labelReleaseDate);
        labelMovieTime.setText(movie.labelMovieTime);
        labelGenre.setText(movie.labelGenre);
        labelPlot.setText(movie.labelPlot);

        String string = "";
        for (JsonObject jsonObject:
            movie.labelRatings) {
            string += jsonObject.get("Source").getAsString();
            string += ": ";
            string += jsonObject.get("Value").getAsString();
            string += "\n";
        }

        labelRatings.setText(string);

    }
}
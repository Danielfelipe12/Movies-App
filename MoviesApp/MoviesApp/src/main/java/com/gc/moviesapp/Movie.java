package com.gc.moviesapp;

import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class Movie {
    public Image movieImage;
    public String labelMovieName;
    public String labelRated;
    public String labelReleaseDate;
    public String labelMovieTime;
    public String labelGenre;
    public JsonObject[] labelRatings;
    public String labelPlot;

    public Movie() {
        labelMovieName = null;
    }

    public Image getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Image movieImage) {
        this.movieImage = movieImage;
    }

    public String getLabelMovieName() {
        return labelMovieName;
    }

    public void setLabelMovieName(String labelMovieName) {
        this.labelMovieName = labelMovieName;
    }

    public String getLabelRated() {
        return labelRated;
    }

    public void setLabelRated(String labelRated) {
        this.labelRated = labelRated;
    }

    public String getLabelReleaseDate() {
        return labelReleaseDate;
    }

    public void setLabelReleaseDate(String labelReleaseDate) {
        this.labelReleaseDate = labelReleaseDate;
    }

    public String getLabelMovieTime() {
        return labelMovieTime;
    }

    public void setLabelMovieTime(String labelMovieTime) {
        this.labelMovieTime = labelMovieTime;
    }

    public String getLabelGenre() {
        return labelGenre;
    }

    public void setLabelGenre(String labelGenre) {
        this.labelGenre = labelGenre;
    }

    public String getLabelPlot() {
        return labelPlot;
    }

    public void setLabelPlot(String labelPlot) {
        this.labelPlot = labelPlot;
    }

    public JsonObject[] getLabelRatings() {
        return labelRatings;
    }

    public void setLabelRatings(JsonObject[] labelRatings) {
        this.labelRatings = labelRatings;
    }
}

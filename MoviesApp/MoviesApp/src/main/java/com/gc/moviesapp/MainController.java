package com.gc.moviesapp;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;

public class MainController {
    static Scene scene;
    static Stage stage;
    static  MainController mainController;
    @FXML
    private Label labelMoviesFound;
    @FXML
    private TextField textFieldSearch;
    @FXML
    private ScrollPane scrollPane;


    @FXML
    protected void clickButtonSearch() {
        Movie movie;

        String searchString = MainController.mainController.textFieldSearch.getText();
        searchString = searchString.replaceAll(" ","%20");
        if(searchString.charAt(0)=='t'&&searchString.charAt(1)=='t'){
            movie = APIConnection.askMovieId(searchString);
            if(movie.getLabelMovieName()==null){
                MainController.mainController.scrollPane.setContent(new Label("IMDb ID not found"));
                labelMoviesFound.setText("Movies found: 0");
            }else{
                MoviePageController.moviePageController.fillFields(movie);
                MainController.stage.setScene(MoviePageController.scene);
            }
        }else{
            LinkedList<MovieDateAndButton> list = APIConnection.askSimilarMovies(searchString);
            MainController.mainController.scrollPane.setContent(null);

            VBox vBox = new VBox();
            for (MovieDateAndButton mdb: list) {
                vBox.getChildren().add(mdb.button);
            }
            labelMoviesFound.setText("Movies found: 20");
            MainController.mainController.scrollPane.setContent(vBox);
        }
    }
}
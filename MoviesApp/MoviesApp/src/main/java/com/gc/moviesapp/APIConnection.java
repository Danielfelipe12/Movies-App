package com.gc.moviesapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.LinkedList;

public class APIConnection {

    public APIConnection() {
    }

    public static Movie askMovieId(String movieId){
        Movie movie = new Movie();

        String apiKey = "eca18034";
        String movieTitle = movieId;
        String apiUrl = "http://www.omdbapi.com/?i=" + movieTitle + "&apikey=" + apiKey;
        //http://www.omdbapi.com/?i=tt3896198&apikey=eca18034
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);

            HttpResponse response = httpClient.execute(httpGet);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            System.out.println();

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

            movie.movieImage = ImageDownloader.downloadImage(jsonObject.get("Poster").getAsString());

            movie.labelMovieName = jsonObject.get("Title").getAsString();
            movie.labelRated = jsonObject.get("Rated").getAsString();
            movie.labelReleaseDate = jsonObject.get("Released").getAsString();
            movie.labelMovieTime = jsonObject.get("Runtime").getAsString();
            movie.labelGenre = jsonObject.get("Genre").getAsString();
            movie.labelPlot = jsonObject.get("Plot").getAsString();

            LinkedList<JsonObject> list = new LinkedList();
            JsonArray ratings = jsonObject.get("Ratings").getAsJsonArray();
            for (int i = 0; i < ratings.size(); i++) {
                list.add(ratings.get(i).getAsJsonObject());
            }
            movie.labelRatings = (JsonObject[]) list.toArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

    public static Movie askMovieName(String movieTitle){
        Movie movie = new Movie();

        String apiKey = "eca18034";
        String apiUrl = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=" + movieTitle;
        //http://www.omdbapi.com/?apikey=yourapikey&t=movie_title
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);

            HttpResponse response = httpClient.execute(httpGet);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            System.out.println();

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

            movie.movieImage = ImageDownloader.downloadImage(jsonObject.get("Poster").getAsString());

            movie.labelMovieName = jsonObject.get("Title").getAsString();
            movie.labelRated = jsonObject.get("Rated").getAsString();
            movie.labelReleaseDate = jsonObject.get("Released").getAsString();
            movie.labelMovieTime = jsonObject.get("Runtime").getAsString();
            movie.labelGenre = jsonObject.get("Genre").getAsString();
            movie.labelPlot = jsonObject.get("Plot").getAsString();

            JsonArray ratings = jsonObject.get("Ratings").getAsJsonArray();
            JsonObject[] array = new JsonObject[ratings.size()];
            for (int i = 0; i < ratings.size(); i++) {
                array[i] = ratings.get(i).getAsJsonObject();
            }
            movie.labelRatings = array;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

    public static LinkedList<MovieDateAndButton> askSimilarMovies(String movieTitle){

        movieTitle = movieTitle.replaceAll(" ","%20");

        LinkedList<MovieDateAndButton> list = new LinkedList<>();

        String apiKey = "6c674e293cb4aba52dfe7aad616a1de0";
        String apiUrl = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + movieTitle;
        //https://api.themoviedb.org/3/search/movie?api_key=yourapikey&query=movie_title
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);

            HttpResponse response = httpClient.execute(httpGet);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            JsonObject jsonObjectResults = JsonParser.parseString(jsonResponse).getAsJsonObject();

            JsonArray jsonResponses = jsonObjectResults.getAsJsonArray("results");

            for (int i = 0; i < jsonResponses.size(); i++) {


                JsonObject jsonObject = JsonParser.parseString(jsonResponses.get(i).toString()).getAsJsonObject();
                String name = jsonObject.get("title").getAsString();
                String date = "released: " + jsonObject.get("release_date").getAsString();

                MovieDateAndButton movieAndDate = new MovieDateAndButton(name,date);
                list.add(movieAndDate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

}

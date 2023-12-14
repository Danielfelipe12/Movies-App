module com.example.moviesapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires com.google.gson;
    requires java.desktop;


    opens com.gc.moviesapp to javafx.fxml;
    exports com.gc.moviesapp;
}
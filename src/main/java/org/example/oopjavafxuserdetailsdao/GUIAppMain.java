package org.example.oopjavafxuserdetailsdao;  // Feb 2025

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/// We create a JavaFX Application by writing a class that
/// extends javafx.application.Application. (as above)
/// The Application is started in its own JavaFX Application thread by
/// calling the launch() method.
/// The start() method is then called by the JavaFX runtime.
/// [Application class API](https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html)
/// [javafx API](https://docs.oracle.com/javase/8/javafx/api/index.html?javafx/application/Application.html)

public class GUIAppMain extends Application {

    public static void main(String[] args) {
        launch(); // launch() is a static method defined in JavaFX Application class (inherited)
    }

    /// start() is called by the JavaFX runtime system, after our JavaFX Application
    /// is launched.  This is the entry point to our program where we load UI and Controllers
    @Override
    public void start(Stage stage) throws IOException {

        /// create fxml Loader, based on fxml file resource
        FXMLLoader loader = new FXMLLoader(GUIAppMain.class.getResource("user-view.fxml"));
        Parent root = loader.load();  // load in the root (Parent container) of UI, and instantiate the Controller

        // Load the Scene (containing GUI Controls)
        Scene scene = new Scene(root, 450, 650);
        stage.setScene(scene);
        stage.setTitle("User GUI Application");
        stage.show();
    }
}




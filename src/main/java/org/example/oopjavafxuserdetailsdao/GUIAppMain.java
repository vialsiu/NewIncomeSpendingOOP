package org.example.oopjavafxuserdetailsdao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GUIAppMain extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(GUIAppMain.class.getResource("user-view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 450, 650);
        stage.setScene(scene);
        stage.setTitle("User GUI Application");
        stage.show();
    }
}




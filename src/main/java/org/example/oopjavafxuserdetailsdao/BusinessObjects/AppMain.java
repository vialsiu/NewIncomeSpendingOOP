//package org.example.oopjavafxuserdetailsdao;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TabPane;
//import javafx.stage.Stage;
//
//public class GUIAppMain extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        TabPane root = new TabPane();
//
//        Tab userTab = new Tab("User Details");
//        Parent userContent = FXMLLoader.load(getClass().getResource("/user-view.fxml"));
//        userTab.setContent(userContent);
//        userTab.setClosable(false);
//
//        Tab expenseTab = new Tab("Expense Manager");
//        Parent expenseContent = FXMLLoader.load(getClass().getResource("/expense-view.fxml"));
//        expenseTab.setContent(expenseContent);
//        expenseTab.setClosable(false);
//
//        root.getTabs().addAll(userTab, expenseTab);
//
//        Scene scene = new Scene(root, 800, 600);
//        primaryStage.setTitle("Finance Management System");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
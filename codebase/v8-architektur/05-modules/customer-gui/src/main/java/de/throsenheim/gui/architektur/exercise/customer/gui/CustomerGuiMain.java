package de.throsenheim.gui.architektur.exercise.customer.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CustomerGuiMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent customerSearch = FXMLLoader.load(getClass().getResource("CustomerSearch.fxml"));

        primaryStage.setScene(new Scene(customerSearch));

        primaryStage.show();
    }
}

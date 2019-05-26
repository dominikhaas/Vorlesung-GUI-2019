package de.throsenheim.gui.u08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Main class fuer Uebung 07
 * 
 * @author dominik.haas
 */
public class U08Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        URL resource = getClass().getResource("chart/Chart.fxml");
        System.out.println("test!:" + resource);
        Parent root = FXMLLoader.load(resource);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

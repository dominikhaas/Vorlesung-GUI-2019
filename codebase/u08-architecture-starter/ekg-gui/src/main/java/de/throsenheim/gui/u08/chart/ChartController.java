
package de.throsenheim.gui.u08.chart;

import de.throsenheim.gui.u08.header.HeaderController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Presenter für den Diagramm-View.
 *
 * @author dominik.haas
 */
public class ChartController implements Initializable {
    
    @FXML
    private HeaderController headerController;
    @FXML
    private LineChart<Number, Number> chart;
    
    //progress
    @FXML
    private GridPane progressArea;
    @FXML
    private Label progressLabel;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button cancelButton;
    
    private ChartModel chartModel = new ChartModel();
    
    private GenerateDataService generateDataService = new GenerateDataService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeGenerateDataService();
        initializeEventHandlers();
        initializeUiBindings();
    }    
    //Aufgabe 3
    private void initializeGenerateDataService() {

        generateDataService.setOnSucceeded((event) -> {
            chartModel.updateChartData(generateDataService.getValue());
        });
    }

    private void initializeEventHandlers() {
        headerController.setActionListener(() -> {
            //Aufgabe 1 & 2
            //generateGraph();
            
            //Aufgabe 3
            generateDataService.restart();
        });
        cancelButton.setOnAction((event) ->  {
            //Aufgabe 3
            generateDataService.cancel();
        });
    }    

    private void initializeUiBindings() {
        progressLabel.textProperty().bind(generateDataService.messageProperty());
        progressBar.progressProperty().bind(generateDataService.progressProperty());
        progressArea.visibleProperty().bind(generateDataService.runningProperty());
        chart.dataProperty().bind(chartModel.getChartData());
    }    
    
    //Aufgabe 1 & 2
    private void generateGraph() {
        new Thread(()-> {
            simulateLongRunningTask();
            Platform.runLater(() -> {
               chartModel.generateData(headerController.getSettingsModel().seriesProperty().get());   
            });
        }).start();
    } 

    private void simulateLongRunningTask() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

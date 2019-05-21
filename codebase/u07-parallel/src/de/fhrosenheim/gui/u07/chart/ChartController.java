
package de.fhrosenheim.gui.u07.chart;

import de.fhrosenheim.gui.u07.header.HeaderController;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

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

        //Alternative to setOnSucceeded
        //chartModel.chartData.bind(generateDataService.valueProperty());
    }

    private void initializeEventHandlers() {
        headerController.setActionListener(() -> {
            //Aufgabe 1 & 2
            //generateGraph();
            
            //Aufgabe 3
            generateGraphAufgabe3();
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
            ObservableList<XYChart.Series<Number, Number>> chartData = chartModel.generateData(headerController.getSettingsModel().seriesProperty().get());
            Platform.runLater(() -> {
                chartModel.updateChartData(chartData);
            });
        }).start();
    }

    private void generateGraphAufgabe3() {
        generateDataService.restart();
    }

    private void simulateLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

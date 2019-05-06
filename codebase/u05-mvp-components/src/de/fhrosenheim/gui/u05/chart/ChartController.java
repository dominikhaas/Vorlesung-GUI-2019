
package de.fhrosenheim.gui.u05.chart;

import de.fhrosenheim.gui.u05.header.HeaderController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;

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
    
    private ChartModel chartModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chartModel = new ChartModel(headerController.getSettingsModel());


        headerController.setActionListener(() -> {
            generateChartData();
        });
        
        chart.dataProperty().bind(chartModel.getChartData());
    }    
    
    private void generateChartData() {
        chartModel.generateData();
    } 
}

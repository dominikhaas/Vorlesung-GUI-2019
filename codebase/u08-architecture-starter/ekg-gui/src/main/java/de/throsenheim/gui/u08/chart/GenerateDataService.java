package de.throsenheim.gui.u08.chart;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart;

/**
 * JavaFX Service der als Factory für den GenerateDataTask fungiert.
 * Diese Klasse kann im Programm einmal am Anfang initialisiert werden und dann
 * dauerhaft verwendet (im Gegensatz zu einem einzelnen Task).
 * 
 * @author dominik.haas
 */
public class GenerateDataService extends Service<ObservableList<XYChart.Series<Number, Number>>> {

    @Override
    protected Task<ObservableList<XYChart.Series<Number, Number>>> createTask() {
        return new GenerateDataTask();
    }
}

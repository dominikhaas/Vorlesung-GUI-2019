package de.fhrosenheim.gui.u07.chart;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart;

/**
 * JavaFX Task der eine lange Ladezeit mit Statusupdates simuliert und danach
 * die Zufallsdaten generiert.
 * 
 * @author dominik.haas
 */
public class GenerateDataTask extends Task<ObservableList<XYChart.Series<Number, Number>>> {

    private static final Logger LOGGER = Logger.getLogger(GenerateDataTask.class.getName());
    private static final int STEP_COUNT = 10;



    @Override
    protected ObservableList<XYChart.Series<Number, Number>> call() throws Exception {



        LOGGER.log(Level.INFO, "GenerateDataTask.call in Thread {0}", Thread.currentThread());
        updateStatus(0, STEP_COUNT);
        if (simulateLongRunningTask()) {
            return generateData();
        } else {
            return null;
        }
    }

    private boolean simulateLongRunningTask() {
        for (int i = 1; i <= STEP_COUNT; i++) {
            try {
                Thread.sleep(300);

                if (isCancelled()) {
                    return false;
                } else {
                    updateStatus(i, STEP_COUNT);
                }

            } catch (InterruptedException ex) {
                if (isCancelled()) {
                    return false;
                }
            }
        }
        return true;
    }

    private ObservableList<XYChart.Series<Number, Number>> generateData() {
        ObservableList<XYChart.Series<Number, Number>> seriesList = FXCollections.observableArrayList();

        final XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i < 100; i++) {
            series.getData().add(new XYChart.Data<>(i, Math.random() * i));
        }
        seriesList.addAll(series);
        return seriesList;
    }

    private void updateStatus(int currentStep, int stepCount) {
        updateMessage("Step " + currentStep + "/" + stepCount + " done");
        updateProgress(currentStep, stepCount);
    }

    //Nur zur Ausgabe des Threads (sonst nicht benötigt)
    @Override
    protected void succeeded() {
        LOGGER.log(Level.INFO, "GenerateDataTask.succeeded in Thread {0}", Thread.currentThread());
    }
}

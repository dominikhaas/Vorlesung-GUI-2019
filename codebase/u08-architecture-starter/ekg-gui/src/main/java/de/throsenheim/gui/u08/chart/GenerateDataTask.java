package de.throsenheim.gui.u08.chart;

import de.throsenheim.gui.u08.unsorted.DataSeriesServiceImpl;
import de.throsenheim.gui.u08.unsorted.PointDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX Task der eine lange Ladezeit mit Statusupdates simuliert und danach
 * die Zufallsdaten generiert.
 * 
 * @author dominik.haas
 */
public class GenerateDataTask extends Task<ObservableList<XYChart.Series<Number, Number>>> {

    private static final Logger LOGGER = Logger.getLogger(GenerateDataTask.class.getName());

    private DataSeriesServiceImpl dataSeriesService = new DataSeriesServiceImpl();


    public GenerateDataTask() {
    }

    @Override
    protected ObservableList<XYChart.Series<Number, Number>> call() throws Exception {
        LOGGER.log(Level.INFO, "GenerateDataTask.call in Thread {0}", Thread.currentThread());

        Thread.sleep(2000);

        List<PointDto> pointsFromService = dataSeriesService.loadDataSeries().getPoints();

        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        for (PointDto pointDto : pointsFromService) {
            series.getData().add(new XYChart.Data<>(pointDto.getX(), pointDto.getY()));
        }

        return FXCollections.observableArrayList(series);
    }
}

package de.fhrosenheim.gui.u07.chart;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * Model für das Diagramm. Beinhaltet eine Serie von Daten die zufällig erzeugt
 * wird.
 *
 * @author dominik.haas
 */
public class ChartModel {

    public final SimpleObjectProperty<ObservableList<XYChart.Series<Number, Number>>> chartData = new SimpleObjectProperty<>(FXCollections.observableArrayList());

    public final void updateChartData(ObservableList<XYChart.Series<Number, Number>> seriesList) {
        chartData.set(seriesList);
    }

    public SimpleObjectProperty<ObservableList<XYChart.Series<Number, Number>>> getChartData() {
        return chartData;
    }

    public final ObservableList<XYChart.Series<Number, Number>> generateData(String seriesName) {
        ObservableList<XYChart.Series<Number, Number>> seriesList = FXCollections.observableArrayList();

        final XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(seriesName);
        for (int i = 0; i < 100; i++) {
            series.getData().add(new XYChart.Data<>(i, Math.random() * i));
        }
        seriesList.addAll(series);
        return seriesList;
    }
}

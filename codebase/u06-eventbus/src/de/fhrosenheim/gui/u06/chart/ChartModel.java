package de.fhrosenheim.gui.u06.chart;

import de.fhrosenheim.gui.u06.header.HeaderSettingsModel;
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
    
    private final SimpleObjectProperty<ObservableList<XYChart.Series<Number, Number>>> chartData = new SimpleObjectProperty<>();
    private final ObservableList<XYChart.Series<Number, Number>> seriesList = FXCollections.observableArrayList();
    
    private final HeaderSettingsModel settingsModel;

    public ChartModel(HeaderSettingsModel settingsModel) {
        this.settingsModel = settingsModel;
        chartData.set(seriesList);
    }

    public final void generateData() {
        seriesList.clear();
        final XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(settingsModel.getSeries());
        for(int i = 0; i < 100; i++) {
            series.getData().add(new XYChart.Data<>(i, Math.random() * i));
        }
        seriesList.addAll(series);
    }

    public SimpleObjectProperty<ObservableList<XYChart.Series<Number, Number>>> getChartData() {
        return chartData;
    }  
}

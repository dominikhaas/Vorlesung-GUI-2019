package de.fhrosenheim.gui.u07.header;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 * Model fuer die Eingaben im Header.
 * 
 * @author dominik.haas
 */
public class HeaderSettingsModel {
    private final StringProperty series = new SimpleStringProperty();
    private final StringProperty measurement = new SimpleStringProperty();
    private final StringProperty host = new SimpleStringProperty();
    private final StringProperty process = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty metric = new SimpleStringProperty();
    private final StringProperty exclude = new SimpleStringProperty();
    private final StringProperty sampling = new SimpleStringProperty();
    private final StringProperty aggregation = new SimpleStringProperty();
    private final StringProperty graph = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> from = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> until = new SimpleObjectProperty<>();
    private final BooleanProperty expertMode = new SimpleBooleanProperty();

    public HeaderSettingsModel() {
        sampling.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            aggregation.set(null);
            graph.set(null);
        });
    }

    public String getSeries() {
        return series.get();
    }

    public void setSeries(String series) {
        this.series.set(series);
    }
    
    public StringProperty seriesProperty() {
        return series;
    }

    public String getMeasurement() {
        return measurement.get();
    }

    public void setMeasurement(String measurement) {
        this.measurement.set(measurement);
    }
    
    public StringProperty measurementProperty() {
        return measurement;
    }

    public String getHost() {
        return host.get();
    }

    public void setHost(String host) {
        this.host.set(host);
    }
    
    public StringProperty hostProperty() {
        return host;
    }

    public String getProcess() {
        return process.get();
    }

    public void setProcess(String process) {
        this.process.set(process);
    }
    
    public StringProperty processProperty() {
        return process;
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }    
    
    public StringProperty typeProperty() {
        return type;
    }

    public String getMetric() {
        return metric.get();
    }

    public void setMetric(String metric) {
        this.metric.set(metric);
    }    
    
    public StringProperty metricProperty() {
        return metric;
    }

    public String getExclude() {
        return exclude.get();
    }

    public void setExclude(String exclude) {
        this.exclude.set(exclude);
    }    
    
    public StringProperty excludeProperty() {
        return exclude;
    }

    public String getSampling() {
        return sampling.get();
    }

    public void setSampling(String sampling) {
        this.sampling.set(sampling);
    }    
    
    public StringProperty samplingProperty() {
        return sampling;
    }

    public String getAggregation() {
        return aggregation.get();
    }

    public void setAggregation(String aggregation) {
        this.aggregation.set(aggregation);
    }    
    
    public StringProperty aggregationProperty() {
        return aggregation;
    }

    public String getGraph() {
        return graph.get();
    }    


    public void setGraph(String graph) {
        this.graph.set(graph);
    }
    
    public StringProperty graphProperty() {
        return graph;
    }
    public LocalDate getFrom() {
        return from.get();
    }

    public void setFrom(LocalDate from) {
        this.from.set(from);
    }    
    
    public ObjectProperty<LocalDate> fromProperty() {
        return from;
    }

    public LocalDate getUntil() {
        return until.get();
    }

    public void setUntil(LocalDate until) {
        this.until.set(until);
    }    
    
    public ObjectProperty<LocalDate> untilProperty() {
        return until;
    }

    public boolean isExpertMode() {
        return expertMode.get();
    }

    public void setExpertMode(boolean expertMode) {
        this.expertMode.set(expertMode);
    }    
    
    public BooleanProperty expertModeProperty() {
        return expertMode;
    }

    @Override
    public String toString() {
        return "HeaderSettings{" + "series=" + series + ", measurement=" + measurement + ", host=" + host + ", process=" + process + ", type=" + type + ", metric=" + metric + ", exclude=" + exclude + ", sampling=" + sampling + ", aggregation=" + aggregation + ", graph=" + graph + ", from=" + from + ", until=" + until + ", expertMode=" + expertMode + '}';
    }
    
    
}

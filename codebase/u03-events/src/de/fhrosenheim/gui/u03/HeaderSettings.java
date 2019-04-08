package de.fhrosenheim.gui.u03;

import java.time.LocalDate;

/**
 * POJO fuer die Eingaben im Header.
 * 
 * @author dominik.haas
 */
public class HeaderSettings {
    private String series;
    private String measurement;
    private String host;
    private String process;
    private String type;
    private String metric;
    private String exclude;
    private String sampling;
    private String aggregation;
    private String graph;
    private LocalDate from;
    private LocalDate until;
    private boolean expertMode;


    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String getSampling() {
        return sampling;
    }

    public void setSampling(String sampling) {
        this.sampling = sampling;
    }

    public String getAggregation() {
        return aggregation;
    }

    public void setAggregation(String aggregation) {
        this.aggregation = aggregation;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public boolean isExpertMode() {
        return expertMode;
    }

    public void setExpertMode(boolean expertMode) {
        this.expertMode = expertMode;
    }

    @Override
    public String toString() {
        return "HeaderSettings{" +
                "series='" + series + '\'' +
                ", measurement='" + measurement + '\'' +
                ", host='" + host + '\'' +
                ", process='" + process + '\'' +
                ", type='" + type + '\'' +
                ", metric='" + metric + '\'' +
                ", exclude='" + exclude + '\'' +
                ", sampling='" + sampling + '\'' +
                ", aggregation='" + aggregation + '\'' +
                ", graph='" + graph + '\'' +
                ", from=" + from +
                ", until=" + until +
                ", expertMode=" + expertMode +
                '}';
    }
}

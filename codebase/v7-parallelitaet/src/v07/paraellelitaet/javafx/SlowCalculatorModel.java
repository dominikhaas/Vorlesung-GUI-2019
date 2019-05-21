/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v07.paraellelitaet.javafx;

import v07.paraellelitaet.regularthread.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dominik.haas
 */
public class SlowCalculatorModel {
    private StringProperty result = new SimpleStringProperty("?");
    private DoubleProperty progress = new SimpleDoubleProperty(0d);
    
    public void reset() {
        result.set("?");
        setProgress(0d);
    }
    
    public void incrementProgress() {
        setProgress(getProgress() + 0.1);
        System.out.println("Progress: " + getProgress() + "/1.0");
    }

    public String getResult() {
        return result.get();
    }
    
    public void setResult(String value) {
        this.result.set(value);
    }
    
    public StringProperty resultProperty() {
        return this.result;
    }
    
    public double getProgress() {
        return progress.get();
    }
    
    public void setProgress(double value) {
        this.progress.set(value);
    }
    
    public DoubleProperty progressProperty() {
        return this.progress;
    }
}

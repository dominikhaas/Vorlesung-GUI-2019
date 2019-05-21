/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v07.paraellelitaet.regularthread;

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
    
    public void reset() {
        result.set("?");
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
    
  
}

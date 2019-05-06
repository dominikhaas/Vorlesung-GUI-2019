package de.fhrosenheim.gui.u05.header;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 * Model für die möglichen Auswahlwerte im Header.
 * 
 * @author dominik.haas
 */
public class HeaderSettingsFilterModel {

    
    private final ListProperty<String> aggregations = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<String> samplings = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<String> graphs = new SimpleListProperty<>(FXCollections.observableArrayList());

    public HeaderSettingsFilterModel() {
        graphs.addAll("Line", "Sum", "Point");
        samplings.addAll("None", "Days", "Hours", "Minutes");
        aggregations.addAll("None", "Avg", "Min", "Max");
    }

    public ListProperty<String> graphsProperty() {
        return graphs;
    }
    
    public ListProperty<String> samplingsProperty() {
        return samplings;
    } 
        
    public ListProperty<String> aggregationsProperty() {
        return aggregations;
    } 
}

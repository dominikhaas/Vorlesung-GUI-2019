package de.fhrosenheim.gui.u06.status;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StatusModel {
    private StringProperty status = new SimpleStringProperty();

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}

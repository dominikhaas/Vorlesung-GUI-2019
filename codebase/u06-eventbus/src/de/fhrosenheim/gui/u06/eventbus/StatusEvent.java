package de.fhrosenheim.gui.u06.eventbus;


/**
 * Event um Statusmeldungen zu transportieren
 * 
 * @author dominik.haas
 */
public class StatusEvent implements Event {
    
    private final String status;

    public StatusEvent(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
}

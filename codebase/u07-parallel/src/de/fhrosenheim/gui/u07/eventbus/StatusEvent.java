/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhrosenheim.gui.u07.eventbus;

import java.util.EventObject;

/**
 *
 * @author dominik.haas
 */
public class StatusEvent extends EventObject {
    
    private final String status;

    public StatusEvent(Object source, String status) {
        super(source);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
}

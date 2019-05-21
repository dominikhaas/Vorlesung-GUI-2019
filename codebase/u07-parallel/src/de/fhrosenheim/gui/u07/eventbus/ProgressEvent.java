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
public class ProgressEvent extends EventObject {
    
    private final double value;

    public ProgressEvent(Object source, double value) {
        super(source);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    
}

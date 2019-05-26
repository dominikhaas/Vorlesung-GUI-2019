/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.throsenheim.gui.u08.status;

import de.throsenheim.gui.u08.eventbus.SimpleEventBus;
import de.throsenheim.gui.u08.eventbus.StatusEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author dominik.haas
 */
public class StatusController implements Initializable {
    
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SimpleEventBus.getBus().subscribe(StatusEvent.class, (StatusEvent event) -> {
            label.setText(event.getStatus());
        });
    }       
}

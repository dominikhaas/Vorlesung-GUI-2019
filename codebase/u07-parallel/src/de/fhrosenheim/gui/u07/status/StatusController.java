/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhrosenheim.gui.u07.status;

import de.fhrosenheim.gui.u07.eventbus.SimpleEventBus;
import de.fhrosenheim.gui.u07.eventbus.StatusEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

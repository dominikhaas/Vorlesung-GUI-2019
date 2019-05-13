package de.fhrosenheim.gui.u06.status;

import de.fhrosenheim.gui.u06.eventbus.EventBus;
import de.fhrosenheim.gui.u06.eventbus.SimpleEventBus;
import de.fhrosenheim.gui.u06.eventbus.StatusEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Controller für die Statuskomponente - Empfänger von Statusevents
 *
 * @author dominik.haas
 */
public class StatusController implements Initializable {
    
    @FXML
    private Label label;

    private StatusModel model = new StatusModel();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initial value
        model.setStatus("No event yet!");

        //data binding
        this.label.textProperty().bind(model.statusProperty());

        //event bus - receiver
        EventBus bus = SimpleEventBus.getBus();
        bus.subscribe(StatusEvent.class, (StatusEvent event) -> {
            model.setStatus(event.getStatus());
        });
    }       
}

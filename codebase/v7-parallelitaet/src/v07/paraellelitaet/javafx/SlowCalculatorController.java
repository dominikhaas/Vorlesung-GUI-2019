/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v07.paraellelitaet.javafx;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import v07.paraellelitaet.regularthread.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author dominik.haas
 */
public class SlowCalculatorController implements Initializable {

    @FXML
    private Label resultLabel;
    
    @FXML
    private Label statusLabel;

    @FXML
    ProgressBar progress;

    @FXML
    private Button goButton;

    @FXML
    private Button resetButton;

    private SlowCalculationService service = new SlowCalculationService();

    private SlowCalculatorModel model = new SlowCalculatorModel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        resultLabel.textProperty().bind(model.resultProperty());


        progress.progressProperty().bind(service.progressProperty());
        statusLabel.textProperty().bind(service.messageProperty());


        progress.visibleProperty().bind(service.runningProperty());
        statusLabel.visibleProperty().bind(service.runningProperty());


        goButton.addEventHandler(ActionEvent.ANY, (e) -> {

            service.restart();

            service.setOnSucceeded((e2) -> {
                model.setResult(service.getValue());
            });
/*
            task.setOnSucceeded((e2) -> {


            });*/

        });

        resetButton.addEventHandler(ActionEvent.ANY, (e3) -> {
            service.cancel();
            model.reset();
        });
    }

}
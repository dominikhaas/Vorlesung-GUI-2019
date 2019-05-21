/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v07.paraellelitaet.regularthread;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author dominik.haas
 */
public class SlowCalculatorController implements Initializable {

    @FXML
    private Label resultLabel;

    @FXML
    private Button goButton;

    @FXML
    private Button resetButton;

    private SlowCalculatorModel model = new SlowCalculatorModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resultLabel.textProperty().bind(model.resultProperty());

        goButton.addEventHandler(ActionEvent.ANY, (e) -> {

            System.out.println("Start Event Handler");

            System.out.println("Event handler in thread: " + Thread.currentThread().getName());

            new Thread(() -> {
                System.out.println("Start new custom thread");

                System.out.println("Calculation in new custom thread: " + Thread.currentThread().getName());

                String result = calculate();

                Platform.runLater(() -> {

                    System.out.println("Start update ui");

                    System.out.println("Platform runlater in : " + Thread.currentThread().getName());
                    updateResult(result);

                    System.out.println("End update ui");
                });

                System.out.println("End new custom thread");

            }).start();

            System.out.println("End Event Handler");
        });

        resetButton.addEventHandler(ActionEvent.ANY, (e) -> {
            model.reset();
        });

    }

    private String calculate() {

        System.out.print("\nCalculating ");
        for (int i = 0; i < 9; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }

        return "4";
    }

    private void updateResult(String result) {
        model.setResult(result);
    }

}
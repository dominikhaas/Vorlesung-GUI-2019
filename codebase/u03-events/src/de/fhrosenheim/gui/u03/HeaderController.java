package de.fhrosenheim.gui.u03;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


/**
 * Controller fuer die Header-Maske
 *
 * @author dominik.haas
 */
public class HeaderController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(HeaderController.class.getName());

    @FXML
    private ComboBox<String> seriesInput;
    @FXML
    private ComboBox<String> measurementInput;
    @FXML
    private ComboBox<String> hostInput;
    @FXML
    private ComboBox<String> processInput;
    @FXML
    private ComboBox<String> typeInput;
    @FXML
    private ComboBox<String> metricInput;
    @FXML
    private TextField excludeInput;
    @FXML
    private ComboBox<String> samplingInput;
    @FXML
    private ComboBox<String> aggregationInput;
    @FXML
    private ComboBox<String> graphInput;
    @FXML
    private DatePicker fromInput;
    @FXML
    private DatePicker untilInput;
    @FXML
    private CheckBox expertModeInput;
    @FXML
    private Button generateGraphButton;
    @FXML
    private Pane rootPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        generateGraphButton.setOnAction(this::onGenerateGraph);

        generateGraphButton.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onGenerateGraph(actionEvent);
            }
        });

        //Beispiel für zwei Event Filter und deren Reihenfolge
        //Der Event Filter auf oberer Ebene blockiert das kleine "a".
        rootPane.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if("a".equals(e.getCharacter())) {
                e.consume();
            }
            LOGGER.info("KEY_PRESSED on root");
        });
        seriesInput.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            LOGGER.info("KEY_PRESSED on seriesInput");
        });
    }

    public void onGenerateGraph(ActionEvent e) {
        HeaderSettings headerSettings = toSettings();
        LOGGER.log(Level.INFO, "on generate graph: {0}", headerSettings);
    }

    private HeaderSettings toSettings() {
        HeaderSettings result = new HeaderSettings();
        result.setSeries(seriesInput.getEditor().getText());
        result.setMeasurement(measurementInput.getEditor().getText());
        result.setHost(hostInput.getEditor().getText());
        result.setProcess(processInput.getEditor().getText());
        result.setType(typeInput.getEditor().getText());
        result.setMetric(metricInput.getEditor().getText());
        result.setExclude(excludeInput.getText());
        result.setExpertMode(expertModeInput.isSelected());

        result.setSampling(samplingInput.getSelectionModel().getSelectedItem());
        result.setAggregation(aggregationInput.getSelectionModel().getSelectedItem());
        result.setGraph(graphInput.getSelectionModel().getSelectedItem());

        result.setFrom(fromInput.getValue());
        result.setUntil(untilInput.getValue());

        return result;
    }


}

package de.fhrosenheim.gui.u05.header;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


/**
 * Presenter fuer die Header-Maske
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
    
    private final HeaderSettingsModel settingsModel = new HeaderSettingsModel();
    private final HeaderSettingsFilterModel filterModel = new HeaderSettingsFilterModel();
    
    
    private HeaderActionListener actionListener;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeBindings();
        generateGraphButton.setOnAction(this::onGenerateGraph);
    }

    private void initializeBindings() {
        initializeSettingsModelBindings();
        initializeFilterModelBindings();
    }

    private void initializeSettingsModelBindings() {
        seriesInput.valueProperty().bindBidirectional(settingsModel.seriesProperty());
        measurementInput.valueProperty().bindBidirectional(settingsModel.measurementProperty());
        hostInput.valueProperty().bindBidirectional(settingsModel.hostProperty());
        processInput.valueProperty().bindBidirectional(settingsModel.processProperty());
        typeInput.valueProperty().bindBidirectional(settingsModel.typeProperty());
        metricInput.valueProperty().bindBidirectional(settingsModel.metricProperty());
        excludeInput.textProperty().bindBidirectional(settingsModel.excludeProperty());
        expertModeInput.selectedProperty().bindBidirectional(settingsModel.expertModeProperty());
        
        samplingInput.valueProperty().bindBidirectional(settingsModel.samplingProperty());
        aggregationInput.valueProperty().bindBidirectional(settingsModel.aggregationProperty());
        graphInput.valueProperty().bindBidirectional(settingsModel.graphProperty());
        
        fromInput.valueProperty().bindBidirectional(settingsModel.fromProperty());
        untilInput.valueProperty().bindBidirectional(settingsModel.untilProperty());
    }    
    
    private void initializeFilterModelBindings() {
        samplingInput.itemsProperty().bind(filterModel.samplingsProperty());
        aggregationInput.itemsProperty().bind(filterModel.aggregationsProperty());
        graphInput.itemsProperty().bind(filterModel.graphsProperty());
    }
    
    @FXML
    private void onGenerateGraph(ActionEvent e) {
        LOGGER.log(Level.INFO, "on generate graph: {0}", settingsModel);
        if(this.actionListener != null) {
            this.actionListener.onGenerateGraph();
        }
    }

    public HeaderSettingsModel getSettingsModel() {
        return settingsModel;
    }

    public void setActionListener(HeaderActionListener actionListener) {
        this.actionListener = actionListener;
    }
    
    
}

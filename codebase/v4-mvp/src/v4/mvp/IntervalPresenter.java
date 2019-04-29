package v4.mvp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 *
 * @author haas
 */
public class IntervalPresenter implements Initializable{

    @FXML
    private Button buttonDown;
    @FXML
    private ProgressBar valueProgressbar;
    @FXML
    private TextField valueTextField;
    @FXML
    private Button buttonUp;

    private IntervalModel model = new IntervalModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //event handlers
        buttonDown.setOnAction((event) -> {
            model.decrease();
        });

        buttonUp.setOnAction((event) -> {
            model.increase();
        });


        //Initialize data binding
        valueProgressbar.progressProperty().bind(model.valueProperty().divide(10));
        valueTextField.textProperty().bind(model.valueProperty().asString());
    }
}
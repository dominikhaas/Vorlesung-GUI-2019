package de.throsenheim.gui.architektur.exercise.customer.gui;

import de.throsenheim.gui.architektur.exercise.customer.business.api.CustomerDto;
import de.throsenheim.gui.architektur.exercise.customer.business.api.CustomerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ServiceLoader;

public class CustomerSearch implements Initializable {
    @FXML
    private TextField searchInput;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<CustomerDto> searchResultList;

    private CustomerSearchModel model;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CustomerService service = ServiceLoader.load(CustomerService.class).findFirst().get();
        model = new CustomerSearchModel(service);


        //data binding
        searchInput.textProperty().bindBidirectional(model.searchTextProperty());
        searchResultList.itemsProperty().bind(model.searchResultsProperty());


        searchButton.setOnAction((e) -> {
            model.search();
        });
    }
}

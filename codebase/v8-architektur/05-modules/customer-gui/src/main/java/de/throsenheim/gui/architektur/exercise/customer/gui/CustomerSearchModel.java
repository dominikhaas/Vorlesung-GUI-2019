package de.throsenheim.gui.architektur.exercise.customer.gui;

import de.throsenheim.gui.architektur.exercise.customer.business.api.CustomerDto;
import de.throsenheim.gui.architektur.exercise.customer.business.api.CustomerService;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Set;

public class CustomerSearchModel {
    private CustomerService customerService;

    private StringProperty searchText = new SimpleStringProperty();
    private ObjectProperty<ObservableList<CustomerDto>> searchResults = new SimpleObjectProperty<>();

    public CustomerSearchModel(CustomerService customerService) {
        this.customerService = customerService;
    }



    public void search() {
        Set<CustomerDto> result = customerService.searchForCustomers(getSearchText());
        this.searchResults.setValue(FXCollections.observableArrayList(result));
    }

    public String getSearchText() {
        return searchText.get();
    }

    public StringProperty searchTextProperty() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText.set(searchText);
    }

    public ObservableList<CustomerDto> getSearchResults() {
        return searchResults.get();
    }

    public ObjectProperty<ObservableList<CustomerDto>> searchResultsProperty() {
        return searchResults;
    }

    public void setSearchResults(ObservableList<CustomerDto> searchResults) {
        this.searchResults.set(searchResults);
    }
}

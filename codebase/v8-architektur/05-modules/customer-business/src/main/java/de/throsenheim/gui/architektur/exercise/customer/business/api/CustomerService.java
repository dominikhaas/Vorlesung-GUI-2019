package de.throsenheim.gui.architektur.exercise.customer.business.api;

import java.util.Set;

public interface CustomerService {
    Set<CustomerDto> searchForCustomers(String expression);
}

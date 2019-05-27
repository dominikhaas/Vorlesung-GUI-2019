package de.throsenheim.gui.architektur.exercise.customer.business.impl;


import de.throsenheim.gui.architectur.dataaccess.CustomerDao;
import de.throsenheim.gui.architektur.exercise.customer.business.api.CustomerDto;
import de.throsenheim.gui.architektur.exercise.customer.business.api.CustomerService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Set<CustomerDto> searchForCustomers(String expression) {
        new CustomerDao();
        return new HashSet<>();
    }
}

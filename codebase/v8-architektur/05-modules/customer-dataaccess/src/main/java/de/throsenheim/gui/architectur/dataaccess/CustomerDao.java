package de.throsenheim.gui.architectur.dataaccess;

import java.util.Arrays;
import java.util.List;

public class CustomerDao {

    public List<CustomerEt> findCustomers(String searchString) {
        return Arrays.asList(new CustomerEt("Tom", "Müller"));
    }
}

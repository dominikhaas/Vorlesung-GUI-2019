package layers.gui;

import layers.business.AddressDto;
import layers.business.CustomerDto;


public class CustomerEditDialog {
    private CustomerDto customer;
    private AddressDto address;

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
        this.address = customer.getAddress();
    }
}

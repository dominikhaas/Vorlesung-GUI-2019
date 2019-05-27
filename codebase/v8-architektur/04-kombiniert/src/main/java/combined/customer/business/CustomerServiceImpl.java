package combined.customer.business;


import combined.email.business.Email;
import combined.email.business.EmailService;
import combined.email.business.EmailServiceFactory;


public class CustomerServiceImpl implements CustomerService {


    private EmailService emailService = EmailServiceFactory.getEmailSerice();

    @Override
    public void registerNewCustomer(CustomerDto newCustomer) {
        emailService.sendEmail(new Email("to@test.com", "test"));
        //do stuff
    }
}

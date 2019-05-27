package combined.email.business;

import combined.email.business.impl.EmailServiceDummyImpl;

public class EmailServiceFactory {

    public static EmailService getEmailSerice() {
        return new EmailServiceDummyImpl();
    }
}

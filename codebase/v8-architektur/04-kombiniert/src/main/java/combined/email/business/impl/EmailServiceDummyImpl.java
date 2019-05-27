package combined.email.business.impl;

import combined.email.business.Email;
import combined.email.business.EmailService;

public class EmailServiceDummyImpl implements EmailService {
    @Override
    public void sendEmail(Email email) {
        System.out.println("Sending mail: " + email);
    }
}

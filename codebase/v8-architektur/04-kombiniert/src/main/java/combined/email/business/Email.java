package combined.email.business;

public class Email {
    private String to;
    private String subject;

    public Email(String to, String subject) {
        this.to = to;
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }
}

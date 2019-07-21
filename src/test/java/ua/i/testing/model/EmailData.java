package ua.i.testing.model;

public class EmailData {
    private final String emailAddress;
    private final String subject;
    private final String emailText;

    public EmailData(String emailAddress, String subject, String emailText) {
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.emailText = emailText;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailText() {
        return emailText;
    }
}

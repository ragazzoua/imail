package ua.i.testing.model;

import java.util.Objects;

public class EmailData {
    private final String id;
    private final String emailAddress;
    private final String subject;
    private final String emailText;

    public EmailData(String emailAddress, String subject, String emailText) {
        this.id = null;
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.emailText = emailText;
    }

    public EmailData(String id, String emailAddress, String subject, String emailText) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.emailText = emailText;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "EmailData{" +
                "id='" + id + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailData emailData = (EmailData) o;
        return Objects.equals(id, emailData.id) &&
                Objects.equals(emailAddress, emailData.emailAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, emailAddress);
    }
}

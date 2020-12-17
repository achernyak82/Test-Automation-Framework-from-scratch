package com.epam.cdp.testautomationframework.businessobjects;

public class TestLetter {

    private final String email;
    private final String subject;
    private final String data;

    public TestLetter(String email, String subject, String data) {
        this.email = email;
        this.subject = subject;
        this.data = data;
    }

    public String getSubject() {
        return subject;
    }

    public String getData() {
        return data;
    }

    public String getEmailAddress() {
        return email;
    }

}

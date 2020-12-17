package com.epam.cdp.designpatterns.businessobjects;

public class TestLetter {

    private String email;
    private String subject;
    private String data;

    private static Builder builder;

    private TestLetter() {

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

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String subject;
        private String data;

        private Builder() {

        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setData(String data) {
            this.data = data;
            return this;
        }

        public TestLetter build() {
            TestLetter letter = new TestLetter();
            letter.email = this.email;
            letter.subject = this.subject;
            letter.data = this.data;
            return letter;
        }

    }

}

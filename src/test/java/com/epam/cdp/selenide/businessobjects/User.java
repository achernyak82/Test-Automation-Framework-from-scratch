package com.epam.cdp.selenide.businessobjects;

public class User {

    private final String Login;
    private final String Password;

    public User(String login, String password) {
        this.Login = login;
        this.Password = password;
    }

    public String getLogin() {
      return Login;
    }

    public String getPassword() {
        return Password;
    }
}

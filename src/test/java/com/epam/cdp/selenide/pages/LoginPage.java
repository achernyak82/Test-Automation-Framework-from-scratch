package com.epam.cdp.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "mailbox:login")
    private SelenideElement inputLogin;

    @FindBy(xpath = "//label[text()='Ввести пароль']")
    private SelenideElement inputPassword;

    @FindBy(id = "mailbox:password")
    private SelenideElement textPassword;

    @FindBy(xpath = "//input[@class='o-control']")
    private SelenideElement enterInTheMail;

    public LoginPage() {
        super();
    }

    public void typeEmail(String email) {
        inputLogin.shouldBe(Condition.visible).sendKeys(email);
        inputPassword.click();
    }

    public void typePassword(String password) {
        textPassword.shouldBe(Condition.visible).sendKeys(password);
    }

    public void clickToEnter() {
        enterInTheMail.click();
    }
}

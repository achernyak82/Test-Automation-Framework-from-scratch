package com.epam.cdp.designpatterns.pages;

import com.epam.cdp.designpatterns.decorator.CustomDriverDecorator;
import com.epam.cdp.designpatterns.logging.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "http:/mail.ru";

    @FindBy(id = "mailbox:login")
    private WebElement inputLogin;

    @FindBy(xpath = "//label[text()='Ввести пароль']")
    private WebElement inputPassword;

    @FindBy(id = "mailbox:password")
    private WebElement textPassword;

    @FindBy(xpath = "//input[@class='o-control']")
    private WebElement enterInTheMail;

    public LoginPage(CustomDriverDecorator driver) {
        super(driver);
    }


    public void openPage() {
        MyLogger.info("Going to URL: " + HOMEPAGE_URL);
        driver.get(HOMEPAGE_URL);
        waitElementIsVisible(inputLogin, this);
    }

    public void typeEmail(String email) {
        driver.highlightElement(inputLogin);
        driver.unHighLightElement(inputLogin);
        inputLogin.sendKeys(email);
        MyLogger.info("Typing login " + inputLogin.getText() + " (Additional information: " + inputLogin + ")");
        driver.highlightElement(inputPassword);
        driver.unHighLightElement(inputPassword);
        inputPassword.click();
        MyLogger.info("Clicking element '" + inputPassword.getText() + "' (Additional information: " + inputPassword + ")");
    }

    public void typePassword(String password) {
        waitElementIsVisible(textPassword, this);
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(textPassword).build().perform();
        MyLogger.info("Clicking element " + textPassword.getText() + "(Additional information: " + textPassword + ")");
        textPassword.click();
        driver.highlightElement(textPassword);
        textPassword.sendKeys(password);
        MyLogger.info("Typing password " + textPassword.getText() + " (Additional information: " + textPassword + ")");
        driver.unHighLightElement(textPassword);
    }

    public void clickToEnter() {
        driver.highlightElement(enterInTheMail);
        driver.unHighLightElement(enterInTheMail);
        enterInTheMail.click();
        MyLogger.info("Entering in email" + enterInTheMail.getText() + "(Additional information: " + enterInTheMail + ")");
    }

    public void cleanTheField() {
        MyLogger.info("Clearing the input field" + inputLogin.getText() + "(Additional information: " + inputLogin + ")");
        inputLogin.click();
        inputLogin.clear();
    }
}

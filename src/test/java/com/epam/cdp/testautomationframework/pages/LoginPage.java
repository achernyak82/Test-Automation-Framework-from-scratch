package com.epam.cdp.testautomationframework.pages;

import org.openqa.selenium.WebDriver;
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void openPage() {
        driver.get(HOMEPAGE_URL);
        waitElementIsVisible(inputLogin);
    }

    public void typeEmail(String email) {
        inputLogin.sendKeys(email);
        inputPassword.click();
    }

    public void typePassword(String password) {
        waitElementIsVisible(textPassword);
        Actions actions = new Actions(driver);
        actions.moveToElement(textPassword).build().perform();
        textPassword.click();
        textPassword.sendKeys(password);
    }

    public void clickToEnter() {
        enterInTheMail.click();
    }
}

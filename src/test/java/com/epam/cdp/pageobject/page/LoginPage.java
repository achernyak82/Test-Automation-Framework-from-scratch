package com.epam.cdp.pageobject.page;

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

    @FindBy(id = "mailbox:submit")
    private WebElement enterInTheMail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitElementIsVisible(inputLogin);
        return this;
    }

    public LoginPage typeEmail(String email) {
        inputLogin.sendKeys(email);
        inputPassword.click();
        return this;
    }

    public LoginPage typePassword(String password) {
        waitElementIsVisible(textPassword);
        Actions actions = new Actions(driver);
        actions.moveToElement(textPassword).build().perform();
        textPassword.click();
        textPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickToEnter() {
        safeJavaScriptClick(enterInTheMail);
        return this;
    }

    public MailFolderPage enterInMail(String email, String password) {
       openPage().typeEmail(email).typePassword(password).clickToEnter();
       return new MailFolderPage(driver);
    }
}

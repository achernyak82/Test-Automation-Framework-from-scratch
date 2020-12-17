package com.epam.cdp.testautomationframework.steps;

import org.openqa.selenium.WebDriver;
import com.epam.cdp.testautomationframework.pages.*;
import com.epam.cdp.testautomationframework.testmanagers.DriverManager;

public abstract class AbstractBaseStep {

    protected FilterSettingsPage filterSettingsPage;
    protected LoginPage loginPage;
    protected MailFolderPage mailFolderPage;
    protected NewFolderPage newFolderPage;
    protected WriteEmailPage writeEmailPage;

    public AbstractBaseStep() {
        WebDriver driver = DriverManager.getDriver();
        filterSettingsPage = new FilterSettingsPage(driver);
        loginPage = new LoginPage(driver);
        mailFolderPage = new MailFolderPage(driver);
        newFolderPage = new NewFolderPage(driver);
        writeEmailPage = new WriteEmailPage(driver);
    }
}

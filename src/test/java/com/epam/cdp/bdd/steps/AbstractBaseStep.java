package com.epam.cdp.bdd.steps;

import com.epam.cdp.bdd.decorator.CustomDriverDecorator;
import com.epam.cdp.bdd.pages.*;
import com.epam.cdp.bdd.testmanagers.DriverManager;

public abstract class AbstractBaseStep {

    protected FilterSettingsPage filterSettingsPage;
    protected LoginPage loginPage;
    protected MailFolderPage mailFolderPage;
    protected NewFolderPage newFolderPage;
    protected WriteEmailPage writeEmailPage;

    public AbstractBaseStep() {
        CustomDriverDecorator driver = DriverManager.getInstance().getDriver();
        filterSettingsPage = new FilterSettingsPage(driver);
        loginPage = new LoginPage(driver);
        mailFolderPage = new MailFolderPage(driver);
        newFolderPage = new NewFolderPage(driver);
        writeEmailPage = new WriteEmailPage(driver);
    }
}

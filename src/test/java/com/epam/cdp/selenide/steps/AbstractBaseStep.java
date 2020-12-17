package com.epam.cdp.selenide.steps;

import com.epam.cdp.selenide.pages.*;

public abstract class AbstractBaseStep {

    protected FilterSettingsPage filterSettingsPage;
    protected LoginPage loginPage;
    protected MailFolderPage mailFolderPage;
    protected NewFolderPage newFolderPage;
    protected WriteEmailPage writeEmailPage;

    public AbstractBaseStep() {
        filterSettingsPage = new FilterSettingsPage();
        loginPage = new LoginPage();
        mailFolderPage = new MailFolderPage();
        newFolderPage = new NewFolderPage();
        writeEmailPage = new WriteEmailPage();
    }
}

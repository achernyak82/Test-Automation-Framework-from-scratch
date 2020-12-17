package com.epam.cdp.designpatterns.steps;

import com.epam.cdp.designpatterns.pages.LoginPage;

public class ActionSteps extends AbstractBaseStep {

    private static ActionSteps actionSteps;

    private ActionSteps() {
        super();
    }

    public static ActionSteps getActionSteps() {
        if (actionSteps == null) {
            setActionSteps();
        }
        return actionSteps;
    }

    private static void setActionSteps() {
        actionSteps = new ActionSteps();
    }

    public void logoutFromEmail() {
        mailFolderPage.logoutFromEmail();
        loginPage.cleanTheField();
    }

    public void enterInMail(String login, String password) {
        loginPage.openPage();
        loginPage.cleanTheField();
        loginPage.typeEmail(login);
        loginPage.typePassword(password);
        loginPage.clickToEnter();
    }

    public void writeNewEmail(String address, String subject, String content) {
        mailFolderPage.startNewLetter();
        writeEmailPage.addSentAddress(address);
        writeEmailPage.addSubject(subject);
        writeEmailPage.addContentOfTheLetter(content);
    }

    public void saveInDraft() {
        writeEmailPage.saveInDraft();
        writeEmailPage.closeWritingPage();
        mailFolderPage.enterInDrafts();
    }

    public void sendFromDraft() {
        mailFolderPage.clickOnTheDraftEmail();
        writeEmailPage.sendFromDrafts();
    }

    public void enterInSendingEmails() {
        mailFolderPage.enterInSendingEmails();
    }

    public void delFromDraft() {
        mailFolderPage.checkTestEmail();
        mailFolderPage.delFromDrafts();
    }

    public void delFromBasket() {
        mailFolderPage.enterInBasket();
        mailFolderPage.cleanTheBasket();
        mailFolderPage.delFromBasket();
    }

    public void addNewFolder() {
        mailFolderPage.addNewFolder();
        newFolderPage.typeNewFolderName();
        newFolderPage.addFolder();
    }

    public void addNewFilterWithTestSettings(String text) {
        mailFolderPage.testFolderClick();
        mailFolderPage.addNewFilter();
        filterSettingsPage.dropDownClick();
        filterSettingsPage.selectFromDropDown();
        filterSettingsPage.addContaintForEmailSubject(text);
        filterSettingsPage.saveFilter();
    }

    public void sendTestEmailFromTestFolder() {
        writeEmailPage.sendSimply();
        mailFolderPage.testFolderClick();
    }

    public void delTestFolder() {
        mailFolderPage.rightClickOnTheTestFolder();
        mailFolderPage.selectDeleteOption();
        mailFolderPage.confirmDeletingTestFolder();
    }
}

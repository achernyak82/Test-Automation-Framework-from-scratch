package com.epam.cdp.testautomationframework.steps;

public class ActionSteps extends AbstractBaseStep {

    public ActionSteps() {
        super();
    }

    public void enterInMail(String login, String password) {
        loginPage.openPage();
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

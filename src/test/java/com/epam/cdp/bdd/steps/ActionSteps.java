package com.epam.cdp.bdd.steps;

import com.epam.cdp.bdd.businessobjects.TestLetter;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class ActionSteps extends AbstractBaseStep {

    public ActionSteps() {
        super();
    }

    @DataTableType
    public TestLetter mapToTestLetter(Map<String, String> testLetter) {
        return new TestLetter(
                testLetter.get("address"),
                testLetter.get("subject"),
                testLetter.get("body"));
    }

    @Given("I enter in email with login {string} and password {string}")
    public void enterInMail(String login, String password) {
        loginPage.openPage();
        loginPage.typeEmail(login);
        loginPage.typePassword(password);
        loginPage.clickToEnter();
    }

    @When("^I write a letter with parameters:$")
    public void writeNewEmail(TestLetter letter) {
        mailFolderPage.startNewLetter();
        writeEmailPage.addSentAddress(letter.getEmailAddress());
        writeEmailPage.addSubject(letter.getSubject());
        writeEmailPage.addContentOfTheLetter(letter.getData());
    }

    @When("^I save the letter in the draft folder$")
    public void saveInDraft() {
        writeEmailPage.saveInDraft();
        writeEmailPage.closeWritingPage();
        mailFolderPage.enterInDrafts();
    }

    @When("^I send the letter from the draft folder$")
    public void sendFromDraft() {
        mailFolderPage.clickOnTheDraftEmail();
        writeEmailPage.sendFromDrafts();
    }

    public void enterInSendingEmails() {
        mailFolderPage.enterInSendingEmails();
    }

    @When("^I delete the letter from the draft folder$")
    public void delFromDraft() {
        mailFolderPage.checkTestEmail();
        mailFolderPage.delFromDrafts();
    }

    @When("^I delete the letter from the basket$")
    public void delFromBasket() {
        mailFolderPage.enterInBasket();
        mailFolderPage.cleanTheBasket();
        mailFolderPage.delFromBasket();
    }

    @When("I add new folder {string}")
    public void addNewFolder(String folderName) {
        mailFolderPage.addNewFolder();
        newFolderPage.typeNewFolderName(folderName);
        newFolderPage.addFolder();
    }

    @When("I add new filter for the test folder with text {string}")
    public void addNewFilterWithTestSettings(String text) {
        mailFolderPage.testFolderClick();
        mailFolderPage.addNewFilter();
        filterSettingsPage.dropDownClick();
        filterSettingsPage.selectFromDropDown();
        filterSettingsPage.addContaintForEmailSubject(text);
        filterSettingsPage.saveFilter();
    }

    @When("^I send the letter from the test folder$")
    public void sendTestEmailFromTestFolder() {
        writeEmailPage.sendSimply();
        mailFolderPage.testFolderClick();
    }

    @When("^I delete test folder$")
    public void delTestFolder() {
        mailFolderPage.rightClickOnTheTestFolder();
        mailFolderPage.selectDeleteOption();
        mailFolderPage.confirmDeletingTestFolder();
    }
}

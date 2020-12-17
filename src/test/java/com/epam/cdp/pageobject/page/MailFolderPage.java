package com.epam.cdp.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MailFolderPage extends AbstractPage {

    @FindBy(xpath = "//a[@title = 'Написать письмо']")
    private WebElement writeLetter;

    @FindBy(xpath = "//a[@title = 'Написать письмо']//span[@class='compose-button__wrapper']")
    private WebElement spanToHighLight;

    @FindBy(xpath = "//div[@class='nav__folder-name__txt'][text()='Черновики']")
    private WebElement draftFolder;

    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent']//span[@class='ll-crpt']")
    private WebElement testAddressFromTestEmail;

    @FindBy(xpath = "//div[@class='llc__item llc__item_title']//span[text()='TESTEmail']")
    private WebElement testTopicFromTestEmail;

    @FindBy(xpath = "//div[@class='llc__item llc__item_title']//span[@class='ll-sp__normal']")
    private WebElement testContentFromTestEmail;

    @FindBy(className = "dataset__empty")
    private WebElement emptyDrafts;

    @FindBy(xpath = "//div[@class='nav__folder-name']/div[text()='Отправленные']")
    private WebElement sentEmailsFolder;

    @FindBy(css = "div.llc__item.llc__item_correspondent > span.ll-crpt")
    private WebElement sentTestEmail;

    @FindBy(xpath = "//div[@class='ll-av__container']//span[@class='ll-av__checkbox']")
    private WebElement testEmailChecked;

    @FindBy(xpath = "//span[@title='Удалить']")
    private WebElement delFromDrafts;

    @FindBy(xpath = "//div[@class='nav__folder-name']//div[text()='Корзина']")
    private WebElement basketFolder;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Очистить']")
    private WebElement cleanTheBasket;

    @FindBy(xpath = "//div[text() = 'В корзине пусто']")
    private WebElement basketEmpty;

    @FindBy(className = "llc__content")
    private WebElement containerOfTheLetter;

    @FindBy(xpath = "//div[@class = 'llc__container']//div[@class = 'llc__content']")
    private WebElement containerOfTheBasket;

    @FindBy(xpath = "//span[text()='Новая папка']")
    private WebElement newFolderButton;

    @FindBy(xpath = "//div[contains(text(),'test')]")
    private WebElement newTestFolder;

    @FindBy(xpath = "//a[@class='link']")
    private WebElement createFilter;

    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent llc__item_unread']//span[@class='ll-crpt']")
    private WebElement testAddressFromMyselfEmail;

    @FindBy(xpath = "//div[@data-qa-id = 'delete']//span[text()='Удалить папку']")
    private WebElement deleteTestFolder;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Удалить']")
    private WebElement deleteTestFolderConfirmation;

    public MailFolderPage(WebDriver driver) {
        super(driver);
    }

    public String giveText() {
        waitElementIsVisible(writeLetter);
        return writeLetter.getText();
    }

    public String getAddressFromMyselfEmail() {
        waitElementIsVisible(testAddressFromMyselfEmail);
        return testAddressFromMyselfEmail.getText();
    }

    public WriteEmailPage startNewLetter() {
        waitElementIsVisible(writeLetter);
        safeJavaScriptClick(writeLetter);
        highlightElement(spanToHighLight);
        return new WriteEmailPage(driver);
    }

    public MailFolderPage enterInDrafts() {
        draftFolder.click();
        highlightElement(draftFolder);
        return this;
    }

    public String getTestAddress() {
        waitElementIsVisible(testAddressFromTestEmail);
        return testAddressFromTestEmail.getText();
    }

    public String getTestTopic() {
        return testTopicFromTestEmail.getText();
    }

    public String getTestContent() {
        return testContentFromTestEmail.getText();
    }

    public WriteEmailPage clickOnTheDraftEmail() {
        safeJavaScriptClick(testAddressFromTestEmail);
        highlightElement(testAddressFromTestEmail);
        return new WriteEmailPage(driver);
    }

    public boolean getEmptyFromDrafts(){
        waitElementIsVisible(emptyDrafts);
        return emptyDrafts.isDisplayed();
    }

    public MailFolderPage enterInSendingEmails() {
        safeJavaScriptClick(sentEmailsFolder);
        highlightElement(sentEmailsFolder);
        return this;
    }

    public String getTextFromSentEmail(){
        waitElementIsVisible(sentTestEmail);
        return sentTestEmail.getText();
    }

    public MailFolderPage checkTestEmail(){
        waitElementIsVisible(containerOfTheLetter);
        Actions actions = new Actions(driver);
        actions.moveToElement(containerOfTheLetter).perform();
        waitElementIsVisible(testEmailChecked);
        testEmailChecked.click();
        highlightElement(testEmailChecked);
        return this;
    }

    public MailFolderPage delFromDrafts() {
        safeJavaScriptClick(delFromDrafts);
        return this;
    }

    public MailFolderPage enterInBasket() {
        safeJavaScriptClick(basketFolder);
        highlightElement(basketFolder);
        return this;
    }

    public MailFolderPage cleanTheBasket() {
        waitElementIsVisible(containerOfTheBasket);
        Actions actions = new Actions(driver);
        actions.moveToElement(containerOfTheBasket).perform();
        testEmailChecked.click();
        highlightElement(testEmailChecked);
        return this;
    }

    public MailFolderPage delFromBasket() {
        safeJavaScriptClick(delFromDrafts);
        return this;
    }

    public String getTextFromEmptyBasket() {
        waitElementIsVisible(basketEmpty);
        return basketEmpty.getText();
    }

    public NewFolderPage addNewFolder() {
        waitElementIsVisible(newFolderButton);
        newFolderButton.click();
        highlightElement(newFolderButton);
        return new NewFolderPage(driver);
    }

    public MailFolderPage testFolderClick() {
        waitElementIsVisible(newTestFolder);
        newTestFolder.click();
        highlightElement(newTestFolder);
        return this;
    }

    public FilterSettingsPage addNewFilter() {
        waitElementIsVisible(createFilter);
        createFilter.click();
        return new FilterSettingsPage(driver);
    }

    public MailFolderPage rightClickOnTheTestFolder() {
        new Actions(driver)
                .moveToElement(newTestFolder)
                .contextClick(newTestFolder)
                .build()
                .perform();
        return this;
    }

    public MailFolderPage selectDeleteOption() {
        deleteTestFolder.click();
        highlightElement(deleteTestFolder);
        return this;
    }

    public MailFolderPage confirmDeletingTestFolder() {
        waitElementIsVisible(deleteTestFolderConfirmation);
        deleteTestFolderConfirmation.click();
        return this;
    }

    public MailFolderPage similarStepsInBasket() {
        enterInBasket().cleanTheBasket().delFromBasket();
        return this;
    }
}

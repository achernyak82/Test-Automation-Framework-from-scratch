package com.epam.cdp.testautomationframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.epam.cdp.testautomationframework.tools.JavaScriptTool;

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

    public String getAddressFromMyselfEmail() {
        waitElementIsVisible(testAddressFromMyselfEmail);
        return testAddressFromMyselfEmail.getText();
    }

    public void startNewLetter() {
        waitElementIsVisible(writeLetter);
        writeLetter.click();
    }

    public void enterInDrafts() {
        draftFolder.click();
        JavaScriptTool.highlightElement(draftFolder);
    }

    public String getTestAddress() {
        waitElementIsVisible(testAddressFromTestEmail);
        return testAddressFromTestEmail.getText();
    }

    public void clickOnTheDraftEmail() {
        JavaScriptTool.safeJavaScriptClick(testAddressFromTestEmail);
        JavaScriptTool.highlightElement(testAddressFromTestEmail);
    }

    public boolean getEmptyFromDrafts() {
        waitElementIsVisible(emptyDrafts);
        return emptyDrafts.isDisplayed();
    }

    public void enterInSendingEmails() {
        JavaScriptTool.safeJavaScriptClick(sentEmailsFolder);
        JavaScriptTool.highlightElement(sentEmailsFolder);
    }

    public String getTextFromSentEmail() {
        waitElementIsVisible(sentTestEmail);
        return sentTestEmail.getText();
    }

    public void checkTestEmail() {
        waitElementIsVisible(containerOfTheLetter);
        Actions actions = new Actions(driver);
        actions.moveToElement(containerOfTheLetter).perform();
        waitElementIsVisible(testEmailChecked);
        testEmailChecked.click();
        JavaScriptTool.highlightElement(testEmailChecked);
    }

    public void delFromDrafts() {
        JavaScriptTool.safeJavaScriptClick(delFromDrafts);
    }

    public void enterInBasket() {
        JavaScriptTool.safeJavaScriptClick(basketFolder);
        JavaScriptTool.highlightElement(basketFolder);
    }

    public void cleanTheBasket() {
        waitElementIsVisible(containerOfTheBasket);
        Actions actions = new Actions(driver);
        actions.moveToElement(containerOfTheBasket).perform();
        testEmailChecked.click();
        JavaScriptTool.highlightElement(testEmailChecked);
    }

    public void delFromBasket() {
        JavaScriptTool.safeJavaScriptClick(delFromDrafts);
    }

    public String getTextFromEmptyBasket() {
        waitElementIsVisible(basketEmpty);
        return basketEmpty.getText();
    }

    public void addNewFolder() {
        waitElementIsVisible(newFolderButton);
        newFolderButton.click();
        JavaScriptTool.highlightElement(newFolderButton);
    }

    public void testFolderClick() {
        waitElementIsVisible(newTestFolder);
        newTestFolder.click();
        JavaScriptTool.highlightElement(newTestFolder);
    }

    public void addNewFilter() {
        waitElementIsVisible(createFilter);
        createFilter.click();
    }

    public void rightClickOnTheTestFolder() {
        new Actions(driver)
                .moveToElement(newTestFolder)
                .contextClick(newTestFolder)
                .build()
                .perform();
    }

    public void selectDeleteOption() {
        deleteTestFolder.click();
        JavaScriptTool.highlightElement(deleteTestFolder);
    }

    public void confirmDeletingTestFolder() {
        waitElementIsVisible(deleteTestFolderConfirmation);
        deleteTestFolderConfirmation.click();
    }
}

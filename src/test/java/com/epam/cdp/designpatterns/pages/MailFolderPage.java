package com.epam.cdp.designpatterns.pages;

import com.epam.cdp.designpatterns.decorator.CustomDriverDecorator;
import com.epam.cdp.designpatterns.logging.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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

    @FindBy(css = "div.llc__item.llc__item_corespondent > span.ll-crpt")
    private WebElement sentTestEmail;

    @FindBy(xpath = "//div[@class='ll-av__container']//span[@class='ll-av__checkbox']")
    private WebElement testEmailChecked;

    @FindBy(xpath = "//span[@title='Удалить']")
    private WebElement delFromDrafts;

    @FindBy(xpath = "//div[@class='nav__folder-name']//div[text()='Корзина']")
    private WebElement basketFolder;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Очистить']")
    private WebElement cleanTheBasket;

    @FindBy(xpath = "//div[text() = 'В корзина пусто']")
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

    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent llc__item_read']//span[@class='ll-crpt']")
    private WebElement testAddressFromMyselfEmail;

    @FindBy(xpath = "//div[@data-qa-id = 'delete']//span[text()='Удалить папку']")
    private WebElement deleteTestFolder;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Удалить']")
    private WebElement deleteTestFolderConfirmation;

    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    private WebElement logout;

    @FindBy(xpath = "//a[@id='PH_authLink']")
    private WebElement login;

    public MailFolderPage(CustomDriverDecorator driver) {
        super(driver);
    }

    public void logoutFromEmail() {
        MyLogger.info("Logout from email '" + logout.getText() + "' (Additional information: " + logout + ")");
        logout.click();
        waitElementIsVisible(login,this);
        MyLogger.info("Logout has been successful '" + login.getText() + "' (Additional information: " + login + ")");
    }

    public String getAddressFromMyselfEmail() {
        try {
            waitElementIsVisible(testAddressFromMyselfEmail, this);
            return testAddressFromMyselfEmail.getText();
        } catch (NoSuchElementException e) {
            MyLogger.error("Can't find the WebElement." + e.getMessage());
        } catch (TimeoutException e) {
            MyLogger.error("Can't wait till the  WebElement's appearance." + e.getMessage());
            rightClickOnTheTestFolder();
            selectDeleteOption();
            confirmDeletingTestFolder();
        }
        return testAddressFromMyselfEmail.getText();
    }

    public void startNewLetter() {
        waitElementIsVisible(writeLetter, this);
        driver.highlightElement(writeLetter);
        driver.unHighLightElement(writeLetter);
        writeLetter.click();
    }

    public void enterInDrafts() {
        driver.highlightElement(draftFolder);
        draftFolder.click();
        driver.unHighLightElement(draftFolder);
        MyLogger.info("Entering in draft folder '" + draftFolder.getText() + "' (Additional information: " + draftFolder + ")");
    }

    public String getTestAddress() {
        waitElementIsVisible(testAddressFromTestEmail, this);
        return testAddressFromTestEmail.getText();
    }

    public void clickOnTheDraftEmail() {
        driver.highlightElement(testAddressFromTestEmail);
        testAddressFromTestEmail.click();
        driver.unHighLightElement(testAddressFromTestEmail);
    }

    public boolean getEmptyFromDrafts() {
        waitElementIsVisible(emptyDrafts, this);
        return emptyDrafts.isDisplayed();
    }

    public void enterInSendingEmails() {
        driver.highlightElement(sentEmailsFolder);
        sentEmailsFolder.click();
        driver.unHighLightElement(sentEmailsFolder);
    }

    public String getTextFromSentEmail() {
        try {
            waitElementIsVisible(sentTestEmail, this);
            return sentTestEmail.getText();
        } catch (NoSuchElementException e) {
            MyLogger.error("Can't find the WebElement." + e.getMessage());
        } catch (TimeoutException e) {
            MyLogger.error("Can't wait till the  WebElement's appearance." + e.getMessage());
        }
        return sentTestEmail.getText();
    }

    public void checkTestEmail() {
        waitElementIsVisible(containerOfTheLetter, this);
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(containerOfTheLetter).perform();
        waitElementIsVisible(testEmailChecked, this);
        driver.highlightElement(testEmailChecked);
        testEmailChecked.click();
        MyLogger.info("Choosing test email" + testEmailChecked.getText() + "(Additional information: " + delFromDrafts + ")");
        driver.unHighLightElement(testEmailChecked);
    }

    public void delFromDrafts() {
        waitElementIsVisible(delFromDrafts, this);
        MyLogger.info("Deleting test email from drafts '" + delFromDrafts.getText() + "' (Additional information: " + delFromDrafts + ")");
        driver.highlightElement(delFromDrafts);
        driver.unHighLightElement(delFromDrafts);
        delFromDrafts.click();
    }

    public void enterInBasket() {
        driver.highlightElement(basketFolder);
        basketFolder.click();
        driver.unHighLightElement(basketFolder);
        MyLogger.info("Entering in basket '" + basketFolder.getText() + "' (Additional information: " + basketFolder + ")");
    }

    public void cleanTheBasket() {
        waitElementIsVisible(containerOfTheBasket, this);
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(containerOfTheBasket).perform();
        driver.highlightElement(testEmailChecked);
        testEmailChecked.click();
        MyLogger.info("Choosing test email in drafts " + testEmailChecked.getText() + "(Additional information: " + testEmailChecked + ")");
        driver.unHighLightElement(testEmailChecked);
    }

    public void delFromBasket() {
        waitElementIsVisible(delFromDrafts, this);
        MyLogger.info("Deleting test email from basket '" + delFromDrafts.getText() + "' (Additional information: " + delFromDrafts + ")");
        driver.highlightElement(delFromDrafts);
        driver.unHighLightElement(delFromDrafts);
        delFromDrafts.click();

    }

    public String getTextFromEmptyBasket() {
        try {
            waitElementIsVisible(basketEmpty, this);
            return basketEmpty.getText();
        } catch (NoSuchElementException e) {
            MyLogger.error("Can't find the WebElement." + e.getMessage());
        } catch (TimeoutException e) {
            MyLogger.error("Can't wait till the WebElement's appearance." + e.getMessage());
        }
        return basketEmpty.getText();
    }

    public void addNewFolder() {
        waitElementIsVisible(newFolderButton, this);
        driver.highlightElement(newFolderButton);
        newFolderButton.click();
        driver.unHighLightElement(newFolderButton);
    }

    public void testFolderClick() {
        waitElementIsVisible(newTestFolder, this);
        driver.highlightElement(newTestFolder);
        newTestFolder.click();
        driver.unHighLightElement(newTestFolder);
    }

    public void addNewFilter() {
        waitElementIsVisible(createFilter, this);
        driver.highlightElement(createFilter);
        createFilter.click();
        driver.unHighLightElement(createFilter);
    }

    public void rightClickOnTheTestFolder() {
        new Actions(driver.getDriver())
                .moveToElement(newTestFolder)
                .contextClick(newTestFolder)
                .build()
                .perform();
    }

    public void selectDeleteOption() {
        waitElementIsVisible(deleteTestFolder, this);
        driver.highlightElement(deleteTestFolder);
        driver.unHighLightElement(deleteTestFolder);
        MyLogger.info("Selecting delete option '" + deleteTestFolder.getText() + "' (Additional information: " + deleteTestFolder + ")");
        deleteTestFolder.click();
    }

    public void confirmDeletingTestFolder() {
        waitElementIsVisible(deleteTestFolderConfirmation, this);
        driver.highlightElement(deleteTestFolderConfirmation);
        driver.unHighLightElement(deleteTestFolderConfirmation);
        MyLogger.info("Deleting confirmation '" + deleteTestFolderConfirmation.getText() + "' (Additional information: " + deleteTestFolderConfirmation + ")");
        deleteTestFolderConfirmation.click();
    }
}

package com.epam.cdp.designpatterns.pages;

import com.epam.cdp.designpatterns.decorator.CustomDriverDecorator;
import com.epam.cdp.designpatterns.logging.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WriteEmailPage extends AbstractPage {

    @FindBy(css = "div.inputContainer--nsqFu > input")
    private WebElement sentAddress;

    @FindBy(name = "Subject")
    private WebElement sentSubject;

    @FindBy(xpath = "//div[@tabindex='505']/div[1]")
    private WebElement sentContent;

    @FindBy(xpath = "//span[text()='Сохранить']")
    private WebElement saveInDraft;

    @FindBy(xpath = "//button[@title='Закрыть']")
    private WebElement closeWritePage;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Отправить']")
    private WebElement sendEmailFromDrafts;

    @FindBy(xpath = "//div[@class='layer__controls']/span[@title='Закрыть']")
    private WebElement closeAfterSend;

    public WriteEmailPage(CustomDriverDecorator driver) {
        super(driver);
    }

    public void addSentAddress(String whom) {
        waitElementIsVisible(sentAddress, this);
        driver.highlightElement(sentAddress);
        sentAddress.sendKeys(whom);
        MyLogger.info("Typing the address " + sentAddress.getText() + "(Additional information: " + sentAddress + ")");
        driver.unHighLightElement(sentAddress);
    }

    public void addSubject(String topic) {
        driver.highlightElement(sentSubject);
        sentSubject.sendKeys(topic);
        MyLogger.info("Typing the subject " + sentSubject.getText() + "(Additional information: " + sentSubject + ")");
        driver.unHighLightElement(sentSubject);
    }

    public void addContentOfTheLetter(String content) {
        new Actions(driver.getDriver())
                .moveToElement(sentContent)
                .click()
                .sendKeys(content)
                .build()
                .perform();
        MyLogger.info("Typing body of email " + sentContent.getText() + "(Additional information: " + sentContent + ")");
    }

    public void saveInDraft() {
        driver.highlightElement(saveInDraft);
        driver.unHighLightElement(saveInDraft);
        saveInDraft.click();
        MyLogger.info("Clicking element '" + saveInDraft.getText() + "' (Additional information: " + saveInDraft + ")");
    }

    public void closeWritingPage() {
        waitElementIsVisible(closeWritePage, this);
        driver.highlightElement(closeWritePage);
        driver.unHighLightElement(closeWritePage);
        MyLogger.info("Finishing writing " + closeWritePage.getText() + " (Additional information: " + closeWritePage + ")");
        closeWritePage.click();
    }

    public void sendFromDrafts() {
        waitElementIsVisible(sendEmailFromDrafts, this);
        driver.highlightElement(sendEmailFromDrafts);
        driver.unHighLightElement(sendEmailFromDrafts);
        MyLogger.info("Sending email from drafts '" + sendEmailFromDrafts.getText() + "' (Additional information: " + sendEmailFromDrafts + ")");
        sendEmailFromDrafts.click();
        waitElementIsVisible(closeAfterSend, this);
        driver.highlightElement(closeAfterSend);
        driver.unHighLightElement(closeAfterSend);
        MyLogger.info("Closing after sending " + closeAfterSend.getText() + "(Additional information: " + closeAfterSend + ")");
        closeAfterSend.click();
    }

    public void sendSimply() {
        driver.highlightElement(sendEmailFromDrafts);
        MyLogger.info("Sending email '" + sendEmailFromDrafts.getText() + "' (Additional information: " + sendEmailFromDrafts + ")");
        driver.unHighLightElement(sendEmailFromDrafts);
        sendEmailFromDrafts.click();
        waitElementIsVisible(closeAfterSend, this);
        driver.highlightElement(closeAfterSend);
        MyLogger.info("Closing after send " + closeAfterSend.getText() + "(Additional information: " + closeAfterSend + ")");
        driver.unHighLightElement(closeAfterSend);
        closeAfterSend.click();
    }
}

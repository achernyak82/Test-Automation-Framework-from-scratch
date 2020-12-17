package com.epam.cdp.bdd.pages;

import com.epam.cdp.bdd.decorator.CustomDriverDecorator;
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

    public void addSentAddress(String whom){
       waitElementIsVisible(sentAddress);
       sentAddress.sendKeys(whom);
    }

    public void addSubject(String topic) {
       sentSubject.sendKeys(topic);
    }

    public void addContentOfTheLetter(String content) {
        new Actions(driver.getDriver())
                .moveToElement(sentContent)
                .click()
                .sendKeys(content)
                .build()
                .perform();
    }

    public void saveInDraft() {
       saveInDraft.click();
    }

    public void closeWritingPage() {
        closeWritePage.click();
    }

    public void sendFromDrafts() {
        waitElementIsVisible(sendEmailFromDrafts);
        sendEmailFromDrafts.click();
        waitElementIsVisible(closeAfterSend);
        closeAfterSend.click();
    }

    public void sendSimply() {
        sendEmailFromDrafts.click();
        waitElementIsVisible(closeAfterSend);
        closeAfterSend.click();
    }
}

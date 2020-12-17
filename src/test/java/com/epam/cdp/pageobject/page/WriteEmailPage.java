package com.epam.cdp.pageobject.page;

import org.openqa.selenium.WebDriver;
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

    protected WriteEmailPage(WebDriver driver) {
        super(driver);
    }

    public WriteEmailPage addSentAddress(String whom){
       waitElementIsVisible(sentAddress);
       sentAddress.sendKeys(whom);
       highlightElement(sentAddress);
       return this;
    }

    public WriteEmailPage addSubject(String topic) {
       sentSubject.sendKeys(topic);
       highlightElement(sentSubject);
       return this;
    }

    public WriteEmailPage addContentOfTheLetter(String content) {
        new Actions(driver)
                .moveToElement(sentContent)
                .click()
                .sendKeys(content)
                .build()
                .perform();
        highlightElement(sentContent);
        return this;
    }

    public WriteEmailPage saveInDraft() {
       safeJavaScriptClick(saveInDraft);
       highlightElement(saveInDraft);
       return  this;
    }

    public MailFolderPage closeWritingPage() {
       safeJavaScriptClick(closeWritePage);
       return new MailFolderPage(driver);
    }

    public MailFolderPage sendFromDrafts() {
        waitElementIsVisible(sendEmailFromDrafts);
        sendEmailFromDrafts.click();
        waitElementIsVisible(closeAfterSend);
        closeAfterSend.click();
        return new MailFolderPage(driver);
    }

    public MailFolderPage sendSimply() {
        safeJavaScriptClick(sendEmailFromDrafts);
        waitElementIsVisible(closeAfterSend);
        closeAfterSend.click();
        return new MailFolderPage(driver);
    }
}

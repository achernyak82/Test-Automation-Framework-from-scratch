package com.epam.cdp.testautomationframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.epam.cdp.testautomationframework.tools.JavaScriptTool;

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

    public WriteEmailPage(WebDriver driver) {
        super(driver);
    }

    public void addSentAddress(String whom){
       waitElementIsVisible(sentAddress);
       sentAddress.sendKeys(whom);
       JavaScriptTool.highlightElement(sentAddress);
    }

    public void addSubject(String topic) {
       sentSubject.sendKeys(topic);
       JavaScriptTool.highlightElement(sentSubject);
    }

    public void addContentOfTheLetter(String content) {
        new Actions(driver)
                .moveToElement(sentContent)
                .click()
                .sendKeys(content)
                .build()
                .perform();
        JavaScriptTool.highlightElement(sentContent);
    }

    public void saveInDraft() {
       saveInDraft.click();
       JavaScriptTool.highlightElement(saveInDraft);
    }

    public void closeWritingPage() {
        JavaScriptTool.safeJavaScriptClick(closeWritePage);
    }

    public void sendFromDrafts() {
        waitElementIsVisible(sendEmailFromDrafts);
        sendEmailFromDrafts.click();
        waitElementIsVisible(closeAfterSend);
        closeAfterSend.click();
    }

    public void sendSimply() {
        JavaScriptTool.safeJavaScriptClick(sendEmailFromDrafts);
        waitElementIsVisible(closeAfterSend);
        closeAfterSend.click();
    }
}

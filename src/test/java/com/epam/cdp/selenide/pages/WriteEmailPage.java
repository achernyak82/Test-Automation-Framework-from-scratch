package com.epam.cdp.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class WriteEmailPage extends AbstractPage {

    @FindBy(css = "div.inputContainer--nsqFu > input")
    private SelenideElement sentAddress;

    @FindBy(name = "Subject")
    private SelenideElement sentSubject;

    @FindBy(xpath = "//div[@tabindex='505']/div[1]")
    private SelenideElement sentContent;

    @FindBy(xpath = "//span[text()='Сохранить']")
    private SelenideElement saveInDraft;

    @FindBy(xpath = "//button[@title='Закрыть']")
    private SelenideElement closeWritePage;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Отправить']")
    private SelenideElement sendEmailFromDrafts;

    @FindBy(xpath = "//div[@class='layer__controls']/span[@title='Закрыть']")
    private SelenideElement closeAfterSend;

    public WriteEmailPage() {
        super();
    }

    public void addSentAddress(String whom) {
        sentAddress.shouldBe(Condition.visible).sendKeys(whom);
    }

    public void addSubject(String topic) {
        sentSubject.sendKeys(topic);
    }

    public void addContentOfTheLetter(String content) {
        sentContent.sendKeys(content);
    }

    public void saveInDraft() {
        saveInDraft.click();
    }

    public void closeWritingPage() {
        closeWritePage.click();
    }

    public void sendFromDrafts() {
        sendEmailFromDrafts.shouldBe(Condition.visible).click();
        closeAfterSend.shouldBe(Condition.visible).click();
    }

    public void sendSimply() {
        sendEmailFromDrafts.click();
        closeAfterSend.shouldBe(Condition.visible).click();
    }
}

package com.epam.cdp.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MailFolderPage extends AbstractPage {

    @FindBy(xpath = "//a[@title = 'Написать письмо']")
    private SelenideElement writeLetter;

    @FindBy(xpath = "//a[@title = 'Написать письмо']//span[@class='compose-button__wrapper']")
    private SelenideElement spanToHighLight;

    @FindBy(xpath = "//div[@class='nav__folder-name__txt'][text()='Черновики']")
    private SelenideElement draftFolder;

    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent']//span[@class='ll-crpt']")
    private SelenideElement testAddressFromTestEmail;

    @FindBy(xpath = "//div[@class='llc__item llc__item_title']//span[text()='TESTEmail']")
    private SelenideElement testTopicFromTestEmail;

    @FindBy(xpath = "//div[@class='llc__item llc__item_title']//span[@class='ll-sp__normal']")
    private SelenideElement testContentFromTestEmail;

    @FindBy(className = "dataset__empty")
    private SelenideElement emptyDrafts;

    @FindBy(xpath = "//div[@class='nav__folder-name']/div[text()='Отправленные']")
    private SelenideElement sentEmailsFolder;

    @FindBy(css = "div.llc__item.llc__item_correspondent > span.ll-crpt")
    private SelenideElement sentTestEmail;

    @FindBy(xpath = "//div[@class='ll-av__container']//span[@class='ll-av__checkbox']")
    private SelenideElement testEmailChecked;

    @FindBy(xpath = "//span[@title='Удалить']")
    private SelenideElement delFromDrafts;

    @FindBy(xpath = "//div[@class='nav__folder-name']//div[text()='Корзина']")
    private SelenideElement basketFolder;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Очистить']")
    private SelenideElement cleanTheBasket;

    @FindBy(xpath = "//div[text() = 'В корзине пусто']")
    private SelenideElement basketEmpty;

    @FindBy(className = "llc__content")
    private SelenideElement containerOfTheLetter;

    @FindBy(xpath = "//div[@class = 'llc__container']//div[@class = 'llc__content']")
    private SelenideElement containerOfTheBasket;

    @FindBy(xpath = "//span[text()='Новая папка']")
    private SelenideElement newFolderButton;

    @FindBy(xpath = "//div[contains(text(),'test')]")
    private SelenideElement newTestFolder;

    @FindBy(xpath = "//a[@class='link']")
    private SelenideElement createFilter;

    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent llc__item_unread']//span[@class='ll-crpt']")
    private SelenideElement testAddressFromMyselfEmail;

    @FindBy(xpath = "//div[@data-qa-id = 'delete']//span[text()='Удалить папку']")
    private SelenideElement deleteTestFolder;

    @FindBy(xpath = "//span[@class='button2__wrapper']/span[text()='Удалить']")
    private SelenideElement deleteTestFolderConfirmation;

    public MailFolderPage() {
        super();
    }

    public SelenideElement getAddressFromMyselfEmail() {
        return testAddressFromMyselfEmail.shouldBe(Condition.visible);
    }

    public void startNewLetter() {
        writeLetter.shouldBe(Condition.visible).click();
    }

    public void enterInDrafts() {
        draftFolder.click();
    }

    public SelenideElement getTestAddress() {
        return testAddressFromTestEmail.shouldBe(Condition.visible);
    }

    public void clickOnTheDraftEmail() {
        testAddressFromTestEmail.click();
    }

    public SelenideElement getEmptyFromDrafts() {
        return emptyDrafts.shouldBe(Condition.visible);
    }

    public void enterInSendingEmails() {
        sentEmailsFolder.click();
    }

    public SelenideElement getTextFromSentEmail() {
        return sentTestEmail.shouldBe(Condition.visible);
    }

    public void checkTestEmail() {
        containerOfTheLetter.hover();
        testEmailChecked.shouldBe(Condition.visible).click();
    }

    public void delFromDrafts() {
        delFromDrafts.click();
    }

    public void enterInBasket() {
        basketFolder.click();
    }

    public void cleanTheBasket() {
        containerOfTheBasket.shouldBe(Condition.visible).hover();
        testEmailChecked.shouldBe(Condition.visible).click();
    }

    public void delFromBasket() {
        delFromDrafts.click();
    }

    public SelenideElement getTextFromEmptyBasket() {
        return basketEmpty.shouldBe(Condition.visible);
    }

    public void addNewFolder() {
        newFolderButton.shouldBe(Condition.visible).click();
    }

    public void testFolderClick() {
        newTestFolder.shouldBe(Condition.visible).click();
    }

    public void addNewFilter() {
        createFilter.shouldBe(Condition.visible).click();
    }

    public void rightClickOnTheTestFolder() {
        newTestFolder.contextClick();
    }

    public void selectDeleteOption() {
        deleteTestFolder.click();
    }

    public void confirmDeletingTestFolder() {
        deleteTestFolderConfirmation.shouldBe(Condition.visible).click();
    }
}

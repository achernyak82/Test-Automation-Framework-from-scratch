package com.epam.cdp.selenide.steps;


import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;

public class AssertionSteps extends AbstractBaseStep {

    public AssertionSteps() {
        super();
    }

    public void assertThatTestEmailIsInDraft(String email) {
        mailFolderPage.getTestAddress().shouldHave(text(email));
    }

    public void assertThatDraftFolderIsEmpty() {
        mailFolderPage.getEmptyFromDrafts().should(Condition.appear);
    }

    public void assertThatTestEmailIsInSendingFolder(String email) {
        mailFolderPage.getTextFromSentEmail().shouldHave(text(email));

    }

    public void assertThatBasketIsEmpty() {
        mailFolderPage.getTextFromEmptyBasket().shouldHave(text("В корзине пусто"));
    }

    public void assertThatTestEmailIsInTestFolder() {
        mailFolderPage.getAddressFromMyselfEmail().shouldHave(text("alexander chernyak"));
    }
}

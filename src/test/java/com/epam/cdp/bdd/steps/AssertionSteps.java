package com.epam.cdp.bdd.steps;

import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AssertionSteps extends AbstractBaseStep {


    public AssertionSteps() {
        super();
    }

    public void assertThatTestEmailIsInDraft(String email) {
        String actualAddress = mailFolderPage.getTestAddress();
        assertEquals(actualAddress, email);
    }

    public void assertThatDraftFolderIsEmpty() {
        boolean emptyFolder = mailFolderPage.getEmptyFromDrafts();
        assertTrue(emptyFolder);
    }

    @Then("The letter to {string} should be in the sending folder")
    public void assertThatTestEmailIsInSendingFolder(String email) {
        String actualAddress = mailFolderPage.getTextFromSentEmail();
        assertEquals(actualAddress, email);
    }

    @Then("^The basket should be empty$")
    public void assertThatBasketIsEmpty() {
        String actualBasketText = mailFolderPage.getTextFromEmptyBasket();
        assertEquals(actualBasketText, "В корзине пусто");
    }

    @Then("The letter to {string} should be in the test folder")
    public void assertThatTestEmailIsInTestFolder() {
        String actualTextFromTestEmail = mailFolderPage.getAddressFromMyselfEmail();
        assertEquals(actualTextFromTestEmail, "alexander chernyak");
    }
}

package com.epam.cdp.designpatterns.steps;


import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AssertionSteps extends AbstractBaseStep {

    private static AssertionSteps assertionSteps;

    private AssertionSteps() {
        super();
    }

    public static AssertionSteps getAssertionSteps() {
        if (assertionSteps == null) {
            setAssertionSteps();
        }
        return assertionSteps;
    }

    private static void setAssertionSteps() {
        assertionSteps = new AssertionSteps();
    }

    public void assertThatTestEmailIsInDraft(String email) {
        String actualAddress = mailFolderPage.getTestAddress();
        assertEquals(actualAddress, email);
    }

    public void assertThatDraftFolderIsEmpty() {
        boolean emptyFolder = mailFolderPage.getEmptyFromDrafts();
        assertTrue(emptyFolder);
    }

    public void assertThatTestEmailIsInSendingFolder(String email) {
        String actualAddress = mailFolderPage.getTextFromSentEmail();
        assertEquals(actualAddress, email);
    }

    public void assertThatBasketIsEmpty() {
        String actualBasketText = mailFolderPage.getTextFromEmptyBasket();
        assertEquals(actualBasketText, "В корзине пусто");
    }

    public void assertThatTestEmailIsInTestFolder() {
        String actualTextFromTestEmail = mailFolderPage.getAddressFromMyselfEmail();
        assertEquals(actualTextFromTestEmail, "alexander chernyak");
    }
}

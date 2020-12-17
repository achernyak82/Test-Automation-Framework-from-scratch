package com.epam.cdp.designpatterns.tests;

import com.epam.cdp.designpatterns.businessobjects.FilterTest;
import com.epam.cdp.designpatterns.businessobjects.TestLetter;
import com.epam.cdp.designpatterns.listeners.LFailure;
import com.epam.cdp.designpatterns.testmanagers.BaseTestManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ LFailure.class })
public class WebDriverEmailTest extends BaseTestManager {

    TestLetter testEmail1 = new TestDataGenerator().getEmail();
    TestLetter testEmail2 = new TestDataGenerator().getEmailToMyself();
    FilterTest filterText = new TestDataGenerator().getFilter();

    @Test
    public void stepByStepWebDriverEmailTest() {
        actionSteps.writeNewEmail(testEmail1.getEmailAddress(), testEmail1.getSubject(), testEmail1.getData());
        actionSteps.saveInDraft();
        assertionSteps.assertThatTestEmailIsInDraft(testEmail1.getEmailAddress());
        actionSteps.sendFromDraft();
        assertionSteps.assertThatDraftFolderIsEmpty();
        actionSteps.enterInSendingEmails();
        assertionSteps.assertThatTestEmailIsInSendingFolder(testEmail1.getEmailAddress());
    }

    @Test
    public void basketTest() {
        actionSteps.writeNewEmail(testEmail1.getEmailAddress(), testEmail1.getSubject(), testEmail1.getData());
        actionSteps.saveInDraft();
        actionSteps.delFromDraft();
        actionSteps.delFromBasket();
        assertionSteps.assertThatBasketIsEmpty();
    }

    @Test
    public void newFolderTest() {
        actionSteps.addNewFolder();
        actionSteps.addNewFilterWithTestSettings(filterText.getText());
        actionSteps.writeNewEmail(testEmail2.getEmailAddress(), testEmail2.getSubject(), testEmail2.getData());
        actionSteps.sendTestEmailFromTestFolder();
        assertionSteps.assertThatTestEmailIsInTestFolder();
        actionSteps.delTestFolder();
        actionSteps.delFromBasket();
        assertionSteps.assertThatBasketIsEmpty();
    }
}


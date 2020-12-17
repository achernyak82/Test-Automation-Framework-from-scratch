package com.epam.cdp.bdd.tests;

import com.epam.cdp.bdd.businessobjects.FilterTest;
import com.epam.cdp.bdd.businessobjects.TestLetter;
import com.epam.cdp.bdd.businessobjects.User;
import com.epam.cdp.bdd.testmanagers.BaseTestManager;
import org.testng.annotations.Test;

public class WebDriverEmailTest extends BaseTestManager {

  /*  User user = new TestDataGenerator().getUser();
    TestLetter testEmail1 = new TestDataGenerator().getEmail();
    TestLetter testEmail2 = new TestDataGenerator().getEmailToMyself();
    FilterTest filterText = new TestDataGenerator().getFilter();

    @Test
    public void stepByStepWebDriverEmailTest() {

        actionSteps.enterInMail(user.getLogin(), user.getPassword());
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

        actionSteps.enterInMail(user.getLogin(), user.getPassword());
        actionSteps.writeNewEmail(testEmail1.getEmailAddress(), testEmail1.getSubject(), testEmail1.getData());
        actionSteps.saveInDraft();
        actionSteps.delFromDraft();
        actionSteps.delFromBasket();
        assertionSteps.assertThatBasketIsEmpty();
    }

    @Test
    public void newFolderTest() {

        actionSteps.enterInMail(user.getLogin(), user.getPassword());
        actionSteps.addNewFolder();
        actionSteps.addNewFilterWithTestSettings(filterText.getText());
        actionSteps.writeNewEmail(testEmail2.getEmailAddress(), testEmail2.getSubject(), testEmail2.getData());
        actionSteps.sendTestEmailFromTestFolder();
        assertionSteps.assertThatTestEmailIsInTestFolder();

        actionSteps.delTestFolder();
        actionSteps.delFromBasket();
        assertionSteps.assertThatBasketIsEmpty();
    }

   */
}


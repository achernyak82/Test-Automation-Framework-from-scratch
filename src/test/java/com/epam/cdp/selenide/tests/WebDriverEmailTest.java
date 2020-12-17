package com.epam.cdp.selenide.tests;

import org.testng.annotations.Test;
import com.epam.cdp.selenide.businessobjects.FilterTest;
import com.epam.cdp.selenide.businessobjects.TestLetter;
import com.epam.cdp.selenide.businessobjects.User;
import com.epam.cdp.selenide.testmanagers.BaseTestManager;

public class WebDriverEmailTest extends BaseTestManager {

    User user = new User("testalexnsk", "Uer89fd1982");
    TestLetter testEmail1 = new TestLetter("achernyak82@mail.ru", "testEmail", "SOME DATA");
    TestLetter testEmail2 = new TestLetter("testalexnsk@mail.ru", "TESTemail", "SOME DATA");
    FilterTest filterText = new FilterTest("testemail");

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
}


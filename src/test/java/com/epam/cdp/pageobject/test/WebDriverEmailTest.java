package com.epam.cdp.pageobject.test;

import com.epam.cdp.SeleniumTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.cdp.pageobject.page.LoginPage;
import com.epam.cdp.pageobject.page.MailFolderPage;

import static com.epam.cdp.pageobject.test.BaseTest.*;

public class WebDriverEmailTest extends BaseTest{

 @Test
 public void stepByStepWebDriverEmailTest()  {

     MailFolderPage emailTestPage = new LoginPage(driver)
             .enterInMail(TEST_EMAIL,EMAIL_PASSWORD)
             .startNewLetter()
             .addSentAddress(WHO_SEND_EMAIL_TO)
             .addSubject(THE_SENT_SUBJECT)
             .addContentOfTheLetter(THE_SENT_DATA)
             .saveInDraft()
             .closeWritingPage()
             .enterInDrafts();

     String actualAddress = emailTestPage.getTestAddress();
     Assert.assertEquals(actualAddress,"achernyak82@mail.ru");

     emailTestPage = emailTestPage
             .clickOnTheDraftEmail()
             .sendFromDrafts();

     boolean actualEmptyStatusOfDrafts = emailTestPage.getEmptyFromDrafts();
     Assert.assertTrue(actualEmptyStatusOfDrafts);

     emailTestPage = emailTestPage.
             enterInSendingEmails();

     String actualSentEmailAddress = emailTestPage.getTextFromSentEmail();
     Assert.assertEquals(actualSentEmailAddress,"achernyak82@mail.ru");
 }

 @Test
 public void basketTest() {

     MailFolderPage folderPage = new LoginPage(driver)
             .enterInMail(TEST_EMAIL, EMAIL_PASSWORD)
             .startNewLetter()
             .addSentAddress(WHO_SEND_EMAIL_TO)
             .addSubject(THE_SENT_SUBJECT)
             .addContentOfTheLetter(THE_SENT_DATA)
             .saveInDraft()
             .closeWritingPage();

     folderPage = folderPage
             .enterInDrafts()
             .checkTestEmail()
             .delFromDrafts();

     folderPage = folderPage
             .similarStepsInBasket();

     String actualBasketEmptyText = folderPage.getTextFromEmptyBasket();
     Assert.assertEquals(actualBasketEmptyText,"В корзине пусто");
 }

@Test
public void newFolderTest() {

     MailFolderPage testFolderPage = new LoginPage(driver)
             .enterInMail(TEST_EMAIL, EMAIL_PASSWORD)
             .addNewFolder()
             .typeNewFolderName()
             .addFolder();

     testFolderPage = testFolderPage
             .testFolderClick()
             .addNewFilter()
             .selectFromDropDown()
             .addContainForEmailSubject(THE_SENT_SUBJECT)
             .saveFilter();

     testFolderPage = testFolderPage.startNewLetter()
             .addSentAddress(I_SEND_EMAIL_TO_MYSELF)
             .addSubject(THE_SENT_SUBJECT)
             .addContentOfTheLetter(THE_SENT_DATA)
             .sendSimply()
             .testFolderClick();

    String  actualMyTestAddress = testFolderPage.getAddressFromMyselfEmail();
    Assert.assertEquals( actualMyTestAddress, "alexander chernyak");

    testFolderPage = testFolderPage
            .rightClickOnTheTestFolder()
            .selectDeleteOption()
            .confirmDeletingTestFolder()
            .similarStepsInBasket();

    String actualBasketEmptyText = testFolderPage.getTextFromEmptyBasket();
    Assert.assertEquals(actualBasketEmptyText,"В корзине пусто");
}
}

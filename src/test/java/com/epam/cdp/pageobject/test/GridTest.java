package com.epam.cdp.pageobject.test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.epam.cdp.pageobject.page.LoginPage;
import com.epam.cdp.pageobject.page.MailFolderPage;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.cdp.pageobject.test.BaseTest.*;

public class GridTest {

    ThreadLocal <WebDriver> drivers = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        ChromeDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        WebDriver driver = null;
        try
        {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        drivers.set(driver);
        }

    @Test
    public void basketTest() {

        MailFolderPage folderPage = new LoginPage(drivers.get())
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
    public void stepByStepWebDriverEmailTest() {

        MailFolderPage emailTestPage = new LoginPage(drivers.get())
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

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
            drivers.get().quit();
        }
    }



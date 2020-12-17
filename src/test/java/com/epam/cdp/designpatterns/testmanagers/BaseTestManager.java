package com.epam.cdp.designpatterns.testmanagers;

import com.epam.cdp.designpatterns.businessobjects.User;
import com.epam.cdp.designpatterns.factory.BrowserFactory;
import com.epam.cdp.designpatterns.factory.BrowserType;
import com.epam.cdp.designpatterns.logging.MyLogger;
import com.epam.cdp.designpatterns.steps.ActionSteps;
import com.epam.cdp.designpatterns.steps.AssertionSteps;
import com.epam.cdp.designpatterns.tests.TestDataGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTestManager {

    private User user;
    protected WebDriver driver;
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;

    @BeforeClass
    public void setupClass() {
        driver = BrowserFactory.createBrowserDriver(BrowserType.GOOGLECHROME);
        driver.manage().window().maximize();
        actionSteps = ActionSteps.getActionSteps();
        assertionSteps = AssertionSteps.getAssertionSteps();
        user = new TestDataGenerator().getUser();
    }

    @BeforeMethod
    public void login() {
        actionSteps.enterInMail(user.getLogin(), user.getPassword());
    }

    @AfterMethod
    public void logout() {
        actionSteps.logoutFromEmail();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        MyLogger.warn("Browser is closing now.");
    }
}

package com.epam.cdp.bdd.testmanagers;

import com.epam.cdp.bdd.factory.BrowserFactory;
import com.epam.cdp.bdd.factory.BrowserType;
import com.epam.cdp.bdd.steps.ActionSteps;
import com.epam.cdp.bdd.steps.AssertionSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTestManager {

    protected WebDriver driver;

    protected ActionSteps actionSteps;

    protected AssertionSteps assertionSteps;

    @Before
    public void setupClass() {
        driver = BrowserFactory.createBrowserDriver(BrowserType.GOOGLECHROME);
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver.manage().window().maximize();
        actionSteps = new ActionSteps();
        assertionSteps = new AssertionSteps();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

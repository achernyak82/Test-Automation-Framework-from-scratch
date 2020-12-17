package com.epam.cdp.testautomationframework.testmanagers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.epam.cdp.testautomationframework.steps.ActionSteps;
import com.epam.cdp.testautomationframework.steps.AssertionSteps;

public class BaseTestManager {

    protected WebDriver driver;

    protected ActionSteps actionSteps;

    protected AssertionSteps assertionSteps;

    @BeforeClass
    public void setupClass() {
        driver = DriverManager.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver.manage().window().maximize();
        actionSteps = new ActionSteps();
        assertionSteps = new AssertionSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

package com.epam.cdp.bdd.hooks;

import com.epam.cdp.bdd.factory.BrowserFactory;
import com.epam.cdp.bdd.factory.BrowserType;
import com.epam.cdp.bdd.testmanagers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    protected WebDriver driver;

    @Before
    public void setupUp() {
        driver = BrowserFactory.createBrowserDriver(BrowserType.GOOGLECHROME);
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().getDriver().quit();
        DriverManager.makeInstanceNull();
    }

}

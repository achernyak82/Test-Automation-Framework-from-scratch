package com.epam.cdp.testautomationframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected final int WAIT_TIMEOUT_SECONDS = 25;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).
                until(ExpectedConditions.
                        visibilityOf(element));
    }
}

package com.epam.cdp.bdd.pages;

import com.epam.cdp.bdd.decorator.CustomDriverDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected CustomDriverDecorator driver;

    private final int WAIT_TIMEOUT_SECONDS = 25;

    protected AbstractPage(CustomDriverDecorator driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).
                until(ExpectedConditions.
                        visibilityOf(element));
    }
}

package com.epam.cdp.designpatterns.pages;

import com.epam.cdp.designpatterns.decorator.CustomDriverDecorator;
import org.openqa.selenium.StaleElementReferenceException;
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

    protected void waitElementIsVisible(WebElement element, AbstractPage page) {
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).
                    until(ExpectedConditions.
                            visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, page);
        }
    }
}

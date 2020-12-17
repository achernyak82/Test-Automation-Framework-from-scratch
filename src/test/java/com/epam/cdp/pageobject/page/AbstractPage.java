package com.epam.cdp.pageobject.page;

import org.openqa.selenium.*;
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

    protected void highlightElement(WebElement element) {
        String backgroundColor = element.getCssValue("backgroundColor");
        executeJavaScript("arguments[0].style.backgroundColor = '" + "aqua" + "'", element);
        executeJavaScript("arguments[0].style.backgroundColor = '" + backgroundColor + "'", element);
    }

    private void executeJavaScript (String script, WebElement element) {
        JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
        javaScript.executeScript(script,element);
    }

    protected void safeJavaScriptClick(WebElement element)  {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");
                executeJavaScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("The page has been changed dynamically and the element is no longer available "+ e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element "+ e.getStackTrace());
        }
    }
}

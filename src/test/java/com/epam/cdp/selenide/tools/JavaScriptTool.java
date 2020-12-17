package com.epam.cdp.selenide.tools;

import org.openqa.selenium.*;
import com.epam.cdp.selenide.testmanagers.DriverManager;

public class JavaScriptTool {

    public static void highlightElement(WebElement element) {
        String backgroundColor = element.getCssValue("backgroundColor");
        executeJavaScript("arguments[0].style.backgroundColor = '" + "aqua" + "'", element);
        executeJavaScript("arguments[0].style.backgroundColor = '" + backgroundColor + "'", element);
    }

    private static void executeJavaScript(String script, WebElement element) {
        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
        javaScript.executeScript(script, element);
    }

    public static void safeJavaScriptClick(WebElement element) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");
                executeJavaScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("The page has been changed dynamically and the element is no longer available " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }
    }

}

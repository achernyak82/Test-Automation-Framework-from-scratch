package com.epam.cdp.bdd.tools;

import com.epam.cdp.bdd.testmanagers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractJavaScriptTool {

    protected static void executeJavaScript(String script, WebElement element) {
        WebDriver driver = DriverManager.getInstance().getDriver();
        JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
        javaScript.executeScript(script, element);
    }
}

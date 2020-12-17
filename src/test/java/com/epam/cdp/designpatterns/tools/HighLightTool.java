package com.epam.cdp.designpatterns.tools;

import org.openqa.selenium.WebElement;

public class HighLightTool extends AbstractJavaScriptTool {

    public static void highlightElement(WebElement element) {
        executeJavaScript("arguments[0].style.border='5px solid green'", element);
    }
}

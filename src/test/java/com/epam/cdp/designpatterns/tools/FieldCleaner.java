package com.epam.cdp.designpatterns.tools;

import org.openqa.selenium.WebElement;

public class FieldCleaner extends AbstractJavaScriptTool{

    public static void  cleanTheField(WebElement element) {
        executeJavaScript("arguments[0].value = ''", element);
    }
}

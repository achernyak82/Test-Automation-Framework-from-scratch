package com.epam.cdp.bdd.tools;

import org.openqa.selenium.WebElement;

public class HighLightTool extends AbstractJavaScriptTool {

    public static void highlightElement(WebElement element) {
        String backgroundColor = element.getCssValue("backgroundColor");
        executeJavaScript("arguments[0].style.backgroundColor = '" + "aqua" + "'", element);
        executeJavaScript("arguments[0].style.backgroundColor = '" + backgroundColor + "'", element);
    }
}

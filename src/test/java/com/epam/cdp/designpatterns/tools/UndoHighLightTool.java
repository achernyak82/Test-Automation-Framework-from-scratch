package com.epam.cdp.designpatterns.tools;

import org.openqa.selenium.WebElement;

public class UndoHighLightTool extends AbstractJavaScriptTool {

    public static void unHighLightElement(WebElement element) {
        executeJavaScript("arguments[0].style.border='0px'", element);
    }

}

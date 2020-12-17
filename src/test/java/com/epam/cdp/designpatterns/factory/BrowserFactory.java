package com.epam.cdp.designpatterns.factory;

import com.epam.cdp.designpatterns.testmanagers.DriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public static WebDriver createBrowserDriver(BrowserType type) {
        switch (type) {

            case GOOGLECHROME:
                return DriverManager.getInstance().getGoogleChromeDriver();

            case FIREFOX:
                return DriverManager.getInstance().getFireFoxDriver();

            default:
                throw new IllegalArgumentException("Invalid Browser Type!");
        }
    }
}

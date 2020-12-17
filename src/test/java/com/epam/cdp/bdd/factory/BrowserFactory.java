package com.epam.cdp.bdd.factory;

import com.epam.cdp.bdd.testmanagers.DriverManager;
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

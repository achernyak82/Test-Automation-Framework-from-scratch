package com.epam.cdp.testautomationframework.testmanagers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private static void setDriver() {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}

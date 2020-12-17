package com.epam.cdp.bdd.testmanagers;

import com.epam.cdp.bdd.decorator.CustomDriverDecorator;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static DriverManager instance;
    private CustomDriverDecorator driver;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public CustomDriverDecorator getDriver() {
        return driver;
    }

    public static void makeInstanceNull() {
        instance = null;
    }

    public WebDriver getGoogleChromeDriver() {
        if (driver == null) {
            setGoogleChromeDriver();
        }
        return driver;
    }

    public WebDriver getFireFoxDriver() {
        if (driver == null) {
            setFireFoxDriver();
        }
        return driver;
    }

    private void setGoogleChromeDriver() {
        ChromeDriverManager.chromedriver().setup();
        driver = new CustomDriverDecorator(new ChromeDriver());
        driver.manage().window().maximize();
    }

    private void setFireFoxDriver() {
        FirefoxDriverManager.firefoxdriver().setup();
        driver = new CustomDriverDecorator(new FirefoxDriver());
        driver.manage().window().maximize();
    }
}

package com.epam.cdp.designpatterns.tools;

import com.epam.cdp.designpatterns.logging.MyLogger;
import com.epam.cdp.designpatterns.testmanagers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenShotTaker {

    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    public static void takeScreenShot() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            MyLogger.info("Saved screenshot: " + screenshotName);
        } catch (
                IOException e) {
            MyLogger.error("Failed to make screenshot");
        }
    }
}

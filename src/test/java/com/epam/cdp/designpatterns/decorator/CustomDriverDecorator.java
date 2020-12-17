package com.epam.cdp.designpatterns.decorator;

import com.epam.cdp.designpatterns.logging.MyLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class CustomDriverDecorator implements WebDriver, JavascriptExecutor {

    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    private WebDriver driver;

    public CustomDriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }

    @Override
    public Object executeScript(String s, Object... element) {
        JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
        return javaScript.executeScript(s, element);
    }

    @Override
    public Object executeAsyncScript(String s, Object... objects) {
        return null;
    }

    public void highlightElement(WebElement element) {
        executeScript("arguments[0].style.border='5px solid green'", element);
    }

    public void  cleanTheField(WebElement element) {
        executeScript("arguments[0].value = ''", element);
    }

    public void unHighLightElement(WebElement element) {
        executeScript("arguments[0].style.border='0px'", element);
    }

    public void takeScreenShot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            MyLogger.debug("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            MyLogger.error("Failed to make screenshot");
        }
    }
}

package com.epam.cdp.testautomationframework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.epam.cdp.testautomationframework.tools.JavaScriptTool;

public class FilterSettingsPage extends AbstractPage {

    @FindBy(xpath = "//input[@data-test-id='condition-value']")
    private WebElement testFromValue;

    @FindBy(xpath = "//button[@data-test-id='submit']//span")
    private WebElement saveFilter;

    @FindBy(xpath = "//div[@class='Select-value']")
    private WebElement dropDownFrom;

    @FindBy(xpath = "//div[@class='Select-menu-outer']//*[contains(text(),'Тема')]")
    private WebElement selectFrom;


    public FilterSettingsPage(WebDriver driver) {
        super(driver);
    }


    public void addContaintForEmailSubject(String text) {
        Actions builder = new Actions(driver);
        Action writeCapital = builder
                .click(testFromValue)
                .keyDown(Keys.SHIFT)
                .sendKeys(testFromValue, text.substring(0, 3))
                .keyUp(Keys.SHIFT)
                .sendKeys(text.substring(4, 7))
                .build();
        writeCapital.perform();
        JavaScriptTool.highlightElement(testFromValue);
    }

    public void dropDownClick() {
        waitElementIsVisible(dropDownFrom);
        dropDownFrom.click();
    }

    public void selectFromDropDown() {
        dropDownClick();
        JavaScriptTool.highlightElement(dropDownFrom);
        waitElementIsVisible(selectFrom);
        JavaScriptTool.highlightElement(selectFrom);
        selectFrom.click();
    }

    public void saveFilter() {
        JavaScriptTool.safeJavaScriptClick(saveFilter);
    }
}

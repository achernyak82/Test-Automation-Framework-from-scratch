package com.epam.cdp.designpatterns.pages;

import com.epam.cdp.designpatterns.decorator.CustomDriverDecorator;
import com.epam.cdp.designpatterns.logging.MyLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FilterSettingsPage extends AbstractPage {

    @FindBy(xpath = "//input[@data-test-id='condition-value']")
    private WebElement testFromValue;

    @FindBy(xpath = "//button[@data-test-id='submit']//span")
    private WebElement saveFilter;

    @FindBy(xpath = "//div[@class='Select-value']")
    private WebElement dropDownFrom;

    @FindBy(xpath = "//div[@class='Select-menu-out']//*[contains(text(),'Тема')]")
    private WebElement selectFrom;


    public FilterSettingsPage(CustomDriverDecorator driver) {
        super(driver);
    }


    public void addContaintForEmailSubject(String text) {
        Actions builder = new Actions(driver.getDriver());
        Action writeCapital = builder
                .click(testFromValue)
                .keyDown(Keys.SHIFT)
                .sendKeys(testFromValue, text.substring(0, 3))
                .keyUp(Keys.SHIFT)
                .sendKeys(text.substring(4, 7))
                .build();
        writeCapital.perform();
    }

    public void dropDownClick() {
        waitElementIsVisible(dropDownFrom, this);
        driver.highlightElement(dropDownFrom);
        dropDownFrom.click();
        driver.unHighLightElement(dropDownFrom);
    }

    public void selectFromDropDown() {
        dropDownClick();
        try {
            waitElementIsVisible(selectFrom, this);
            driver.highlightElement(selectFrom);
            selectFrom.click();
            driver.unHighLightElement(selectFrom);
        } catch (TimeoutException e) {
            MyLogger.error("Can't wait till the WebElement's appearance." + e.getMessage());
        }
    }

    public void saveFilter() {
        driver.highlightElement(saveFilter);
        saveFilter.click();
        driver.unHighLightElement(saveFilter);
    }
}

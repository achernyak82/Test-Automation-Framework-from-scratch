package com.epam.cdp.pageobject.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

    @FindBy(xpath = "//div[@class='Select-menu-outer']//*[contains(text(),'Тема')]")
    private WebElement selectFrom;


    protected FilterSettingsPage(WebDriver driver) {
        super(driver);
    }


    public FilterSettingsPage addContainForEmailSubject(String test) {
        Actions builder = new Actions(driver);

        Action writeCapital = builder
                .click(testFromValue)
                .keyDown(Keys.SHIFT)
                .sendKeys(testFromValue, "test")
                .keyUp(Keys.SHIFT)
                .sendKeys("email")
                .build();
        writeCapital.perform();
        highlightElement(testFromValue);
        return this;
    }

    public FilterSettingsPage dropDownClick() {
        dropDownFrom.click();
        return this;
    }

    public FilterSettingsPage selectFromDropDown() {
        waitElementIsVisible(dropDownFrom);
        dropDownClick();
        highlightElement(dropDownFrom);
        waitElementIsVisible(selectFrom);
        highlightElement(selectFrom);
        selectFrom.click();
        return this;
    }

    public MailFolderPage saveFilter() {
        safeJavaScriptClick(saveFilter);
        return new MailFolderPage(driver);
    }
}

package com.epam.cdp.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FilterSettingsPage extends AbstractPage {

    @FindBy(xpath = "//input[@data-test-id='condition-value']")
    private SelenideElement testFromValue;

    @FindBy(xpath = "//button[@data-test-id='submit']//span")
    private SelenideElement saveFilter;

    @FindBy(xpath = "//div[@class='Select-value']")
    private SelenideElement dropDownFrom;

    @FindBy(xpath = "//div[@class='Select-menu-outer']//*[contains(text(),'Тема')]")
    private SelenideElement selectFrom;


    public FilterSettingsPage() {
        super();
    }


    public void addFilterForEmailSubject(String text) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Actions builder = new Actions(driver);
        Action writeCapital = builder
                .click(testFromValue)
                .keyDown(Keys.SHIFT)
                .sendKeys(testFromValue, text.substring(0, 4))
                .keyUp(Keys.SHIFT)
                .sendKeys(text.substring(4, 8))
                .build();
        writeCapital.perform();
    }

    public void dropDownClick() {
        dropDownFrom.shouldBe(Condition.visible).click();
    }

    public void selectFromDropDown() {
        selectFrom.shouldBe(Condition.visible).click();
    }

    public void saveFilter() {
        saveFilter.click();
    }
}

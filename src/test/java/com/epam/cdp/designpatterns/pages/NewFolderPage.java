package com.epam.cdp.designpatterns.pages;

import com.epam.cdp.designpatterns.decorator.CustomDriverDecorator;
import com.epam.cdp.designpatterns.logging.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewFolderPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Название']")
    private WebElement folderName;

    @FindBy(xpath = "//button[@data-test-id = 'submit']/span")
    private WebElement folderAdd;

    public NewFolderPage(CustomDriverDecorator driver) {
        super(driver);
    }

    public void typeNewFolderName(){
        waitElementIsVisible(folderName, this);
        driver.highlightElement(folderName);
        folderName.sendKeys("testFolder");
        driver.unHighLightElement(folderName);
        MyLogger.info("Typing test folder " + folderName.getText() + " (Additional information: " + folderName + ")");
    }

    public void addFolder() {
        driver.highlightElement(folderAdd);
        driver.unHighLightElement(folderAdd);
        MyLogger.info("Adding test folder  '" + folderAdd.getText() + "' (Additional information: " + folderAdd + ")");
        folderAdd.click();
    }
}

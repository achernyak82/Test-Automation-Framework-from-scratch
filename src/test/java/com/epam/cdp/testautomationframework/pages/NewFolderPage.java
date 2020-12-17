package com.epam.cdp.testautomationframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.epam.cdp.testautomationframework.tools.JavaScriptTool;

public class NewFolderPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Название']")
    private WebElement folderName;

    @FindBy(xpath = "//button[@data-test-id = 'submit']/span")
    private WebElement folderAdd;

    public NewFolderPage(WebDriver driver) {
        super(driver);
    }

    public void typeNewFolderName(){
        waitElementIsVisible(folderName);
        folderName.sendKeys("testFolder");
        JavaScriptTool.highlightElement(folderName);
    }

    public void addFolder() {
        JavaScriptTool.safeJavaScriptClick(folderAdd);
    }
}

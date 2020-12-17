package com.epam.cdp.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewFolderPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Название']")
    private WebElement folderName;

    @FindBy(xpath = "//button[@data-test-id = 'submit']/span")
    private WebElement folderAdd;

    protected NewFolderPage(WebDriver driver) {
        super(driver);
    }

    public NewFolderPage typeNewFolderName(){
        waitElementIsVisible(folderName);
        folderName.sendKeys("testFolder");
        highlightElement(folderName);
        return this;
    }

    public MailFolderPage addFolder() {
        safeJavaScriptClick(folderAdd);
        return new MailFolderPage(driver);
    }
}

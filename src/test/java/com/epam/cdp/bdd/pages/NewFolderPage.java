package com.epam.cdp.bdd.pages;

import com.epam.cdp.bdd.decorator.CustomDriverDecorator;
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

    public void typeNewFolderName(String folder){
        waitElementIsVisible(folderName);
        folderName.sendKeys(folder);
    }

    public void addFolder() {
        folderAdd.click();
    }
}

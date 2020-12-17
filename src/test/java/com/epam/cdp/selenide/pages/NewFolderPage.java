package com.epam.cdp.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class NewFolderPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Название']")
    private SelenideElement folderName;

    @FindBy(xpath = "//button[@data-test-id = 'submit']/span")
    private SelenideElement folderAdd;

    public NewFolderPage() {
        super();
    }

    public void typeNewFolderName(){
        folderName.shouldBe(Condition.appear).sendKeys("testFolder");
    }

    public void addFolder() {
        folderAdd.click();
    }
}

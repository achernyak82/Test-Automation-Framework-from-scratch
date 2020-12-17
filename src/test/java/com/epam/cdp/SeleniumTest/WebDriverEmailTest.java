package com.epam.cdp.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverEmailTest extends BaseTest{

 @Test
 public void stepByStepWebDriverEmailTest() {

     // to check that the login has been successful
     driver.get("http:/mail.ru");
     WebElement login = waitForElementLocatedBy(driver, By.id("mailbox:login"));
     login.sendKeys(TEST_EMAIL);
     WebElement input = driver.findElement(By.xpath("//label[text()='Ввести пароль']"));
     input.click();
     WebElement password = driver.findElement(By.name("password"));
     password.sendKeys(EMAIL_PASSWORD);
     password.submit();
     WebElement testLogin = waitForElementLocatedBy(driver, By.xpath("//a[starts-with(@title,'Написать')]"));
     Assert.assertEquals(testLogin.getText(),"Написать письмо");

     // to check that  the letter has been written and saved in drafts successfully
     WebElement write = driver.findElement(By.cssSelector("div.sidebar__compose-btn-box > a"));
     write.click();
     WebElement email = waitForElementLocatedBy(driver, By.cssSelector("div.inputContainer--nsqFu > input"));
     email.sendKeys("achernyak82@mail.ru");
     WebElement topic = driver.findElement(By.name("Subject"));
     topic.sendKeys("TestEmail");
     // it's beyond my current comprehension how to keep away from using index and tabindex here
     WebElement content = driver.findElement(By.xpath("//div[@tabindex='505']/div[1]"));
     Actions actions = new Actions(driver);
     actions.moveToElement(content);
     actions.click();
     actions.sendKeys("SOME DATA");
     actions.build().perform();
     WebElement save = driver.findElement(By.xpath("//span[text()='Сохранить']"));
     save.click();
     WebElement close = driver.findElement(By.xpath("//button[@title='Закрыть']"));
     close.click();
     WebElement draft = driver.findElement(By.xpath("//div[@class='nav__folder-name__txt'][text()='Черновики']"));
     draft.click();
     WebElement mailToSent = waitForElementVisibledBy(driver, By.xpath("//div[@class='llc__item llc__item_correspondent']/span[@title='achernyak82@mail.ru']"));
     Assert.assertEquals(mailToSent.getText(),"achernyak82@mail.ru");
     WebElement subject = driver.findElement(By.xpath("//div[@class='llc__item llc__item_title']//span[text()='TestEmail']"));
     Assert.assertEquals(subject.getText(),"TestEmail");
     WebElement body = driver.findElement(By.xpath("//div[@class='llc__item llc__item_title']//span[@class='ll-sp__normal']"));
     Assert.assertEquals(body.getText(),"SOME DATA -- alexander chernyak");

     // to check that the letter has been sent and deleted from drafts successfully
     mailToSent.click();
     WebElement sending = waitForElementLocatedBy(driver, By.xpath("//span[@class='button2__wrapper']/span[text()='Отправить']"));
     sending.click();
     WebElement closeAgain = waitForElementVisibledBy(driver, By.xpath("//div[@class='layer__controls']/span[@title='Закрыть']"));
     closeAgain.click();
     draft.click();
     WebElement empty = waitForElementVisibledBy(driver, By.className("dataset__empty"));
     Assert.assertTrue(empty.isDisplayed());

     // to check that the letter has been placed in outbox folder
     WebElement out = driver.findElement(By.xpath("//div[@class='nav__folder-name']/div[text()='Отправленные']"));
     out.click();
     WebElement check = waitForElementVisibledBy(driver, By.cssSelector("div.llc__item.llc__item_correspondent > span.ll-crpt"));
     Assert.assertEquals(check.getText(),"achernyak82@mail.ru");
 }

 private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
     return new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(by));
 }

    private static WebElement waitForElementVisibledBy(WebDriver driver, By by) {
        return new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

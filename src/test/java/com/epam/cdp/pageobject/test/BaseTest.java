package com.epam.cdp.pageobject.test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    protected static final String WHO_SEND_EMAIL_TO = "achernyak82@mail.ru";
    protected static final String I_SEND_EMAIL_TO_MYSELF = "testalexnsk@mail.ru";
    protected static final String THE_SENT_SUBJECT = "TESTemail";
    protected static final String THE_SENT_DATA = "SOME DATA";
    protected static final String TEST_EMAIL = "testalexnsk";
    protected static final String EMAIL_PASSWORD = "Uer89fd1982";

    @BeforeClass
        public  void setupClass() {
        ChromeDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}

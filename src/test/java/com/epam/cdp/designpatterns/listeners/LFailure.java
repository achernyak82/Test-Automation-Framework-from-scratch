package com.epam.cdp.designpatterns.listeners;

import com.epam.cdp.designpatterns.testmanagers.DriverManager;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LFailure extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        DriverManager.getInstance().getDriver().takeScreenShot();
    }
}

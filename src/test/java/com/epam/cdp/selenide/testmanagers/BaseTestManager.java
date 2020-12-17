package com.epam.cdp.selenide.testmanagers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.epam.cdp.selenide.steps.ActionSteps;
import com.epam.cdp.selenide.steps.AssertionSteps;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public class BaseTestManager {

    private static final String HOMEPAGE_URL = "http:/mail.ru";

    protected ActionSteps actionSteps;

    protected AssertionSteps assertionSteps;

    @BeforeClass
    public void setupClass() {
        timeout = 100000;
        pollingInterval = 500;
        startMaximized = true;
        browserSize = "1920x1080";
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        open(HOMEPAGE_URL);
        actionSteps = new ActionSteps();
        assertionSteps = new AssertionSteps();
    }}

package com.epam.cdp.selenide.pages;

import static com.codeborne.selenide.Selenide.page;

public abstract class AbstractPage {

    protected AbstractPage() {
        page(this);
    }
}

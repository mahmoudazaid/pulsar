package com.celonis.selenium.locator;

import com.celonis.selenium.locator.core.I18nLocator;
import com.celonis.selenium.locator.core.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public enum LoginPageLocator implements Locator, I18nLocator {
    LOADING_ELEMENT(By.xpath("//p[text()='LOADING']")),
    EMAIL(By.xpath("//input[@data-testing-uid='login-form-username-input']")),
    PASSWORD(By.xpath("//input[@data-testing-uid='login-form-password-input']")),
    SIGNIN(By.xpath("//button[@data-testing-uid='login-form-submit-button']")),
    PAGE_SECTION("//h2[contains(text(),'%s')]");

    static Logger logger = Logger.getLogger(LoginPageLocator.class.getName());
    private By locator;
    private String key;


    LoginPageLocator(By locator) {
        this.locator = locator;
    }

    LoginPageLocator(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public By by() {
        logger.trace("locator");
        if (this.getKey() == null) {
            return locator;
        } else {
            return By.xpath(this.getKey());
        }
    }

    @Override
    public By by(Object... index) {
        logger.trace("selector");
        return (By.xpath(String.format(key, index)));
    }
}

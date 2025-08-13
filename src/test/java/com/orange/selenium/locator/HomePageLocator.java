package com.orange.selenium.locator;

import com.orange.selenium.locator.core.I18nLocator;
import com.orange.selenium.locator.core.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public enum HomePageLocator implements Locator, I18nLocator {
    // Homepage header and navigation
    SIGN_IN_LINK(By.xpath("//*[text()='Sign In']")),

    HOME_PAGE("StackDemo");

    static Logger logger = Logger.getLogger(HomePageLocator.class.getName());
    private By locator;
    private String key;

    HomePageLocator(By locator) {
        this.locator = locator;
    }

    HomePageLocator(String key) {
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
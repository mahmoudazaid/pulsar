package com.pulsar.selenium.locator;

import com.pulsar.selenium.locator.core.I18nLocator;
import com.pulsar.selenium.locator.core.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public enum CartPageLocator implements Locator, I18nLocator {
    // Product catalog locators
    PRODUCT_CATALOG(By.xpath("//div[@class='shelf-container']")),
    ADD_TO_CART_BUTTON("//p[@class='shelf-item__title' and (text()='%s')]/..//div[contains(text(),'Add to cart')]"),
    CART_ITEM("//div[@class='float-cart__content']//*[text()='%s']"),
    CART_COUNT(By.xpath("//span[@class='bag__quantity'"));

    static final Logger logger = Logger.getLogger(CartPageLocator.class.getName());
    private By locator;
    private String key;

    CartPageLocator(By locator) {
        this.locator = locator;
    }

    CartPageLocator(String key) {
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
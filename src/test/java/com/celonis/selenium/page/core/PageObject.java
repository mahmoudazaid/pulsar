package com.celonis.selenium.page.core;

import com.celonis.selenium.driver.CustomWebDriver;
import org.apache.log4j.Logger;

public class PageObject {
    protected static Logger logger;
    protected final CustomWebDriver driver;

    public PageObject(CustomWebDriver driver, String pageClass) {
        logger = Logger.getLogger(pageClass);
        logger.trace(pageClass);
        this.driver = driver;
    }
}

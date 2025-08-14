package com.pulsar.selenium.page;

import com.pulsar.selenium.driver.CustomWebDriver;
import com.pulsar.selenium.page.core.PageObject;
import static com.pulsar.selenium.locator.HomePageLocator.*;
import org.apache.log4j.Logger;

public class HomePage extends PageObject {
    
    private static final Logger logger = Logger.getLogger(HomePage.class.getName());
    
    public HomePage(CustomWebDriver driver) {
        super(driver, HomePage.class.getName());
    }

    /**
     * Wait for homepage to load
     */
    public void waitForHomePageToLoad() {
        try {
            driver.waitUntilTitleIs(HOME_PAGE.getKey(), 30);
            logger.info("Homepage loaded successfully");
        } catch (Exception e) {
            logger.warn("Timeout waiting for homepage to load: " + e.getMessage());
        }
    }
} 
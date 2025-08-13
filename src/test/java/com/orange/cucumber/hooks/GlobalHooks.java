package com.orange.cucumber.hooks;

import com.orange.cucumber.runner.TestState;
import com.orange.selenium.driver.BrowserFactory;
import com.orange.selenium.driver.CustomWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.apache.log4j.Logger;

public class GlobalHooks {
    private static final Logger logger = Logger.getLogger(GlobalHooks.class.getName());

    private static boolean executed = false;

    private static CustomWebDriver globalDriver;

    private final TestState localState;

    public GlobalHooks(TestState localState) {
        this.localState = localState;
    }

    @Before(order = 0)
    public void startBrowser() {
        if (!executed) {
            logger.info("start browser");
            // Create the shared selenium web driver
            globalDriver = BrowserFactory.getBrowser();

            executed = true;
        }

        logger.info("set driver");
        localState.setDriver(globalDriver);
        logger.info("driver set");
    }

    @After(order = 7)
    public void cleanupAfterAllTests() {
        logger.info("All tests completed, cleaning up browser");
        if (globalDriver != null) {
            try {
                globalDriver.quit();
                globalDriver = null;
                executed = false;
            } catch (Exception e) {
                logger.warn("Error quitting browser: " + e.getMessage());
            }
        }
    }
}

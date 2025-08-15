package com.pulsar.cucumber.hooks.ui;

import com.pulsar.cucumber.runner.TestState;
import com.pulsar.selenium.driver.BrowserFactory;
import com.pulsar.selenium.driver.CustomWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class UIGlobalHooks {
    private static final Logger logger = Logger.getLogger(UIGlobalHooks.class.getName());

    private static boolean executed = false;

    private static CustomWebDriver globalDriver;

    private final TestState localState;

    public UIGlobalHooks(TestState localState) {
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



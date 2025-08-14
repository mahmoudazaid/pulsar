package com.pulsar.cucumber.hooks;

import com.pulsar.cucumber.runner.TestState;
import com.pulsar.utils.SystemProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;

public class UIScenarioHooks {
    private static final Logger logger = Logger.getLogger(UIScenarioHooks.class.getName());

    private final TestState state;

    public UIScenarioHooks(TestState state) {
        this.state = state;
    }

    @Before(order = 1)
    public void goToURL() {
        try {
            String url = SystemProperties.getApplicationUrl();
            if (state.getDriver() != null) {
                state.getDriver().goToUrl(url);
            }
        } catch (Exception ex) {
            logger.info("Problem happened when opening page");
            logger.info(ex.getMessage());
        }
    }

    @Before(order = 2)
    public void deleteCookiesBeforeScenario() {
        logger.info("delete cookies before");
        if (state.getDriver() != null) {
            try {
                state.getDriver().deleteAllCookies();
            } catch (Exception e) {
                logger.warn("Could not delete cookies: " + e.getMessage());
            }
        }
    }

    @Before(order = 3)
    public void logBeforeScenario(Scenario scenario) {
        String msg = "Entering scenario " + scenario.getName();
        logger.info(msg);
    }

    @After(order = 1)
    public void restartBrowserOnFailure(Scenario scenario) {
        logger.info("screenshot");
        if (scenario.isFailed()) {
            try {
                // Don't quit the browser on failure - let it continue for other tests
                logger.info("Test failed but keeping browser alive for other tests");
            } catch (Exception ex) {
                logger.error(String.format("Error handling test failure: %s", ex.getMessage()));
            }
        }
    }

    @After(order = 2)
    public void deleteCookiesAfterScenario() {
        logger.info("delete cookies after");
        if (state.getDriver() != null) {
            try {
                state.getDriver().deleteAllCookies();
            } catch (Exception e) {
                logger.warn("Could not delete cookies: " + e.getMessage());
            }
        }
    }

    @After(order = 3)
    public void logAfterScenario(Scenario scenario) {
        String msg = "Exiting scenario " + scenario.getName() + " with status " + scenario.getStatus();
        logger.info(msg);
    }
}

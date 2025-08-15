package com.pulsar.cucumber.hooks.ui;

import com.pulsar.cucumber.runner.TestState;
import com.pulsar.utils.SystemProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
                if (state.getDriver() != null && state.getDriver().getSeleniumWebDriver() instanceof TakesScreenshot) {
                    byte[] screenshot = ((TakesScreenshot) state.getDriver().getSeleniumWebDriver()).getScreenshotAs(OutputType.BYTES);
                    Allure.addAttachment("Failure Screenshot", "image/png", new java.io.ByteArrayInputStream(screenshot), ".png");
                }
                logger.info("Test failed; artifacts attached to Allure");
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



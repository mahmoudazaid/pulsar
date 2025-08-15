package com.pulsar.cucumber.hooks.ui;

import com.pulsar.cucumber.runner.TestState;
import com.pulsar.utils.SystemProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;
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
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                }
                // GIF capture removed
                // Attach a small HTML snippet for context
                try {
                    String html = "<html><body><h3>Failure Context</h3><p>See screenshot and GIF attachments above.</p></body></html>";
                    scenario.attach(html.getBytes(java.nio.charset.StandardCharsets.UTF_8), "text/html", "context.html");
                } catch (Exception ig) {
                    logger.warn("Could not attach HTML: " + ig.getMessage());
                }
                logger.info("Test failed; artifacts attached to report");
            } catch (Exception ex) {
                logger.error(String.format("Error handling test failure: %s", ex.getMessage()));
            }
        }
        // Always add a tiny debug attachment to verify adapter wiring
        try {
            byte[] hello = "debug: after hook executed".getBytes(java.nio.charset.StandardCharsets.UTF_8);
            scenario.attach(hello, "text/plain", "debug.txt");
        } catch (Exception ignored) {}
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



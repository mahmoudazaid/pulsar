package com.orange.cucumber.hooks;

import com.orange.cucumber.runner.TestState;
import com.orange.selenium.driver.BrowserFactory;
import com.orange.utils.SystemProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;

import static com.orange.selenium.locator.LoginPageLocator.LOADING_ELEMENT;

public class ScenarioHooks {
    private static final Logger logger = Logger.getLogger(ScenarioHooks.class.getName());
    private static final String URL = SystemProperties.getApplicationUrl();

    private final TestState state;

    public ScenarioHooks(TestState state) {
        if (state.getDriver().getSeleniumWebDriver().toString().contains("(null)")) {
            // Create the shared selenium web driver
            state.setDriver(BrowserFactory.getBrowser());
        }
        this.state = state;
    }

    @Before(order = 1)
    public void goToURL() throws Exception {
        try {
            state.getDriver().goToUrl(URL);
            state.getDriver().waitInvisibilityOf(LOADING_ELEMENT, 120);
        } catch (Exception ex) {
            logger.info("Problem happened when opening page");
            logger.info(ex.getMessage());
        }
    }

    @Before(order = 2)
    public void deleteCookiesBeforeScenario() {
        logger.info("delete cookies before");
        if (state.getDriver() != null) {
            state.getDriver().deleteAllCookies();
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
                if (state.getDriver() != null) {
                    logger.info("stop browser");
                    state.getDriver().quit();
                }
            } catch (Exception ex) {
                logger.error(String.format("stop browser because: %s", ex.getMessage()));
            }
        }
    }

    @After(order = 2)
    public void deleteCookiesAfterScenario() {
        logger.info("delete cookies after");
        if (state.getDriver() != null) {
            state.getDriver().deleteAllCookies();
        }
    }

    @After(order = 3)
    public void logAfterScenario(Scenario scenario) {
        String msg = "Exiting scenario " + scenario.getName() + " with status " + scenario.getStatus();
        logger.info(msg);
    }
}

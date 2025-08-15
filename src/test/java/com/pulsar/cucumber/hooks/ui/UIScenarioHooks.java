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
        // Do not attach artifacts here; handled in @AfterStep to embed under the step itself
    }

    @io.cucumber.java.AfterStep
    public void attachFailureScreenshotInHook(io.cucumber.java.Scenario scenario) {
        if (!scenario.isFailed()) {
            return;
        }
        try {
            if (state.getDriver() != null && state.getDriver().getSeleniumWebDriver() instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) state.getDriver().getSeleniumWebDriver()).getScreenshotAs(OutputType.BYTES);
                String b64 = java.util.Base64.getEncoder().encodeToString(screenshot);
                String descriptiveName = "Screenshot - " + scenario.getName();
                String htmlInline = "<html><head><style>body{font-family:Arial,Helvetica,sans-serif;margin:0;padding:8px} .shot{max-width:100%;height:auto;border:2px solid #e74c3c;border-radius:6px;box-shadow:0 1px 4px rgba(0,0,0,.1)}</style></head><body>"
                        + "<div><strong>" + descriptiveName + "</strong></div>"
                        + "<img class='shot' alt='failure screenshot' src='data:image/png;base64," + b64 + "'/></body></html>";
                scenario.attach(htmlInline.getBytes(java.nio.charset.StandardCharsets.UTF_8), "text/html", descriptiveName);
            }
        } catch (Exception ex) {
            logger.warn("Could not attach step-level inline screenshot from hook: " + ex.getMessage());
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



package com.orange.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

/**
 * Scenario hooks specifically for API testing
 * No WebDriver dependencies - only API-related scenario handling
 */
public class APIScenarioHooks {
    private static final Logger logger = Logger.getLogger(APIScenarioHooks.class.getName());

    @Before(order = 1)
    public void logBeforeScenario(Scenario scenario) {
        String msg = "Starting API scenario: " + scenario.getName();
        logger.info(msg);
        logger.info("Scenario tags: " + scenario.getSourceTagNames());
        
        // Log scenario details for API testing
        if (scenario.getSourceTagNames().contains("@performance")) {
            logger.info("Performance test scenario detected");
        }
        if (scenario.getSourceTagNames().contains("@security")) {
            logger.info("Security test scenario detected");
        }
    }

    @Before(order = 2)
    public void setupAPIScenario() {
        logger.info("Setting up API scenario environment");
        
        // Add any API-specific scenario setup here
        // For example: reset test data, set up authentication, etc.
        
        logger.info("API scenario setup completed");
    }

    @After(order = 1)
    public void logAfterScenario(Scenario scenario) {
        String status = scenario.getStatus().toString();
        String msg = "Completed API scenario: " + scenario.getName() + " with status: " + status;
        logger.info(msg);
        
        if (scenario.isFailed()) {
            logger.error("API scenario failed: " + scenario.getName());
            // Log any API-specific failure information
            if (scenario.getStatus().toString().contains("FAILED")) {
                logger.error("Scenario execution failed - check API logs for details");
            }
        } else {
            logger.info("API scenario passed successfully: " + scenario.getName());
        }
    }

    @After(order = 2)
    public void cleanupAPIScenario() {
        logger.info("Cleaning up API scenario environment");
        
        // Add any API-specific scenario cleanup here
        // For example: cleanup test data, close connections, etc.
        
        logger.info("API scenario cleanup completed");
    }

    @After(order = 3)
    public void logScenarioSummary(Scenario scenario) {
        String duration = scenario.getStatus().toString();
        logger.info("API Scenario Summary:");
        logger.info("  Name: " + scenario.getName());
        logger.info("  Status: " + scenario.getStatus());
        logger.info("  Tags: " + scenario.getSourceTagNames());
        
        // Add any additional API-specific logging here
        if (scenario.getSourceTagNames().contains("@create")) {
            logger.info("  Type: Create operation test");
        } else if (scenario.getSourceTagNames().contains("@read")) {
            logger.info("  Type: Read operation test");
        } else if (scenario.getSourceTagNames().contains("@update")) {
            logger.info("  Type: Update operation test");
        } else if (scenario.getSourceTagNames().contains("@delete")) {
            logger.info("  Type: Delete operation test");
        }
    }
} 
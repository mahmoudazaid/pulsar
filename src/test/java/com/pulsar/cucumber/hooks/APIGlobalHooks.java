package com.pulsar.cucumber.hooks;

import com.pulsar.api.config.ApiConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

/**
 * Global hooks specifically for API testing
 * No WebDriver dependencies - only API-related setup and teardown
 */
public class APIGlobalHooks {
    private static final Logger logger = Logger.getLogger(APIGlobalHooks.class.getName());
    private static boolean executed = false;

    @Before(order = 0)
    public void initializeAPI() {
        if (!executed) {
            logger.info("Initializing API test environment");
            
            // Print API configuration for debugging
            ApiConfig.printConfiguration();
            
            // Validate API configuration
            validateAPIConfiguration();
            
            executed = true;
            logger.info("API test environment initialized successfully");
        }
    }

    @After(order = 7)
    public void cleanupAPI() {
        logger.info("API tests completed, performing cleanup");
        
        // Add any API-specific cleanup here
        // For example: cleanup test data, close connections, etc.
        
        logger.info("API cleanup completed");
    }

    private void validateAPIConfiguration() {
        try {
            String baseUrl = ApiConfig.getBaseUrl();
            String authToken = ApiConfig.getAuthToken();
            
            if (baseUrl == null || baseUrl.trim().isEmpty()) {
                logger.error("API base URL is not configured");
                throw new IllegalStateException("API base URL is not configured");
            }
            
            if (authToken == null || authToken.trim().isEmpty()) {
                logger.error("API authentication token is not configured");
                throw new IllegalStateException("API authentication token is not configured");
            }
            
            if (!authToken.startsWith("Bearer ")) {
                logger.error("API authentication token should start with 'Bearer '");
                throw new IllegalStateException("API authentication token should start with 'Bearer '");
            }
            
            logger.info("API configuration validation passed");
            logger.info("Base URL: " + baseUrl);
            logger.info("Auth token configured: [REDACTED]");
            
        } catch (Exception e) {
            logger.error("API configuration validation failed: " + e.getMessage());
            throw new RuntimeException("API configuration validation failed", e);
        }
    }
} 
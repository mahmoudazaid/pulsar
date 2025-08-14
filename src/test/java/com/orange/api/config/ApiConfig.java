package com.orange.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration manager for API testing
 * Loads configuration from system.properties in main resources
 */
public class ApiConfig {
    
    private static final String SYSTEM_CONFIG_FILE = "system.properties";
    
    private static Properties properties;
    private static String currentEnvironment;
    
    static {
        loadConfiguration();
    }
    
    /**
     * Load configuration from system.properties file
     */
    private static void loadConfiguration() {
        properties = new Properties();
        
        // Load system properties (main resources)
        loadProperties(SYSTEM_CONFIG_FILE);
        
        // Load system properties (can override file properties)
        properties.putAll(System.getProperties());
        
        // Set current environment
        currentEnvironment = getString("env", "dev");
    }
    
    /**
     * Load properties from a specific file
     */
    private static void loadProperties(String configFile) {
        try (InputStream inputStream = ApiConfig.class.getClassLoader().getResourceAsStream(configFile)) {
            if (inputStream != null) {
                properties.load(inputStream);
                System.out.println("✅ Loaded configuration from: " + configFile);
            } else {
                System.err.println("❌ Configuration file not found: " + configFile);
            }
        } catch (IOException e) {
            System.err.println("❌ Error loading configuration from " + configFile + ": " + e.getMessage());
        }
    }
    
    /**
     * Get the current environment
     */
    public static String getEnvironment() {
        return currentEnvironment;
    }
    
    /**
     * Set the environment
     */
    public static void setEnvironment(String environment) {
        currentEnvironment = environment;
        loadConfiguration(); // Reload configuration
    }
    
    /**
     * Get a string property
     */
    public static String getString(String key) {
        return properties.getProperty(key);
    }
    
    /**
     * Get a string property with default value
     */
    public static String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    /**
     * Get an integer property
     */
    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
    
    /**
     * Get an integer property with default value
     */
    public static int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    /**
     * Get a boolean property
     */
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
    
    /**
     * Get a boolean property with default value
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        try {
            return Boolean.parseBoolean(properties.getProperty(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }
    
    /**
     * Get API base URL
     */
    public static String getBaseUrl() {
        return getString("api.base.url");
    }
    
    /**
     * Get users endpoint
     */
    public static String getUsersEndpoint() {
        return getString("api.users.endpoint");
    }
    
    /**
     * Get authentication token
     */
    public static String getAuthToken() {
        return getString("api.auth.token");
    }
    
    /**
     * Get connection timeout
     */
    public static int getConnectionTimeout() {
        return getInt("api.connection.timeout", 10000);
    }
    
    /**
     * Get read timeout
     */
    public static int getReadTimeout() {
        return getInt("api.read.timeout", 30000);
    }
    
    /**
     * Get rate limit delay
     */
    public static int getRateLimitDelay() {
        return getInt("api.rate.limit.delay", 1000);
    }
    
    /**
     * Get expected status code for operation
     */
    public static int getExpectedStatus(String operation) {
        return getInt("api.expected.status." + operation, 200);
    }
    
    /**
     * Get content type
     */
    public static String getContentType() {
        return getString("api.content.type.json", "application/json");
    }
    
    /**
     * Get accept header
     */
    public static String getAcceptHeader() {
        return getString("api.accept.json", "application/json");
    }
    
    /**
     * Get header name for content type
     */
    public static String getContentTypeHeaderName() {
        return getString("api.headers.content.type", "Content-Type");
    }
    
    /**
     * Get header name for authorization
     */
    public static String getAuthorizationHeaderName() {
        return getString("api.headers.authorization", "Authorization");
    }
    
    /**
     * Get header name for accept
     */
    public static String getAcceptHeaderName() {
        return getString("api.headers.accept", "Accept");
    }
    
    /**
     * Get test user count
     */
    public static int getTestUserCount() {
        return getInt("api.test.users.count", 5);
    }
    
    /**
     * Get test user prefix
     */
    public static String getTestUserPrefix() {
        return getString("api.test.user.prefix", "TestUser");
    }
    
    /**
     * Get test email domain
     */
    public static String getTestEmailDomain() {
        return getString("api.test.email.domain", "@example.com");
    }
    
    /**
     * Check if logging is enabled for request body
     */
    public static boolean isRequestBodyLoggingEnabled() {
        return getBoolean("api.logging.show.request.body", false);
    }
    
    /**
     * Check if logging is enabled for response body
     */
    public static boolean isResponseBodyLoggingEnabled() {
        return getBoolean("api.logging.show.response.body", false);
    }
    
    /**
     * Get logging level
     */
    public static String getLoggingLevel() {
        return getString("api.logging.level", "INFO");
    }
    
    /**
     * Check if retry is enabled
     */
    public static boolean isRetryEnabled() {
        return getBoolean("api.retry.enabled", false);
    }
    
    /**
     * Get max retry attempts
     */
    public static int getMaxRetryAttempts() {
        return getInt("api.retry.max.attempts", 1);
    }
    
    /**
     * Check if performance testing is enabled
     */
    public static boolean isPerformanceTestEnabled() {
        return getBoolean("api.performance.test.enabled", false);
    }
    
    /**
     * Get performance test timeout
     */
    public static int getPerformanceTestTimeout() {
        return getInt("api.performance.timeout", 60000);
    }
    
    /**
     * Print current configuration
     */
    public static void printConfiguration() {
        System.out.println("🔧 Current API Configuration:");
        System.out.println("   Environment: " + getEnvironment());
        System.out.println("   Base URL: " + getBaseUrl());
        System.out.println("   Users Endpoint: " + getUsersEndpoint());
        System.out.println("   Connection Timeout: " + getConnectionTimeout() + "ms");
        System.out.println("   Read Timeout: " + getReadTimeout() + "ms");
        System.out.println("   Rate Limit Delay: " + getRateLimitDelay() + "ms");
        System.out.println("   Test User Count: " + getTestUserCount());
        System.out.println("   Logging Level: " + getLoggingLevel());
        System.out.println("   Request Body Logging: " + isRequestBodyLoggingEnabled());
        System.out.println("   Response Body Logging: " + isResponseBodyLoggingEnabled());
    }
} 
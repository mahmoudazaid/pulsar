package com.pulsar.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pulsar.api.config.ApiConfig;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.net.http.HttpClient;
import java.time.Duration;

/**
 * Base class for API tests providing common HTTP client functionality
 */
public abstract class BaseApiTest {
    
    protected HttpClient httpClient;
    protected ObjectMapper objectMapper;
    
    @BeforeClass
    public void setUpClass() {
        // Print current configuration
        ApiConfig.printConfiguration();
        
        // Initialize HTTP client with configured timeouts
        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(ApiConfig.getConnectionTimeout()))
                .build();
        
        objectMapper = new ObjectMapper();
    }
    
    @BeforeMethod
    public void setUpMethod() {
        // Reset any test state if needed
    }
    
    /**
     * Log request details if logging is enabled
     */
    protected void logRequest(String method, String url, String body) {
        if (ApiConfig.isRequestBodyLoggingEnabled()) {
            System.out.println("📤 " + method + " " + url);
            if (body != null && !body.isEmpty()) {
                System.out.println("📝 Request Body: " + body);
                try {
                    Allure.addAttachment("API Request - " + method + " " + url, "application/json", new java.io.ByteArrayInputStream(body.getBytes(java.nio.charset.StandardCharsets.UTF_8)), ".json");
                } catch (Exception ignored) {}
            }
        }
    }
    
    /**
     * Log response details if logging is enabled
     */
    protected void logResponse(int statusCode, String body) {
        if (ApiConfig.isResponseBodyLoggingEnabled()) {
            System.out.println("📥 Response Status: " + statusCode);
            if (body != null && !body.isEmpty()) {
                System.out.println("📄 Response Body: " + body);
                try {
                    Allure.addAttachment("API Response - Status " + statusCode, "application/json", new java.io.ByteArrayInputStream(body.getBytes(java.nio.charset.StandardCharsets.UTF_8)), ".json");
                } catch (Exception ignored) {}
            }
        }
    }
} 
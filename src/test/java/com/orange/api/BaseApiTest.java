package com.orange.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.api.config.ApiConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
     * Execute HTTP request and return response
     */
    protected HttpResponse<String> executeRequest(HttpRequest request) throws IOException, InterruptedException {
        // Add rate limiting delay if configured
        if (ApiConfig.getRateLimitDelay() > 0) {
            try {
                Thread.sleep(ApiConfig.getRateLimitDelay());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
    
    /**
     * Validate HTTP status code
     */
    protected void validateStatusCode(HttpResponse<String> response, int expectedStatusCode) {
        assert response.statusCode() == expectedStatusCode : 
            String.format("Expected status code %d, but got %d", expectedStatusCode, response.statusCode());
    }
    
    /**
     * Validate response is not null and not empty
     */
    protected void validateResponseBody(HttpResponse<String> response) {
        assert response.body() != null : "Response body should not be null";
        assert !response.body().trim().isEmpty() : "Response body should not be empty";
    }
    
    /**
     * Validate response contains expected content type
     */
    protected void validateContentType(HttpResponse<String> response, String expectedContentType) {
        String actualContentType = response.headers().firstValue("content-type").orElse("");
        assert actualContentType.contains(expectedContentType) : 
            String.format("Expected content type containing '%s', but got '%s'", expectedContentType, actualContentType);
    }
    
    /**
     * Validate JSON response schema (basic validation)
     */
    protected void validateJsonSchema(HttpResponse<String> response) {
        try {
            objectMapper.readTree(response.body());
        } catch (Exception e) {
            throw new AssertionError("Response is not valid JSON: " + e.getMessage());
        }
    }
    
    /**
     * Log request details if logging is enabled
     */
    protected void logRequest(String method, String url, String body) {
        if (ApiConfig.isRequestBodyLoggingEnabled()) {
            System.out.println("📤 " + method + " " + url);
            if (body != null && !body.isEmpty()) {
                System.out.println("📝 Request Body: " + body);
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
            }
        }
    }
} 
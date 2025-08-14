package com.pulsar.api.service;

import com.pulsar.api.BaseApiTest;
import com.pulsar.api.config.ApiConfig;
import com.pulsar.api.model.User;
import com.pulsar.utils.TestDataGenerator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Service class for handling User API operations
 */
public class UserApiService extends BaseApiTest {
    
    private final java.net.http.HttpClient httpClient;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;
    
    public UserApiService() {
        // Initialize HTTP client and object mapper for this service
        this.httpClient = java.net.http.HttpClient.newBuilder()
                .connectTimeout(java.time.Duration.ofMillis(com.pulsar.api.config.ApiConfig.getConnectionTimeout()))
                .build();
        
        this.objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
    }
    
    /**
     * Create a new user
     */
    public HttpResponse<String> createUser(User user) throws IOException, InterruptedException {
        String userJson = objectMapper.writeValueAsString(user);
        
        // Log request if enabled
        logRequest("POST", ApiConfig.getBaseUrl() + ApiConfig.getUsersEndpoint(), userJson);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ApiConfig.getBaseUrl() + ApiConfig.getUsersEndpoint()))
                .header(ApiConfig.getContentTypeHeaderName(), ApiConfig.getContentType())
                .header(ApiConfig.getAuthorizationHeaderName(), ApiConfig.getAuthToken())
                .POST(HttpRequest.BodyPublishers.ofString(userJson))
                .build();
        
        HttpResponse<String> response = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        
        // Log response if enabled
        logResponse(response.statusCode(), response.body());
        
        return response;
    }

    /**
     * Delete user by ID
     */
    public HttpResponse<String> deleteUser(int userId) throws IOException, InterruptedException {
        String url = ApiConfig.getBaseUrl() + ApiConfig.getUsersEndpoint() + "/" + userId;
        
        // Log request if enabled
        logRequest("DELETE", url, null);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header(ApiConfig.getAuthorizationHeaderName(), ApiConfig.getAuthToken())
                .DELETE()
                .build();
        
        HttpResponse<String> response = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        
        // Log response if enabled
        logResponse(response.statusCode(), response.body());
        
        return response;
    }
    
    /**
     * Create a test user with sample data
     */
    public User createTestUser() {
        return TestDataGenerator.generateRandomUser();
    }
} 
package com.orange.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.orange.api.BaseApiTest;
import com.orange.api.config.ApiConfig;
import com.orange.api.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Service class for handling User API operations
 */
public class UserApiService extends BaseApiTest {
    
    private final java.net.http.HttpClient httpClient;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;
    
    public UserApiService() {
        // Initialize HTTP client and object mapper for this service
        this.httpClient = java.net.http.HttpClient.newBuilder()
                .connectTimeout(java.time.Duration.ofMillis(com.orange.api.config.ApiConfig.getConnectionTimeout()))
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
     * Get all users
     */
    public HttpResponse<String> getAllUsers() throws IOException, InterruptedException {
        // Log request if enabled
        logRequest("GET", ApiConfig.getBaseUrl() + ApiConfig.getUsersEndpoint(), null);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ApiConfig.getBaseUrl() + ApiConfig.getUsersEndpoint()))
                .header(ApiConfig.getAcceptHeaderName(), ApiConfig.getAcceptHeader())
                .GET()
                .build();
        
        HttpResponse<String> response = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        
        // Log response if enabled
        logResponse(response.statusCode(), response.body());
        
        return response;
    }
    
    /**
     * Get user by ID
     */
    public HttpResponse<String> getUserById(int userId) throws IOException, InterruptedException {
        String url = ApiConfig.getBaseUrl() + ApiConfig.getUsersEndpoint() + "/" + userId;
        
        // Log request if enabled
        logRequest("GET", url, null);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header(ApiConfig.getAcceptHeaderName(), ApiConfig.getAcceptHeader())
                .GET()
                .build();
        
        HttpResponse<String> response = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        
        // Log response if enabled
        logResponse(response.statusCode(), response.body());
        
        return response;
    }
    
    /**
     * Update user by ID
     */
    public HttpResponse<String> updateUser(int userId, User user) throws IOException, InterruptedException {
        String userJson = objectMapper.writeValueAsString(user);
        String url = ApiConfig.getBaseUrl() + ApiConfig.getUsersEndpoint() + "/" + userId;
        
        // Log request if enabled
        logRequest("PUT", url, userJson);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header(ApiConfig.getContentTypeHeaderName(), ApiConfig.getContentType())
                .header(ApiConfig.getAuthorizationHeaderName(), ApiConfig.getAuthToken())
                .PUT(HttpRequest.BodyPublishers.ofString(userJson))
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
     * Parse response to User object
     */
    public User parseUserFromResponse(HttpResponse<String> response) throws IOException {
        return objectMapper.readValue(response.body(), User.class);
    }
    
    /**
     * Parse response to List of User objects
     */
    public List<User> parseUsersFromResponse(HttpResponse<String> response) throws IOException {
        return objectMapper.readValue(response.body(), new TypeReference<List<User>>() {});
    }
    
    /**
     * Create a test user with sample data
     */
    public User createTestUser() {
        return new User(
            ApiConfig.getTestUserPrefix() + " " + System.currentTimeMillis(),
            "testuser" + System.currentTimeMillis() + ApiConfig.getTestEmailDomain(),
            "male",
            "active"
        );
    }
    
    /**
     * Create a test user with custom data
     */
    public User createTestUser(String name, String email, String gender, String status) {
        return new User(name, email, gender, status);
    }
    
    /**
     * Create multiple test users for performance testing
     */
    public List<User> createMultipleTestUsers(int count) {
        List<User> users = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(createTestUser());
        }
        return users;
    }
} 
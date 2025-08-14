package com.orange.cucumber.stepDef.api;

import com.orange.api.BaseApiTest;
import com.orange.api.config.ApiConfig;
import com.orange.api.model.User;
import com.orange.api.service.UserApiService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Step definitions for API testing
 * Implements steps for Create a new user successfully scenario
 */
public class UsersCrud extends BaseApiTest {
    
    private UserApiService userApiService;
    private HttpResponse<String> lastResponse;
    private User testUser;
    private List<User> createdUsers;
    
    @Before
    public void setUp() {
        // Initialize HTTP client and object mapper for API testing
        httpClient = java.net.http.HttpClient.newBuilder()
                .connectTimeout(java.time.Duration.ofMillis(com.orange.api.config.ApiConfig.getConnectionTimeout()))
                .build();
        
        objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        
        userApiService = new UserApiService();
        createdUsers = new java.util.ArrayList<>();
    }
    
    @After
    public void tearDown() {
        // Clean up created users
        if (createdUsers != null) {
            for (User user : createdUsers) {
                if (user.getId() != null) {
                    try {
                        userApiService.deleteUser(user.getId());
                        System.out.println("🧹 Cleaned up test user with ID: " + user.getId());
                    } catch (Exception e) {
                        System.out.println("⚠️ Failed to clean up test user: " + e.getMessage());
                    }
                }
            }
        }
    }
    
    // Background steps
    @Given("the API base URL is configured")
    public void theApiBaseUrlIsConfigured() {
        String baseUrl = ApiConfig.getBaseUrl();
        Assert.assertNotNull(baseUrl, "API base URL should be configured");
        Assert.assertFalse(baseUrl.trim().isEmpty(), "API base URL should not be empty");
        System.out.println("✅ API base URL configured: " + baseUrl);
    }
    
    @Given("I have a valid authentication token")
    public void iHaveAValidAuthenticationToken() {
        String authToken = ApiConfig.getAuthToken();
        Assert.assertNotNull(authToken, "Authentication token should be configured");
        Assert.assertFalse(authToken.trim().isEmpty(), "Authentication token should not be empty");
        Assert.assertTrue(authToken.startsWith("Bearer "), "Authentication token should start with 'Bearer '");
        System.out.println("✅ Authentication token configured");
    }
    
    @Given("I prepare test user data")
    public void iPrepareTestUserData() {
        testUser = userApiService.createTestUser();
        Assert.assertNotNull(testUser, "Test user should be created");
        System.out.println("✅ Test user data prepared: " + testUser.getName());
    }
    
    // Create user steps
    @When("I send a POST request to create a new user with the following data:")
    public void iSendAPostRequestToCreateANewUserWithTheFollowingData(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
        List<List<String>> rows = dataTable.asLists();
        List<String> headers = rows.get(0);
        List<String> values = rows.get(1);
        
        User user = new User(
            values.get(0), // name
            values.get(1), // email
            values.get(2), // gender
            values.get(3)  // status
        );
        
        lastResponse = userApiService.createUser(user);
        System.out.println("📤 Created user: " + user.getName());
        
        // Add to cleanup list
        if (lastResponse.statusCode() == 201) {
            try {
                User createdUser = objectMapper.readValue(lastResponse.body(), User.class);
                if (createdUser.getId() != null) {
                    createdUsers.add(createdUser);
                }
            } catch (Exception e) {
                System.out.println("⚠️ Could not parse created user for cleanup: " + e.getMessage());
            }
        }
    }
    
    // Response validation steps
    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertNotNull(lastResponse, "Response should exist");
        Assert.assertEquals(lastResponse.statusCode(), expectedStatusCode, 
            "Expected status code " + expectedStatusCode + ", but got " + lastResponse.statusCode());
        System.out.println("✅ Response status code: " + lastResponse.statusCode());
    }
    
    @Then("the response should contain valid JSON")
    public void theResponseShouldContainValidJson() {
        Assert.assertNotNull(lastResponse, "Response should exist");
        Assert.assertNotNull(lastResponse.body(), "Response body should not be null");
        Assert.assertFalse(lastResponse.body().trim().isEmpty(), "Response body should not be empty");
        
        try {
            objectMapper.readTree(lastResponse.body());
            System.out.println("✅ Response contains valid JSON");
        } catch (Exception e) {
            Assert.fail("Response should contain valid JSON: " + e.getMessage());
        }
    }
    
    @Then("the response should contain the created user data")
    public void theResponseShouldContainTheCreatedUserData() {
        Assert.assertNotNull(lastResponse, "Response should exist");
        Assert.assertNotNull(lastResponse.body(), "Response body should not be null");
        
        try {
            User createdUser = objectMapper.readValue(lastResponse.body(), User.class);
            Assert.assertNotNull(createdUser, "Created user should not be null");
            Assert.assertNotNull(createdUser.getName(), "User name should not be null");
            Assert.assertNotNull(createdUser.getEmail(), "User email should not be null");
            Assert.assertNotNull(createdUser.getGender(), "User gender should not be null");
            Assert.assertNotNull(createdUser.getStatus(), "User status should not be null");
            
            System.out.println("✅ Response contains created user data: " + createdUser.getName());
        } catch (Exception e) {
            Assert.fail("Response should contain created user data: " + e.getMessage());
        }
    }
    
    @Then("the user should have a unique ID")
    public void theUserShouldHaveAUniqueId() {
        Assert.assertNotNull(lastResponse, "Response should exist");
        Assert.assertNotNull(lastResponse.body(), "Response body should not be null");
        
        try {
            User createdUser = objectMapper.readValue(lastResponse.body(), User.class);
            Assert.assertNotNull(createdUser.getId(), "User ID should not be null");
            Assert.assertTrue(createdUser.getId() > 0, "User ID should be a positive integer");
            
            System.out.println("✅ User has unique ID: " + createdUser.getId());
        } catch (Exception e) {
            Assert.fail("User should have a unique ID: " + e.getMessage());
        }
    }
} 
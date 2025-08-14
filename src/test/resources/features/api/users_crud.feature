@api @users @crud
Feature: User API CRUD Operations
  As a system administrator
  I want to manage users through the API
  So that I can perform create, read, update, and delete operations

  @create @smoke
  Scenario: Create a new user successfully
    Given the API base URL is configured
    And I have a valid authentication token
    And I prepare test user data
    When I send a POST request to create a new user
    Then the response status code should be 201
    And the response should contain valid JSON
    And the response should contain the created user data
    And the user should have a unique ID

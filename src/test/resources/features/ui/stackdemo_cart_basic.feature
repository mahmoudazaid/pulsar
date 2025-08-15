@ui
Feature: StackDemo Cart Basic Functionality
  As a user
  I want to add items to my cart
  So that I can purchase them later

  Scenario: Add item to cart
    Given I am on the StackDemo Home Page
    And I am browsing the product catalog
    When I add a product "iPhone 12" to cart
    Then the item should be added to my cart
    And the cart count should show "5"

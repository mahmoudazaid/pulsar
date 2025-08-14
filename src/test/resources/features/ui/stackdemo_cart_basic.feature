@ui @smoke @cart
Feature: StackDemo Cart Basic Functionality
  As a user
  I want to add items to my cart
  So that I can purchase them later

  Background:
    Given I am on the StackDemo Home Page

  @add_to_cart
  Scenario: Add item to cart
    Given I am browsing the product catalog
    When I add a product "iPhone 12" to cart
    Then the item should be added to my cart
    And the cart count should show "1"
Feature: StackDemo Basic Cart Operations
  As a user on StackDemo site
  I want to perform basic cart operations
  So that I can manage my shopping cart effectively

  @smoke @cart
  Scenario: Add item to cart
    Given I am on the StackDemo Home Page
    And I am browsing the product catalog
    And I add a product "iPhone 12" to cart
    Then the item should be added to my cart
    And the cart count should show "1"
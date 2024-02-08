@Regression
Feature: Guest place an order

  Scenario: Use default payment option
    Given I am a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email    |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | as@b.com |
    And I have 1 "Blue Shoes" in the Cart
    And I am on the Checkout Page
    And I provide billing details
    And I place an order
    Then the order should be placed successfully
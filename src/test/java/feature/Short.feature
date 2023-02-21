Feature: verify Shorting Functionality
  Scenario: Product Shorting functionality
    Given user is on landing page
    Then user choose the product category
    When user chooses the shorting option

    Then products are shorted in selected order


Feature: Shopping Cart

  Scenario: to verify that items are added to cart section
    Given user is at landing page
    And  user proceed to Login link
    When  User Search for Product
    And   User adds items to the cart
    And  user clicks on Shopping cart
    Then  Valadating items number


    Scenario: to verify the total price of the cart
      Given user at  landing page
      When   user search for product
      And    User add items to the cart
      And  user click on Shopping cart
      Then user validates the price and quantity

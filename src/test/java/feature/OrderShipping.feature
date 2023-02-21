Feature: Product is successfully ordered
  @smoke
  Scenario Outline: verify OrderId is gentrated on successful Shipping
    Given user is on landing page
    Then  user provides credential using "<filename>" and "<key>"
    Then  user selects the products
    And   user Proceeds to shopping cart and checkout
    When  user  fills neccessary details for shipping
    Then Orderid should be displayed
    Examples:
      | filename | key  |
      |Credential| user2|

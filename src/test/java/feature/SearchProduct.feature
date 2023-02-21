Feature:  Search Functionality
  @smoke
  Scenario Outline: Search Function gives Proper result
    Given user at  landing page
    Then  user  login into website "<fileName>"and "<key>"
    When user searches for particular product
    Then Results shown are matches with the  product page and product searched
    Examples:
      | fileName | key  |
      |Credential| user2|

Feature: Testing  Login functionality
  Scenario Outline: Login experience with vaild credential
    Given user is on landing page
    And user proceeds to Login link
    When user provides "<fileName>" and "<key>"
    Then user is on HomePage
    Examples:
      | fileName | key  |
      |Credential| user1|


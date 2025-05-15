Feature: Login

  @Test1 @Login @Positive
  Scenario: Login
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result

  @Test2 @Login @Negative
  Scenario: Login invalid username and password
    Given User is on login page
    When User invalid fill username and password
    And User click login button
    Then User get error message
Feature: login validation
  @Login
  Scenario: Verify valid credentials
    Given User is on the login page
    When the user tries to login the application with "Admin" and "admin123"
    Then the user should successfully login to the application

  Scenario: Verify invalid credentials
    Given User is on the login page
    When the user tries to login the application with "Admin" and "admin1234"
    Then the user should successfully login to the application

  @MultiLogin
  Scenario: Verify multiple credentials
    Given User is on the login page
    When the user tries to login the application with following credentials
    |username|password|
    |Admin   |admin123|
    |Shiji   |Shiji123|
    Then the user should successfully login to the application
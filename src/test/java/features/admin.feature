Feature: admin page scenarios


  Background:
    Given User is on the login page
    When the user tries to login the application with "Admin" and "admin123"
    And the user is redirected to the admin page

  @Admin
  Scenario: Verify user details

    And the user searches for a username with "Admin"
    Then the user should see the details of "Admin"

  @Admin
  Scenario: Verify user details
    And the user searches for a username with "Shiji"
    Then the user should see the details of "Admin"


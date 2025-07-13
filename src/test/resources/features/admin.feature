@admin
Feature: Admin Page Access

  As a user
  I want to access the admin page from the homepage
  So that I can attempt to log in as an administrator

  Background:
    Given I am on the homepage

  @navigation
  Scenario: Navigate to Admin login page
    When I click the admin button
    Then I should be navigated to the admin login page

  @negative
  Scenario: Attempt to login to admin with invalid credentials
    When I click the admin button
    And I enter "test@example.com" in the admin username field
    And I enter "invalidpassword" in the admin password field
    And I click the login button
    Then I should see an adminpage error message saying "Invalid credentials"

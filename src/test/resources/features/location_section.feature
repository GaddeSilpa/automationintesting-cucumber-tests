@location
Feature: View the location information of the guesthouse

  As a user
  I want to click the location button
  So that I can view the address and map of the guesthouse

  Background:
    Given I am on the homepage

  @positive
  Scenario: Navigate to location section using the location button
    When I click on the location button
    Then I should see the location section
    And I should see the address "Shady Meadows B&B, Shadows valley, Newingtonfordburyshire, Dilbery, N1 1AA"

  @positive
  Scenario: Verify contact details under location
    When I click on the location button
    Then I should see the email "fake@fakeemail.com"
    And I should see the phone number "012345678901"



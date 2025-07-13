Feature: Home Page

  Scenario Outline: Verify Home Page Title and Welcome Message Book Button
    Given I launch the browser
    When I open the application
    Then I should see the homepage title contains <expectedTitle>
    And the welcome message should be <message>
    Examples:
      | expectedTitle    | message                        |
      | "Restful-booker" | "Welcome to Shady Meadows B&B" |

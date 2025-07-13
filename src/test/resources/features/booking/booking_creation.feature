@booking @creation
Feature: Booking Creation on Automation In Testing website

  As a user
  I want to be able to create a booking
  So that I can reserve a room on the website
  Background:
    Given I am on the homepage
  @positive
  Scenario: Verify rooms are listed
    When I click on the book now button
    Then I should see the following rooms:
      | Single |
      | Double |
      | Suite  |


@positive
Scenario Outline: Create a valid booking with required details
  When I enter "<firstname>" in the firstname field
  And I enter "<lastname>" in the lastname field
  And I enter "<email>" in the booking email field
  And I enter "<phone>" in the booking phone field
  And I select the room with name "<roomname>"
  And I click the Book button
  Then I should see the booking confirmation message

  Examples:
    | firstname | lastname | email                | phone       | roomname | checkin    | checkout   |
    | John      | Doe      | john.doe@email.com   | 07456685795 | Single   | 2025-07-20 | 2025-07-22 |
    | Jane      | Smith    | jane.smith@email.com | 07456685798 | Double   | 2025-07-15 | 2025-07-18 |
    | Ram       | dev      | jane.smith@email.com | 07456685793 | Suite    | 2025-07-15 | 2025-07-18 |


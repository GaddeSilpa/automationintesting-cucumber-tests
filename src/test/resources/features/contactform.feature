@contact
Feature: Contact Form Submission

  As a user
  I want to be able to submit a message using the contact form
  So that the admin receives my inquiries

  Background:
    Given I am on the contact form section of the homepage

  @positive
  Scenario Outline: Successfully submit contact form with valid details
    When I enter "<name>" in the contact form name field
    And I enter "<email>" in the contact form email field
    And I enter "<phone>" in the contact form phone field
    And I enter "<subject>" in the subject field
    And I enter "<message>" in the message field
    And I click the submit button
    Then I should see a success message saying "Thanks for getting in touch"

    Examples:
      | name     | email            | subject       | message                                    | phone       |
      | John Doe | john@example.com | Booking Issue | I have a question about booking the room. | 07653476843 |


  @negative
  Scenario: Submit contact form with missing required fields
    When I click the submit button
    Then I should see validation errors for all required fields

  @negative
  Scenario: Submit contact form with invalid email
    When I enter the following contact form details:
      | name    | Test User                                       |
      | email   | Invalid Email                                   |
      | subject | Enquire about room services.                    |
      | message | This is a test message to test email validation |
      | phone   | 07546545467                                     |
    And I click the submit button
    Then I should see an contactform error message saying "must be a well-formed email address"



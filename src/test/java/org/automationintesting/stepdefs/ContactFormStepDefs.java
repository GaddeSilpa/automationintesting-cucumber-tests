package org.automationintesting.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.automationintesting.pages.ContactPage;
import org.automationintesting.util.BasePage;
import org.testng.Assert;

import java.util.Map;

import static org.testng.Assert.assertTrue;


public class ContactFormStepDefs extends BasePage {

    ContactPage contactPage = new ContactPage(driver);

    @Given("I am on the contact form section of the homepage")
    public void i_am_on_contact_form_section() {
        contactPage.gotoContactForm();
        // assertTrue("Contact form not visible", contactPage.isContactFormVisible());
    }

    @When("I enter {string} in the contact form name field")
    public void i_enter_name(String name) {
        contactPage.enterName(name);
    }

    @When("I enter {string} in the contact form email field")
    public void i_enter_email(String email) {
        contactPage.enterEmail(email);
    }

    @When("I enter {string} in the contact form phone field")
    public void i_enter_phone(String phone) {
        contactPage.enterPhone(phone);
    }


    @When("I enter {string} in the subject field")
    public void i_enter_subject(String subject) {
        contactPage.enterSubject(subject);
    }

    @When("I enter {string} in the message field")
    public void i_enter_message(String message) {
        contactPage.enterMessage(message);
    }

    @When("I click the submit button")
    public void i_click_submit_button() {
        contactPage.clickSubmitButton();
    }

    @Then("I should see a success message saying {string}")
    public void i_should_see_success_message(String expectedMessage) {
        String actualMessage = contactPage.getSuccessMessage();
        // Assert.assertEquals(expectedMessage, actualMessage);*/
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message to contain: \"" + expectedMessage + "\", but got: \"" + actualMessage + "\"");

    }

    @Then("I should see validation errors for all required fields")
    public void i_should_see_validation_errors_for_required_fields() {
        assertTrue(contactPage.isNameValidationErrorDisplayed(), "Name error not displayed");
        assertTrue(contactPage.isEmailValidationErrorDisplayed(), "Email error not displayed");
        assertTrue(contactPage.isSubjectValidationErrorDisplayed(), "Subject error not displayed");
        assertTrue(contactPage.isMessageValidationErrorDisplayed(), "Message error not displayed");
    }

    @When("I enter the following contact form details:")
    public void i_enter_contact_form_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();

        if (data.containsKey("name")) contactPage.enterName(data.get("name"));
        if (data.containsKey("email")) contactPage.enterEmail(data.get("email"));
        if (data.containsKey("phone")) contactPage.enterPhone(data.get("phone"));
        if (data.containsKey("subject")) contactPage.enterSubject(data.get("subject"));
        if (data.containsKey("message")) contactPage.enterMessage(data.get("message"));
    }

    @Then("I should see an contactform error message saying {string}")
    public void i_should_see_error_message(String expectedMessage) {
        String actualError = contactPage.getEmailValidationError();
        Assert.assertTrue(actualError.contains(expectedMessage),
                "Expected error message to contain: \"" + expectedMessage + "\", but got: \"" + actualError + "\"");
    }

}


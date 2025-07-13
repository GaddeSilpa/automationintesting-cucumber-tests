package org.automationintesting.stepdefs;

import io.cucumber.java.en.*;
import org.automationintesting.pages.AdminPage;
import org.automationintesting.util.BasePage;
import org.testng.Assert;

    public class AdminStepDefs extends BasePage {

        AdminPage adminPage = new AdminPage(driver);

        @When("I click the admin button")
        public void i_click_the_admin_button() {
            adminPage.clickAdminButton();
        }

        @Then("I should be navigated to the admin login page")
        public void i_should_be_navigated_to_admin_login_page() {
            Assert.assertTrue(driver.getCurrentUrl().contains("admin"), "Not navigated to admin page.");
        }

        @When("I enter {string} in the admin username field")
        public void i_enter_username_in_admin_field(String email) {
            adminPage.userName(email);
        }

        @When("I enter {string} in the admin password field")
        public void i_enter_password_in_admin_field(String password) {
            adminPage.enterPassword(password);
        }

        @When("I click the login button")
        public void i_click_the_login_button() {
            adminPage.clickLoginButton();
        }

        @Then("I should see an adminpage error message saying {string}")
        public void i_should_see_admin_login_error(String expectedError) {
            Assert.assertTrue(adminPage.getErrorMessage().contains(expectedError),
                    "Expected error message not shown.");
        }
    }


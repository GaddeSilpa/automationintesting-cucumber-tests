package org.automationintesting.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationintesting.pages.HomePage;
import org.automationintesting.util.BasePage;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class HomeStepDefs extends BasePage {

    private HomePage homePage;

    @Given("I launch the browser")
    public void i_launch_the_browser() {

    }

    @When("I open the application")
    public void i_open_the_application() {
        homePage = new HomePage(driver);

    }

    @Then("I should see the homepage title contains {string}")
    public void i_should_see_the_homepage_title_contains(String expectedTitle) {
        assertTrue(homePage.VerifyPageTitle().contains(expectedTitle));

    }

    @Then("the welcome message should be {string}")
    public void the_welcome_message_should_be(String message) {
        Assert.assertEquals(message, homePage.welcomeMessage());

    }


}

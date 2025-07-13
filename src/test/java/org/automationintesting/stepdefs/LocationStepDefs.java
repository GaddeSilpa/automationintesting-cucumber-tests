package org.automationintesting.stepdefs;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationintesting.pages.LocationPage;
import org.automationintesting.pages.HomePage;
import org.automationintesting.util.BasePage;
import org.testng.Assert;

public class LocationStepDefs extends BasePage {

    HomePage homePage = new HomePage(driver);
    LocationPage locationPage = new LocationPage(driver);

    @When("I click on the location button")
    public void i_click_on_the_location_button() {
        homePage.clickLocationButton();
    }

    @Then("I should see the location section")
    public void i_should_see_the_location_section() {
        Assert.assertTrue(locationPage.isLocationSectionVisible());
    }

    @Then("I should see the address {string}")
    public void i_should_see_the_address(String expectedAddress) {
        Assert.assertTrue(locationPage.getAddressText().contains(expectedAddress));
    }


    @Then("I should see the email {string}")
    public void i_should_see_the_email(String expectedEmail) {
        Assert.assertEquals(locationPage.getEmailText(), expectedEmail);
    }

    @Then("I should see the phone number {string}")
    public void i_should_see_the_phone_number(String expectedPhone) {
        Assert.assertEquals(locationPage.getPhoneNumberText(), expectedPhone);
    }


}



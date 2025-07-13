package org.automationintesting.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationintesting.pages.BookingPage;
import org.automationintesting.util.BasePage;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingStepDefs extends BasePage {

    private Map<String, String> testData = new HashMap<>();
    private BookingPage bookingPage = new BookingPage(driver);

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {

    }

    @When("I click on the book now button")
    public void i_click_on_the_book_now_button() {

        bookingPage.clickBookNowButton();
    }

    @Then("I should see the following rooms:")
    public void i_should_see_the_following_rooms(List<String> expectedRooms) {
        boolean result = bookingPage.areRoomsVisible(expectedRooms);

        if (!result) {
            throw new AssertionError("Room list mismatch!\nExpected: " +
                    expectedRooms + "\nBut found: " + bookingPage.getVisibleRooms());
        }
    }

    @When("I enter {string} in the firstname field")
    public void i_enter_firstname(String firstname) {
        bookingPage.scrollDown();
        testData.put("firstname", firstname);
    }

    @When("I enter {string} in the lastname field")
    public void i_enter_lastname(String lastname) {
        testData.put("lastname", lastname);
    }

    @When("I enter {string} in the booking email field")
    public void i_enter_email(String email) {
        testData.put("email", email);
    }

    @When("I enter {string} in the booking phone field")
    public void i_enter_phone(String phone) {
        testData.put("phone", phone);
    }

    @When("I select the room with name {string}")
    public void i_select_room(String roomname) {
        testData.put("roomname", roomname);
    }

    @When("I click the Book button")
    public void i_click_book_button() {
        boolean booked = bookingPage.bookRoom(
                testData.get("roomname"),
                testData.get("firstname"),
                testData.get("lastname"),
                testData.get("email"),
                testData.get("phone")
        );
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout"),
                "Booking failed. Expected URL to contain 'checkout', but was: " + currentUrl

        );
    }

    @Then("I should see the booking confirmation message")
    public void i_should_see_booking_confirmation() {
        Assert.assertTrue(bookingPage.isBookingConfirmed());
    }

    @When("I click the Book button without entering any details")
    public void i_click_book_button_without_entering_details() {
        bookingPage.scrollDown(); // optional if needed
        bookingPage.clickReserveNow(); // or elementUtil.doClick(reserveNow);
    }

}

package org.automationintesting.pages;

import org.automationintesting.util.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Map;

public class BookingPage {


    private WebDriver driver;
    private ElementUtils elementUtil;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtils(driver);
    }

    // Locators (update based on actual site structure)
    By bookNow = By.xpath("//a[text()='Book Now']");
    By rooms = By.xpath("//h5[@class='card-title']");
    By reserveNow = By.xpath("//button[text()='Reserve Now']");
    By firstNameField = By.xpath("//input[@name='firstname']");
    By lastNameField = By.xpath("//input[@name='lastname']");
    By emailField = By.xpath("//input[@name='email']");
    By phoneField = By.xpath("//input[@name='phone']");
    By CancelButton = By.xpath("//button[text()='Cancel']");
    By bookingConfirmationMessage = By.xpath("//h2[text()='Booking Confirmed']");
    By bookingList = By.cssSelector(".booking");


    public void clickBookNowButton() {
        elementUtil.doClick(bookNow);
    }


    public boolean isBookingConfirmed() {
        return driver.findElement(bookingConfirmationMessage).isDisplayed();
    }


    public List<String> getVisibleRooms() {
        List<WebElement> roomElements = driver.findElements(By.cssSelector(".room-info h3"));
        List<String> actualRooms = new ArrayList<>();

        for (WebElement room : roomElements) {
            actualRooms.add(room.getText().trim());
        }

        return actualRooms;
    }

    public void scrollDown() {
        elementUtil.scrollPageDown();
    }

    public boolean bookRoom(String roomType, String firstName, String lastName, String email, String phone) {
        elementUtil.scrollPageDown();
        clickBookNowButton(roomType);
        elementUtil.scrollPageDown();
        elementUtil.clickElementByJS(reserveNow);
        elementUtil.waitForElementToBeVisible(CancelButton);
        fillBookingForm(firstName, lastName, email, phone);
        String pageSource = driver.getCurrentUrl();
        return pageSource.contains("checkout");
    }

    private void fillBookingForm(String firstName, String lastName, String email, String phone) {
        elementUtil.doSendKeys(firstNameField, firstName);
        elementUtil.doSendKeys(lastNameField, lastName);
        elementUtil.doSendKeys(emailField, email);
        elementUtil.doSendKeys(phoneField, phone);
        elementUtil.clickElementByJS(reserveNow);
    }

    public void clickReserveNow() {
        elementUtil.clickElementByJS(reserveNow);
    }

    private void clickBookNowButton(String roomType) {
        int index = roomBookNowIndex.getOrDefault(roomType, 1); // fallback to [1] if unknown
        String roomsBookNow = "//*[@id='rooms']//div[2]/div[" + index + "]//div[3]/a";
        WebElement bookNowBtn = driver.findElement(By.xpath(roomsBookNow));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", bookNowBtn);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(bookNowBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookNowBtn);
    }

    private final Map<String, Integer> roomBookNowIndex = Map.of(
            "Single", 1,
            "Double", 2,
            "Suite", 3
    );

    public boolean areRoomsVisible(List<String> expectedRooms) {
        List<WebElement> roomElements = elementUtil.getElements(rooms);// Adjust selector if needed
        List<String> actualRooms = new ArrayList<>();

        for (WebElement room : roomElements) {
            String roomName = room.getText().trim();
            actualRooms.add(roomName);
        }

        // Debug output for visibility
        System.out.println("Expected rooms: " + expectedRooms);
        System.out.println("Actual rooms on page: " + actualRooms);

        return actualRooms.containsAll(expectedRooms);
    }

}

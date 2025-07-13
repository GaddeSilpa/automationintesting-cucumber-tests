package org.automationintesting.pages;


import org.automationintesting.util.ElementUtils;
import org.automationintesting.util.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationPage {

    private final  WebDriver driver;
    private final ElementUtils elementUtil;

    public LocationPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtils(driver);
    }

    // Locators for location section
    private final By locationSection = By.xpath("//h2[text()='Our Location']");
    private final By addressText = By.xpath("//*[@id='location']//div[2]//div[1]/div[2]/p");
    private final By emailText = By.xpath("//*[@id='location']//div[2]/div[2]//div[3]/div[2]/p");
    private final By phoneText = By.xpath("//*[@id='location']//div[2]/div[2]/p");


    // Actions
    public boolean isLocationSectionVisible() {
        // return elementUtil.waitForElementVisible(locationSection, 5).isDisplayed();
        return elementUtil.waitForElementToBeVisible(locationSection).isDisplayed();

    }

    public String getAddressText() {
        return elementUtil.doGetText(addressText);
    }

    public String getEmailText() {
        return elementUtil.doGetText(emailText);
    }

    public String getPhoneNumberText() {
        return elementUtil.doGetText(phoneText);
    }

}



package org.automationintesting.pages;

import org.automationintesting.util.ElementUtils;
import org.automationintesting.util.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private ElementUtils elementUtil;

    //By Locators
    private final By welcomeMessage = By.xpath("//h1[@class='display-4 fw-bold mb-4']");
    private final By pageTitle = By.tagName("title");
    private By locationButton = By.xpath("//a[text()='Location']");

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtils(driver);
    }

    public String VerifyPageTitle() {
        return driver.getTitle();

    }

    public void clickLocationButton() {
        elementUtil.clickElementByJS(locationButton);
    }

    public boolean isWelcomeMessageDisplayed() {
        return elementUtil.doIsDisplayed(welcomeMessage);
    }

    public String welcomeMessage() {
        return elementUtil.doGetText(welcomeMessage);

    }
}

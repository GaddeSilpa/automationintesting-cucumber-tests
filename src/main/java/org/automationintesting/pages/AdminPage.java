package org.automationintesting.pages;


import org.automationintesting.util.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    private final WebDriver driver;
    private final ElementUtils elementUtil;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtils(driver);
    }

    // Locators
    private final By adminButton = By.xpath("//a[text()='Admin']");
    private final By userNameField = By.xpath("//input[@id='username']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//button[@id='doLogin']");
    private final By errorMessage = By.xpath("//div[text()='Invalid credentials']");

    // Actions
    public void clickAdminButton() {
        elementUtil.doClick(adminButton);
    }

    public void userName(String username) {
        elementUtil.doSendKeys(userNameField, username);
    }

    public void enterPassword(String password) {
        elementUtil.doSendKeys(passwordField, password);
    }

    public void clickLoginButton() {
        elementUtil.doClick(loginButton);
    }

    public String getErrorMessage() {
        return elementUtil.doGetText(errorMessage);
    }
}


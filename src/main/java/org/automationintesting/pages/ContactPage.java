package org.automationintesting.pages;

import org.automationintesting.util.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {


    private final WebDriver driver;
    private final ElementUtils elementUtil;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtils(driver);
    }

    // Locators
    private final By contactForm = By.xpath("//div[@class='container']//preceding::a[text()='Contact'][2]");
    private final By nameField = By.xpath("//input[@id='name']");
    private final By emailField = By.xpath("//input[@id='email']");
    private final By subjectField = By.xpath("//input[@id='subject']");
    private final By phoneField = By.xpath("//input[@id='phone']");
    private final By messageField = By.xpath("//textarea[@id='description']");
    private final By submitButton = By.xpath("//button[text()='Submit']");
    private final By successMessage = By.xpath("//div[@class='card-body p-4']//h3[@class='h4 mb-4']");
    private final By nameError = By.xpath("//div[@class='alert alert-danger']//child::p[4]");
    private final By emailError = By.xpath("//div[@class='alert alert-danger']//child::p[6]");
    private final By subjectError = By.xpath("//div[@class='alert alert-danger']//child::p[3]");
    private final By messageError = By.xpath("//div[@class='alert alert-danger']//child::p[2]");
    private final By messageLengthError = By.xpath("//div[@class='alert alert-danger']//child::p[1]");
    private final By subjectLengthError = By.xpath("//div[@class='alert alert-danger']//child::p[5]");
    private final By phoneLengthError = By.xpath("//div[@class='alert alert-danger']//child::p[7]");
    private final By phoneError = By.xpath("//div[@class='alert alert-danger']//child::p[8]");
    private final By emailValidationError = By.xpath("//div[@class='alert alert-danger']");


    // Actions
    public void gotoContactForm() {
        //elementUtil.scrollToElement(contactForm);
        elementUtil.clickElementByJS(contactForm);
    }

    public void enterName(String name) {
        elementUtil.doSendKeys(nameField, name);
    }

    public void enterEmail(String email) {
        elementUtil.doSendKeys(emailField, email);
    }

    public void enterPhone(String phone) {
        elementUtil.doSendKeys(phoneField, phone);
    }

    public void enterSubject(String subject) {
        elementUtil.doSendKeys(subjectField, subject);
    }

    public void enterMessage(String message) {
        elementUtil.doSendKeys(messageField, message);
    }

    public void clickSubmitButton() {
        elementUtil.clickElementByJS(submitButton);
        // elementUtil.doClick(submitButton);
    }

    public String getSuccessMessage() {
        return elementUtil.doGetText(successMessage);
    }

    public String getEmailValidationError() {
        return elementUtil.doGetText(emailValidationError);
    }


    public boolean isNameValidationErrorDisplayed() {
        return elementUtil.doIsDisplayed(nameError);
    }

    public boolean isEmailValidationErrorDisplayed() {
        return elementUtil.doIsDisplayed(emailError);
    }

    public boolean isSubjectValidationErrorDisplayed() {
        return elementUtil.doIsDisplayed(subjectError);
    }

    public boolean isSubjectLengthValidationErrorDisplayed() {
        return elementUtil.doIsDisplayed(subjectLengthError);
    }

    public boolean isMessageLengthValidationErrorDisplayed() {
        return elementUtil.doIsDisplayed(messageLengthError);
    }

    public boolean isPhoneValidationErrorDisplayed() {
        return elementUtil.doIsDisplayed(phoneError);
    }

    public boolean isPhoneLengthValidationErrorDisplayed() {
        return elementUtil.doIsDisplayed(phoneLengthError);
    }

    public boolean isMessageValidationErrorDisplayed() {
        //  return elementUtil.isElementDisplayed(messageError);
        return elementUtil.doIsDisplayed(messageError);
    }

}


package org.automationintesting.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class ElementUtils {



        WebDriver driver;
        //JavaScriptUtil jsUtil;

        public ElementUtils(WebDriver driver) {
            this.driver = driver;
           // jsUtil = new JavaScriptUtil(this.driver);
        }

        public List<WebElement> getElements(By locator) {
            List<WebElement> elementsList = driver.findElements(locator);
            return elementsList;
        }

        public WebElement getElement(By locator) {
            WebElement element = null;
            try {
                System.out.println("locator is : " + locator);
                element = driver.findElement(locator);
               // jsUtil.drawBorder(element);
                System.out.println("WebElement is created successfully : " + locator);

            } catch (Exception e) {
                System.out.println("some exception got occurred with this locator: " + locator);
            }
            return element;
        }

        public void doSendKeys(By locator, String value) {
            elementToBeClickable(locator);
            getElement(locator).sendKeys(value);
        }

        public void doClick(By locator) {

            elementToBeClickable(locator);
            getElement(locator).click();
        }

        public String doGetText(By locator) {
            waitForElementPresent(locator, 10);
            return getElement(locator).getText();
        }

        public boolean doIsDisplayed(By locator) {
            waitForElementPresent(locator, 10);
            return getElement(locator).isDisplayed();
        }

        // **********************************Drop Down Utils
        // *********************************

       /* public void doSelectByVisibleText(By locator, String value) {
            Select select = new Select(getElement(locator));
            select.selectByVisibleText(value);
        }*/

        public void doSelectByIndex(By locator, int index) {
            Select select = new Select(getElement(locator));
            select.selectByIndex(index);
        }

        public void doSelectByValue(By locator, String value) {
            Select select = new Select(getElement(locator));
            select.selectByValue(value);
        }

        public int doDropDownOptionsCount(By locator) {
            return doGetDropDownOptions(locator).size();
        }

        public ArrayList<String> doGetDropDownOptions(By locator) {
            ArrayList<String> ar = new ArrayList<String>();
            Select select = new Select(getElement(locator));
            List<WebElement> OptionsList = select.getOptions();

            for (int i = 0; i < OptionsList.size(); i++) {
                String text = OptionsList.get(i).getText();
                ar.add(text);
            }
            return ar;
        }

        public void doSelectDropDownValueWithoutSelect(By locator, String value) {
            List<WebElement> optionsList = getElements(locator);

            for (int i = 0; i < optionsList.size(); i++) {
                String text = optionsList.get(i).getText();
                if (text.equals(value)) {
                    optionsList.get(i).click();
                    break;
                }
            }
        }

        // **********************************Actions class Utils
        // *********************************
        public void doActionsSendKeys(By locator, String value) {
            Actions action = new Actions(driver);
            action.sendKeys(getElement(locator), value).build().perform();
        }

        // ***************************** Wait Utils
        // *******************************************


        public WebElement waitForElementPresent(By locator, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element;
        }
        public WebElement elementToBeClickable(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element;
        }

        public WebElement waitForElementToBeVisible(By locator) {
            WebElement element = getElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        }

        public WebElement waitForElementToBeClickable(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return element;
        }

        public boolean waitForUrl(String url, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.urlContains(url));
        }

        public Alert waitForAlertToBePresent(int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            return alert;
        }


        public String waitForTitleToBePresent(String title, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains(title));
            return driver.getTitle();
        }

    public void scrollPageDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public void clickElementByJS(By locator) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();",driver.findElement(locator));

    }

        public void switchTodefaultFrame(){

            driver.switchTo().defaultContent();
        }
        public void doselectContent(By locator){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'",driver.findElement(locator));
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"));

        }

        public Date getCurrentDate() throws ParseException{

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
            return dateWithoutTime;
        }
        public String getCurrentmonth() throws ParseException {

            DateFormat format = new SimpleDateFormat("MMMM", Locale.ENGLISH);
            Date dateWithoutTime = format.parse(format.format(new Date()));
            Calendar now = Calendar.getInstance();
            int month = now.get(Calendar.MONTH)+1;
            String todayStr = Integer.toString(month);
            return todayStr;
        }
        public String getCurrentDay (){

            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            //Get Current Day as a number
            int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
            //Integer to String Conversion
            String todayStr = Integer.toString(todayInt);
            return todayStr;
        }

    }


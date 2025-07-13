package org.automationintesting.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage {

    protected static WebDriver driver;
    public static Properties prop;
   // protected  ElementUtils elementUtil;
    public BasePage(){
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/java/org/automationintesting/config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("Chrome")){

            try{

                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("---start-maximized");
                chromeOptions.addArguments("---disable-popup-blocking");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("---ignore-certificate-errors");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
            }
            catch(Exception e){

                System.out.println(e.getMessage());
            }
        }
        else if(browserName.equalsIgnoreCase("IE")){
            try{

                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
            }
            catch(Exception e){

                System.out.println(e.toString());

            }
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            try{

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
            }

            catch(Exception e){

                System.out.println(e.toString());
            }
        }

        else{

            System.out.println("no browser selected");
        }
driver.get(prop.getProperty("url"));

    }
    }


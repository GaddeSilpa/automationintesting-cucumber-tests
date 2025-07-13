package org.automationintesting.util;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        tlDriver.set(driver);
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}

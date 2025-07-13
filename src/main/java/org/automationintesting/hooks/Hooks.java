package org.automationintesting.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.automationintesting.util.BasePage;

public class Hooks extends BasePage {

    @Before
    public void setUp() {
        BasePage base = new BasePage();
        BasePage.initialization();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

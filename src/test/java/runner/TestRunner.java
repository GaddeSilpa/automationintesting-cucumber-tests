package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/features",
    glue = {"org.automationintesting.stepdefs","org.automationintesting.hooks"},
            plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json"}
           // ,tags = "@location","@contact","@booking
           //,tags = " @@location"
    )
    public class TestRunner extends AbstractTestNGCucumberTests {


    }

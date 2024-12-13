package runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@doglist OR @E1",                       
        plugin = {"pretty", "html:target/cucumber-reports.html"},  // Report generation
        monochrome = true,
        strict = true
)

public class TestRunner {

}

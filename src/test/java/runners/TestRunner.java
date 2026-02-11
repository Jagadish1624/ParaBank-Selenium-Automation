package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        		plugin = {
        			    "pretty",
        			    "json:target/cucumber.json","html:target/cucumber-report.html",
        			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        			},
        monochrome = true
)


public class TestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(name = "scenarios", parallel = false)
	public Object[][] scenarios() {
	    return super.scenarios();
	}

	}


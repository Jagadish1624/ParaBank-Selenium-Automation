package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void setup() {
	    DriverSetup.initDriver();
	}
	@After
	public void tearDown(Scenario scenario){

	    if(scenario.isFailed()){

	        TakesScreenshot ts =
	            (TakesScreenshot) DriverSetup.getDriver();

	        byte[] screenshot =
	            ts.getScreenshotAs(OutputType.BYTES);

	        scenario.attach(
	            screenshot,
	            "image/png",
	            "Failure Screenshot");
	    }

	    DriverSetup.quit();
	}

}

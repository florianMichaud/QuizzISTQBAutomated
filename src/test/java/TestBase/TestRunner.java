package TestBase;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = "Steps")
public class TestRunner {
	
	@AfterClass
	public static void tearDown() {
		DriverSingleton.getInstance().quit();
	}

}

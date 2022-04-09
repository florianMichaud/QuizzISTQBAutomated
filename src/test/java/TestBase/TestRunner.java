package TestBase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = "Steps")
public class TestRunner {
	private static Driver driver;
	
	@BeforeClass
	public static void setup() {
		driver = new Driver();
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}

}

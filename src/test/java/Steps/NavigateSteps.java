package Steps;

import org.openqa.selenium.WebDriver;

import TestBase.DriverSingleton;
import io.cucumber.java.en.Given;

public class NavigateSteps {
	private WebDriver driver;
	
	public NavigateSteps() {
		this.driver = DriverSingleton.getInstance();
	}

	@Given("I navigate to {string}")
	public void navigateToUrl(String url) {
		driver.get(url);
	}
}

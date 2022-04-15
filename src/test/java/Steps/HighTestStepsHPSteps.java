package Steps;

import TestBase.DriverSingleton;
import io.cucumber.java.en.And;
import pages.HighTestHomePage;

public class HighTestStepsHPSteps {
	private HighTestHomePage highTestHomePage;
	
	public HighTestStepsHPSteps() {
		highTestHomePage = new HighTestHomePage(DriverSingleton.getInstance());
	}
	
	@And("I navigate to {string} section")
	public void navigateToSectionByName(String sectionName) {
		highTestHomePage.clickHeaderSectionByLinkText(sectionName);
	}
}
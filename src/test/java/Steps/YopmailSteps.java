package Steps;

import TestBase.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.YopmailPage;

public class YopmailSteps {
	private YopmailPage yopmailPage;
	
	public YopmailSteps() {
		yopmailPage = new YopmailPage(DriverSingleton.getInstance());
	}

	@And("I login to my email")
	public void checkMyEmails() {
		yopmailPage.acceptCookies();
		yopmailPage.login();
		
	}
	
	@Then("I can check my results")
	public void checkResults() {
		yopmailPage.openMailsWithResults();
	}
	
	@And("I got {string}% correct answers")
	public void checkCorrectAnswers(String correctAnswersExpected) {
		yopmailPage.getResults(correctAnswersExpected);
	}
}

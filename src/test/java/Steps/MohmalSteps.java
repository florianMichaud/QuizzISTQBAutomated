package Steps;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import TestBase.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MohmalPage;

public class MohmalSteps {
	private MohmalPage mohmalPage;
	
	public MohmalSteps() {
		mohmalPage = new MohmalPage(DriverSingleton.getInstance());
	}
	
	@And("I get an email")
	public void takeEmail() {
		this.mohmalPage.getEmail();
	}
	
	@And("I login to my email")
	public void checkMyEmails() {
		try {
			mohmalPage.login();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("I can check my results")
	public void checkMyResults() {
		mohmalPage.openMailsWithResults();
	}
	
	@And("I got {string}% correct answers")
	public void checkCorrectAnswers(int correctAnswersExpected) {
		mohmalPage.getResults(correctAnswersExpected);
	}
}

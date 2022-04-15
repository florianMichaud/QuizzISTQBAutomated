package Steps;

import TestBase.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.QuizPage;

public class QuizSteps {
	private QuizPage quizPage;
	
	
	public QuizSteps() {
		quizPage = new QuizPage(DriverSingleton.getInstance());
	}

	@When("I complete the quiz")
	public void completeQuiz() {
		quizPage.isOpenedQuiz();
		quizPage.completeQuiz();
	}
	
	@And("I enter my mail")
	public void enterMail() {
		quizPage.sendsResultsByMail();
	}
}

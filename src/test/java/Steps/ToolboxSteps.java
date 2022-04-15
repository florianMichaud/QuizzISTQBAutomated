package Steps;

import TestBase.DriverSingleton;
import io.cucumber.java.en.And;
import pages.ToolboxPage;

public class ToolboxSteps {
	private ToolboxPage toolboxPage;
	
	public ToolboxSteps() {
		this.toolboxPage = new ToolboxPage(DriverSingleton.getInstance());
	}
	
	//voir si on peut variabiliser la langue
	@And("I run {string} in french")
	public void launchISQTBQuizByName(String quizName) {
		toolboxPage.runQuizByNameAndByLanguage(quizName, "Français");
	}
}

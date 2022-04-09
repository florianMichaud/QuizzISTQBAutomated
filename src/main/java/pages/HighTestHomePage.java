package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HighTestHomePage {
	private By toolboxLink;
	private WebDriver driver;
	
	public HighTestHomePage(WebDriver driver) {
		this.driver = driver; 
		this.toolboxLink = By.linkText("Toolbox");
	}
	
	public void clickToolboxSection() {
		driver.findElement(toolboxLink).click();
	}
}

package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolboxPage {
	private WebDriver driver;
	private JavascriptExecutor jsExecutor;

	public ToolboxPage(WebDriver driver) {
		this.driver = driver;
		this.jsExecutor = (JavascriptExecutor) driver;
	}
	
	public void runQuizByNameAndByLanguage(String name, String language) {
		String quizzTitleXpath = "//h2[text()='"+name+"']";
		WebElement quizzTitle = driver.findElement(By.xpath(quizzTitleXpath));
		
		jsExecutor.executeScript("arguments[0].scrollIntoView();", quizzTitle);
		String xpathSelectorLanguage = quizzTitleXpath + "/following::div/a[contains(text(),'"+language+"')]";
		
		WebElement french = driver.findElement(By.xpath(xpathSelectorLanguage));
		jsExecutor.executeScript("window.scrollTo(0, 0);", "");	
		jsExecutor.executeScript("window.scrollTo(0,750);", "");
		french.click();		
	}
}

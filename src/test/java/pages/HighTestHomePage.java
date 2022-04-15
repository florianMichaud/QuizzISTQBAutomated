package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HighTestHomePage {
	private WebDriver driver;
	
	public HighTestHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickHeaderSectionByLinkText(String link) {
		String xpathExpression = "//a[contains(text(),'"+link+"')]";
		driver.findElement(By.xpath(xpathExpression)).click();;
	}
}

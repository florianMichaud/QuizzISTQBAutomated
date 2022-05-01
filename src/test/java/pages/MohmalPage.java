package pages;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.JsonPropertiesFileUtils;

public class MohmalPage {
	private WebDriver driver;
	
	public MohmalPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getEmail() {
		this.driver.findElement(By.id("rand")).click();
		String emailXpath = "//div[@id='email']/div[@class=\"email\"]";
		String t = this.driver.findElement(By.xpath(emailXpath)).getText();
		this.driver.findElement(By.xpath(emailXpath)).click();
		System.out.println("Email : "+t);
		
		try {
			JsonPropertiesFileUtils.addProperty("email", t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void login() throws IOException, ParseException {
		driver.findElement(By.id("choose")).click();
		driver.findElement(By.xpath("//input")).sendKeys(JsonPropertiesFileUtils.getProperty("email"));
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("create")).click();
	}
	
	public void openMailsWithResults() {
		List<WebElement> mails = driver.findElements(By.xpath("//tbody/tr"));
		mails.get(0).click();
	}
	
	public void getResults(int correctAnswersExpected) {
		String resultsTxt = driver.findElement(By.id("score")).getText();
		System.out.println(resultsTxt);
		assertTrue(resultsTxt.contains(String.valueOf(correctAnswersExpected)));
	}
}

package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailPage {
	private WebDriver driver;
	private JavascriptExecutor jsExecutor;

	public YopmailPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.jsExecutor = (JavascriptExecutor) driver;
	}
	
	public void acceptCookies() {
		driver.findElement(By.id("accept")).click();
	}
	public void login() {
		assertTrue(driver.getTitle().toLowerCase().contains("yopmail"));
		WebElement mailInput = driver.findElement(By.id("login"));
		assertTrue(mailInput.isDisplayed());
		mailInput.sendKeys("testisqtb@yopmail.com");
		WebElement confirmMail = driver.findElement(By.id("refreshbut"));
		assertTrue(confirmMail.isDisplayed());
		confirmMail.click();
		WebElement mailShowed = driver.findElement(By.className("bname"));
		assertTrue(mailShowed.getText().equalsIgnoreCase("testisqtb@yopmail.com"));
	}

	public void openMailsWithResults(){
		//TODO Faire une fonction qui permettant de choisir le bon email
		List<WebElement> mails = driver.findElements(By.className("m"));
		boolean findLastHighTestMail = false;
		int i = 0;
		while(mails.size()>0 && !findLastHighTestMail) {
			mails.get(i).click();
			WebElement sender = driver.findElement(By.xpath("span[class='ellipsis b']"));
			//Rajouter une condition pour l'ouverture du mail
			if(sender.getText().contains("contact@hightest.nc")) {
				findLastHighTestMail = true;
			}
			i++;
		}
		
	}
	
	public void getResults(String correctAnswersExpected) {
		int correctAnswersExpectedInteger = Integer.parseInt(correctAnswersExpected);
		String xpathResults = "//div[@id='mail']//div[contains(text(),'"+correctAnswersExpectedInteger+"%')]";
		driver.findElement(By.xpath(xpathResults));
	}
}

package pages;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.JsonPropertiesFileUtils;

public class QuizPage {
	private WebDriver driver;
	private Map<Integer, Integer> qcmAnswers;
	private JavascriptExecutor jsExecutor;

	public QuizPage(WebDriver driver) {
		super();
		this.driver = driver;
		qcmAnswers = new HashMap<Integer, Integer>();
		initData(qcmAnswers);
		this.jsExecutor = (JavascriptExecutor) driver;
	}
	
	public void isOpenedQuiz() {
		List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		boolean findPage = false;
		int i = 0;
		while(!findPage && i<tabs.size()) {
			driver.switchTo().window(tabs.get(i));
			findPage = driver.getTitle().contains("ISTQB");
			i++;
		}
				
		assertTrue(driver.getTitle().contains("ISTQB"));
	}
	
	public void completeQuiz() {
		String questionBlockBase = "form>div";
		Iterator<Integer> it = qcmAnswers.values().iterator();
		int j = 0;
		
		while(it.hasNext()) {
			String questionBlock = questionBlockBase+":nth-of-type("+(++j)+")";
			String checkAnswerSelector = questionBlock + ">input[value='"+it.next() +"']";
			WebElement element = driver.findElement(By.cssSelector(checkAnswerSelector));
			jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
			element.click();
		}
		
		driver.findElement(By.id("submit")).click();
		
	}
	
	public void sendsResultsByMail() {
		WebElement mailInput = driver.findElement(By.id("email"));
		//mailInput.sendKeys("testisqtb@yopmail.com");
		try {
			mailInput.sendKeys(JsonPropertiesFileUtils.getProperty("email"));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement submitMail = driver.findElement(By.id("submitMail"));
		assertTrue(submitMail.isDisplayed());
		submitMail.click();
	}
	
	private void initData(Map<Integer,Integer> qcmAnswers) {
		qcmAnswers.put(1, 1);
		qcmAnswers.put(2, 2);
		qcmAnswers.put(3, 1);
		qcmAnswers.put(4, 2);
		qcmAnswers.put(5, 2);
		qcmAnswers.put(6, 3);
		qcmAnswers.put(7, 2);
		qcmAnswers.put(8, 4);
		qcmAnswers.put(9, 1);
		qcmAnswers.put(10, 3);
		qcmAnswers.put(11, 4);
		qcmAnswers.put(12, 2);
		qcmAnswers.put(13, 3);
		qcmAnswers.put(14, 2);
		qcmAnswers.put(15, 4);
		qcmAnswers.put(16, 3);
		qcmAnswers.put(17, 3);
		qcmAnswers.put(18, 1);
		qcmAnswers.put(19, 2);
		qcmAnswers.put(20, 2);
		
	}
	
	private void showData() {
		for(Map.Entry<Integer, Integer> entry : this.qcmAnswers.entrySet()) {
			System.out.println(entry.getKey() + " : "+entry.getValue());
		}
	}
}

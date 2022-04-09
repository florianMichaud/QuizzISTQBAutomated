package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private WebDriver driver;
	
	public Driver() {
		//System.setProperty("webdriver.chrome.driver", "ressources/chromedriver");
		WebDriverManager.chromedriver()/*.browserVersion("100.0.4896.75")*/.setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hightest.nc");
		System.out.println(driver.getTitle());
	}
	
	public void close() {
		this.driver.close();
	}

}

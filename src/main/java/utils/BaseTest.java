package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		driver.get("http://keybooks.ro");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}

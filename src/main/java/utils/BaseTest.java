package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public JavascriptExecutor jse;
	
	@BeforeClass
	public void setup() {
		
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://keybooks.ro");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		
		// comensatriu pentru conflict
		jse = (JavascriptExecutor) driver;
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.quit();
	}

}

package curs1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumScript {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		driver.get("http://keybooks.ro");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void getTitle() {
		
		/*
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://keybooks.ro");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		*/
		
		System.out.println(driver.getTitle());

	}
	
	@Test
	public void getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
		
	}

}

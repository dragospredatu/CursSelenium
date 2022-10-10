package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {
	
	public WebDriver driver;
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Custom sendKeys method/ Wraps Selenium default sendKeys and enhances it
	 * with clear() method before sending the test
	 * @param locator --> used inside method to create a WebElement object
	 * @param value --> String value to be used as text input
	 */
	public void sendKeys(By locator, String value) {
		
		WebElement element = driver.findElement(locator);
		
		try {
			element.clear();
			element.sendKeys(value);
		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	public void click(By locator) {
		
		WebElement element = driver.findElement(locator);
		
		try {
			waitForElementToBeClickable(element);
			element.click();
		}catch(NoSuchElementException e) {
			System.out.println("Something went wrong");
		}catch(StaleElementReferenceException e) {
			WebElement element2 = driver.findElement(locator);
			element2.click();
		}
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumWrappers;

public class ContactsPage extends SeleniumWrappers{
	
	//public WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
	}
	
	//Inputs
	public By nameField = By.cssSelector("input[name='your-name']");
	public By emailField = By.cssSelector("input[name='your-email']");
	public By subjectField = By.cssSelector("input[name='your-s']");
	public By messageField = By.cssSelector("textarea[name='your-message']");
	//Submit button
	public By sendMessage = By.cssSelector("input[type='submit'][value='Send Message']");
	//Message sent or not sent confirmation
	public By messageConfirmation = By.cssSelector("div[class='wpcf7-response-output'");
	//Errors
	public By nameFieldError = By.cssSelector("span[class='wpcf7-form-control-wrap your-name']>span");
	public By emailFieldError = By.cssSelector("span[class='wpcf7-form-control-wrap your-email']>span");
	public By messageFieldError = By.cssSelector("span[class='wpcf7-form-control-wrap your-message']>span");
	
	public void sendMessage(String name, String email, String subject, String message) {
		
		driver.findElement(nameField).clear();;
		driver.findElement(emailField).clear();
		driver.findElement(subjectField).clear();
		driver.findElement(messageField).clear();
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(subjectField).sendKeys(subject);
		driver.findElement(messageField).sendKeys(message);
		driver.findElement(sendMessage).click();
	}
	
	public boolean checkMessageIsDisplayed(By locator) {

		return driver.findElement(locator).isDisplayed();
	}
	

}

package curs4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeworkCurs4 extends BaseTest{
	
	@Test
	public void sendMessage() throws InterruptedException {
		
		driver.get("https://keybooks.ro/contacts/");
		SoftAssert assertElements = new SoftAssert();
		
		WebElement name = driver.findElement(By.cssSelector("input[type='text'][name='your-name']"));
		assertElements.assertTrue(name.isDisplayed());
		name.sendKeys("Dragos");
		
		WebElement email = driver.findElement(By.cssSelector("input[type='email'][name='your-email']"));
		assertElements.assertTrue(email.isDisplayed());
		email.sendKeys("dragos@email.com");
		
		WebElement subject = driver.findElement(By.cssSelector("input[type='text'][name='your-s']"));
		assertElements.assertTrue(subject.isDisplayed());
		subject.sendKeys("Title");
		
		WebElement message = driver.findElement(By.cssSelector("textarea[name='your-message']"));
		assertElements.assertTrue(message.isDisplayed());
		message.sendKeys("This is the message I sent");
		
		WebElement sendMessage = driver.findElement(By.cssSelector("input[type='submit'][value='Send Message']"));
		assertElements.assertTrue(sendMessage.isDisplayed());
		sendMessage.click();
		
		Thread.sleep(2000);
		
		WebElement messageSentConfirmation = driver.findElement(By.cssSelector("div[class='wpcf7-response-output'"));
		assertElements.assertTrue(messageSentConfirmation.getText().equals("Thank you for your message. It has been sent."));
		
		assertElements.assertAll();
	}
}

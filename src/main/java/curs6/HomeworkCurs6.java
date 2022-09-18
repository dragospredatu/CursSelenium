package curs6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeworkCurs6 extends BaseTest{
	
	@Test
	public void addBookReview() throws InterruptedException {
		
		SoftAssert assertElements = new SoftAssert();
		
		WebElement selectBook = driver.findElement(By.cssSelector("a[href='its-a-really-strange-story']"));
		selectBook.click();
		Thread.sleep(2000);
		
		WebElement reviewsTab = driver.findElement(By.cssSelector("a[href='#tab-reviews']"));
		reviewsTab.click();
		Thread.sleep(2000);
		
		WebElement submitReview = driver.findElement(By.cssSelector("input[name='submit'][id='submit']"));
		submitReview.click();
		Thread.sleep(2000);
		
		Alert alertJS = driver.switchTo().alert();
		alertJS.accept();
		
		WebElement rating = driver.findElement(By.cssSelector("a[class='star-4']"));
		rating.click();
		WebElement reviewText = driver.findElement(By.cssSelector("textarea[id='comment']"));
		reviewText.sendKeys("This book deserves 4 star");
		WebElement name = driver.findElement(By.cssSelector("input[id='author']"));
		name.sendKeys("Dragos");
		WebElement email = driver.findElement(By.cssSelector("input[id='email']"));
		email.sendKeys("dragos@email.com");
		
		submitReview.click();
		Thread.sleep(3000);
		
		WebElement reviewApproval = driver.findElement(By.cssSelector("em[class='woocommerce-review__awaiting-approval']"));
		assertElements.assertTrue(reviewApproval.getText().equals("Your review is awaiting approval"));
		
		assertElements.assertAll();
	}
}

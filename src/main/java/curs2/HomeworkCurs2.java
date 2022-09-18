package curs2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeworkCurs2 extends BaseTest{
	
	@Test
	public void checkElementsVisible() throws InterruptedException {
		
		WebElement loginButton = driver.findElement(By.className("menu_user_login"));
		WebElement loginUserField = driver.findElement(By.id("log"));
		WebElement loginPassField = driver.findElement(By.id("password"));
			
		SoftAssert assertElements = new SoftAssert();
		assertElements.assertTrue(loginButton.isDisplayed());
		assertElements.assertFalse(loginUserField.isDisplayed());
		assertElements.assertFalse(loginPassField.isDisplayed());
		
		loginButton.click();
		Thread.sleep(500);
		
		assertElements.assertTrue(loginUserField.isDisplayed());
		assertElements.assertTrue(loginPassField.isDisplayed());
		
		assertElements.assertAll();
		
	}

}

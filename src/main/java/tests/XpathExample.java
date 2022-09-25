package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest{

	@Test
	public void xpathExample() throws InterruptedException {

		WebElement loginPopup =  driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", loginPopup);
		loginPopup.click();

		//OR
		WebElement userField =  driver.findElement(By.xpath("//input[@id='log' or @name='log']  "));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", userField);
		userField.sendKeys("TestUser");

		//AND
		WebElement passField = driver.findElement(By.xpath("//input[@id='password' and @name='pwd']  "));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", passField);
		passField.sendKeys("12345@67890");


		WebElement submitButton = driver.findElement(By.xpath("//input[@class='submit_button']"));
		submitButton.click();

		Thread.sleep(4000);
	}
}
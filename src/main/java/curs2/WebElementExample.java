package curs2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;

public class WebElementExample extends BaseTest{
	
	@Test
	public void login() throws InterruptedException {
		
		driver.findElement(By.className("menu_user_login")).click();
		System.out.println(driver.findElement(By.id("log")).isDisplayed()); //isDisplayed() - verifica daca elementul este vizibil sau nu
		Thread.sleep(3000); //bad practice
	}

}

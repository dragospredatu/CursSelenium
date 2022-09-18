package curs3;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeworkCurs3 extends BaseTest{
	
	@Test
	public void checkBook() throws InterruptedException {
		
		//WebElement bookTheForest = driver.findElement(By.linkText("The forest"));
		List<WebElement> bookCategories = driver.findElements(By.className("sc_tabs_title"));
		SoftAssert assertElements = new SoftAssert();
		
		for(WebElement category : bookCategories) {
			
			System.out.println("Searching for book 'The forest' in " + category.getText());
			category.click();
			Thread.sleep(2000);
			assertElements.assertTrue(driver.findElement(By.linkText("The forest")).isDisplayed());
			
			if(bookCategories.indexOf(category)==bookCategories.size()-1){
				
				driver.findElement(By.linkText("The forest")).click();
				Thread.sleep(2000);
				assertElements.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/");
				
			}
		}
		
		assertElements.assertAll();
		
	}

}

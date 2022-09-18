package curs3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class SeleniumLocators extends BaseTest{
	
	
	@Test(priority=0)
	public void tagNameLocator() {
			
		WebElement discoverText =  driver.findElement(By.tagName("em"));
		System.out.println(discoverText.getText());
		assertEquals(discoverText.getText(), "Discover");
		
		
		assertEquals(driver.findElement(By.tagName("em")).getText(), "Discover");

		
		//<a href="shop" class="sc_button sc_button_square sc_button_style_filled sc_button_size_small aligncenter margin_bottom_medium" 
		//style="width:190px;">DISCOVER MORE BOOKS</a>
		
		//xpath
		
		//   //a[contains(text(), "DISCOVER MORE BOOKS")] --> 2 elemente
		//   (//a[contains(text(), "DISCOVER MORE BOOKS")])[2]
		
	}
	
	@Test(priority=1)
	public void linkTextLocator() {
		
		driver.findElement(By.linkText("BOOKS")).click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
	}
	
	@Test(priority=2)
	public void partialLinkTextLocator() {
		driver.findElement(By.partialLinkText("Cooking")).click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love/");
	}
	
	/*
	 * <a href="https://keybooks.ro/shop/lonely-man-in-white-hat/">Lonely man in white hat</a>
	 * 
	 * LINK text --> Lonely man in white hat
	 * 
	 * PARTIAL link text-->Lonley
	 * PARTIAL link text-->man
	 * PARTIAL link text-->hat
	 * PARTIAL link text-->in
	 */
	
	@Test(priority=3)
	public void classNameLocator() {
		WebElement price = driver.findElement(By.className("price"));
		assertTrue(price.isDisplayed());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red')", price);
		assertTrue(price.getText().contains("20.55"));
	}
	
	@Test(priority=4)
	public void idLocator() {
		driver.findElement(By.id("tab-title-reviews")).click();
	}
	
	@Test(priority=5)
	public void nameLocator() throws InterruptedException {
		driver.findElement(By.name("comment")).sendKeys("Commentul meu la acesta carte!");
		Thread.sleep(4000);
	}
	

}

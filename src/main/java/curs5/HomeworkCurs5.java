package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeworkCurs5 extends BaseTest{
	
	@Test
	public void addBookToCart() throws InterruptedException {
		
		SoftAssert assertElements = new SoftAssert();
		
		WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit'][class='search_submit icon-search']"));
		searchButton.click();
		
		Thread.sleep(1000);
		
		WebElement searchInput = driver.findElement(By.cssSelector("input[type='text'][class='search_field']"));
		searchInput.sendKeys("The story about me");
		searchInput.submit();
		
		WebElement loadMoreResults = driver.findElement(By.cssSelector("a[href='#'][id='viewmore_link']"));
		
		loadMoreResults.click();
		Thread.sleep(3000);
		
		WebElement bookFoundInSearchResults = driver.findElement(By.cssSelector("a[href='https://keybooks.ro/shop/the-story-about-me/']"));
		assertElements.assertTrue(bookFoundInSearchResults.isDisplayed());
	
		bookFoundInSearchResults.click();
		Thread.sleep(3000);
		assertElements.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/");
		
		WebElement addToCart = driver.findElement(By.cssSelector("button[type='submit'][name='add-to-cart']"));
		
		addToCart.click();
		Thread.sleep(3000);
		
		WebElement addedToCartMessage = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertElements.assertTrue(addedToCartMessage.getText().contains("“The story about me” has been added to your cart."));
		
		WebElement viewCart = driver.findElement(By.cssSelector("a[href='https://keybooks.ro/cart/'][tabindex='1']"));
		
		viewCart.click();
		Thread.sleep(3000);
		assertElements.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");
		
		assertElements.assertAll();
	}
	
	@Test
	public void updateCart() throws InterruptedException {
		
		SoftAssert assertElements = new SoftAssert();
		
		WebElement quantity = driver.findElement(By.cssSelector("input[type='number']"));
		quantity.clear();
		quantity.sendKeys("2");
		
		WebElement updateCart = driver.findElement(By.cssSelector("button[type='submit'][class='button'][name='update_cart']"));
		
		updateCart.click();
		Thread.sleep(3000);
		
		WebElement cartUpdatedAlert = driver.findElement(By.cssSelector("div[class='woocommerce-message'][role='alert']"));
		assertElements.assertEquals(cartUpdatedAlert.getText(), "Cart updated.");
		
		WebElement checkout = driver.findElement(By.cssSelector("a[href='https://keybooks.ro/checkout/']"));
		
		checkout.click();
		Thread.sleep(3000);
		
		assertElements.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");
		
		WebElement billingDetails = driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields']"));
		assertElements.assertTrue(billingDetails.isDisplayed());
		assertElements.assertTrue(billingDetails.getText().contains("Billing details"));
		
		WebElement additionalInfo = driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields']"));
		assertElements.assertTrue(additionalInfo.isDisplayed());
		assertElements.assertTrue(additionalInfo.getText().contains("Additional information"));
		
		assertElements.assertAll();
	}
}

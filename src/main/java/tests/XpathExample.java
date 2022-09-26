package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest{

	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void xpathExample2() {
		
		driver.findElement(By.xpath("//span[@class='user_name']")).click();
		
		// xpath
		// //a[contains(@href, 'profile.php')]
		// css
		// a[href*='profile.php']
		// xpath 2
		// //a[contains(text(), 'Settings')]
		
		driver.findElement(By.xpath("//a[contains(text(), 'Settings')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'orde')]")).click();
		
		// index based
		// (//th[contains(@class, 'woocommerce-orders-table__header')]/span)[2]
		// --> contains()
		// //th[contains(@class, 'woocommerce-orders-table__header')]/span[contains(text(), 'Order')]
		WebElement orderTableHeader = driver.findElement(By.xpath("//th[contains(@class, 'woocommerce-orders-table__header')]/span[contains(text(), 'Order')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", orderTableHeader);
		
		WebElement statusTableHeader = driver.findElement(By.xpath("(//th[contains(@class, 'woocommerce-orders-table__header')]/span)[3]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", statusTableHeader);
		
		WebElement order_1697 = driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),'1697')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", order_1697);

		// NOT
		// //td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(),'1697'))]
		WebElement orders = driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(),'1697'))]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid green')", orders);
		
		order_1697.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/view-order/1697/");

	}
}
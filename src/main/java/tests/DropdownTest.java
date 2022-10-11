package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class DropdownTest extends BaseTest{
	
	//@Test(priority=1)
	public void selectByValueTest() {
		
		/*NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.shopLink);
		ShopPage shopPage = new ShopPage(driver);*/
		//NavMenuPage navMenu = new NavMenuPage(driver);
		ShopPage shopPage = navMenu.navigateToShop();
		shopPage.selectByValue("price");
		//assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/?orderby=price");
		assertEquals(shopPage.getSelectedOption(), "Sort by price: low to high");
	}
	
	@Test(groups = "ProductFunctionality")
	public void selectByVisibleTextTest() {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.shopLink);
		
		ShopPage shopPage = new ShopPage(driver);
		shopPage.selectByVisibleText("Sort by popularity");
		assertEquals(shopPage.getSelectedOption(), "Sort by popularity");
	}
	
	@Test(groups = "ProductFunctionality")
	public void selectByIndex() {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.shopLink);
		
		ShopPage shopPage = new ShopPage(driver);
		shopPage.selectByIndex(3);
		assertEquals(shopPage.getSelectedOption(), "Sort by latest");
	}
	
	@Test(priority = 4)
	public void exceptionExample() {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.shopLink);
		
		WebElement dropdown = driver.findElement(By.name("orderby"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Sort by popularity");
		//refresh
		WebElement dropdown2 = driver.findElement(By.name("orderby"));
		Select select2 = new Select(dropdown2);
		select2.selectByVisibleText("Sort by latest");
	}
	
	@Test
	public void checkPricesAfterSorting() {
		
		ShopPage shopPage = navMenu.navigateToShop();
		shopPage.selectByValue("price");
		assertEquals(shopPage.getSelectedOption(), "Sort by price: low to high");
		double cheapestBookPrice = Double.parseDouble(driver.findElement(shopPage.cheapestBook).getText().substring(1));
		double mostExpensiveBookPrice = Double.parseDouble(driver.findElement(shopPage.mostExpensiveBook).getText().substring(1));
		assertTrue(cheapestBookPrice < mostExpensiveBookPrice, "The price ordering is not correct!");
	}
}

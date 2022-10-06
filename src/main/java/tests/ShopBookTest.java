package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.ShopBookPage;
import pages.ShopPage;
import utils.BaseTest;

public class ShopBookTest extends BaseTest{
	
	@Test
	public void checkElementsDisplayedOnShopBookPage() throws InterruptedException{
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.shopLink);
		ShopPage shopPage = new ShopPage(driver);
		shopPage.navigateTo(shopPage.bookNewGalaxy);
		ShopBookPage shopBookPage = new ShopBookPage(driver);
		
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookCover));
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookRating));
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookTitle));
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookPrice));
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookQuantity));
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookDescription));
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookAddToCart));
		assertTrue(shopBookPage.checkElementIsDisplayed(shopBookPage.bookDetails));
	}
}

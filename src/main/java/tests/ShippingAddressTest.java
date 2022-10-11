package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import pages.ShippingAddressPage;
import utils.BaseTest;

public class ShippingAddressTest extends BaseTest {

	@Test
	public void checkShippingAddress() throws InterruptedException {
		
		//Login and wait for the page to reload
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp("TestUser", "12345@67890");
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.logoutButton));
		
		//Navigate to ShippingAddress page
		ShippingAddressPage shippingAddressPage = new ShippingAddressPage(driver);
		driver.get(shippingAddressPage.SHIPPING_ADDRESS_PAGE_URL);
		wait.until(ExpectedConditions.presenceOfElementLocated(shippingAddressPage.shippingAddressTitle));
		
		//Select country
		shippingAddressPage.selectByIndex(shippingAddressPage.countryDropdown, 41);
		//Wait until 'Province' is visible
		wait.until(ExpectedConditions.presenceOfElementLocated(shippingAddressPage.provinceDropdown));
		//Select province
		shippingAddressPage.selectByValue(shippingAddressPage.provinceDropdown, "NL");
		//Assert selections
		assertEquals(shippingAddressPage.getSelectedOption(shippingAddressPage.countryDropdown), "Canada");
		assertEquals(shippingAddressPage.getSelectedOption(shippingAddressPage.provinceDropdown), "Newfoundland and Labrador");
	}
}

package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test(priority=0)
	public void loginTest() throws InterruptedException {
		
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		//loginPage.loginInApp(username, password)
		//assert

		LoginPage loginPage= new LoginPage(driver);

		loginPage.loginInApp("TestUser", "12345@67890");

		//varianta1
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());
		//varianta2
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginSuccessMessage));
	    loginPage.logoutFromApp();
	}

	@Test(priority=1)
	public void invalidLoginTest() throws InterruptedException {
		
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		//loginPage.loginInApp(username, password)
		//assert

		LoginPage loginPage= new LoginPage(driver);

		loginPage.loginInApp("TestCeva", "12345@67890");

		//varianta1
		assertTrue(loginPage.loginErrorMessageIsDisplayed());
		//varianta2
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginErrorMessage));

	}
	

}

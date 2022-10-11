package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;

public class CheckUrlsDataProvider extends BaseTest{
	
	@DataProvider
	public Object[][] urlTestData(){
		
		Object[][] data = new Object[6][2];
		
		data[0][0] = "(//a[@href='the-forest'])[1]";
		data[0][1] = "https://keybooks.ro/shop/the-forest/";
		
		data[1][0] = "(//a[@href='the-son'])[1]";
		data[1][1] = "https://keybooks.ro/shop/the-son/";
		
		data[2][0] = "(//a[@href='life-in-the-garden'])[1]";
		data[2][1] = "https://keybooks.ro/shop/life-in-the-garden/";
		
		data[3][0] = "(//a[@href='the-long-road-to-the-deep-silence'])[1]";
		data[3][1] = "https://keybooks.ro/shop/the-long-road-to-the-deep-silence/";
		
		data[4][0] = "(//a[@href='its-a-really-strange-story'])[1]";
		data[4][1] = "https://keybooks.ro/shop/its-a-really-strange-story/";
		
		data[5][0] = "(//a[@href='storm'])[1]";
		data[5][1] = "https://keybooks.ro/shop/storm/";
		
		return data;
	}
	
	@Test(dataProvider = "urlTestData")
	public void urlTest(String xpath, String url) {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(By.xpath(xpath));
		assertEquals(driver.getCurrentUrl(), url);
		driver.get("http://keybooks.ro");
	}
}
package tests;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderSearchBookTest extends BaseTest{
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "bookNamesDataProvider")
	public void searchBookTest(String book, String picture) {
		
		NavMenuPage menu = new NavMenuPage(driver);
		menu.searchBook(book);
		menu.isBookPictureDisplayed(picture);
	}
}

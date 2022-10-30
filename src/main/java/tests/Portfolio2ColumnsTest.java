package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;

public class Portfolio2ColumnsTest extends BaseTest{

	@Test
	public void portfolio2ColumnsTest() throws InterruptedException{
		
		String[] blogPostTitles = new String[15];
		blogPostTitles[0] = "15 Amazing Things About Reading in the Fall";
		blogPostTitles[1] = "10 Book Recommendations For Family Members";
		blogPostTitles[2] = "The Best business books – Financial Times";
		blogPostTitles[3] = "The Best Poetry Books of All Time";
		blogPostTitles[4] = "Five the Best Audiobooks";
		blogPostTitles[5] = "Book reviews: Find the best new books";
		blogPostTitles[6] = "How end-of-year book lists prove we lack diversity";
		blogPostTitles[7] = "We need to talk about all women writers";
		blogPostTitles[8] = "The hottest books to warm you up this winter";
		blogPostTitles[9] = "Why I won’t stop buying books";
		blogPostTitles[10] = "Celebrity Picks:Favorite Reads of 2015";
		blogPostTitles[11] = "Weekend Reading";
		blogPostTitles[12] = "Coffee Table Books";
		blogPostTitles[13] = "Turn the Page: Your Next Rock ‘N’ Roll Book Club";
		blogPostTitles[14] = "The Book Report: Episode 3";

		app.menu.hoverElement(app.menu.blogLink);
		app.menu.hoverElement(app.menu.portfolioBlogLink);
		app.menu.hoverElement(app.menu.portfolio2ColumnsBlogLink);
		app.menu.navigateTo(app.menu.portfolio2ColumnsBlogLink);
		Thread.sleep(1000);
		
		for(int i=1; i<16; i++){
			app.portfolio2ColumnsPage.hoverElement(By.xpath("//div[contains(@class, 'isotope_item_portfolio_2')][" + String.valueOf(i) +"]"));
			Thread.sleep(500);
			System.out.println(app.portfolio2ColumnsPage.driver.findElement(By.xpath("//div[contains(@class, 'isotope_item_portfolio_2')][" + String.valueOf(i) +"]//h4[@class='post_title']")).getText());
			assertEquals(app.portfolio2ColumnsPage.driver.findElement(By.xpath("//div[contains(@class, 'isotope_item_portfolio_2')][" + String.valueOf(i) +"]//h4[@class='post_title']")).getText(), blogPostTitles[i-1]);
		}
	}
}
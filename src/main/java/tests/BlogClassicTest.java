package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.BlogClassicPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class BlogClassicTest extends BaseTest{
	
	@Test
	public void testBlogClassicPost() throws InterruptedException{
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.blogLink);
		navMenu.navigateTo(navMenu.blogClassicLink);
		BlogClassicPage blogClassic = new BlogClassicPage(driver);
		blogClassic.openBlogPost(blogClassic.blogPost);
		blogClassic.addCommentToBlogPost("Comment text", "Name filled in", "email@gmail.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(blogClassic.commentAwaitingModeration));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(blogClassic.commentAwaitingModeration, "Your comment is awaiting moderation."));
		assertTrue(blogClassic.checkMessageIsDisplayed(blogClassic.commentAwaitingModeration));
	}
}

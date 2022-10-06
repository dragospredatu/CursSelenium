package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogClassicPage {
	
	public WebDriver driver;
	
	public BlogClassicPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	public By blogPost = By.xpath("//h4[@class='post_title']//a[contains(@href, 'business-books')]");
	public By commentField = By.xpath("//textarea[@id='comment']");
	public By nameField = By.xpath("//input[@id='author']");
	public By emailField = By.xpath("//input[@id='email']");
	public By postCommentButton = By.xpath("//p[@class='form-submit']//input[@name='submit']");
	public By commentAwaitingModeration = By.xpath("//div[@class='comment_not_approved']");
	
	//methods
	public void openBlogPost(By locator) {
		
		driver.findElement(locator).click();
	}
	
	public void addCommentToBlogPost(String comment, String name, String email) {
		
		driver.findElement(commentField).sendKeys(comment);
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(postCommentButton).click();
	}
	
	public boolean checkMessageIsDisplayed(By locator) {

		return driver.findElement(locator).isDisplayed();
	}

}

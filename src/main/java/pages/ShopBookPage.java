package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopBookPage {
	
	public WebDriver driver;
	
	public ShopBookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	public By bookCover = By.xpath("//figure[@class='woocommerce-product-gallery__wrapper']");
	public By bookRating = By.xpath("//div[@class='woocommerce-product-rating']//div");
	public By bookTitle = By.xpath("//h1[@class='product_title entry-title']");
	public By bookPrice = By.xpath("//p[@class='price']//span");
	public By bookQuantity = By.xpath("//div[@class='quantity']//input");
	public By bookDescription = By.xpath("//div[@class='woocommerce-product-details__short-description']");
	public By bookAddToCart = By.xpath("//form[@class='cart']//button[@type='submit']");
	public By bookDetails = By.xpath("//div[@class='product_meta']");
	
	public boolean checkElementIsDisplayed(By locator) {

		return driver.findElement(locator).isDisplayed();
	}

}

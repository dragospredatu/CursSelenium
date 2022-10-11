package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
	
	public WebDriver driver;
	public final String SHIPPING_ADDRESS_PAGE_URL = "https://keybooks.ro/account/edit-address/shipping/";
	public WebElement dropdown;
	public Select select;
	
	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	public By shippingAddressTitle = By.xpath("//div[@class='woocommerce-MyAccount-content']//form[@method='post']//h3[text()='Shipping address']");
	public By countryDropdown = By.name("shipping_country");
	public By provinceDropdown = By.name("shipping_state");
	
	
	//Methods
	public void selectByIndex(By element, int index) {

		dropdown = driver.findElement(element);
		select = new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public void selectByValue(By element, String value) {

		dropdown = driver.findElement(element);
		select = new Select(dropdown);
		select.selectByValue(value);
	}
	
	public String getSelectedOption(By element) {

		dropdown = driver.findElement(element);
		select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}

}

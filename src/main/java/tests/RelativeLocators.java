package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import utils.BaseTest;

public class RelativeLocators extends BaseTest{

	/*
	 * toLeftOf
	 * toRightOf
	 * below
	 * above
	 * near
	 * 
	 */

	@Test
	public void relativeLocatorsExample() throws InterruptedException {
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	WebElement price10_20 =driver.findElement(RelativeLocator.with(By.xpath("//h5[contains(text(), '$10.20')]"))
			.toLeftOf(By.cssSelector("a[href='life-in-the-garden']")));
	jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", price10_20);


	WebElement price15_99 =driver.findElement(RelativeLocator.with(By.xpath("//h5[contains(text(), '$15.99')]"))
			.toRightOf(By.xpath("//h5[contains(text(), '$10.20')]")));
	jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red')", price15_99);


	WebElement book = driver.findElement(RelativeLocator.with(By.xpath("//a[@href='its-a-really-strange-story']"))
			.below(By.xpath("//img[contains(@src, 'book12')]")));
	jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:4px solid red')", book);


	WebElement picture = driver.findElement(RelativeLocator.with(By.xpath("//img[contains(@src, 'books7')]"))
			.above(By.xpath("//a[@href='storm']")));
	jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:6px solid red')", picture);


	WebElement author =  driver.findElement(RelativeLocator.with(By.xpath("//p[contains(text(),'Richard Mann')]"))
			.near(picture, 250));
	jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:6px solid red')", author);


	Thread.sleep(4000);
	}
}
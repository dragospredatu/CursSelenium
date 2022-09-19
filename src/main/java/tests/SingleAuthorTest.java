package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;

public class SingleAuthorTest extends BaseTest{
	
	@Test
	public void singleAuthorTest() throws InterruptedException {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.singleAuthorLink);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd first inited'] div div")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd first inited'] div div"), "95%"));
		//WebElement dramaScore = driver.findElement(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd first inited'] div div"));
		//assertEquals(dramaScore.getText(), "95%");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 even inited'] div div")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 even inited'] div div"), "75%"));
		//WebElement biographyScore = driver.findElement(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 even inited'] div div"));
		//assertEquals(biographyScore.getText(), "75%");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd inited'] div div")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd inited'] div div"), "82%"));
		//WebElement biographyScore = driver.findElement(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd inited'] div div"));
		//assertEquals(biographyScore.getText(), "82%");
		
	}

}

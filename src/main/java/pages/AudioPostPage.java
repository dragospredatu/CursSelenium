package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class AudioPostPage extends SeleniumWrappers{
	
	public AudioPostPage(WebDriver driver) {
		super(driver);
	}
	
	public By playButton = By.xpath("//div[contains(@class, 'mejs-playpause-button')]");
	public By songSlider = By.xpath("//span[@class='mejs-time-current']");
	public By volumeSlider = By.xpath("//span[@class='mejs-horizontal-volume-current']");
	
}

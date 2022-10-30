package tests;

import org.testng.annotations.Test;

import utils.BaseTest;

public class AudioPostTest extends BaseTest{
	
	@Test
	public void audioPostTest(){
		
		app.menu.hoverElement(app.menu.blogLink);
		app.menu.hoverElement(app.menu.postFormatsBlogLink);
		app.menu.navigateTo(app.menu.postFormatsBlogLink);
		app.menu.navigateTo(app.postFormatsPage.audioPost);
		app.audioPostPage.click(app.audioPostPage.playButton);
		app.audioPostPage.dragAndDrop(app.audioPostPage.songSlider, 200, 0);
		app.audioPostPage.dragAndDrop(app.audioPostPage.volumeSlider, 50, 0);
	}
}

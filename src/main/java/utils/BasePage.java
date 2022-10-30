package utils;

import pages.AudioPostPage;
import pages.ContactsPage;
import pages.NavMenuPage;
import pages.PostFormatsPage;

public class BasePage extends BaseTest{
	
	public NavMenuPage menu = new NavMenuPage(driver);
	public ContactsPage contactPage = new ContactsPage(driver);
	public PostFormatsPage postFormatsPage = new PostFormatsPage(driver);
	public AudioPostPage audioPostPage = new AudioPostPage(driver);

}

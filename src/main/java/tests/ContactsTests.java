package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class ContactsTests extends BaseTest{
	
	@Test
	public void testContactsPageForm() throws InterruptedException {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.contactLink);
		ContactsPage contactsPage = new ContactsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		//check that message is sent - all fields are filled in
		contactsPage.sendMessage("Name", "email@gmail.com", "Subject", "Message text");
		wait.until(ExpectedConditions.presenceOfElementLocated(contactsPage.messageConfirmation));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(contactsPage.messageConfirmation, "Thank you for your message. It has been sent."));
		assertTrue(contactsPage.checkMessageIsDisplayed(contactsPage.messageConfirmation));
		
		//check error message when the Name field is empty
		contactsPage.sendMessage("", "email@gmail.com", "Subject", "Message text");
		wait.until(ExpectedConditions.presenceOfElementLocated(contactsPage.nameFieldError));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(contactsPage.nameFieldError, "The field is required."));
		assertTrue(contactsPage.checkMessageIsDisplayed(contactsPage.nameFieldError));
		wait.until(ExpectedConditions.presenceOfElementLocated(contactsPage.messageConfirmation));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(contactsPage.messageConfirmation, "One or more fields have an error. Please check and try again."));
		assertTrue(contactsPage.checkMessageIsDisplayed(contactsPage.messageConfirmation));

		//check error message when the Email field is empty
		contactsPage.sendMessage("Name", "", "Subject", "Message text");
		wait.until(ExpectedConditions.presenceOfElementLocated(contactsPage.emailFieldError));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(contactsPage.emailFieldError, "The field is required."));
		assertTrue(contactsPage.checkMessageIsDisplayed(contactsPage.emailFieldError));
		wait.until(ExpectedConditions.presenceOfElementLocated(contactsPage.messageConfirmation));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(contactsPage.messageConfirmation, "One or more fields have an error. Please check and try again."));
		assertTrue(contactsPage.checkMessageIsDisplayed(contactsPage.messageConfirmation));
		
		//check error message when the Message field is empty
		contactsPage.sendMessage("Name", "email@gmail.com", "Subject", "");
		wait.until(ExpectedConditions.presenceOfElementLocated(contactsPage.messageFieldError));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(contactsPage.messageFieldError, "The field is required."));
		assertTrue(contactsPage.checkMessageIsDisplayed(contactsPage.messageFieldError));
		wait.until(ExpectedConditions.presenceOfElementLocated(contactsPage.messageConfirmation));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(contactsPage.messageConfirmation, "One or more fields have an error. Please check and try again."));
		assertTrue(contactsPage.checkMessageIsDisplayed(contactsPage.messageConfirmation));
	}

}

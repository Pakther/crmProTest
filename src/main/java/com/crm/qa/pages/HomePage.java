package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebDriver driver;
	
	/// DECLARE YOUR WEB ELEMENTS
	
	By headerText = By.xpath("//td[contains(text(),'User: 'naveen k')]");
	By contactLink = By.xpath("//a[contains(text(),'Contacts')]");
	
	
	
	// page constructor
	public HomePage (WebDriver driver) {
		
		this.driver = driver;
	}

	
	// Actions
	public String verifyHomePageTitle() {
		

		return driver.getTitle();
	
		
	}
	
	public ContactsPage clickOnContactLink() {
		
		driver.findElement(contactLink).click();
		
		return new ContactsPage();
	
	}
	
}

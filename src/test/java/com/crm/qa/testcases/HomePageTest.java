package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;	
	
	
	public HomePageTest () {
		
		super();
		
	}

	
	
@BeforeMethod	
	public void setUp() {
			
		
		initialization();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		
	}

@Test
public void verifyHomePageTitleTest() {
	
	

	
	String actualHeader = homePage.verifyHomePageTitle();
	String expectedHeader = "CRMPRO";
	
	assertEquals(actualHeader, expectedHeader,"HOMEPAGE TITLE INCORRECT");
	
	System.out.println(actualHeader +" The accurate header is displayed");
	
	
	
}









@AfterMethod
	public void tearDown() {
	
	
	driver.quit();
}
	
}

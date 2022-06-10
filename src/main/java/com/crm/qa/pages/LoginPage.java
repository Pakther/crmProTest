package com.crm.qa.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.crm.qa.base.TestBase;
import com.crm.qa.testdata.CRMReadExcel;

public class LoginPage extends TestBase {
	
	WebDriver driver;
	
	//Page Factory - OR
	

//	
//	@FindBy(xpath = "//*[@name = 'username']")
//	WebElement userNameBtn;
//	
//	
//	@FindBy(xpath = "//*[@name = 'password']")
//	WebElement passwordBtn;
//	
//	
//	@FindBy(xpath = "//input[@type = 'submit']")
//	WebElement loginBtn;
//	
//	
//	@FindBy(xpath = "//img[@class = 'img-responsive']")
//	WebElement crmLogo;
	
	
	By userNameBtn = By.xpath("//*[@name = 'username']");
	By passwordBtn = By.xpath("//*[@name = 'password']");
	By loginBtn = By.xpath("//input[@type = 'submit']");
	By crmLogo = By.xpath("//img[@class = 'img-responsive']");
	
	
	
	
	// initialize page constructor
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	// Actions
	
	public String validateLoginTitle() {
		
	return driver.getTitle();	
		
	}
	
	public boolean validateCRMImage() {
		
		
		
		return driver.findElement(crmLogo).isDisplayed();
		
		
		
//		return crmLogo.isDisplayed();
		
	
		
	}
	

	public HomePage login(String username, String password) {
		
		
		
		driver.findElement(userNameBtn).sendKeys(username.toString());
		driver.findElement(passwordBtn).sendKeys(password.toString());
		driver.findElement(loginBtn).click();
		
		
		
//		userNameBtn.sendKeys(un);
//		passwordBtn.sendKeys(pwd);
//		loginBtn.click();
		
		return new HomePage(driver);
		
	}
	

}

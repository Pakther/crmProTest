package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testdata.CRMReadExcel;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	HomePage homePage;
	
	public LoginPageTest() {
		
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		
	
	setUp();
	loginPage = new LoginPage(driver);
		
	}
	
	
	public Object[][] getData(String excelPath, String sheetName){
		
		
		CRMReadExcel excel = new CRMReadExcel(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object [][] data = new Object[rowCount-1][colCount];
		
		for(int i = 1; i <rowCount; i ++) {
			
			for (int j = 0; j<colCount; j ++) {
				
				Object testData = excel.getCellValue(i, j);
				data[i-1][j] = testData;

				System.out.println(data[i-1][j] + " | ");
				
				
			}
			
			System.out.println();
			
			
		}
		
		return data;	
	}
	
	
	
	@DataProvider (name="LoginData")
	public Object[][] getTestData(){
		
		String excelPath = "./src/main/java/com/crm/qa/testdata/LoginData.xlsx";
		String sheetName = "login";
		
		Object data[][] = getData(excelPath, sheetName);
		
		return data;
		
	
	}
	
	
	@Test (priority = 1)
	public void loginPageTitleTest(){
		
		
		
	String actualTitle = loginPage.validateLoginTitle();
	String expectedTitle = "Free CRM - CRM software for customer relationship management, sales, and support.";
	
	Assert.assertEquals(actualTitle, expectedTitle);
	
	System.out.println("The correct title is displayed: " + actualTitle );

		
		
	}
	
	@Test (priority = 2)
	public void crmLogoImageTest() {
		
	boolean flag = loginPage.validateCRMImage();
		
	Assert.assertTrue(flag);
	
	System.out.println();
		
	}
	
	
	
	@Test (dataProvider = "LoginData", priority = 3)
	public void loginTest(String username, String password) {
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		  homePage = loginPage.login(username, password);
	
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}

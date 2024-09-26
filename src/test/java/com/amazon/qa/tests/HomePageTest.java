package com.amazon.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductListPage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	ProductListPage productListPage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver, wait);
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
	@Test
	public void Log_in() {
		productListPage = homePage.searchingProduct(prop.getProperty("productName"));
		
	}
	
//	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}

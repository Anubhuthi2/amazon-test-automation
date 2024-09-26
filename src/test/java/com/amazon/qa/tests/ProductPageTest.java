package com.amazon.qa.tests;
import org.testng.annotations.Listeners;
import allureReports.AllureListener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductListPage;
import com.qa.pages.ProductPage;

public class ProductPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductListPage productListPage;
	ProductPage productPage;
	
	public ProductPageTest() {
		super();
	}
	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver, wait);
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		productListPage = homePage.searchingProduct(prop.getProperty("productName"));
		productPage = productListPage.findingParticularProduct();
	}
	
	@Test(priority=1)
	public void switchingTabs() {
		productPage.switchingTab();
	}

	@Test(priority=2)
	public void addingToCart() throws InterruptedException {
		productPage.addingProductToCart();
		
}
	//@Afterclass
	public void tearDown() {
		driver.quit();
	}
}

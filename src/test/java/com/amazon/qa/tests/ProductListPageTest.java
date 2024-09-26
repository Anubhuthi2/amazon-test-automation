package com.amazon.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductListPage;
import com.qa.pages.ProductPage;

public class ProductListPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ProductListPage productListPage;
	ProductPage productPage;
	
	public ProductListPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver, wait);
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		productListPage = homePage.searchingProduct(prop.getProperty("productName"));
	}
	
	@Test
	public void SearchingForBrand() {
		productPage = productListPage.findingParticularProduct();
		
}
}
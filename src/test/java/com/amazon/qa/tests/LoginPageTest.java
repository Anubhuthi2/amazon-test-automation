package com.amazon.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage(driver,wait);
	}
	
	@Test
	public void Log_in() {
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
//	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

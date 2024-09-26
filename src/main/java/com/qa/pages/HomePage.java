package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

import dev.failsafe.internal.util.Assert;

public class HomePage extends TestBase{
	
	//Page factory :OR
	@FindBy(xpath= "//span[contains(@id, 'nav-link-accountList-nav-line-1')]")
	WebElement HelloUsername;
	
	@FindBy(xpath = "//input[contains(@id , 'twotabsearchtextbox')]")
	WebElement searchbox;
	
	public HomePage(WebDriver driver ,WebDriverWait wait) {
		this.driver = driver;
		this.wait= wait;
		PageFactory.initElements(driver, this);
	}
	
	public void Ex_Wait(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public ProductListPage searchingProduct(String product) {
		wait.until(ExpectedConditions.textToBePresentInElement(HelloUsername, prop.getProperty("name")));
		searchbox.sendKeys(product);
		searchbox.sendKeys(Keys.RETURN);
		return new ProductListPage(driver,wait);
	}
	
	
	

}

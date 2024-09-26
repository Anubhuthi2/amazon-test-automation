package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class ProductListPage extends TestBase {
	
	@FindBy(xpath= "//span[contains(@class ,'a-size-base-plus a-color-base') and text() = 'boAt'][1]")
	WebElement BoAtWatch;
	
	@FindBy(xpath="//span[contains(@class ,'a-size-base-plus a-color-base a-text-normal')][1]")
    WebElement BoAtWatchClickableElement;	
	
	public ProductListPage(WebDriver driver ,WebDriverWait wait) {
		this.driver = driver;
		this.wait= wait;
		PageFactory.initElements(driver, this);
	}
		
	public ProductPage findingParticularProduct() {
		currentHandle = driver.getWindowHandle();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", BoAtWatchClickableElement);
		BoAtWatchClickableElement.click();
		return new ProductPage(driver,wait);
	}
		
		
}

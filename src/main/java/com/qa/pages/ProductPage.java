package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(xpath = "//input[@id ='add-to-cart-button']")
	WebElement addToCart;
	
	public ProductPage(WebDriver driver ,WebDriverWait wait) {
		this.driver = driver;
		this.wait= wait;
		PageFactory.initElements(driver, this);
	}
	
	public void switchingTab() {
		Set<String> handles=driver.getWindowHandles();
		for(String handle: handles) {
		if(!handle.equalsIgnoreCase(currentHandle)) {
		//Switch to the opened tab
		driver.switchTo().window(handle);
		}
		else break;
			
	}
	}
	public void addingProductToCart() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
		addToCart.click();
	}
	
}

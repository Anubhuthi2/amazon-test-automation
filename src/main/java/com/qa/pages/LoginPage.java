package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait;
	
	@FindBy(xpath = "//span[contains(@id , 'nav-link-accountList-nav-line-1')]")
	WebElement HelloSignin;
	
	@FindBy(xpath = "//span[contains(@class ,'nav-action-inner') and text() = 'Sign in']")
	WebElement SigninBtn;
	
	@FindBy(xpath = "//*[contains(@id ,'ap_email')]")
	WebElement username;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(id = "signInSubmit")
	WebElement signinBtn;
	
	@FindBy(id = "auth-fpp-link-bottom")
	WebElement forgotPassword;
	
	public LoginPage(WebDriver driver, WebDriverWait wait ){
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	public void ex_wait(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public HomePage login(String user,String pass) {
		ex_wait(HelloSignin);
		Actions action =new Actions(driver);
		action.moveToElement(HelloSignin).perform();
		
		ex_wait(SigninBtn);
		SigninBtn.click();
		
		ex_wait(username);
		username.sendKeys(user);
		continueButton.click();
		
		ex_wait(password);
		password.sendKeys(pass);
		signinBtn.click();
		
		return new HomePage(driver , wait);
	}
	

}

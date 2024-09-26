package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase{
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	protected String currentHandle;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		
		}catch(FileNotFoundException e)
		{e.printStackTrace();
		}catch(IOException e)
		{e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String BrowserName = prop.getProperty("browser");
		if(BrowserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public static WebDriver getDriver() {
        return driver;
    }

}

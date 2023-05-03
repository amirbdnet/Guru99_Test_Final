package com.guru99.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.guru99.qa.Util.TestUtill;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	public static WebDriver driver;  // Initialize webdriver
	public static Properties prop;
	
	public TestBaseClass(){
		
		try {			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\amirb\\eclipse-workspace\\Guru99Test\\src\\main\\java\\com\\guru99\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("Select Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtill.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtill.Implicit_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	

}

package com.guru99.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBaseClass;
import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;

public class LoginPageTest extends TestBaseClass {
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	@Test(priority =1)
	public void loginpage_Title_Test() {
		String title = loginpage.validatetitle();
		System.out.println("Title of page is " + title);
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	@Test(priority = 2)
	public void loginTest() {
	homepage =	loginpage.login(prop.getProperty("UserID"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void teraDown() {
		driver.quit();
	}
}

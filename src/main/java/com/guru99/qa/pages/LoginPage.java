package com.guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.base.TestBaseClass;

public class LoginPage extends TestBaseClass {

	
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement UserID;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	@FindBy(name="btnReset")
	WebElement resetbtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	public String validatetitle() {
		return driver.getTitle();
	}
	public HomePage login (String un, String pwd) {
		UserID.sendKeys(un);
		Password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}

}

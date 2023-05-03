package com.guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.base.TestBaseClass; ////a[contains (text(),'New Account')]

public class HomePage extends TestBaseClass  {
	
	@FindBy(xpath = "//a[contains (text(),'New Customer')]")
	WebElement NewCustomerLink;

	@FindBy(xpath = "//a[contains (text(),'New Account')]")
	WebElement NewAccountLink;
	
	@FindBy(xpath = "//a[contains (text(),'Deposit')]")
	WebElement Deposit;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String varifyHomePageTitle() {
		return driver.getTitle();
	}
	public NewCustomerpage NewCustomerLink() {
		NewCustomerLink.click();
		return new NewCustomerpage();
	}
	public NewAccount NewAccountLink() {
		NewAccountLink.click();
		return new NewAccount();
	}
}

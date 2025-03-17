package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class HomePage extends BaseClass{

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccEdit;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutEdit;

	public WebElement getMyAccEdit() {
		return myAccEdit;
	}

	public WebElement getLogoutEdit() {
		return logoutEdit;
	}
	
	public void signOut() {
		myAccEdit.click();
		logoutEdit.click();
	}
}

package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

/**
 * 
 * @author Siddesh Contains Login page elements & business lib like login()
 * 
 **/
public class LoginPage extends BaseClass {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccEdit;
	
	@FindBy(linkText = "Login")
	private WebElement loginEdit;
	
	
	@FindBy(id = "input-email")
	private WebElement usrname;

	@FindBy(id = "input-password")
	private WebElement pasd;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement assWarningPopup;

	public WebElement getAssWarningPopup() {
		return assWarningPopup;
	}

	public WebElement getUsrname() {
		return usrname;
	}

	public WebElement getPassword() {
		return pasd;
	}

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement lgnbtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPasd() {
		return pasd;
	}

	public WebElement getLgnbtn() {
		return lgnbtn;
	}

	public void loginToApp(String username, String password) {
		
		myAccEdit.click();
		loginEdit.click();
		usrname.sendKeys(username);
		pasd.sendKeys(password);

		wLib.scrollByAmt(driver);
		lgnbtn.click();
	}
	
	public void loginToAppUsingInvalidCred(String invalidEmail, String invalidPassword) {
		usrname.sendKeys(invalidEmail);
		pasd.sendKeys(invalidPassword);
		lgnbtn.click();
	}
	

}

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
public class LoginPage extends BaseClass{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="exampleInputEmail1")
	private WebElement usrname;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement pasd;

	public WebElement getUsrname() {
		return usrname;
	}

	public WebElement getPassword() {
		return pasd;
	}
	
	@FindBy(name = "login")
	private WebElement lgnbtn;

	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	public void loginToApp(String username, String password) {
		usrname.sendKeys(username);
		pasd.sendKeys(password);
		
		wLib.scrollByAmt(driver);
		lgnbtn.click();
	}
	
}

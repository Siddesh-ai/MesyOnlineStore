package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class MyCartPage extends BaseClass {
	WebDriver driver;

	public MyCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " //a[contains(text(),'Books')]")
	private WebElement bookEdit;

	@FindBy(name = "product")
	private WebElement prodEdit;

	@FindBy(xpath = "//ul[@class='list-unstyled']/li/a[@href='#']")
	private WebElement userLoginConf;

	@FindBy(xpath = "//ul[@class='list-unstyled']//a[@href='#']")
	private WebElement myAccEdit;

	@FindBy(xpath = "//input[@class='form-control unicase-form-control text-input'][@id='name']")
	private WebElement nameEditInMyAccPage;

	@FindBy(xpath = "//input[@class='form-control unicase-form-control text-input'][@id='contactno']")
	private WebElement contactEditInMyAccPage;

	@FindBy(xpath = "//button[text()='Update'][@name='update']")
	private WebElement updateBtnInMyAccPage;

	@FindBy(xpath  = "//a[@href='category.php?cid=4']")
	private WebElement elec;

	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getElec() {
		return elec;
	}

	public WebElement getUpdateBtnInMyAccPage() {
		return updateBtnInMyAccPage;
	}

	public WebElement getContactEditInMyAccPage() {
		return contactEditInMyAccPage;
	}

	public WebElement getNameEditInMyAccPage() {
		return nameEditInMyAccPage;
	}

	public WebElement getMyAccEdit() {
		return myAccEdit;
	}

	public WebElement getUserLoginConf() {
		return userLoginConf;
	}

	public WebElement getProdEdit() {
		return prodEdit;
	}

	public WebElement getBookEdit() {
		return bookEdit;
	}

	public void searchProd(String productInfo) {
		prodEdit.click();
		prodEdit.sendKeys(productInfo);
	}

	public void updatePersonalInfoInMyAccPage(String name, String contact) throws Throwable {
		myAccEdit.click();
		nameEditInMyAccPage.sendKeys(name);
		contactEditInMyAccPage.sendKeys(contact);
		updateBtnInMyAccPage.click();
	}

}

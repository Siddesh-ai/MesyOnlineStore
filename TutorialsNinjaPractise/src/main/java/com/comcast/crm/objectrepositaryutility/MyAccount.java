package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class MyAccount extends BaseClass {
	WebDriver driver;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Laptops & Notebooks")
	private WebElement lapNote;

	@FindBy(name = "search")
	private WebElement seaechfld;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-default btn-lg')]")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSeaechfld() {
		return seaechfld;
	}

	public WebElement getAllLapNotDropdown() {
		return allLapNotDropdown;
	}

	@FindBy(xpath = "//a[text()='Show AllLaptops & Notebooks']")
	private WebElement allLapNotDropdown;

	public WebElement getAllLapNote() {
		return allLapNotDropdown;
	}

	public WebElement getLapNote() {
		return lapNote;
	}

	public void laptopNotebookModule() {
		lapNote.click();
		allLapNotDropdown.click();
	}
	
	public void enterSearchFieldForProductCompare(String productName) {
		seaechfld.sendKeys(productName);
		searchBtn.click();
	}
}

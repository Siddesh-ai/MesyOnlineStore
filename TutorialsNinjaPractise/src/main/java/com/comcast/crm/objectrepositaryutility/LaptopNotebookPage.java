package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class LaptopNotebookPage extends BaseClass {
	WebDriver driver;

	public LaptopNotebookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//input[@name='search']")
	private WebElement seaechfld;
	
	@FindBy(xpath = "//span[@class='input-group-btn']/button[@type='button']")
	private WebElement searchBtn;
	
	public WebElement getSeaechfld() {
		return seaechfld;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void searchAndEnterLapNotPage(String element) {
		seaechfld.sendKeys(element);
		searchBtn.click();
	}

}

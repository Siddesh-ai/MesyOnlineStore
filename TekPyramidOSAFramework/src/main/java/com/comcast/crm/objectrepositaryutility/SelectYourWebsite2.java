package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectYourWebsite2 {
	WebDriver driver;

	public SelectYourWebsite2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(linkText = "Online_Shopping_Application")
	private WebElement SelectYourWebsite;


	public WebElement getSelectYourWebsite() {
		return SelectYourWebsite;
	}
}

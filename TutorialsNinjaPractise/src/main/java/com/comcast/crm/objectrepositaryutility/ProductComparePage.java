package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class ProductComparePage extends BaseClass{

	WebDriver driver;
	public ProductComparePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//i[contains(@class,'fa fa-exchange')]/parent::button)[1]")
	private WebElement compareBtn;
	
	public WebElement getCompareBtn() {
		return compareBtn;
	}
	
	public void productCompareAction() {
		wLib.mouseMoveOnElement(driver, compareBtn);
		compareBtn.click();
	}
	
	@FindBy(xpath = "//ul[contains(@class,'list-unstyled')]/preceding-sibling::h1")
	private WebElement assertProductNameVerify;
	
	@FindBy(linkText = "product comparison")
	private WebElement assertProductSuccessAddedHeaderVerify;
	
	public WebElement getAssertProductNameVerify() {
		return assertProductNameVerify;
	}

	public WebElement getAssertProductSuccessAddedHeaderVerify() {
		return assertProductSuccessAddedHeaderVerify;
	}

	public WebElement getAssProd() {
		return assertProductNameVerify;
	}
	
}

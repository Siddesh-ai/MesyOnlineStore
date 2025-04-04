package ecommerce.mecys.genericutility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.mecys.genericutility.basetest.BaseClass;

public class PaymentMethodPage extends BaseClass {
	WebDriver driver;

	public PaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='COD']")
	private WebElement codRadioBtn;
	
	@FindBy(xpath  = "//input[@value='submit']")
	private WebElement submitBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCodRadioBtn() {
		return codRadioBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
}

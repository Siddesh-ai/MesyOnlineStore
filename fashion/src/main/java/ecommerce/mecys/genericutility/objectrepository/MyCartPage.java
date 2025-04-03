package ecommerce.mecys.genericutility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.mecys.genericutility.basetest.BaseClass;

public class MyCartPage extends BaseClass {

	WebDriver driver;

	public MyCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "product")
	private WebElement searchBar;

	@FindBy(xpath =   "//button[@name=\"search\"]")
	private WebElement searchBtn;

	@FindBy(xpath = "//td[@class='cart-product-name-info']/..//a[text()='Bucket']")
	private WebElement verifyProd;

	@FindBy(xpath = "//div[@class='arrow plus gradient']")
	private WebElement increaseQuantity;

	@FindBy(xpath = "//input[@class=\"btn btn-upper btn-primary pull-right outer-right-xs\"]")
	private WebElement updateShoppingCartBtn;

	@FindBy(xpath = "//button[text()='PROCCED TO CHEKOUT']")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(name = "billingaddress")
	private WebElement billingAddressEdit;
	
	@FindAll({@FindBy(id = "bilingstate"), @FindBy(name="bilingstate")})
	private WebElement bilingStateEdit;
	
	@FindBy(id = "billingcity")
	private WebElement billingCityEdit;
	
	@FindBy(id="billingpincode")
	private WebElement billingPincodeEdit;
	
	@FindBy(name="update")
	private WebElement shippingUpdateBtn;
	
	@FindBy(name="shippingaddress")
	private WebElement shippingAddressEdit;
	
	@FindBy(id ="shippingstate")
	private WebElement shippingStateEdit;
	
	@FindBy(id="shippingcity")
	private WebElement shippingCityEdit;
	
	@FindBy(name="shippingpincode")
	private WebElement shippingPincodeEdit;
	
	@FindBy(name="shipupdate")
	private WebElement shippingUdateBtn;
	

	

	public WebElement getBillingAddressEdit() {
		return billingAddressEdit;
	}

	public WebElement getShippingUpdateBtn() {
		return shippingUpdateBtn;
	}

	public WebElement getShippingAddressEdit() {
		return shippingAddressEdit;
	}

	public WebElement getShippingStateEdit() {
		return shippingStateEdit;
	}

	public WebElement getShippingCityEdit() {
		return shippingCityEdit;
	}

	public WebElement getShippingPincodeEdit() {
		return shippingPincodeEdit;
	}

	public WebElement getShippingUdateBtn() {
		return shippingUdateBtn;
	}

	public WebElement getBilingStateEdit() {
		return bilingStateEdit;
	}

	public WebElement getBillingCityEdit() {
		return billingCityEdit;
	}

	public WebElement getBillingPincodeEdit() {
		return billingPincodeEdit;
	}

	public WebElement getProceedToCheckOutBtn() {
		return proceedToCheckOutBtn;
	}

	public WebElement getUpdateShoppingCartBtn() {
		return updateShoppingCartBtn;
	}

	public WebElement getVerifyProd() {
		return verifyProd;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	@FindBy(xpath = "//a[contains(text(),'Electronics')]")
	private WebElement selectElectronicsOption;

	public WebElement getSelectElectronicsOption() {
		return selectElectronicsOption;
	}

	public WebElement getIncreaseQuantity() {
		return increaseQuantity;
	}

	public void increaseProductQuantity() throws Throwable {
		double quantity = eLib.getIntDataFromExcel("IncreaseCount", 0, 0);
		for (int i = 0; i<= quantity; i++) {
			increaseQuantity.click();
		}
	}

	public void updateShoppingCart() throws InterruptedException {
		wLib.scrollByAmt(driver);
		getUpdateShoppingCartBtn().click();
		Thread.sleep(3000);
	}

}

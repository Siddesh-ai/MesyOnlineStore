package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class ProductsDetailsPage extends BaseClass {
	WebDriver driver;

	public ProductsDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "ir")
	private WebElement prodQuan;

	@FindBy(className = "btn btn-primary")
	private WebElement addToCartEdit;

	@FindBy(xpath = "//div[@class='col-sm-6 col-md-4 wow fadeInUp animated']//a[@href='category.php?page=product&action=add&id=43']")
	private WebElement selectAddtoCart;

	@FindBy(className  = "search-field")
	private WebElement searchOnProductCategorypage;


	@FindBy(xpath = "//button[@class='search-button']")
	private WebElement searchBtn;
	
	public WebElement getClickSearch() {
		return searchBtn;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getSearchOnProductCategorypage() {
		return searchOnProductCategorypage;
	}

	public WebElement getSelectAddtoCart() {
		return selectAddtoCart;
	}

	public WebElement getProdQuan() {
		return prodQuan;
	}

	public WebElement getAddToCartEdit() {
		wLib.scrollByAmt(driver);
		return addToCartEdit;
	}

	public void enterQuantity(int add) throws Throwable {
		for (int i = 1; i < 40; i++) {
			prodQuan.click();
		}
	}

	public void cartItemAdding() throws InterruptedException {
		searchOnProductCategorypage.sendKeys("Asus Strix G16");
		Thread.sleep(3000);
		searchBtn.click();
		Thread.sleep(3000);

		addToCartEdit.click();
		Thread.sleep(3000);

		selectAddtoCart.click();
	}
}

package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class BooksPage extends BaseClass {
	WebDriver driver;

	public BooksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"product-info text-left\"]//a[text()=\"The Wimpy Kid Do -It- Yourself Book\"]")
	private WebElement engNovel;

	@FindBy(xpath = "//a[@href=\"category.php?pid=15&&action=wishlist\"]")
	private WebElement addToWishListEdit;

	public WebElement getAddToWishListEdit() {
		wLib.scrollByAmt(driver);
		return addToWishListEdit;
	}

	public WebElement getEngNovel() {
		return engNovel;
	}

	public WebElement getAddToCartedit() {
		return addToWishListEdit;
	}

}

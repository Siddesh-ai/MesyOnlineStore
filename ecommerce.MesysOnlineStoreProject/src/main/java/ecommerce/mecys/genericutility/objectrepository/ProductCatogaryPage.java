package ecommerce.mecys.genericutility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.mecys.genericutility.basetest.BaseClass;

public class ProductCatogaryPage extends BaseClass{
	WebDriver driver;

	public ProductCatogaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "royal Chettinad silk")
	private WebElement prodname;
	
	@FindBy(xpath = "//img[@src='admin/productimages/14/lenovo-ideapad-notebook-original-1.jpeg']/../../../..//button[text()='Add to cart']")
	private WebElement addToCartBtn;

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getProdname() {
		return prodname;
	}
	
	public void findProdnameAndClickProd() {
		wLib.scrollByAmt(driver);
		prodname.click();
	}
	
	public void addToCart() {
		wLib.scrollByAmt(driver);
		addToCartBtn.click();
		driver.switchTo().alert().accept();
	}
	
}

package ecommerce.mecys.genericutility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.mecys.genericutility.basetest.BaseClass;

public class HomePage extends BaseClass {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement selectLoginOption;



	public WebElement getSelectLoginOption() {
		return selectLoginOption;
	}
	
	@FindBy(xpath = "//a[@href=\"logout.php\"]")
	private WebElement logoutOption;
	
	
	

	public WebElement getLogoutOption() {
		return logoutOption;
	}
	

}

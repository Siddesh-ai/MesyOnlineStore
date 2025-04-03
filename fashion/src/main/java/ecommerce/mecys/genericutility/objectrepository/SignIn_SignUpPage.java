package ecommerce.mecys.genericutility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.mecys.genericutility.basetest.BaseClass;

public class SignIn_SignUpPage extends BaseClass{

	WebDriver driver;
	public SignIn_SignUpPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "exampleInputEmail1")
	private WebElement emailTextField;
	
	@FindBy(id = "exampleInputPassword1")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement lgnBtn;
	
	
	

	
	

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLgnBtn() {
		return lgnBtn;
	}

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement signOut;

	public WebElement getSignOut() {
		return signOut;
	}

	public void signOut() {
		signOut.click();
	}
	
	
	public void signInToApp(String username, String password) {
		
		emailTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		wLib.scrollByAmt(driver);
		lgnBtn.click();
	}
}

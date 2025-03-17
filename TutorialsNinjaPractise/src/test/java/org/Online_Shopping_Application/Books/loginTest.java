package org.Online_Shopping_Application.Books;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositaryutility.LoginPage;

public class loginTest extends BaseClass{
	@Test(groups="regressionTest")
	public void loginUsingInvalidCredTest() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		String invalidEmail = eLib.getDataFromExcel("LoginInvalidCred", 1, 2);
		String invalidPassword = eLib.getDataFromExcel("LoginInvalidCred", 1, 3);

		loginPage.loginToAppUsingInvalidCred(invalidEmail, invalidPassword);              // first disable login cred in baseclass
		
		WebElement AssertWarningPop = loginPage.getAssWarningPopup();
		Assert.assertTrue(AssertWarningPop.isDisplayed());
	}
}

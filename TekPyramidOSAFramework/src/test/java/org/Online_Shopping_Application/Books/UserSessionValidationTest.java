package org.Online_Shopping_Application.Books;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositaryutility.MyCartPage;
import com.comcast.crm.objectrepositaryutility.ProductsDetailsPage;

public class UserSessionValidationTest extends BaseClass {

	@Test
	public void UserProfileUpdateTest() throws Throwable {
		MyCartPage mcp = new MyCartPage(driver);

		String actualUserInfoOnHomePage = mcp.getUserLoginConf().getText();

		String expectedUserInfoOnHomePage = eLib.getDataFromExcel("IntegrationTestCase", 1, 1);

		Assert.assertEquals(actualUserInfoOnHomePage.contains(expectedUserInfoOnHomePage), true);
	}

	@Test
	public void ProfileUpdateReflectionTest() throws Throwable {

		String name = eLib.getDataFromExcel("IntegrationTestCase", 1, 2);
		String contact = eLib.getDataFromExcel("IntegrationTestCase", 1, 3);

		MyCartPage mcp = new MyCartPage(driver);

		mcp.updatePersonalInfoInMyAccPage(name, contact);

		String actualUserInfoOnHomePage = mcp.getUserLoginConf().getText();
		String expectedUserInfoOnHomePage = eLib.getDataFromExcel("IntegrationTestCase", 1, 2).trim();

		Assert.assertEquals(expectedUserInfoOnHomePage, actualUserInfoOnHomePage);

	}

	@Test
	public void CartCheckoutValidationTest() throws InterruptedException {
		MyCartPage mcp = new MyCartPage(driver);

		WebElement ele = mcp.getElec();
		wLib.doubleClick(driver, ele);
		
		ProductsDetailsPage pdp = new ProductsDetailsPage(driver);
		pdp.cartItemAdding();

		 Assert.assertEquals(false, null);

	}

}

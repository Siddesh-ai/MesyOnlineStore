package ecommerce.mecys.automation.smoketest;

import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce.mecys.genericutility.basetest.BaseClass;
import ecommerce.mecys.genericutility.objectrepository.HomePage;

public class EcommerceSmokeTest extends BaseClass {

	@Test(groups="smokeTest")
	public void verifyHomepageLoadTest() throws Throwable {
		// Assert page title
		String expectedTitle = eLib.getDataFromExcel("SmokeData", 1, 0);
		String actuaTitle = driver.getTitle();
		Assert.assertTrue(actuaTitle.contains(expectedTitle),
				"Title mismatch expected: " + expectedTitle + " but got " + actuaTitle);
		System.out.println("Homepage loaded successfully.");
	}

	@Test(groups="smokeTest")
	public void verifyLoginFunctionalityTest() throws Throwable {
		// Verify successful login
		String expectedUrl = eLib.getDataFromExcel("SmokeData", 1, 1);
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Login successful");

	}
}

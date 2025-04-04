package ecommerce.mecys.automation.integrationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce.mecys.genericutility.basetest.BaseClass;
import ecommerce.mecys.genericutility.objectrepository.HomePage;
import ecommerce.mecys.genericutility.objectrepository.MyCartPage;
import ecommerce.mecys.genericutility.objectrepository.ProductCatogaryPage;
import ecommerce.mecys.genericutility.objectrepository.ProductDetailsPage;

public class EcommerceIntegrationTest extends BaseClass {

	@Test(groups="IntegrationTest")
	public void searchAndVerifyProductPageTest() throws Throwable {
		MyCartPage mcp = new MyCartPage(driver);
		String prodName = eLib.getDataFromExcel("IntegrationData", 1, 0);
		mcp.getSearchBar().sendKeys((prodName), Keys.ENTER);

		ProductCatogaryPage pcp = new ProductCatogaryPage(driver);
		pcp.findProdnameAndClickProd();

		String expectedProduct = eLib.getDataFromExcel("IntegrationData", 1, 0);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		String actualProduct = driver.findElement(By.xpath("//h1[text()='" + prodName + "']")).getText();
		Assert.assertEquals(expectedProduct, actualProduct);
	}

	@Test(groups="IntegrationTest")
	public void cartItemFlowToCheckoutTest() {

		MyCartPage mcp = new MyCartPage(driver);
		mcp.getSelectElectronicsOption().click();

		ProductCatogaryPage pcp = new ProductCatogaryPage(driver);
		pcp.addToCart();

		Assert.assertTrue(mcp.getVerifyProd().isDisplayed());
		System.out.println("Test Passed: The added item appears in the checkout");

	}
}

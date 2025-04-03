package ecommerce.mecys.automation.endtoend;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce.mecys.genericutility.basetest.BaseClass;
import ecommerce.mecys.genericutility.objectrepository.MyCartPage;
import ecommerce.mecys.genericutility.objectrepository.PaymentMethodPage;
import ecommerce.mecys.genericutility.objectrepository.ProductCatogaryPage;
import ecommerce.mecys.genericutility.objectrepository.ProductDetailsPage;

public class EcommerceEndToEndTest extends BaseClass {

	@Test(priority = 1)
	public void endToEndShoppingFlowTest() throws Throwable {
		MyCartPage mcp = new MyCartPage(driver);
		String prodName = eLib.getDataFromExcel("IntegrationData", 1, 0);
		mcp.getSearchBar().sendKeys((prodName), Keys.ENTER);

		ProductCatogaryPage pcp = new ProductCatogaryPage(driver);
		pcp.findProdnameAndClickProd();

		String expectedProduct = eLib.getDataFromExcel("IntegrationData", 1, 0);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		String actualProduct = driver.findElement(By.xpath("//h1[text()='" + prodName + "']")).getText();
		Assert.assertEquals(expectedProduct, actualProduct);

		mcp.getSelectElectronicsOption().click();
		pcp.addToCart();
		Assert.assertTrue(mcp.getVerifyProd().isDisplayed());
		System.out.println("Test Passed: The added item appears in the checkout");
	}

	@Test(priority = 2)
	public void endToEndUpdateQuantityTest() throws InterruptedException {
		MyCartPage mcp = new MyCartPage(driver);
		mcp.getSelectElectronicsOption().click();

		ProductCatogaryPage pcp = new ProductCatogaryPage(driver);
		pcp.addToCart();

		mcp.increaseProductQuantity();
		Thread.sleep(3000);
		mcp.updateShoppingCart();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		wLib.scrollByAmt(driver);
		mcp.getProceedToCheckOutBtn().click();

		PaymentMethodPage pmp = new PaymentMethodPage(driver);
		pmp.getCodRadioBtn().click();
		pmp.getSubmitBtn().click();
		System.out.println("Test Passed: The added item order placed sucessfully");
	}

	@Test(priority = 3)
	public void endToEndShippingAndBillingAddressTest() throws InterruptedException {
		MyCartPage mcp = new MyCartPage(driver);
		mcp.getSelectElectronicsOption().click();

		ProductCatogaryPage pcp = new ProductCatogaryPage(driver);
		pcp.addToCart();
		mcp.increaseProductQuantity();
		mcp.updateShoppingCart();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		wLib.scrollByAmt(driver);
		
		mcp.getProceedToCheckOutBtn().click();

		PaymentMethodPage pmp = new PaymentMethodPage(driver);
		pmp.getCodRadioBtn().click();
		pmp.getSubmitBtn().click();
		System.out.println("Test Passed: The added item order placed sucessfully");
	}
}

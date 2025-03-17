package org.Online_Shopping_Application.Books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositaryutility.LaptopNotebookPage;
import com.comcast.crm.objectrepositaryutility.LoginPage;
import com.comcast.crm.objectrepositaryutility.MyAccount;
import com.comcast.crm.objectrepositaryutility.ProductComparePage;
import com.comcast.crm.objectrepositaryutility.SearchResultsPage;

public class AddToCartTest2 extends BaseClass {
	@Test(groups="smokeTest")

	public void addToCartTest() throws Throwable {
		MyAccount mac = new MyAccount(driver);
		mac.laptopNotebookModule();

		LaptopNotebookPage lnp = new LaptopNotebookPage(driver);
		String laptopName = eLib.getDataFromExcel("prod", 1, 0);
		lnp.searchAndEnterLapNotPage(laptopName);

		SearchResultsPage srp = new SearchResultsPage(driver);
		wLib.scrollByAmt(driver);
		driver.findElement(By.xpath("//div[contains(@class, 'product-layout')]//a[contains(text(),'" + laptopName
				+ "')]/ancestor::div[contains(@class,'product-thumb')]//button[contains(@onclick, 'cart.add')]"))
				.click();
	}


	@Test(groups="ST")
	public void prodCompareFromProdDisplayPageTest() throws Throwable {
		String productName = eLib.getDataFromExcel("LoginInvalidCred", 1, 4);

		MyAccount map =new MyAccount(driver);
		map.enterSearchFieldForProductCompare(productName);
		
		SearchResultsPage srp = new SearchResultsPage(driver);
		//wLib.scrollByAmt(driver);
		
		/* To add to cart use this dynamic xpath
		driver.findElement(By.xpath("//div[contains(@class, 'product-layout')]//a[contains(text(),'" + productName
				+ "')]/ancestor::div[contains(@class,'product-thumb')]//button[contains(@onclick, 'cart.add')]"))
				.click();    
				*/
		srp.getSelectProductOnSearchresultPage().click();
		
		ProductComparePage pcp = new ProductComparePage(driver);
	  
	    String actualProductDetails = pcp.getAssProd().getText();
	    Assert.assertEquals(productName, actualProductDetails);
	    
	    pcp.productCompareAction();
	    
	    boolean productVerifypcp = pcp.getAssertProductSuccessAddedHeaderVerify().isDisplayed();
	    Assert.assertTrue(productVerifypcp);
	}
	
}

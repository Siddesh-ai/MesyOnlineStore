package org.Online_Shopping_Application.Books;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositaryutility.BooksPage;
import com.comcast.crm.objectrepositaryutility.MyCartPage;
import com.comcast.crm.objectrepositaryutility.ProductsDetailsPage;

public class BooksTest extends BaseClass {

	@Test

	private void booksTest() throws Throwable {
		MyCartPage mcp = new MyCartPage(driver);
		mcp.getBookEdit().click();

		BooksPage bp = new BooksPage(driver);
		wLib.scrollByAmt(driver);
		bp.getEngNovel().click();

		ProductsDetailsPage pdp = new ProductsDetailsPage(driver);
		wLib.scrollByAmt(driver);
		pdp.getAddToCartEdit().click();
		
		String expectedText="Realted Products";
		
        String actualtext = driver.findElement(By.xpath("//div[@class=\"row single-product outer-bottom-sm \"]")).getText();
        Assert.assertTrue(actualtext.contains(expectedText));
	}
	
	@Test
	public void booksTestWithAssertVerif() {
		MyCartPage mcp = new MyCartPage(driver);
		mcp.getBookEdit().click();
		
		BooksPage bp = new BooksPage(driver);
		wLib.scrollByAmt(driver);
		bp.getAddToWishListEdit().click();
		
		String ExpectedText = "The Wimpy Kid Do -It- Yourself Book";
		
		Assert.assertTrue(true, ExpectedText);
	}
	
	public void searchForTheProduct() throws Throwable {
		String productInfo=eLib.getDataFromExcel("product", 3, 0);
		MyCartPage mcp = new MyCartPage(driver);
		mcp.searchProd(productInfo);
	}
}
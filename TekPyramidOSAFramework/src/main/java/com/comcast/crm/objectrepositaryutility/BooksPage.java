package com.comcast.crm.objectrepositaryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Siddesh Contains Login page elements & business lib like login()
 * 
 **/
public class BooksPage {
	WebDriver driver;

	public BooksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}

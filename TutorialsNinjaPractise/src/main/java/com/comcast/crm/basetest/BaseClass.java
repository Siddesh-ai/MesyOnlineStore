package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositaryutility.HomePage;
import com.comcast.crm.objectrepositaryutility.LoginPage;

public class BaseClass {

	/* Create object */

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest", "ST" })
	public void configBS() throws SQLException {
		System.out.println("===Connect to DB , Report Config===");
		dbLib.getDbconnection();
	}

	@BeforeClass(groups = { "smokeTest", "regressionTest" ,"ST"})

	public void configBC() throws Throwable {
		System.out.println("===Launch the BROWSER===");

		String BROWSER = fLib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("FireFox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		wLib.waitForPageToLoad(driver); // implicit wait
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest","ST" })
	public void configBM() throws Throwable {

		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

	}


	@AfterMethod(groups = { "smokeTest", "regressionTest","ST"})
	public void configAM() {
		System.out.println("===Logout to Application");
		HomePage hp = new HomePage(driver);
	    hp.signOut();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" ,"ST" })
	public void configAC() {
		System.out.println("===Close the BROWSER===");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest","ST" })
	public void configAS() throws SQLException {
		System.out.println("====Close DB , Report BackUp====");
		dbLib.closeDbconnection();

	}

}

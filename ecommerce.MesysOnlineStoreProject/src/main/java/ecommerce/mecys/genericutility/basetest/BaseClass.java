package ecommerce.mecys.genericutility.basetest;

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

import ecommerce.mecys.genericutility.databaseutility.DataBaseUtility;
import ecommerce.mecys.genericutility.fileutility.ExcelUtility;
import ecommerce.mecys.genericutility.fileutility.FileUtility;
import ecommerce.mecys.genericutility.objectrepository.HomePage;
import ecommerce.mecys.genericutility.objectrepository.SignIn_SignUpPage;
import ecommerce.mecys.genericutility.webdriverutility.JavaUtility;
import ecommerce.mecys.genericutility.webdriverutility.WebDriverUtility;

public class BaseClass {

	/* Create object */

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver = null; // driver object created grobally

	@BeforeSuite(groups = { "smokeTest", "IntegrationTest", "SystemTest" })
	public void configBS() throws SQLException {
		System.out.println("===Connect to DB , Report Config===");
		dbLib.getDbconnection();
	}

	@BeforeClass(groups = { "smokeTest", "IntegrationTest", "SystemTest" })

	public void configBC() throws Throwable {
		System.out.println("===Launch the BROWSER===");

		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));

		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("FireFox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver(); 
		}
		wLib.waitForPageToLoad(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@BeforeMethod(groups = { "smokeTest", "IntegrationTest" , "SystemTest"})
	public void configBM() throws Throwable {

		String USERNAME = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));
		
		HomePage hp= new HomePage(driver);
		hp.getSelectLoginOption().click();
		SignIn_SignUpPage si =new SignIn_SignUpPage(driver);
		si.signInToApp(USERNAME, PASSWORD);
		
	}

	@AfterMethod(groups = { "smokeTest", "IntegrationTest", "SystemTest" })
	public void configAM() {
		System.out.println("===Logout to Application");
		HomePage hp = new HomePage(driver);
		hp.getLogoutOption().click();
		
	}

	@AfterClass(groups = { "smokeTest", "IntegrationTest" , "SystemTest"})
	public void configAC() {
		System.out.println("===Close the BROWSER===");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "IntegrationTest" , "SystemTest"})
	public void configAS() throws SQLException {
		System.out.println("====Close DB , Report BackUp====");
		dbLib.closeDbconnection();
	}
}

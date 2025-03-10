//	package com.comcast.crm.basetest;
//
//import java.sql.SQLException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.comcast.crm.generic.databaseutility.DataBaseUtility;
//import com.comcast.crm.generic.fileutility.ExcelUtility;
//import com.comcast.crm.generic.fileutility.FileUtility;
//import com.comcast.crm.generic.webdriverutility.JavaUtility;
//import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
//import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
//import com.comcast.crm.objectrepositaryutility.HomePage;
//import com.comcast.crm.objectrepositaryutility.LoginPage;
//
//public class BaseClass {
//
//	/* Create object */
//
//	public DataBaseUtility dbLib = new DataBaseUtility();
//	public FileUtility fLib = new FileUtility();
//	public JavaUtility jLib = new JavaUtility();
//	public WebDriverUtility wLib = new WebDriverUtility();
//	public ExcelUtility eLib = new ExcelUtility();
//	public WebDriver driver = null; // driver object created grobally
//
//	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
//	public void configBS() throws SQLException {
//		System.out.println("===Connect to DB , Report Config===");
//		dbLib.getDbconnection();
//	}
//
//	// @Parameters("BROWSER")
//	@BeforeClass(groups = { "smokeTest", "regressionTest" })
//
//	public void configBC() throws Throwable {
//		System.out.println("===Launch the BROWSER===");
//
//		//String BROWSER = fLib.getDataFromPropertiesFile("browser");
//		// browser; //(used during cross browser )
//		
//		String BROWSER =System.getProperty("browser" , fLib.getDataFromPropertiesFile("browser"));
//
//		if (BROWSER.equals("Chrome")) {
////			driver = new ChromeDriver();
//		} else if (BROWSER.equals("FireFox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equals("Edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver(); // After launching the browser, inside driver we have browser session ID and we
//											// want this driver object in my listner implementation class and we cannot
//											// create object of baseclass because they are (annotation methods got
//											// executed automatically we cannot invoke them because they are
//											// instructions so made them static and then by taking help of
//											// classname(BaseClass) we can access the driver object but one problem is
//											// it will not execute in parallel execution (static method will have only
//											// one instance) so create one more variable called "sdriver"
//		}		
//		wLib.waitForPageToLoad(driver);
//		String URL = fLib.getDataFromPropertiesFile("url");
//		driver.get(URL);
//		driver.manage().window().maximize();
//	}
//
//	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
//	public void configBM() throws Throwable {
//	//	System.out.println("===Login to Application===");
//	//	String USERNAME = fLib.getDataFromPropertiesFile("username");
//	//	String PASSWORD = fLib.getDataFromPropertiesFile("password");
//		
//		String USERNAME =System.getProperty("username" , fLib.getDataFromPropertiesFile("username"));
//		String PASSWORD =System.getProperty("password" , fLib.getDataFromPropertiesFile("password"));
//
//
//	z	LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(USERNAME, PASSWORD);
//	}
//
//	@AfterMethod(groups = { "smokeTest", "regressionTest" })
//	public void configAM() {
//		System.out.println("===Logout to Application");
//		HomePage hp = new HomePage(driver);
//		hp.signOut();
//	}
//
//	@AfterClass(groups = { "smokeTest", "regressionTest" })
//	public void configAC() {
//		System.out.println("===Close the BROWSER===");
//		driver.quit();
//	}
//
//	@AfterSuite(groups = { "smokeTest", "regressionTest" })
//	public void configAS() throws SQLException {
//		System.out.println("====Close DB , Report BackUp====");
//		dbLib.closeDbconnection();
//	}

//}

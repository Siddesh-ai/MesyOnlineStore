	package ecommerce.mecys.genericutility.listernerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ecommerce.mecys.genericutility.webdriverutility.UtilityClassObject;



public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configaration"); 
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + time + ".html");
		spark.config().setDocumentTitle("macy's Test Suite results");  
		spark.config().setReportName("masy's Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "EDGE-2025");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup"); 
		report.flush();        
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("<=============>" + result.getMethod().getMethodName() + ">====START=====");
		 test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "==> STARTED <==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("<=============>" + result.getMethod().getMethodName() + ">====END=====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==> COMPLETED <==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName(); 
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_"); 
		test.addScreenCaptureFromBase64String(filePath, testName + "time"); 
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==> FAILED <==");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}

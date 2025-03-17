	package com.comcast.crm.generic.listenerutility;

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
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;



public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentReports report; // by taking help of report variable we insert log
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configaration"); // coming from ISuiteListener
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite results");  //title 
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.valueOf(time));
		// add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup"); // coming from ISuiteListener
		report.flush();        //idu last phase report koduthe so we placed here and report begins in onStart(start to end report koduthe)
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("<=============>" + result.getMethod().getMethodName() + ">====START=====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==> STARTED <==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("<=============>" + result.getMethod().getMethodName() + ">====END=====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==> COMPLETED <==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName(); // inside (testName) we have failed test case name
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_"); // to capture current date and time
		test.addScreenCaptureFromBase64String(filePath, testName + "time"); // attaching the screenshot
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

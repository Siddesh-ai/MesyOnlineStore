package com.comcast.crm.generic.listenerutility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class test implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("From onStart suite");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("From OnFinish");

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("From OnTestStart");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("From OnTestSucess");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("From OntestFailure");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("From onTestSkipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("From onTestFailedButWithinSuccessPercentage");

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart context");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("From ITestContext");

	}

}

package com.ipj.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ipj.annotations.TestAttributes;
import com.ipj.utilities.ExtentReporter;

public class ReportingListener implements ITestListener{

	public void onStart(ITestContext context) {
		//initialize extent reporting
		ExtentReporter.initExtentReporter();
	}

	public void onFinish(ITestContext context) {
		//flush extent reporting
		try {
			ExtentReporter.flushReporter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		//initialize extent test reporter
		ExtentReporter.initTestReporter(result.getName());
		ExtentReporter.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(TestAttributes.class).author());
		ExtentReporter.assignCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(TestAttributes.class).category());
	}
	
	public void onTestSkipped(ITestResult result) {
		ExtentReporter.skip(result.getName()+" test skipped");
	}

	public void onTestSuccess(ITestResult result) {
		ExtentReporter.pass(result.getName()+" test passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentReporter.fail(result.getMethod().getMethodName()+" test failed", false);
	}

}

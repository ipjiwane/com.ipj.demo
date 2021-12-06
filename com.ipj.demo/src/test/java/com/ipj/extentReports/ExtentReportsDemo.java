package com.ipj.extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {

	@Test
	public void demo() throws IOException
	{
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Demo document title");
		spark.config().setReportName("Demo report name");
		
		ExtentTest test1 = extent.createTest("demo test 1");
		test1.pass("Test 1 passed");
		
		ExtentTest test2 = extent.createTest("demo test 2");
		test2.fail("Test 2 failed");
		
		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
}

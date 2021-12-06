package com.ipj.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	private static final String reportPath = System.getProperty("user.dir")+"/ExtentReports/"
			+System.currentTimeMillis()+"_index.html";

	public static void setReporter(ExtentTest test)
	{
		extentTest.set(test);
	}

	private static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}

	public static void unload()
	{
		extentTest.remove();
	}

	public static void initExtentReporter()
	{
		
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Test Execution Report");
			spark.config().setReportName("Regression testing");	
		}
	}

	public static void flushReporter() throws IOException
	{
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop().browse(new File(reportPath).toURI());	
	}

	public static void initTestReporter(String testName)
	{
		setReporter(extent.createTest(testName));
	}

	public static void pass(String message){
		getExtentTest().pass(message);
	}

	public static void fail(String message, boolean takeScreenshot ){
		if(takeScreenshot){
			getExtentTest().fail(message,getScreenshot());
		}
		else {
			getExtentTest().fail(message);
		}
	}

	public static void skip(String message){
		getExtentTest().skip(message);
	}

	public static void info(String message){
		getExtentTest().info(message);
	}

	public static Media getScreenshot(){
		String screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		return MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build();
	}

	public static void assignAuthor(String[] authors) {
		for(String author: authors) {
			getExtentTest().assignAuthor(author);
		}	
	}
	
	public static void assignCategory(String[] categories) {
		for(String category: categories) {
			getExtentTest().assignCategory(category);
		}
	}
}

package com.ipj.tests;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ipj.utilities.DriverManager;
import com.ipj.utilities.ExtentReporter;
import com.ipj.utilities.ReadConfig;

public class BaseClass {

	private String browser;
	private String url;
	protected String username;
	protected String password;

	@BeforeSuite
	public void suiteSetup()
	{
		ReadConfig config = new ReadConfig();
		browser = config.getBrowser();
		url = config.getUrl();
		username = config.getUserName();
		password = config.getPassword();
	}

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{	
		//initialize driver
		if(Objects.isNull(DriverManager.getDriver()))
		{
			DriverManager.initDriver(browser);
			DriverManager.getDriver().get(url);
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	@AfterMethod
	public void tearDown()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.quitDriver();
		}
		ExtentReporter.unload();
	}

}

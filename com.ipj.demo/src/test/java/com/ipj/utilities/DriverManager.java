package com.ipj.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver driver)
	{
		dr.set(driver);
	}
	
	public static WebDriver getDriver()
	{
		return dr.get();
	}
	
	private static void unload()
	{
		dr.remove();
	}
	
	public static void initDriver(String browser)
	{
		//initialize driver
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			setDriver(new InternetExplorerDriver());
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		}
	}
	
	public static void quitDriver()
	{
		getDriver().quit();
		unload();
	}
	
}

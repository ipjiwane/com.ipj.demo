package com.ipj.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ipj.utilities.DriverManager;
import com.ipj.utilities.ExtentReporter;

public class Actions {

	private WebDriver driver = DriverManager.getDriver();
	
	public WebElement waitElementToBeClickable(By locator, int durationInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void setText(String elementName, By locator, String text, int waitTimeInSeconds)
	{
		waitElementToBeClickable(locator,waitTimeInSeconds).sendKeys(text);
		ExtentReporter.info("'"+text+"' is entered in "+elementName);
	}
	
	public void click(String elementName, By locator, int waitTimeInSeconds)
	{
		waitElementToBeClickable(locator,waitTimeInSeconds).click();
		ExtentReporter.info(elementName+" is clicked");
	}
	
}

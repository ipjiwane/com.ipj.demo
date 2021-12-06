package com.ipj.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ipj.annotations.TestAttributes;
import com.ipj.pages.HomePage;
import com.ipj.pages.LoginPage;
import com.ipj.utilities.DriverManager;
import com.ipj.utilities.ExtentReporter;
import com.ipj.utilities.XLUtil;

public class TC_VerifyValidUsers extends BaseClass{

	@TestAttributes(author = { "Ishan","ipj" }, category = { "Smoke","Regression" })
	@Test(dataProvider="testData")
	public void VerifyValidUsers(String username, String password, String status)
	{
		
		//Login Page
		LoginPage lp = new LoginPage();
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();

		List<WebElement> ele = DriverManager.getDriver().findElements(By.xpath("//*[text()='Invalid credentials']"));
		
		if(status.equalsIgnoreCase("valid"))
		{
			if(ele.size()==0)
			{
				Assert.assertTrue(true);
				ExtentReporter.pass("Login successfull as expected");
				HomePage hp = new HomePage();
				hp.clickWelcome();
				hp.clickLogout();
			}else
			{
				ExtentReporter.fail("Login failure",true);
				Assert.assertTrue(false);
			}
		}else if(status.equalsIgnoreCase("invalid"))
		{
			if(ele.size()!=0)
			{
				ExtentReporter.pass("Login failure as expected");
				Assert.assertTrue(true);
			}else
			{
				//Assert.assertTrue(false);
				ExtentReporter.fail("Login successfull",true);
				HomePage hp = new HomePage();
				hp.clickWelcome();
				hp.clickLogout();
				Assert.assertTrue(false);
			}
		}
	}
	
	@DataProvider(name="testData",parallel=true)
	public String[][] getData() throws IOException
	{

		XLUtil excel = new XLUtil(System.getProperty("user.dir")+"/TestData/TestData.xlsx", "Users");
		int rows = excel.getRowCount();
		int cols = excel.getCellCount(0);
		
		String [][] data = new String [rows][cols];
		
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[i-1][j] = excel.getCellData(i,j);
			}
		}
		
		return data;
		
	}
}

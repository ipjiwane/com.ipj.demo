package com.ipj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipj.pages.HomePage;
import com.ipj.pages.LoginPage;
import com.ipj.utilities.DriverManager;

public class TC_LoginLogout extends BaseClass{

	
	//Login Logout test
	@Test

	public void test1()
	{
		/*
		//Login Page
		LoginPage lp = new LoginPage();
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();

		//HomePage

		//verify page navigation
		
		Assert.assertEquals(DriverManager.getDriver().getTitle(),"OrangeHRM");

		//Logout
		HomePage hp = new HomePage();
		hp.clickWelcome();
		hp.clickLogout();
		*/
		System.out.println("Inside test1");

	}
	
	@Test
	public void test2()
	{
		/*
		//Login Page
		LoginPage lp = new LoginPage();
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();

		//HomePage

		//verify page navigation
		
		Assert.assertEquals(DriverManager.getDriver().getTitle(),"OrangeHRM");

		//Logout
		HomePage hp = new HomePage();
		hp.clickWelcome();
		hp.clickLogout();
		*/
		System.out.println("Inside test2");

	}
	
	@Test
	public void test3()
	{
		System.out.println("Inside test3");
		Assert.assertTrue(false);
	}
}

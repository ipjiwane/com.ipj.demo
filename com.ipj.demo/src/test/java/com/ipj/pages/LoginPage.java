package com.ipj.pages;

import org.openqa.selenium.By;

public final class LoginPage extends Actions{
	
	//locators
	private By txtUsername = By.id("txtUsername");
	private By txtPassword = By.id("txtPassword");
	private By btnLogin = By.id("btnLogin");
	
	public void setUsername(String username) {
		setText("Username", txtUsername, username, 0);
	}
	
	public void setPassword(String password) {
		setText("Password", txtPassword, password, 0);
	}
	
	public void clickLogin() {
		click("Login button", btnLogin, 0);
	}
	
	

}

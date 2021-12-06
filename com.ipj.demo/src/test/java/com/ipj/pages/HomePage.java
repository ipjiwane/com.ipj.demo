package com.ipj.pages;

import org.openqa.selenium.By;

public class HomePage extends Actions{

	//locators
	private By linkWelcome = By.id("welcome");
	private By linkLogout = By.xpath("//a[text()='Logout']");

	public void clickWelcome() {
		click("Welcome link",linkWelcome, 3);
	}

	public void clickLogout() {
		click("Logout link",linkLogout, 3);
	}
}

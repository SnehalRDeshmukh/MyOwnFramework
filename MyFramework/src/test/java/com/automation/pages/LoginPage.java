package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		driver = ldriver;

	}

	@FindBy(name = "username")
	WebElement uname;

	@FindBy(name = "password")
	WebElement pswd;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	public void LoginToCRM(String userNameApp, String pswdApp) {
		uname.sendKeys(userNameApp);
		pswd.sendKeys(pswdApp);
		loginButton.click();
	}

}

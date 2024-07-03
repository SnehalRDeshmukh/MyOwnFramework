package com.learnatomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.utilities.BrowserFactory;
import com.utilities.ExcelDataProvider;
import com.utilities.Helper;

public class LoginCRM extends BaseClass {

	@Test
	public void loginApp() {
		
		logger= report.createTest("Login to CRM");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("App Started...");

		loginpage.LoginToCRM("Selenium_50", "Abcd@123456");
		
		logger.pass("Login success");

	}

}

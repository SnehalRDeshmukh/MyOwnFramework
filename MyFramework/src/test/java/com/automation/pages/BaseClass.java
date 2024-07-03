package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.BrowserFactory;
import com.utilities.Helper;
import com.utilities.configDataProvider;

public class BaseClass {
	public WebDriver driver;
	public configDataProvider c1;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		c1 = new configDataProvider();

		ExtentSparkReporter extent = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Reports/FreeCRMReport " + Helper.getCurrentDateTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.StartApplication(driver, c1.getbrowserData(), c1.geturlData());
		Reporter.log("Browser started.");

	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitbrowser(driver);
		Reporter.log("Browser closed.");

	}

	@AfterMethod
	public void teardownMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.CaptureScreenshot(driver);
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		}
		report.flush();

	}

}

package com.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver StartApplication(WebDriver driver, String BrowserName, String AppURL) {
		if (BrowserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver126.exe");
			driver = new ChromeDriver();

		} else if (BrowserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();

		} else if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("We do not support this browser");
		}
		driver.get(AppURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;

	}

	public static void quitbrowser(WebDriver driver) {
		driver.quit();
	}

}

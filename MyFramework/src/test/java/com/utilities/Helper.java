package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	// screenshot, alerts, frames,window handling, java script executor,sync issue.

	public static String CaptureScreenshot(WebDriver driver) {
		
		String screenshot= System.getProperty("user.dir")+"/Screenshots/FreeCRM "+getCurrentDateTime()+".png";
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./Screenshots/FreeCRM "+getCurrentDateTime()+".png");
		try {
			FileUtils.copyFile(src, trg);
			System.out.println("Screen captured successfully.......");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot. " + e.getMessage());
		}
		return screenshot;

	}
	
	
	public static String  getCurrentDateTime() {
		DateFormat df= new SimpleDateFormat("MM_dd_yyyy_HH_ss");
		
		Date currdate = new Date();
		
		return df.format(currdate);
	}


}

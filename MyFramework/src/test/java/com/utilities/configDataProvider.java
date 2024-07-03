package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configDataProvider {
	Properties p1;

	public configDataProvider() {

		File f = new File("./Configurations/config.properties");
		try {
			FileInputStream fs = new FileInputStream(f);

			p1 = new Properties();
			p1.load(fs);
		} catch(Exception e) {
			System.out.println("Unable to resd config file");
			
		}
	}
	
	public String getbrowserData() {
		return p1.getProperty("browser");
	}
	
	public String geturlData() {
		return p1.getProperty("qaURL");
	}

}

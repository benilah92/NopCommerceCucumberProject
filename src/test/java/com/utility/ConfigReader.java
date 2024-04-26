package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	FileInputStream fis;
	public Properties getProp() {
		
		File file = new File("C:\\Users\\mechs\\eclipse-workspace\\Data_Driven_muthu\\src\\test\\java\\com\\utility\\NopCommerce.properties");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
	public String getBrowser() {
		String browser = getProp().getProperty("browser");
		return browser;
	}

}

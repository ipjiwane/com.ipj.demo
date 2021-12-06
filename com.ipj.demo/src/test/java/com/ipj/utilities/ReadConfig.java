package com.ipj.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	private Properties prop = new Properties();
	
	public ReadConfig()
	{
		try {
			File src = new File (System.getProperty("user.dir")+"/Configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Error while reading values from properties file : "+e.getMessage());
		}
	}
	
	public String getBrowser()
	{
		return (String) prop.getProperty("browser");
	}
	
	public String getUrl()
	{
		return (String) prop.getProperty("url");
	}
	
	public String getUserName()
	{
		return (String) prop.getProperty("username");
	}
	
	public String getPassword()
	{
		return (String) prop.getProperty("password");
	}
	
	
}


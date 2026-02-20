package com.comcast.HMS.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPrpertiesFile(String key) throws Exception {
		
		String  path = "./HMS_DATA/CommonData.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties properties = new Properties();
		properties.load(fis);
		String value = properties.getProperty(key);
		
		return value;
		
		
	}
	

}

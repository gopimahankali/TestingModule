package com.comcast.HMS.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * FileUtility class is used to read data from properties file.
 * 
 * This class provides reusable method to fetch configuration data such as:
 * 
 * - Browser name - Application URL - Username - Password - Database URL
 * 
 * Properties file helps to store configuration separately from test scripts.
 * This improves maintainability and flexibility of automation framework.
 * 
 * Properties file location: ./HMS_DATA/CommonData.properties
 * 
 * @author Mahan
 */
public class FileUtility {

	/**
	 * This method is used to read data from properties file based on given key.
	 * 
	 * @param key
	 * @return String (value associated with key)
	 * @throws Exception
	 */
	public String getDataFromPrpertiesFile(String key) throws Exception {

		// Specify properties file path
		String path = "./HMS_DATA/CommonData.properties";

		// Open properties file
		FileInputStream fis = new FileInputStream(path);

		// Create Properties class object
		Properties properties = new Properties();

		// Load properties file into Properties object
		properties.load(fis);

		// Fetch value based on key
		String value = properties.getProperty(key);

		// Return value
		return value;
	}

}
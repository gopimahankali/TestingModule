package com.comcast.HMS.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * JsonUtility class is used to read data from JSON file.
 * 
 * This class provides method to fetch configuration or test data stored in JSON
 * format using key.
 * 
 * JSON files are commonly used to store structured data like: - URL - Username
 * - Password - Environment configuration - Test data
 * 
 * JSON file location: ./HMS_DATA/AppCommonData.json
 * 
 * Uses JSON-simple library to parse JSON file.
 * 
 * @author Mahan
 */
public class JsonUtility {

	/**
	 * This method is used to read data from JSON file based on given key.
	 * 
	 * @param key
	 * @return String (value associated with key)
	 * @throws Exception
	 */
	public String jsonFile(String key) throws Exception {

		// Open JSON file using FileReader
		FileReader reader = new FileReader("./HMS_DATA/AppCommonData.json");

		// Create JSONParser object to parse JSON file
		JSONParser parser = new JSONParser();

		// Parse JSON file and convert into Object
		Object object = parser.parse(reader);

		// Convert Object into JSONObject
		JSONObject map = (JSONObject) object;

		// Fetch value using key and convert to String
		String value = map.get(key).toString();

		// Return value
		return value;

	}
}
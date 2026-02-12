package com.comcast.HMS.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonUtility {

	public String jsonFile(String key) throws Exception {
		
		FileReader reader =  new FileReader("./HMS_DATA/AppCommonData.json");
		JSONParser parser = new JSONParser();
	    Object object = parser.parse(reader);
	    JSONObject map = (JSONObject)object;
	    String value = map.get(key).toString();
	    return value;
		
	}
}

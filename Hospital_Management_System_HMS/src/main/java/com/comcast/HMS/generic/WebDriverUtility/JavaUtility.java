package com.comcast.HMS.generic.WebDriverUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandommnumber() {
		 Random  random = new Random();
		 int ranNumber = random.nextInt(6000);
		 return ranNumber;
		 
	}
	
	public String systemDate() {
	
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = sdf.format(date);
		return date1;
	}
	public String getRequiredDate(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
		
	}
	
}

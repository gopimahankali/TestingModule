package com.comcast.HMS.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * JavaUtility class is used to provide reusable Java helper methods.
 * 
 * This class contains common utility methods such as:
 * 
 * 1. Generating random numbers 2. Getting current system date 3. Getting
 * required date by adding or subtracting days
 * 
 * These methods are useful for dynamic test data generation, date handling, and
 * avoiding duplicate values in automation testing.
 * 
 * @author Mahan
 */
public class JavaUtility {

	/**
	 * This method generates a random number. Used to create unique test data like
	 * usernames, emails, patient names, etc.
	 * 
	 * @return int (random number)
	 */
	public int getRandommnumber() {

		// Create Random class object
		Random random = new Random();

		// Generate random number between 0 and 6000
		int ranNumber = random.nextInt(6000);

		// Return random number
		return ranNumber;
	}

	/**
	 * This method returns current system date in yyyy-MM-dd format.
	 * 
	 * Example output: 2026-02-26
	 * 
	 * @return String (current date)
	 */
	public String systemDate() {

		// Create Date object
		Date date = new Date();

		// Define date format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// Convert date into string format
		String date1 = sdf.format(date);

		// Return formatted date
		return date1;
	}

	/**
	 * This method returns required date by adding or subtracting days.
	 * 
	 * Example: getRequiredDate(5) → returns date after 5 days getRequiredDate(-5) →
	 * returns date before 5 days
	 * 
	 * @param days
	 * @return String (required date)
	 */
	public String getRequiredDate(int days) {

		// Define date format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// Get current date using Calendar
		Calendar cal = Calendar.getInstance();

		// Add or subtract days
		cal.add(Calendar.DAY_OF_MONTH, days);

		// Convert date to string
		String reqDate = sdf.format(cal.getTime());

		// Return required date
		return reqDate;
	}

}
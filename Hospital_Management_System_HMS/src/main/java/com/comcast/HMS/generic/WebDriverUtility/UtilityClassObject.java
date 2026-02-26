package com.comcast.HMS.generic.WebDriverUtility;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

/**
 * UtilityClassObject is used to manage ThreadLocal instances of WebDriver and
 * ExtentTest.
 * 
 * ThreadLocal ensures that each test thread gets its own separate instance of
 * WebDriver and ExtentTest. This is very important when executing tests in
 * parallel.
 * 
 * This class provides global access to:
 * 
 * 1. WebDriver instance (browser) 2. ExtentTest instance (report logging)
 * 
 * This helps avoid conflicts between parallel test executions.
 * 
 * Commonly used in: - BaseTest class (to store driver) - Listener class (to
 * store ExtentTest) - Screenshot utility - Reporting utility
 * 
 * Example: UtilityClassObject.setDriver(driver);
 * UtilityClassObject.getDriver();
 * 
 * UtilityClassObject.setTest(test); UtilityClassObject.getTest();
 * 
 * @author Gopi Shankar Mahankali
 */
public class UtilityClassObject {

	// ThreadLocal variable to store ExtentTest object for each thread
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	// ThreadLocal variable to store WebDriver object for each thread
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	/**
	 * This method returns ExtentTest object of current thread. Used for logging
	 * test steps in Extent Report.
	 * 
	 * @return ExtentTest
	 */
	public static ExtentTest getTest() {

		return test.get();

	}

	/**
	 * This method stores ExtentTest object into ThreadLocal. Used in Listener class
	 * while creating test report.
	 * 
	 * @param actTest
	 */
	public static void setTest(ExtentTest actTest) {

		test.set(actTest);

	}

	/**
	 * This method returns WebDriver object of current thread. Used to access driver
	 * globally across framework.
	 * 
	 * @return WebDriver
	 */
	public static WebDriver getDriver() {

		return driver.get();

	}

	/**
	 * This method stores WebDriver object into ThreadLocal. Used in BaseTest class
	 * after launching browser.
	 * 
	 * @param actDriver
	 */
	public static void setDriver(WebDriver actDriver) {

		driver.set(actDriver);

	}

}
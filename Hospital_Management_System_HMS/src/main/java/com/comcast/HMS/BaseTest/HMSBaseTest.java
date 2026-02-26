package com.comcast.HMS.BaseTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcarst.HMS.generic.databaseutility.DatabaseUtility;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.JavaUtility;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

/**
 * HMSBaseTest class is the Base Class for all test classes.
 * 
 * This class contains common configuration methods such as:
 * 
 * 1. Database connection setup and teardown 2. Browser launch and close 3.
 * Application login and logout 4. Utility class initialization
 * 
 * All test classes should extend this class to reuse common functionality.
 * 
 * Uses TestNG annotations to control execution flow.
 * 
 * Execution Order: BeforeSuite → Connect DB BeforeClass → Launch Browser
 * BeforeMethod → Login Test Method → Execute Test AfterMethod → Logout
 * AfterClass → Close Browser AfterSuite → Close DB
 * 
 * @author Mahan
 */
public class HMSBaseTest {

	// Database utility object for database operations
	protected DatabaseUtility db = new DatabaseUtility();

	// File utility object for reading data from properties file
	protected FileUtility file = new FileUtility();

	// Excel utility object for reading data from Excel file
	protected ExcelUtility excel = new ExcelUtility();

	// WebDriver utility object for browser related reusable methods
	protected WebDriverUtility web = new WebDriverUtility();

	// Java utility object for Java reusable methods like random numbers, date, etc.
	protected JavaUtility java = new JavaUtility();

	// WebDriver reference variable
	protected WebDriver driver = null;

	/**
	 * BeforeSuite annotation executes before entire test suite. Used to establish
	 * database connection.
	 */
	@BeforeSuite
	public void conficBS() throws Exception {

		db.getDbconnection();
	}

	/**
	 * BeforeClass annotation executes before executing test class. Used to launch
	 * browser based on configuration from properties file.
	 */
	@BeforeClass
	public void configBC() throws Exception {

		// Initialize PageFactory (optional initialization)
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		// Edge browser options
		EdgeOptions options = new EdgeOptions();

		// Chrome browser options
		ChromeOptions opt = new ChromeOptions();

		// Disable password manager popup
		Map<String, Object> set = new HashMap<>();
		set.put("profile.password_manager_leak_detection", false);

		opt.setExperimentalOption("prefs", set);

		// Set browser zoom level
		opt.addArguments("--force-device-scale-factor=0.9");
		opt.addArguments("--high-dpi-support=0.9");

		// Read browser name from properties file
		String browser = file.getDataFromPrpertiesFile("Browser");

		// Launch browser based on configuration
		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver(opt);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else {

			driver = new EdgeDriver(options);
		}

		// Store driver in UtilityClassObject for global access
		UtilityClassObject.setDriver(driver);

	}

	/**
	 * BeforeMethod annotation executes before every test method. Used to login into
	 * application.
	 */
	@BeforeMethod()
	public void configBM() throws Exception {

		// Read login data from properties file
		String url = file.getDataFromPrpertiesFile("Url");
		String username = file.getDataFromPrpertiesFile("Patient");
		String password = file.getDataFromPrpertiesFile("Password2");

		// Create LoginPage object
		LoginPage login = new LoginPage(driver);

		// Perform login operation
		login.loginToApplication(url, username, password);

	}

	/**
	 * AfterMethod annotation executes after every test method. Used to logout from
	 * application.
	 */
	@AfterMethod
	public void closeApp() {

		// Create Dashboard page object
		DashBoardPage dash = new DashBoardPage(driver);

		// Click on user icon
		dash.getUser().click();

		// Wait for logout button
		web.explicitWait(driver, dash.getLogout(), 10);

		// Click logout button
		dash.getLogout().click();

	}

	/**
	 * AfterClass annotation executes after execution of test class. Used to close
	 * browser.
	 */
	@AfterClass
	public void ConfigAC() {

		web.closeBrowser(driver);

	}

	/**
	 * AfterSuite annotation executes after execution of entire test suite. Used to
	 * close database connection.
	 */
	@AfterSuite
	public void configAS() throws Exception {

		db.closeDbconnection();
	}

}
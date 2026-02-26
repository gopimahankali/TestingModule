package com.comcast.HMS.BaseTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcarst.HMS.generic.databaseutility.DatabaseUtility;
import com.comcast.HMS.ObjectRepositoryUtility.Doctor_DashboardPage;
import com.comcast.HMS.ObjectRepositoryUtility.Doctor_LoginPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.generic.WebDriverUtility.JavaUtility;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

/**
 * HMSBaseTest2 is a Base Test class designed for Doctor module automation.
 * 
 * This class contains common setup and teardown methods such as:
 * 
 * 1. Database connection setup and teardown 2. Browser launch and close 3.
 * Doctor login and logout 4. Utility class initialization
 * 
 * TestNG annotations are used to control execution flow. All Doctor-related
 * test classes should extend this class.
 * 
 * Execution Flow: BeforeSuite → Connect to Database BeforeClass → Launch
 * Browser BeforeMethod → Login as Doctor Test Method → Execute Test Case
 * AfterMethod → Logout from Application AfterClass → Close Browser AfterSuite →
 * Close Database Connection
 * 
 * @author Mahan
 */
public class HMSBaseTest2 {

	// Database utility object used for database operations
	protected DatabaseUtility db = new DatabaseUtility();

	// File utility object used to read data from properties file
	protected FileUtility file = new FileUtility();

	// Excel utility object used to read data from Excel files
	protected ExcelUtility excel = new ExcelUtility();

	// WebDriver utility object used for browser-related reusable methods
	protected WebDriverUtility web = new WebDriverUtility();

	// Java utility object used for common Java operations
	protected JavaUtility java = new JavaUtility();

	// WebDriver reference variable
	protected WebDriver driver = null;

	/**
	 * BeforeSuite method executes before entire test suite. Used to establish
	 * database connection.
	 */
	@BeforeSuite
	public void conficBS() throws Exception {

		db.getDbconnection();

	}

	/**
	 * BeforeClass method executes before execution of test class. Used to launch
	 * browser based on configuration from properties file.
	 */
	@BeforeClass
	public void openBrowser() throws Exception {

		// Initialize HomePage using PageFactory (optional initialization)
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		// Read browser name from properties file
		String browser = file.getDataFromPrpertiesFile("Browser");

		// Chrome browser options to disable password popup and adjust scaling
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> map = new HashMap<>();
		map.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", map);

		options.addArguments("--force-device-scale-factor=0.9");
		options.addArguments("--high-dpi-support=0.9");

		// Launch browser based on configuration
		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else {

			driver = new EdgeDriver();
		}

		// Store driver globally using UtilityClassObject
		UtilityClassObject.setDriver(driver);

	}

	/**
	 * BeforeMethod executes before every test method. Used to login as Doctor.
	 */
	@BeforeMethod()
	public void login() throws Exception {

		// Read login details from properties file
		String url = file.getDataFromPrpertiesFile("Url");
		String username = file.getDataFromPrpertiesFile("DoctorLogin");
		String password = file.getDataFromPrpertiesFile("Password1");

		// Create Doctor Login Page object
		Doctor_LoginPage Dlogin = new Doctor_LoginPage(driver);

		// Perform login operation
		Dlogin.loginToApplication(url, username, password);

	}

	/**
	 * AfterMethod executes after every test method. Used to logout from Doctor
	 * account.
	 */
	@AfterMethod
	public void logout() {

		// Create Doctor Dashboard page object
		Doctor_DashboardPage dash = new Doctor_DashboardPage(driver);

		// Click user profile icon
		dash.getUser().click();

		// Wait until logout button is visible
		web.explicitWait(driver, dash.getLogout(), 10);

		// Click logout button using JavaScript click (utility method)
		web.argument(driver, dash.getLogout());
	}

	/**
	 * AfterClass executes after execution of test class. Used to close browser.
	 */
	@AfterClass
	public void ConfigAC() {

		web.closeBrowser(driver);

	}

	/**
	 * AfterSuite executes after execution of entire test suite. Used to close
	 * database connection.
	 */
	@AfterSuite
	public void configAS() throws Exception {

		db.closeDbconnection();
	}

}
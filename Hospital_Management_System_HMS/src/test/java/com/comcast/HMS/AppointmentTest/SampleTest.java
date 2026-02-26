package com.comcast.HMS.AppointmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.HMS.ObjectRepositoryUtility.CreateUserPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

/**
 * Sample test class to demonstrate navigation to Create Account page.
 *
 * This test performs: 1. Read browser and URL from properties file 2. Launch
 * browser 3. Open HMS application 4. Navigate to Patient Login page 5. Click
 * Create Account link
 *
 * This test uses: - FileUtility for configuration - WebDriverUtility for
 * browser operations - Page Object Model (POM)
 *
 * @author Mahan
 */
public class SampleTest {

	/**
	 * Test method to navigate to Create Account page
	 *
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {

		// Create utility objects
		WebDriverUtility web = new WebDriverUtility();
		FileUtility file = new FileUtility();

		WebDriver driver = null;

		// Read configuration
		String browser = file.getDataFromPrpertiesFile("Browser");
		String url = file.getDataFromPrpertiesFile("Url");

		// Launch browser using utility method
		driver = web.launchBrowser(browser);

		// Browser setup
		web.maximize(driver);
		web.implicitWait(driver, 20);

		// Open application
		web.url(driver, url);

		// Initialize HomePage
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		// Click Logins menu
		home.getLogins().click();

		// Store parent window
		String parentWindow = web.getWindow(driver);

		// Click Patient Login
		home.getPatientLogin().click();

		// Switch to login window
		web.switchWindow(driver, parentWindow);

		// Initialize LoginPage
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		// Click Create Account link
		login.getCreateAccount().click();

		// Initialize CreateUserPage (optional, if needed)
		CreateUserPage createUser = PageFactory.initElements(driver, CreateUserPage.class);

	}
}
package com.comcast.HMS.AppointmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.HMS.ObjectRepositoryUtility.CreateUserPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

/**
 * CreatePatientTest class is used to automate Patient Registration
 * functionality.
 *
 * This test performs the following operations:
 *
 * 1. Read multiple patient data from Excel file using DataProvider 2. Launch
 * browser 3. Navigate to application URL 4. Navigate to Patient Login page 5.
 * Click Create Account 6. Enter patient details 7. Select gender dynamically 8.
 * Submit registration form 9. Close browser
 *
 * This test uses: - DataProvider for data-driven testing - ExcelUtility to read
 * test data - FileUtility to read configuration data - WebDriverUtility for
 * browser operations - Page Object Model (POM)
 *
 * Improves: - Test coverage - Reusability - Maintainability
 *
 * @author Mahan
 */
public class CreatePatientTest {

	// Utility objects
	WebDriverUtility web = new WebDriverUtility();
	FileUtility file = new FileUtility();

	/**
	 * DataProvider method to fetch patient data from Excel file
	 *
	 * @return Object[][]
	 * @throws Exception
	 */
	@DataProvider(name = "UserData")
	public Object[][] getUserData() throws Exception {

		ExcelUtility excel = new ExcelUtility();

		int rowCount = excel.getRowCount("UserData");
		int cellCount = excel.getCellCount("UserData");

		Object[][] data = new Object[rowCount - 1][cellCount];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				data[i - 1][j] = excel.getData("UserData", i, j);
			}
		}

		return data;
	}

	/**
	 * Test method to create new patient account using Excel data
	 *
	 * @param fullname
	 * @param address
	 * @param city
	 * @param gender
	 * @param email
	 * @param password
	 * @param passwordagain
	 * @throws Exception
	 */
	@Test(dataProvider = "UserData")
	public void createPatient(String fullname, String address, String city, String gender, String email,
			String password, String passwordagain) throws Exception {

		// Read configuration from properties file
		String browser = file.getDataFromPrpertiesFile("Browser");
		String url = file.getDataFromPrpertiesFile("Url");

		// Launch browser
		WebDriver driver = web.launchBrowser(browser);

		// Browser setup
		web.maximize(driver);
		web.implicitWait(driver, 20);
		web.url(driver, url);

		// Navigate to Patient Login page
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		home.getLogins().click();

		String parentWindow = web.getWindow(driver);

		home.getPatientLogin().click();

		web.switchWindow(driver, parentWindow);

		// Navigate to Create Account page
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		web.explicitWait(driver, login.getCreateAccount(), 10);

		login.getCreateAccount().click();

		// Fill Create Patient form
		CreateUserPage create = PageFactory.initElements(driver, CreateUserPage.class);

		create.getFullName().sendKeys(fullname);

		create.getAddress().sendKeys(address);

		create.getCity().sendKeys(city);

		// Select Gender dynamically
		if (gender.equalsIgnoreCase("Male")) {

			web.arg(driver, create.getMaleGender());

		} else if (gender.equalsIgnoreCase("Female")) {

			web.arg(driver, create.getFemaleGender());

		} else {

			System.out.println("Invalid Gender Value");
		}

		// Enter remaining details
		create.getEmail().sendKeys(email);

		create.getPassword().sendKeys(password);

		create.getConfirmPassword().sendKeys(passwordagain);

		// Submit form using JavaScript
		web.argument(driver, create.getSubmit());

		// Close browser
		web.closeBrowser(driver);
	}

}
package com.comcast.HMS.AppointmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.HMS.ObjectRepositoryUtility.BookAppointmentPage;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.JavaUtility;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

/**
 * BookAppointmentTest class is used to automate the Patient Book Appointment
 * functionality.
 *
 * This test performs the following operations:
 *
 * 1. Read browser, URL, username, and password from Properties file 2. Launch
 * browser 3. Navigate to application URL 4. Login as Patient 5. Navigate to
 * Book Appointment page 6. Select Doctor Specialization and Doctor 7. Enter
 * appointment date and time 8. Submit appointment form 9. Close browser
 *
 * This class uses: - Page Object Model (POM) - Utility classes (FileUtility,
 * ExcelUtility, JavaUtility, WebDriverUtility)
 *
 * Improves: - Reusability - Maintainability - Readability
 *
 * @author Mahan
 */
public class BookAppointmentTest {

	// Utility class objects
	FileUtility file = new FileUtility();
	ExcelUtility excel = new ExcelUtility();
	JavaUtility java = new JavaUtility();
	WebDriverUtility web = new WebDriverUtility();

	/**
	 * Test method to book appointment for patient
	 *
	 * @throws Exception
	 */
	@Test
	public void bookAppointment() throws Exception {

		// Read data from properties file
		String browser = file.getDataFromPrpertiesFile("Browser");
		String url = file.getDataFromPrpertiesFile("Url");
		String username = file.getDataFromPrpertiesFile("Patient");
		String password = file.getDataFromPrpertiesFile("Password2");

		// Generate future booking date
		String bookingDate = java.getRequiredDate(10);

		// Launch browser
		WebDriver driver = web.launchBrowser(browser);

		// Apply browser settings
		web.maximize(driver);
		web.implicitWait(driver, 20);

		// Open application URL
		web.url(driver, url);

		// Initialize Page Objects
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		// Navigate to Patient Login
		home.getLogins().click();

		String parentWindow = web.getWindow(driver);

		home.getPatientLogin().click();

		web.switchWindow(driver, parentWindow);

		// Perform Patient Login
		login.getUserName().sendKeys(username);

		login.getPassword().sendKeys(password);

		login.getLoginButton().click();

		// Navigate to Book Appointment page
		DashBoardPage dash = PageFactory.initElements(driver, DashBoardPage.class);

		web.explicitWait(driver, dash.getBookAppointment(), 10);

		dash.getBookAppointment().click();

		// Book Appointment
		BookAppointmentPage book = PageFactory.initElements(driver, BookAppointmentPage.class);

		// Select specialization
		web.dropDown(book.getSpecialization(), "Internal Medicine", driver);

		// Select doctor
		web.dropDown(book.getDoctor(), "53", driver);

		// Enter appointment date
		web.explicitWait(driver, book.getDate(), 10);

		book.getDate().sendKeys(bookingDate);

		// Enter appointment time
		web.explicitWait(driver, book.getTime(), 10);

		web.scroll(driver, book.getDate());

		book.getTime().sendKeys("10:00 AM");

		// Click submit button using JavaScript
		web.argument(driver, book.getSubmit());

		// Close browser
		web.closeBrowser(driver);
	}
}
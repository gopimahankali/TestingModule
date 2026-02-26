package com.comcast.HMS.PatientTest;

/**
 * Book_AppointmentTest class is used to automate Patient Appointment functionality.
 *
 * This test performs the following actions:
 * 1. Login as Patient (handled by HMSBaseTest)
 * 2. Navigate to Book Appointment page
 * 3. Enter appointment details
 * 4. Submit appointment form
 * 5. Handle alert confirmation
 * 6. Log steps in Extent Report
 *
 * This class uses:
 * - Page Object Model (POM)
 * - BaseTest framework setup
 * - ExtentReports Listener
 * - WebDriverUtility reusable methods
 * - JavaUtility for dynamic date generation
 *
 * Listener is used for:
 * - Report generation
 * - Screenshot capture
 * - Logging test execution
 *
 * @author Gopi Shankar Mahankali
 */

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.HMS.BaseTest.HMSBaseTest;
import com.comcast.HMS.ObjectRepositoryUtility.BookAppointmentPage;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;

@Listeners(com.comcast.HMS.ListenerUtility.Listener_Implementation.class)
public class Book_AppointmentTest extends HMSBaseTest {

	/**
	 * Test method to book appointment for patient
	 *
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void BookAppointment() throws Exception {

		// Initialize Page Objects
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		BookAppointmentPage bookAppointmentPage = new BookAppointmentPage(driver);

		// Generate future appointment date dynamically
		String bookingDate = java.getRequiredDate(10);

		// Click Book Appointment option
		web.explicitWait(driver, dashBoardPage.getBookAppointment(), 10);
		dashBoardPage.getBookAppointment().click();

		// Log step in Extent Report
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Book Appointment page");

		// Select Doctor Specialization
		web.dropDown(bookAppointmentPage.getSpecialization(), "Internal Medicine", driver);

		// Select Doctor
		web.dropDown(bookAppointmentPage.getDoctor(), "53", driver);

		// Enter Appointment Date
		web.explicitWait(driver, bookAppointmentPage.getDate(), 10);
		bookAppointmentPage.getDate().sendKeys(bookingDate);

		// Enter Appointment Time
		web.explicitWait(driver, bookAppointmentPage.getTime(), 10);
		web.scroll(driver, bookAppointmentPage.getDate());
		bookAppointmentPage.getTime().sendKeys("11:00 AM");

		// Click Submit button using JavaScript
		web.argument(driver, bookAppointmentPage.getSubmit());

		// Log success in report
		UtilityClassObject.getTest().log(Status.INFO, "Appointment booked successfully");

		// Handle confirmation alert
		web.alert(driver);
	}

	/*
	 * Future Enhancement Test: Cancel Appointment functionality
	 *
	 * This test will: - Navigate to Appointment History - Verify page title -
	 * Cancel appointment - Handle alert confirmation
	 *
	 * Can be enabled when needed
	 */
	/*
	 * @Test(priority = 2) public void AppointmentHistory() {
	 * 
	 * User_Appointment_History appointmentHistory = new
	 * User_Appointment_History(driver); DashBoardPage dashBoardPage = new
	 * DashBoardPage(driver);
	 * 
	 * dashBoardPage.getAppointmentHistory().click();
	 * 
	 * String title = web.getTitle(driver);
	 * 
	 * Assert.assertEquals(title, "User | Appointment History");
	 * 
	 * UtilityClassObject.getTest().log(Status.INFO,
	 * "Appointment History page verified");
	 * 
	 * web.explicitWait(driver, appointmentHistory.getCancel(), 10);
	 * 
	 * web.argument(driver, appointmentHistory.getCancel());
	 * 
	 * web.alert(driver);
	 * 
	 * UtilityClassObject.getTest().log(Status.INFO,
	 * "Appointment canceled successfully"); }
	 */

}
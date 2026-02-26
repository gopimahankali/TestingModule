package com.comcast.HMS.DoctorTest;

import org.testng.annotations.Test;

import com.comcast.HMS.BaseTest.HMSBaseTest2;
import com.comcast.HMS.ObjectRepositoryUtility.Add_PatientPage;
import com.comcast.HMS.ObjectRepositoryUtility.Doctor_DashboardPage;

/**
 * Add_PatientTest class is used to automate Add Patient functionality from
 * Doctor Dashboard in HMS application.
 *
 * This class extends HMSBaseTest2, which provides: - Browser setup and teardown
 * - Doctor login and logout - Database connection setup - Utility class
 * initialization
 *
 * This test performs: 1. Navigate to Patients menu 2. Click Add Patient option
 * 3. Enter patient details 4. Submit Add Patient form
 *
 * This test uses: - Page Object Model (POM) - WebDriverUtility methods -
 * BaseTest reusable setup
 *
 * Improves: - Code reusability - Maintainability - Framework standardization
 *
 * @author Mahan
 */
public class Add_PatientTest extends HMSBaseTest2 {

	/**
	 * Test method to add new patient from Doctor Dashboard
	 */
	@Test
	public void addPatient1() {

		// Initialize Page Object classes
		Doctor_DashboardPage dash = new Doctor_DashboardPage(driver);
		Add_PatientPage addPatientPage = new Add_PatientPage(driver);

		// Apply implicit wait
		web.implicitWait(driver, 10);

		// Navigate to Patients menu
		web.explicitWait(driver, dash.getPatients(), 10);
		dash.getPatients().click();

		// Click Add Patient option
		web.explicitWait(driver, dash.getAddPatients(), 10);
		dash.getAddPatients().click();

		// Enter patient details
		addPatientPage.getPatientName().sendKeys("Rohith");

		addPatientPage.getPatientContact().sendKeys("859872112");

		addPatientPage.getPatientEmail().sendKeys("Rohit@test.com");

		// Select gender using JavaScript click
		web.argument(driver, addPatientPage.getGenderMale());

		// Enter remaining details
		addPatientPage.getAddress().sendKeys("Hyderabad");

		addPatientPage.getPatientAge().sendKeys("26");

		addPatientPage.getMedicalHistory().sendKeys("Mild Fever");

		// Click Add button
		web.argument(driver, addPatientPage.getAdd());

	}

}
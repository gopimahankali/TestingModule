package com.comcast.HMS.DoctorTest;



import org.testng.annotations.Test;

import com.comcast.HMS.BaseTest.HMSBaseTest2;
import com.comcast.HMS.ObjectRepositoryUtility.Add_PatientPage;
import com.comcast.HMS.ObjectRepositoryUtility.Doctor_DashboardPage;

public class Add_PatientTest extends HMSBaseTest2 {
	
	@Test()
	public void addPatient1() {
		
	Doctor_DashboardPage dash = new Doctor_DashboardPage(driver);
	Add_PatientPage aPatient = new Add_PatientPage(driver);
		
		web.implicitWait(driver, 10);
		web.explicitWait(driver, dash.getPatients(), 10);
		dash.getPatients().click();
		web.explicitWait(driver, dash.getAddPatients(), 10);
		dash.getAddPatients().click();
		aPatient.getPatientName().sendKeys("Rohith");
		aPatient.getPatientContact().sendKeys("859872112");
		aPatient.getPatientEmail().sendKeys("Rohit@test.com");
		
			web.argument(driver,aPatient.getGenderMale());
		
		aPatient.getAddress().sendKeys("Hyderabad");
		aPatient.getPatientAge().sendKeys("26");
		aPatient.getMedicalHistory().sendKeys("Mild Fever");
		web.argument(driver,aPatient.getAdd());
	}
}



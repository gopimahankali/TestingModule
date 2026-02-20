package com.comcast.HMS.DoctorTest;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.HMS.BaseTest.HMSBaseTest2;
import com.comcast.HMS.ObjectRepositoryUtility.Add_PatientPage;
import com.comcast.HMS.ObjectRepositoryUtility.Doctor_DashboardPage;
import com.comcast.HMS.generic.fileutility.ExcelUtility;

public class Add_PatientTest extends HMSBaseTest2 {
	
	
	@DataProvider(name = "PatientData1")
	public Object[][] getUserData1() throws Exception {
		ExcelUtility excel = new ExcelUtility();
		Object[][] data = new Object[(excel.getRowCount("Patient1"))-1][excel.getCellCount("Patient1")];
		for(int i = 1;  i< excel.getRowCount("Patient1"); i++) {
			for(int j = 0; j< excel.getCellCount("Patient1"); j++) {
				data[i-1][j] = excel.getData("Patient1",i,j);	
			}
		}
		return data;
	}
	@Test(dataProvider = "PatientData1")
	public void addPatient1(String name, String address, String gender, String email, String contact, String age, String medicalHistory) {
		
	Doctor_DashboardPage dash = new Doctor_DashboardPage(driver);
	Add_PatientPage aPatient = new Add_PatientPage(driver);
		
		web.implicitWait(driver, 10);
		web.explicitWait(driver, dash.getPatients(), 10);
		dash.getPatients().click();
		web.explicitWait(driver, dash.getAddPatients(), 10);
		dash.getAddPatients().click();
		aPatient.getPatientName().sendKeys(name);
		aPatient.getPatientContact().sendKeys(contact);
		aPatient.getPatientEmail().sendKeys(email);
		
		if(gender.equalsIgnoreCase("Female")) {
		web.argument(driver,aPatient.getGenderFemale());
		}else if(gender.equalsIgnoreCase("Male")) {
			web.argument(driver,aPatient.getGenderMale());
		}else {
			System.out.println("gender is not specified");
		}
		
		aPatient.getAddress().sendKeys(address);
		aPatient.getPatientAge().sendKeys(age);
		aPatient.getMedicalHistory().sendKeys(medicalHistory);
		web.argument(driver,aPatient.getAdd());
	}
}



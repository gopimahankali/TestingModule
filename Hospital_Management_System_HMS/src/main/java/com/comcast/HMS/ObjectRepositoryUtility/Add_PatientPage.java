package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_PatientPage {
	
		WebDriver driver;
		public Add_PatientPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(name = "patname")
		private WebElement patientName;
		@FindBy(name = "patcontact")
		private WebElement patientContact;
		@FindBy(name = "patemail")
		private WebElement patientEmail;
		@FindBy(xpath = "//div[@class='clip-radio radio-primary']//child::input[@id='rg-female']")
		private WebElement genderFemale;
		@FindBy(xpath = "//div[@class='clip-radio radio-primary']//child::input[@id='rg-male']")
		private WebElement genderMale;
		@FindBy(name  = "pataddress")
		private WebElement address;
		@FindBy(name  = "patage")
		private WebElement patientAge;
		@FindBy(name  = "medhis")
		private WebElement medicalHistory;
		@FindBy(xpath  = "//button[@type='submit']")
		private WebElement add;
		
		
		public WebElement getPatientName() {
			return patientName;
		}
		public WebElement getPatientContact() {
			return patientContact;
		}
		public WebElement getPatientEmail() {
			return patientEmail;
		}
		public WebElement getGenderFemale() {
			return genderFemale;
		}
		public WebElement getGenderMale() {
			return genderMale;
		}
		public WebElement getAddress() {
			return address;
		}
		public WebElement getPatientAge() {
			return patientAge;
		}
		public WebElement getMedicalHistory() {
			return medicalHistory;
		}
		public WebElement getAdd() {
			return add;
		}


}

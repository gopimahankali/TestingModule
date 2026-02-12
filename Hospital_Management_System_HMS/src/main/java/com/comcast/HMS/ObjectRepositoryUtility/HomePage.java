package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(linkText = "Logins")
	private WebElement logins;
	@FindBy(xpath ="(//button[text()='Click Here'])[1]")
	private WebElement patientLogin;
	@FindBy(xpath ="(//button[text()='Click Here'])[2]")
	private WebElement doctorLogin;
	@FindBy(xpath = "(//button[text()='Click Here'])[3]")
	private WebElement adminLogin;
	
	public WebElement getLogins() {
		return logins;
	}
	public WebElement getPatientLogin() {
		return patientLogin;
	}
	public WebElement getDoctorLogin() {
		return doctorLogin;
	}
	public WebElement getAdminLogin() {
		return adminLogin;
	}
	
}

package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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

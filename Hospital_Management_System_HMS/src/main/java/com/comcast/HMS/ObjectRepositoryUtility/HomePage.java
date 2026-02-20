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
	@FindBy(xpath ="//div[@class='blog-single-det']//descendant::a[@href='hms/user-login.php']")
	private WebElement patientLogin;
	@FindBy(xpath ="//a[@href='hms/doctor']")
	private WebElement doctorLogin;
	@FindBy(xpath = "//a[@href='hms/admin']")
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

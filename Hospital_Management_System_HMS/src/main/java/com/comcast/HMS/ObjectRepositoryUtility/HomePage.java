package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage class represents the Home Page of Hospital Management System (HMS)
 * application.
 * 
 * This class is implemented using Page Object Model (POM) design pattern. It
 * contains WebElements and getter methods to interact with Home Page.
 * 
 * This page provides navigation options for different user roles: - Patient
 * Login - Doctor Login - Admin Login
 * 
 * PageFactory is used to initialize WebElements.
 * 
 * This improves code maintainability, reusability, and readability.
 * 
 * Test scripts use this class to navigate to different login pages.
 * 
 * @author Mahan
 */
public class HomePage {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement for Logins menu link
	@FindBy(linkText = "Logins")
	private WebElement logins;

	// WebElement for Patient Login link
	@FindBy(xpath = "//div[@class='blog-single-det']//descendant::a[@href='hms/user-login.php']")
	private WebElement patientLogin;

	// WebElement for Doctor Login link
	@FindBy(xpath = "//a[@href='hms/doctor']")
	private WebElement doctorLogin;

	// WebElement for Admin Login link
	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement adminLogin;

	/**
	 * Getter method for Logins menu
	 * 
	 * @return WebElement
	 */
	public WebElement getLogins() {

		return logins;
	}

	/**
	 * Getter method for Patient Login link
	 * 
	 * @return WebElement
	 */
	public WebElement getPatientLogin() {

		return patientLogin;
	}

	/**
	 * Getter method for Doctor Login link
	 * 
	 * @return WebElement
	 */
	public WebElement getDoctorLogin() {

		return doctorLogin;
	}

	/**
	 * Getter method for Admin Login link
	 * 
	 * @return WebElement
	 */
	public WebElement getAdminLogin() {

		return adminLogin;
	}

}
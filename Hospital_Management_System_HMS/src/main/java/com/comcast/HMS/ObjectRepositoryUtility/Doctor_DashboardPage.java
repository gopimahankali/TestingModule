package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Doctor_DashboardPage class represents the Doctor Dashboard page in Hospital
 * Management System (HMS) application.
 * 
 * This class is implemented using Page Object Model (POM) design pattern. It
 * contains WebElements and getter methods to interact with Doctor Dashboard.
 * 
 * This page provides functionalities such as: - View Appointment History -
 * Update Profile - Add Patient - Manage Patient - Search - View Dashboard - My
 * Profile - Change Password - Logout
 * 
 * PageFactory is used to initialize WebElements.
 * 
 * This improves code reusability, readability, and maintainability.
 * 
 * @author Mahan
 */
public class Doctor_DashboardPage {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 * 
	 * @param driver
	 */
	public Doctor_DashboardPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement for View Appointment History link
	@FindBy(xpath = "//a[normalize-space(text())='View Appointment History']")
	private WebElement viewAppointmentHistory;

	// WebElement for Update Profile link
	@FindBy(xpath = "//a[normalize-space(text())='Update Profile']")
	private WebElement updateProfile;

	// WebElement for Patients menu
	@FindBy(xpath = "//div[@class='item-content']//descendant::span[text()=' Patients ']")
	private WebElement patients;

	// WebElement for Add Patient submenu
	@FindBy(xpath = "//ul[@class='sub-menu']//child::span[text()=' Add Patient']")
	private WebElement addPatients;

	// WebElement for Manage Patient submenu
	@FindBy(xpath = "//ul[@class='sub-menu']//descendant::span[text()=' Manage Patient ']")
	private WebElement managePatients;

	// WebElement for Search menu
	@FindBy(xpath = "//div[@class='item-content']//descendant::span[text()=' Search ']")
	private WebElement search;

	// WebElement for Dashboard menu
	@FindBy(xpath = "//div[@class='item-content']//descendant::span[text()=' Dashboard ']")
	private WebElement dashboard;

	// WebElement for My Profile option
	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//descendant::a[contains(text(),'My')]")
	private WebElement myProfile;

	// WebElement for Change Password option
	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//descendant::a[contains(text(),'Chan')]")
	private WebElement changePassword;

	// WebElement for Logout option
	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//descendant::a[contains(text(),'Log')]")
	private WebElement logout;

	// WebElement for User profile dropdown
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement user;

	/**
	 * Getter method for View Appointment History
	 */
	public WebElement getViewAppointmentHistory() {
		return viewAppointmentHistory;
	}

	/**
	 * Getter method for My Profile
	 */
	public WebElement getMyProfile() {
		return myProfile;
	}

	/**
	 * Getter method for Change Password
	 */
	public WebElement getChangePassword() {
		return changePassword;
	}

	/**
	 * Getter method for Logout
	 */
	public WebElement getLogout() {
		return logout;
	}

	/**
	 * Getter method for Update Profile
	 */
	public WebElement getUpdateProfile() {
		return updateProfile;
	}

	/**
	 * Getter method for Dashboard menu
	 */
	public WebElement getDashBoard() {
		return dashboard;
	}

	/**
	 * Getter method for Patients menu
	 */
	public WebElement getPatients() {
		return patients;
	}

	/**
	 * Getter method for Add Patient submenu
	 */
	public WebElement getAddPatients() {
		return addPatients;
	}

	/**
	 * Getter method for Manage Patient submenu
	 */
	public WebElement getManagePatient() {
		return managePatients;
	}

	/**
	 * Getter method for Search menu
	 */
	public WebElement getSearch() {
		return search;
	}

	/**
	 * Getter method for User profile dropdown
	 */
	public WebElement getUser() {
		return user;
	}

}
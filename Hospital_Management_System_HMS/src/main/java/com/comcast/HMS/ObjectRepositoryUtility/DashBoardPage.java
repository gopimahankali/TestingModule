package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * DashBoardPage class represents the Dashboard page of HMS application.
 * 
 * This class is implemented using Page Object Model (POM) design pattern. It
 * contains WebElements and getter methods to interact with Dashboard page.
 * 
 * This page provides options such as: - Book Appointment - View Appointment
 * History - View logged-in user profile - Logout from application
 * 
 * PageFactory is used to initialize WebElements.
 * 
 * This improves code reusability, maintainability, and readability.
 * 
 * @author Mahan
 */
public class DashBoardPage {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 * 
	 * @param driver
	 */
	public DashBoardPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement for Book Appointment link
	@FindBy(xpath = "(//p[contains(@class,'links cl-effect-1')])[2]")
	private WebElement bookAppointment;

	// WebElement for Logout link
	@FindBy(xpath = "//a[normalize-space(text())='Log Out']")
	private WebElement logout;

	// WebElement for Username/profile icon
	@FindBy(xpath = "//span[@class ='username']")
	private WebElement user;

	// WebElement for Appointment History link
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmentHistory;

	/**
	 * Getter method for Appointment History element
	 * 
	 * @return WebElement
	 */
	public WebElement getAppointmentHistory() {

		return appointmentHistory;
	}

	/**
	 * Getter method for Logout element
	 * 
	 * @return WebElement
	 */
	public WebElement getLogout() {

		return logout;
	}

	/**
	 * Getter method for User profile element
	 * 
	 * @return WebElement
	 */
	public WebElement getUser() {

		return user;
	}

	/**
	 * Getter method for Book Appointment element
	 * 
	 * @return WebElement
	 */
	public WebElement getBookAppointment() {

		return bookAppointment;
	}

}
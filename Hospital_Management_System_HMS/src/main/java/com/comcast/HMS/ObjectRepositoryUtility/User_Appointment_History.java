package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * User_Appointment_History class represents the Appointment History page for
 * Patient/User in Hospital Management System (HMS) application.
 *
 * This class is implemented using Page Object Model (POM) design pattern. It
 * contains WebElements and methods to interact with Appointment History page.
 *
 * Functionalities provided: - Cancel booked appointment
 *
 * PageFactory is used to initialize WebElements.
 *
 * Improves: - Code reusability - Maintainability - Readability
 *
 * This class is used in test scripts to perform actions on Appointment History
 * page.
 *
 * @author Mahan
 */
public class User_Appointment_History {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 *
	 * @param driver WebDriver instance
	 */
	public User_Appointment_History(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement for Cancel Appointment button/link
	@FindBy(xpath = "//a[@href='appointment-history.php?id=237&cancel=update']")
	private WebElement cancelAppointmentButton;

	/**
	 * Getter method for Cancel Appointment button
	 *
	 * @return WebElement
	 */
	public WebElement getCancel() {

		return cancelAppointmentButton;
	}

}
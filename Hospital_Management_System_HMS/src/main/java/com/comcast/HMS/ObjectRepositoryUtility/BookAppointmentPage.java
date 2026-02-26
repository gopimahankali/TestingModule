package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * BookAppointmentPage class represents the Book Appointment page in Hospital
 * Management System (HMS) application.
 * 
 * This class is implemented using Page Object Model (POM) design pattern. It
 * contains WebElements and getter methods to interact with Book Appointment
 * page.
 * 
 * This page allows user to: - Select doctor specialization - Select doctor -
 * Select appointment date - Select appointment time - Click submit button to
 * book appointment
 * 
 * PageFactory is used to initialize WebElements.
 * 
 * @author Mahan
 */
public class BookAppointmentPage {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 * 
	 * @param driver
	 */
	public BookAppointmentPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement for selecting Doctor Specialization dropdown
	@FindBy(name = "Doctorspecialization")
	private WebElement specialization;

	// WebElement for selecting Doctor dropdown
	@FindBy(name = "doctor")
	private WebElement doctor;

	// WebElement for selecting Appointment Date
	@FindBy(xpath = "//input[@name='appdate']")
	private WebElement date;

	// WebElement for selecting Appointment Time
	@FindBy(name = "apptime")
	private WebElement time;

	// WebElement for Submit button
	@FindBy(name = "submit")
	private WebElement submit;

	/**
	 * Getter method for Specialization dropdown
	 * 
	 * @return WebElement
	 */
	public WebElement getSpecialization() {
		return specialization;
	}

	/**
	 * Getter method for Doctor dropdown
	 * 
	 * @return WebElement
	 */
	public WebElement getDoctor() {
		return doctor;
	}

	/**
	 * Getter method for Appointment Date field
	 * 
	 * @return WebElement
	 */
	public WebElement getDate() {
		return date;
	}

	/**
	 * Getter method for Appointment Time field
	 * 
	 * @return WebElement
	 */
	public WebElement getTime() {
		return time;
	}

	/**
	 * Getter method for Submit button
	 * 
	 * @return WebElement
	 */
	public WebElement getSubmit() {
		return submit;
	}

}
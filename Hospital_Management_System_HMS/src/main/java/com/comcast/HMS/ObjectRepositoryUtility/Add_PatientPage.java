package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Add_PatientPage class represents the Add Patient page of HMS application.
 * 
 * This class is developed using Page Object Model (POM) design pattern. It
 * contains WebElements and reusable methods to interact with Add Patient page.
 * 
 * PageFactory is used to initialize web elements.
 * 
 * This class helps to:
 * 
 * - Enter patient details - Select gender - Enter address, age, and medical
 * history - Click Add button to create patient
 * 
 * This improves code reusability, readability, and maintainability.
 * 
 * @author Mahan
 */
public class Add_PatientPage {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 * 
	 * @param driver
	 */
	public Add_PatientPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement for Patient Name text field
	@FindBy(name = "patname")
	private WebElement patientName;

	// WebElement for Patient Contact text field
	@FindBy(name = "patcontact")
	private WebElement patientContact;

	// WebElement for Patient Email text field
	@FindBy(name = "patemail")
	private WebElement patientEmail;

	// WebElement for Female Gender radio button
	@FindBy(xpath = "//div[@class='clip-radio radio-primary']//child::input[@id='rg-female']")
	private WebElement genderFemale;

	// WebElement for Male Gender radio button
	@FindBy(xpath = "//div[@class='clip-radio radio-primary']//child::input[@id='rg-male']")
	private WebElement genderMale;

	// WebElement for Address text field
	@FindBy(name = "pataddress")
	private WebElement address;

	// WebElement for Patient Age text field
	@FindBy(name = "patage")
	private WebElement patientAge;

	// WebElement for Medical History text field
	@FindBy(name = "medhis")
	private WebElement medicalHistory;

	// WebElement for Add button
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement add;

	/**
	 * Getter method for Patient Name field
	 */
	public WebElement getPatientName() {
		return patientName;
	}

	/**
	 * Getter method for Patient Contact field
	 */
	public WebElement getPatientContact() {
		return patientContact;
	}

	/**
	 * Getter method for Patient Email field
	 */
	public WebElement getPatientEmail() {
		return patientEmail;
	}

	/**
	 * Getter method for Female Gender radio button
	 */
	public WebElement getGenderFemale() {
		return genderFemale;
	}

	/**
	 * Getter method for Male Gender radio button
	 */
	public WebElement getGenderMale() {
		return genderMale;
	}

	/**
	 * Getter method for Address field
	 */
	public WebElement getAddress() {
		return address;
	}

	/**
	 * Getter method for Patient Age field
	 */
	public WebElement getPatientAge() {
		return patientAge;
	}

	/**
	 * Getter method for Medical History field
	 */
	public WebElement getMedicalHistory() {
		return medicalHistory;
	}

	/**
	 * Getter method for Add button
	 */
	public WebElement getAdd() {
		return add;
	}

}
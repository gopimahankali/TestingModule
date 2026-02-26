package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

/**
 * CreateUserPage class represents the Create User (Registration) page in
 * Hospital Management System (HMS) application.
 * 
 * This class is developed using Page Object Model (POM) design pattern. It
 * contains WebElements and getter methods to interact with user registration
 * page.
 * 
 * This page allows user to: - Enter Full Name - Enter Address - Enter City -
 * Select Gender - Enter Email - Enter Password - Confirm Password - Click
 * Submit button to create user
 * 
 * PageFactory is used to initialize WebElements.
 * 
 * This improves code reusability, readability, and maintainability.
 * 
 * @author Mahan
 */
public class CreateUserPage {
	WebDriver driver;

	// Constructor to initialize elements using PageFactory
	public CreateUserPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElement for Full Name text field
	@FindBy(name = "full_name")
	private WebElement fullName;

	// WebElement for Address text field
	@FindBy(name = "address")
	private WebElement address;

	// WebElement for City text field
	@FindBy(name = "city")
	private WebElement city;

	// WebElement for Male Gender radio button
	@FindBy(xpath = "//input[@id='rg-male']")
	private WebElement maleGender;

	// WebElement for Female Gender radio button
	@FindBy(xpath = "//input[@id='rg-female']")
	private WebElement femaleGender;

	// WebElement for Email text field
	@FindBy(id = "email")
	private WebElement email;

	// WebElement for Password text field
	@FindBy(id = "password")
	private WebElement password;

	// WebElement for Confirm Password text field
	@FindBy(id = "password_again")
	private WebElement confirmPassword;

	// WebElement for Submit button
	@FindBy(xpath = "//button[contains(@class,'btn')]")
	private WebElement submit;

	/**
	 * Getter method for Full Name field
	 */
	public WebElement getFullName() {
		return fullName;
	}

	/**
	 * Getter method for Address field
	 */
	public WebElement getAddress() {
		return address;
	}

	/**
	 * Getter method for City field
	 */
	public WebElement getCity() {
		return city;
	}

	/**
	 * Getter method for Male Gender radio button
	 */
	public WebElement getMaleGender() {
		return maleGender;
	}

	/**
	 * Getter method for Female Gender radio button
	 */
	public WebElement getFemaleGender() {
		return femaleGender;
	}

	/**
	 * Getter method for Email field
	 */
	public WebElement getEmail() {
		return email;
	}

	/**
	 * Getter method for Password field
	 */
	public WebElement getPassword() {
		return password;
	}

	/**
	 * Getter method for Confirm Password field
	 */
	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Getter method for Submit button
	 */
	public WebElement getSubmit() {
		return submit;
	}

}
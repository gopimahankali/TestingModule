package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;

/**
 * Doctor_LoginPage class represents the Doctor Login functionality in Hospital
 * Management System (HMS) application.
 * 
 * This class is implemented using Page Object Model (POM) design pattern. It
 * contains WebElements and business method to perform Doctor login.
 * 
 * This class extends WebDriverUtility to use reusable browser methods like: -
 * implicitWait - maximize - switchWindow - navigation methods
 * 
 * This class performs: - Navigate to application URL - Click Login option -
 * Switch to Doctor Login window - Enter username and password - Click Login
 * button
 * 
 * PageFactory is used to initialize WebElements.
 * 
 * This improves code reusability, maintainability, and readability.
 * 
 * @author Mahan
 */
public class Doctor_LoginPage extends WebDriverUtility {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 * 
	 * @param driver
	 */
	public Doctor_LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement for Username text field
	@FindBy(name = "username")
	private WebElement userName;

	// WebElement for Password text field
	@FindBy(name = "password")
	private WebElement password;

	// WebElement for Login button
	@FindBy(name = "submit")
	private WebElement loginButton;

	/**
	 * Getter method for Username field
	 * 
	 * @return WebElement
	 */
	public WebElement getUserName() {
		return userName;
	}

	/**
	 * Getter method for Password field
	 * 
	 * @return WebElement
	 */
	public WebElement getPassword() {
		return password;
	}

	/**
	 * Getter method for Login button
	 * 
	 * @return WebElement
	 */
	public WebElement getLoginButton() {
		return loginButton;
	}

	/**
	 * Business method to perform Doctor Login operation.
	 * 
	 * This method performs: 1. Open application URL 2. Apply implicit wait 3.
	 * Maximize browser 4. Click Login option from HomePage 5. Switch to Doctor
	 * Login window 6. Enter username and password 7. Click Login button
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 */
	public void loginToApplication(String url, String userName, String password) {

		// Apply implicit wait
		implicitWait(driver, 10);

		// Open application URL
		url(driver, url);

		// Maximize browser window
		maximize(driver);

		// Create HomePage object
		HomePage home = new HomePage(driver);

		// Click Login option
		home.getLogins().click();

		// Store parent window ID
		String parent = getWindow(driver);

		// Click Doctor Login option
		home.getDoctorLogin().click();

		// Switch to Doctor Login window
		switchWindow(driver, parent);

		// Enter Username
		getUserName().sendKeys(userName);

		// Enter Password
		getPassword().sendKeys(password);

		// Click Login button
		getLoginButton().click();
	}

}
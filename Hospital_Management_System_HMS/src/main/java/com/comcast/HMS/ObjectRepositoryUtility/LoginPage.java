package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;

/**
 * LoginPage represents the Patient Login page of HMS application.
 *
 * This class is implemented using Page Object Model (POM) design pattern. It
 * contains WebElements and business methods required to perform Patient Login
 * operation.
 *
 * This class extends WebDriverUtility to reuse common WebDriver methods like: -
 * implicit wait - browser maximize - window handling - navigation methods
 *
 * Functionalities provided: - Navigate to application URL - Click Logins menu -
 * Switch to Patient Login window - Enter username and password - Click Login
 * button - Navigate to Create Account page
 *
 * PageFactory is used to initialize WebElements.
 *
 * Improves: - Code reusability - Maintainability - Readability
 *
 * @author Mahan
 */
public class LoginPage extends WebDriverUtility {

	// WebDriver reference variable
	WebDriver driver;

	/**
	 * Constructor to initialize WebElements using PageFactory
	 *
	 * @param driver WebDriver instance
	 */
	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Username text field
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTextField;

	// Password text field
	@FindBy(name = "password")
	private WebElement passwordTextField;

	// Login button
	@FindBy(name = "submit")
	private WebElement loginButton;

	// Create Account link
	@FindBy(xpath = "//a[normalize-space(text())='Create an account']")
	private WebElement createAccountLink;

	/**
	 * Getter for Username field
	 *
	 * @return WebElement
	 */
	public WebElement getUserName() {

		return userNameTextField;
	}

	/**
	 * Getter for Password field
	 *
	 * @return WebElement
	 */
	public WebElement getPassword() {

		return passwordTextField;
	}

	/**
	 * Getter for Login button
	 *
	 * @return WebElement
	 */
	public WebElement getLoginButton() {

		return loginButton;
	}

	/**
	 * Getter for Create Account link
	 *
	 * @return WebElement
	 */
	public WebElement getCreateAccount() {

		return createAccountLink;
	}

	/**
	 * Business method to perform Patient Login.
	 *
	 * Steps performed: 1. Apply implicit wait 2. Open application URL 3. Maximize
	 * browser window 4. Click Logins menu from HomePage 5. Switch to Patient Login
	 * window 6. Enter username 7. Enter password 8. Click Login button
	 *
	 * @param url      Application URL
	 * @param username Patient username
	 * @param password Patient password
	 */
	public void loginToApplication(String url, String username, String password) {

		// Apply implicit wait
		implicitWait(driver, 10);

		// Open application URL
		url(driver, url);

		// Maximize browser
		maximize(driver);

		// Navigate to HomePage
		HomePage homePage = new HomePage(driver);

		// Click Logins menu
		homePage.getLogins().click();

		// Store parent window ID
		String parentWindow = getWindow(driver);

		// Click Patient Login
		homePage.getPatientLogin().click();

		// Switch to child window
		switchWindow(driver, parentWindow);

		// Enter Username
		userNameTextField.sendKeys(username);

		// Enter Password
		passwordTextField.sendKeys(password);

		// Click Login button
		loginButton.click();
	}

}
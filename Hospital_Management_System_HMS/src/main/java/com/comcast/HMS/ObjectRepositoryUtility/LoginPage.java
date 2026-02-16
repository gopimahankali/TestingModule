package com.comcast.HMS.ObjectRepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement Password;
	@FindBy(name = "submit")
	private WebElement loginButton;
	@FindBy(xpath = "//a[normalize-space(text())='Create an account']")
	private WebElement createAccount;
	
	public WebElement getCreateAccount() {
		return createAccount;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return Password;
	}
	public void loginToApplication(String url, String userName, String password) {
		implicitWait(driver, 10);
		url(driver, url);
		maximize(driver);
		HomePage home = new HomePage(driver);
		home.getLogins().click();
		String parent =getWindow(driver);
		home.getPatientLogin().click();
		switchWindow(driver,parent);
		getUserName().sendKeys(userName);
		getPassword().sendKeys(password);
		getLoginButton().click();
	}
	

}

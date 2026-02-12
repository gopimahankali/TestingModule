package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
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
	

}

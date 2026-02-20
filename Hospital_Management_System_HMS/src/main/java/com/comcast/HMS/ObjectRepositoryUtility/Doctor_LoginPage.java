package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;

public class Doctor_LoginPage extends WebDriverUtility {
	WebDriver driver;
	public Doctor_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(name = "submit")
	private WebElement loginButton;
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApplication(String url, String userName, String password) {
		implicitWait(driver, 10);
		url(driver, url);
		maximize(driver);
		HomePage home = new HomePage(driver);
		home.getLogins().click();
		String parent =getWindow(driver);
		home.getDoctorLogin().click();
		switchWindow(driver,parent);
		getUserName().sendKeys(userName);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
	
	}
}

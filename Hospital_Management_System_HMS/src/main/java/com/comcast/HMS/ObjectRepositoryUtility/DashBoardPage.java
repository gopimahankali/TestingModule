package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//p[contains(@class,'links cl-effect-1')])[2]")
	private WebElement bookAppointment;
	@FindBy(xpath = "//a[normalize-space(text())='Log Out']")
	private WebElement logout;
	@FindBy(xpath = "//span[@class ='username']")
	private WebElement user;

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getBookAppointment() {
		return bookAppointment;
	}
	
	
	
	

}

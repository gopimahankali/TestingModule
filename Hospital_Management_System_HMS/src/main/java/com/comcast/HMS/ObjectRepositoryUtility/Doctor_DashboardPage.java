package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctor_DashboardPage {
	WebDriver driver;
	public Doctor_DashboardPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[normalize-space(text())='View Appointment History']")
	private WebElement viewAppointmentHistory;
	@FindBy(xpath = "//a[normalize-space(text())='Update Profile']")
	private WebElement updateProfile;
	@FindBy(xpath  = "//div[@class='item-content']//descendant::span[text()=' Patients ']")
	private WebElement patients;
	@FindBy(xpath = "//ul[@class='sub-menu']//child::span[text()=' Add Patient']")
	private WebElement addPatients;
	@FindBy(xpath = "//ul[@class='sub-menu']//descendant::span[text()=' Manage Patient ']")
	private WebElement managePatients;
	@FindBy(xpath  = "//div[@class='item-content']//descendant::span[text()=' Search ']")
	private WebElement search;
	@FindBy(xpath  = "//div[@class='item-content']//descendant::span[text()=' Dashboard ']")
	private WebElement dashboard;
	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//descendant::a[contains(text(),'My')]")
	private WebElement myProfile;
	@FindBy(xpath  = "//ul[contains(@class,'dropdown')]//descendant::a[contains(text(),'Chan')]")
	private WebElement changePassword;
	@FindBy(xpath  = "//ul[contains(@class,'dropdown')]//descendant::a[contains(text(),'Log')]")
	private WebElement logout;
	@FindBy(xpath  = "//a[@class='dropdown-toggle']")
	private WebElement user;
	
	public WebElement getViewAppointmentHistory() {
		return viewAppointmentHistory;
	}
	public WebElement getMyProfile() {
		return myProfile;
	}
	public WebElement getChangePassword() {
		return changePassword;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getUpdateProfile() {
		return updateProfile;
	}
	public WebElement getDashBoard() {
		return dashboard;
	}
	public WebElement getPatients() {
		return patients;
	}
	public WebElement getAddPatients() {
		return addPatients;
	}
	public WebElement getManagePatient() {
		return managePatients;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getUser() {
		return user;
	}

}

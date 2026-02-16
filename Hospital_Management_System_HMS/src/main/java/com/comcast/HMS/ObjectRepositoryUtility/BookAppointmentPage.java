package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointmentPage {
	WebDriver driver;
	public BookAppointmentPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Doctorspecialization")
	private WebElement specialization;
	@FindBy(name = "doctor")
	private WebElement doctor;
	@FindBy(xpath  = "//input[@name='appdate']")
	private WebElement date;
	@FindBy(name = "apptime")
	private WebElement time;
	@FindBy(name = "submit")
	private WebElement submit;
	public WebElement getSpecialization() {
		return specialization;
	}
	public WebElement getDoctor() {
		return doctor;
	}
	public WebElement getDate() {
		return date;
	}
	public WebElement getTime() {
		return time;
	}
	public WebElement getSubmit() {
		return submit;
	}
	

}

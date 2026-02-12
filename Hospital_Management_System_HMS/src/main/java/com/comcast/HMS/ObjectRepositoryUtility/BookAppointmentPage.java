package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookAppointmentPage {
	
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

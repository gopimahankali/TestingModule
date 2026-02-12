package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {

	@FindBy(name = "full_name")
	private WebElement fullName;
	@FindBy(name = "address")
	private WebElement address;
	@FindBy(name = "city")
	private WebElement city;
	@FindBy(xpath = "//input[@id='rg-male']")
	private WebElement maleGender;
	@FindBy(xpath = "//input[@id='rg-female']")
	private WebElement femaleGender;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "password_again")
	private WebElement confirmPassword;
	@FindBy(xpath = "//button[contains(@class,'btn')]")
	private WebElement submit;
	public WebElement getFullName() {
		return fullName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getMaleGender() {
		return maleGender;
	}
	public WebElement getFemaleGender() {
		return femaleGender;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	public WebElement getSubmit() {
		return submit;
	}
}

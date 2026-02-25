package com.comcast.HMS.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Appointment_History {
	
		WebDriver driver;
		public User_Appointment_History(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//a[@href='appointment-history.php?id=237&cancel=update']")
		private WebElement cancel;
		
		public WebElement getCancel() {
			return cancel;
		}
		
		

}

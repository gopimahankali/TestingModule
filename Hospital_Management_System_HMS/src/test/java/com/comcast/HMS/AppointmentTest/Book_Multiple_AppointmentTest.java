package com.comcast.HMS.AppointmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.HMS.BaseTest.HMSBaseTest;
import com.comcast.HMS.ObjectRepositoryUtility.CreateUserPage;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

public class Book_Multiple_AppointmentTest extends HMSBaseTest  {
	
	
	CreateUserPage Create = new CreateUserPage();
	WebDriverUtility web = new WebDriverUtility();
	FileUtility file = new FileUtility();
	ExcelUtility excel = new ExcelUtility();
	WebDriver driver = null;

	@DataProvider(name = "UserData")
	public Object[][] getUserData() throws Exception {
		
		Object[][] data = new Object[(excel.getRowCount("User_Details"))-1][excel.getCellCount("User_Details")];
		for(int i = 1;  i< excel.getRowCount("User_Details"); i++) {
			for(int j = 0; j< excel.getCellCount("User_Details"); j++) {
				data[i-1][j] = excel.getData("User_Details",i,j);	
			}
		}
		return data;
	}

	@Test(dataProvider = "UserData")
	public void Appointment(String email, String password ) {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		web.implicitWait(driver, 10);
		login.getUserName().sendKeys(email);
		login.getPassword().sendKeys(password);
		login.getLoginButton().click();
		DashBoardPage dash = PageFactory.initElements(driver, DashBoardPage.class);
		dash.getBookAppointment().click();
		
	}
	
	
}

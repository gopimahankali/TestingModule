package com.comcast.HMS.AppointmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.HMS.ObjectRepositoryUtility.CreateUserPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

public class sample {
	
	@Test
	public void test() throws Exception {
		CreateUserPage Create = new CreateUserPage();
		WebDriverUtility web = new WebDriverUtility();
		FileUtility file = new FileUtility();
		WebDriver driver = null;
		String browser = file.getDataFromPrpertiesFile("Browser");
		String url = file.getDataFromPrpertiesFile("Url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else {
				driver = new FirefoxDriver();
			}
		
		
		web.maximize(driver);
		web.implicitWait(driver, 20);
		web.url(driver, url);
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		//Home Page
		home.getLogins().click();
		String parent = web.getWindow(driver);
		home.getPatientLogin().click();
	    web.switchWindow(driver, parent);
	    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	    login.getCreateAccount().click();	
		
		
	}
}


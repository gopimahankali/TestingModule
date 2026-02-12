package com.comcast.HMS.AppointmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.HMS.ObjectRepositoryUtility.CreateUserPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;



public class CreatePatientTest {
	
	CreateUserPage Create = new CreateUserPage();
	WebDriverUtility web = new WebDriverUtility();
	FileUtility file = new FileUtility();
	WebDriver driver = null;
	
	@DataProvider(name = "UserData")
	public Object[][] getUserData() throws Exception {
		ExcelUtility excel = new ExcelUtility();
		Object[][] data = new Object[(excel.getRowCount("UserData"))-1][excel.getCellCount("UserData")];
		for(int i = 1;  i< excel.getRowCount("UserData"); i++) {
			for(int j = 0; j< excel.getCellCount("UserData"); j++) {
				data[i-1][j] = excel.getData("UserData",i,j);	
			}
		}
		return data;
	}
	
	@Test(dataProvider = "UserData")
	public void createPatient(String fullname, String address, String city, String gender, String email, String password, String passwordagain) throws Exception {
		
		String browser = file.getDataFromPrpertiesFile("Browser");
		String url = file.getDataFromPrpertiesFile("Url");
		System.out.println(url);
		WebDriver driver = web.launchBrowser(browser);
		
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
	    web.explicitWait(driver, login.getCreateAccount(), 10);
	    login.getCreateAccount().click();
	    CreateUserPage create = PageFactory.initElements(driver, CreateUserPage.class);
	    create.getFullName().sendKeys(fullname);
	    create.getAddress().sendKeys(address);
	    create.getCity().sendKeys(city);
	    
	    web.waitForPresence(driver, create.getMaleGender());
	    web.waitForPresence(driver, create.getFemaleGender());
	    
	    if(gender.equalsIgnoreCase("Male")) {
	    	web.arg(driver, create.getMaleGender());
	    }else if(gender.equalsIgnoreCase("Female")) {
	    	web.arg(driver, create.getFemaleGender());
	    } else {
	    	System.out.println("error");
	    }
	    
	    create.getEmail().sendKeys(email);
	    create.getPassword().sendKeys(password);
	    create.getConfirmPassword().sendKeys(passwordagain);
	    
	    web.argument(driver, create.getSubmit());
	    
		web.closeBrowser(driver);
		
	}

}

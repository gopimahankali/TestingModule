package com.comcast.HMS.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcarst.HMS.generic.databaseutility.DatabaseUtility;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

public class HMSBaseTest {
	
	DatabaseUtility db = new DatabaseUtility();
	FileUtility file = new FileUtility();
	ExcelUtility excel = new ExcelUtility();
	WebDriverUtility web = new WebDriverUtility();
	WebDriver driver = null;
	
	@BeforeSuite
	public void conficBS() throws Exception {
		db.getDbconnection();
		
	}
	
	@BeforeClass
	public void configBC() throws Exception {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String browser = file.getDataFromPrpertiesFile("Browser");
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		web.maximize(driver);
		
		
	}
	
	@BeforeMethod()
	public void configBM() throws Exception {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		web.implicitWait(driver,20);
		String url = file.getDataFromPrpertiesFile("Url");
		web.url(driver, url);
		home.getLogins().click();
		String parent = web.getWindow(driver);
		home.getPatientLogin().click();
	    web.switchWindow(driver, parent);
	    
	}
	
	@AfterMethod
	public void closeApp() {
		try {
			DashBoardPage dash = PageFactory.initElements(driver, DashBoardPage.class);
			dash.getUser().click();
			web.explicitWait(driver, dash.getLogout(), 10);
			dash.getLogout().click();
		} catch (Exception e) {
			System.out.println("Logout skipped: user not logged in");
	  }
		
	}
	
	@AfterClass
	public void ConfigAC() {
		web.closeBrowser(driver);
		
	}
	@AfterSuite
	public void configAS() {
		
	}
	
}

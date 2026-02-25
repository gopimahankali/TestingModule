package com.comcast.HMS.BaseTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcarst.HMS.generic.databaseutility.DatabaseUtility;
import com.comcast.HMS.ObjectRepositoryUtility.Add_PatientPage;
import com.comcast.HMS.ObjectRepositoryUtility.Doctor_DashboardPage;
import com.comcast.HMS.ObjectRepositoryUtility.Doctor_LoginPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.generic.WebDriverUtility.JavaUtility;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

public class HMSBaseTest2 {
	protected DatabaseUtility db = new DatabaseUtility();
	protected FileUtility file = new FileUtility();
	protected ExcelUtility excel = new ExcelUtility();
	protected WebDriverUtility web = new WebDriverUtility();
	protected JavaUtility java = new JavaUtility();
	protected WebDriver driver = null;
	public static WebDriver sdriver = null;

	
	@BeforeSuite
	public void conficBS() throws Exception {
		db.getDbconnection();
		System.out.println("connected to db");
		
	}
	
	@BeforeClass
	public void openBrowser() throws Exception {
	
		String browser = file.getDataFromPrpertiesFile("Browser");
		ChromeOptions options = new ChromeOptions();
		Map<String , Object > map = new HashMap<>();
		map.put("profile.password_manager_leak_detection",false);
		options.setExperimentalOption("prefs", map);
		options.addArguments("--force-device-scale-factor=0.9");
		options.addArguments("--high-dpi-support=0.9");


		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new EdgeDriver();
	}
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		
	}

	@BeforeMethod()
	public void login() throws Exception {
		String url = file.getDataFromPrpertiesFile("Url");
		String username = file.getDataFromPrpertiesFile("DoctorLogin");
		String password = file.getDataFromPrpertiesFile("Password1");
		Doctor_LoginPage Dlogin = new Doctor_LoginPage(driver);
		Dlogin.loginToApplication(url, username, password);
	    
	}
	
	@AfterMethod
	public void logout() {
		    Doctor_DashboardPage dash = new Doctor_DashboardPage(driver);
			dash.getUser().click();
			web.explicitWait(driver, dash.getLogout(), 10);
			web.argument(driver,dash.getLogout());
	}
	
	@AfterClass
	public void ConfigAC() {
		web.closeBrowser(driver);
		
	}
	@AfterSuite
	public void configAS() throws Exception {
		db.closeDbconnection();
		
	}
	
}


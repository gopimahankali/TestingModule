package com.comcast.HMS.BaseTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcarst.HMS.generic.databaseutility.DatabaseUtility;
import com.comcast.HMS.ObjectRepositoryUtility.BookAppointmentPage;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.JavaUtility;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

public class HMSBaseTest {
	
	protected DatabaseUtility db = new DatabaseUtility();
	protected FileUtility file = new FileUtility();
	protected ExcelUtility excel = new ExcelUtility();
	protected WebDriverUtility web = new WebDriverUtility();
	protected JavaUtility java = new JavaUtility();
	protected WebDriver driver = null;
	public static WebDriver sdriver=null;
	
	
	@BeforeSuite
	public void conficBS() throws Exception {
		db.getDbconnection();
		System.out.println("connected to db");
		
	}
	
	@BeforeClass
	public void configBC() throws Exception {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		EdgeOptions options = new EdgeOptions();

        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
		
		String browser = file.getDataFromPrpertiesFile("Browser");
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new EdgeDriver(options);
	}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		
	}

	@BeforeMethod()
	public void configBM() throws Exception {
		String url = file.getDataFromPrpertiesFile("Url");
		String username = file.getDataFromPrpertiesFile("Patient");
		String password = file.getDataFromPrpertiesFile("Password2");
		LoginPage  login = new LoginPage (driver);
		login.loginToApplication(url, username, password);
	    
	}
	
	@AfterMethod
	public void closeApp() {
			DashBoardPage dash = new DashBoardPage(driver);
			dash.getUser().click();
			web.explicitWait(driver, dash.getLogout(), 10);
			dash.getLogout().click();
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

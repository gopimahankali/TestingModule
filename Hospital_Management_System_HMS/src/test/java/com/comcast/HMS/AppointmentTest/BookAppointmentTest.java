package com.comcast.HMS.AppointmentTest;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.HMS.ObjectRepositoryUtility.BookAppointmentPage;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.ObjectRepositoryUtility.HomePage;
import com.comcast.HMS.ObjectRepositoryUtility.LoginPage;
import com.comcast.HMS.generic.WebDriverUtility.JavaUtility;
import com.comcast.HMS.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.HMS.generic.fileutility.ExcelUtility;
import com.comcast.HMS.generic.fileutility.FileUtility;

public class BookAppointmentTest {
	FileUtility file = new FileUtility();
	ExcelUtility excel = new ExcelUtility();
	JavaUtility java = new JavaUtility();
	WebDriverUtility web = new WebDriverUtility();
	@Test
	public void bookAppointment() throws Exception {

	String browser = file.getDataFromPrpertiesFile("Browser");
	String url = file.getDataFromPrpertiesFile("Url");
	String username = file.getDataFromPrpertiesFile("Patient");
	String password = file.getDataFromPrpertiesFile("Password2");
	String bookingDate  = java.getRequiredDate(10); 
	
	WebDriver driver = web.launchBrowser(browser);
	
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	web.maximize(driver);
	web.implicitWait(driver, 20);
	
	web.url(driver, url);
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	//Home Page
	home.getLogins().click();
	String parent = web.getWindow(driver);
	home.getPatientLogin().click();
    web.switchWindow(driver, parent);
   
	//patient Login
    login.getUserName().sendKeys(username);
    login.getPassword().sendKeys(password);
    login.getLoginButton().click();
   //Dashboard Page
    DashBoardPage dash = PageFactory.initElements(driver, DashBoardPage.class);
    web.explicitWait(driver, dash.getBookAppointment(), 10);
    dash.getBookAppointment().click();
    //Book Appointment
    BookAppointmentPage book = PageFactory.initElements(driver,  BookAppointmentPage.class);
    web.dropDown(book.getSpecialization(),"Internal Medicine", driver);
    web.dropDown(book.getDoctor(),"53",driver);
    web.explicitWait(driver, book.getDate(),10);
    book.getDate().sendKeys(bookingDate);
    web.explicitWait(driver, book.getTime(),10);
    web.scroll(driver,book.getDate());
    book.getTime().sendKeys("10:00 AM");
   
    web.argument(driver,book.getSubmit());
   
    web.closeBrowser(driver);
    
	}
}

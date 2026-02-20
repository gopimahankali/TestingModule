package com.comcast.HMS.PatientTest;
/**
 * This class is used to book an appointment and cancel the appointment
 * @author Gopi Shankar Mahankali
 */
import org.testng.Assert;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;
import com.comcast.HMS.BaseTest.HMSBaseTest;
import com.comcast.HMS.ObjectRepositoryUtility.BookAppointmentPage;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;
import com.comcast.HMS.ObjectRepositoryUtility.User_Appointment_History;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;
 
public class Book_AppointmentTest extends HMSBaseTest  {
	

	//@Test(retryAnalyzer = com.comcast.HMS.ListenerUtility.RetryListenerImp.class)
	@Test(priority = 1)
	public void BookAppointment() throws Exception {
   
	 DashBoardPage dash = new DashBoardPage(driver);
	 BookAppointmentPage book = new BookAppointmentPage(driver);
		String bookingDate  = java.getRequiredDate(10);
		 web.explicitWait(driver, dash.getBookAppointment(), 10);
		 dash.getBookAppointment().click();
		 UtilityClassObject.getTest().log(Status.INFO,"Dashboard page is Displayed");
		 
		    web.dropDown(book.getSpecialization(),"Internal Medicine", driver);
		    web.dropDown(book.getDoctor(),"53",driver);
		    web.explicitWait(driver, book.getDate(),10);
		    book.getDate().sendKeys(bookingDate);
		    web.explicitWait(driver, book.getTime(),10);
		    web.scroll(driver,book.getDate());
		    book.getTime().sendKeys("11:00 AM");
		    web.argument(driver,book.getSubmit()); 
		    UtilityClassObject.getTest().log(Status.INFO,"Appointment Booked Successfully");
            web.alert(driver);
           
	}
	@Test(priority = 3)
		public void AppointmentHistory() {
		User_Appointment_History user = new User_Appointment_History(driver);
		 DashBoardPage dash = new DashBoardPage(driver);
		 dash.getAppointmentHistory().click();
		 String title = web.getTitle(driver);
		 Assert.assertEquals(title, "User | Appointment History");
		 UtilityClassObject.getTest().log(Status.INFO,"Title Verified Successfully");
		 web.explicitWait(driver, user.getCancel(), 10);
		 web.argument(driver, user.getCancel());
		 web.alert(driver);
		 UtilityClassObject.getTest().log(Status.INFO,"Appointment Canceled Successfully");
	}
	@Test(priority = 2)
	public void CheckAppointment() {
		
	}
	
}

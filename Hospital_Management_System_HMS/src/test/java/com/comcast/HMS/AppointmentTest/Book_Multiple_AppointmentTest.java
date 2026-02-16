package com.comcast.HMS.AppointmentTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.HMS.BaseTest.HMSBaseTest;
import com.comcast.HMS.ObjectRepositoryUtility.BookAppointmentPage;
import com.comcast.HMS.ObjectRepositoryUtility.DashBoardPage;

//@Listeners(com.comcast.HMS.ListenerUtility.Listener_Implementation.class)
public class Book_Multiple_AppointmentTest extends HMSBaseTest  {
	

	@Test(retryAnalyzer = com.comcast.HMS.ListenerUtility.RetryListenerImp.class)
	public void Appointment() throws InterruptedException {
		WebDriver driver = null;
	 DashBoardPage dash = new DashBoardPage(driver);
	 BookAppointmentPage book = new BookAppointmentPage(driver);
		String bookingDate  = java.getRequiredDate(10);
		 web.explicitWait(driver, dash.getBookAppointment(), 10);
		 dash.getBookAppointment().click();
	
		    web.dropDown(book.getSpecialization(),"Internal Medicine", driver);
		    web.dropDown(book.getDoctor(),"53",driver);
		    web.explicitWait(driver, book.getDate(),10);
		    book.getDate().sendKeys(bookingDate);
		    web.explicitWait(driver, book.getTime(),10);
		    web.scroll(driver,book.getDate());
		    book.getTime().sendKeys("11:00 AM");
		    web.argument(driver,book.getSubmit()); 
		   Thread.sleep(2000);
            web.alert(driver);
	}
}

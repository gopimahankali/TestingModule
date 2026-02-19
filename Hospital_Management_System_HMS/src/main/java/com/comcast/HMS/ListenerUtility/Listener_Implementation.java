package com.comcast.HMS.ListenerUtility;
/**
 * This class is used to implement the ITestListener and ISuiteListener interface to generate the ExtentReport
 * @author mahan
 */
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.HMS.BaseTest.HMSBaseTest;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;


public class Listener_Implementation implements ITestListener, ISuiteListener{

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		ISuiteListener.super.onStart(suite);
		System.out.println("=== ===>"+"Report Configuration"+"<=== ===");
		
		String time = new Date().toString().replace(" ", "_").replace(":","_");
	    spark = new ExtentSparkReporter("./AdvancedReport/PatientModule/report"+time+".html");
		spark.config().setReportName("Appointment Module");
		spark.config().setDocumentTitle("HMS Test Suite Results");
		spark.config().setTheme(Theme.DARK);
		
	    report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("BROWSER", "FIREFOX");
	
		
	}

	@Override
	public void onFinish(ISuite suite) {
		ISuiteListener.super.onFinish(suite);
		System.out.println("=== ===>"+"Report BackUP"+"<=== ===");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		System.out.println("=== ===>"+result.getMethod().getMethodName()+"=== ===> START <=== ===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"=== ===> STARTED <=== ===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		System.out.println("=== ===>"+result.getMethod().getMethodName()+"=== ===> END <=== ===");
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)HMSBaseTest.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":","_");
		test.addScreenCaptureFromBase64String(filePath, "Success : "+testName+"-"+time);
		test.log(Status.PASS, result.getMethod().getMethodName()+"=== ===> COMPLETED <=== ===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)HMSBaseTest.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":","_");
		test.addScreenCaptureFromBase64String(filePath, "Failure : "+testName+"-"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=== ===> FAILED <=== ===");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, result.getMethod().getMethodName()+"=== ===> SkIPPED <=== ===");
	}
	
	

}

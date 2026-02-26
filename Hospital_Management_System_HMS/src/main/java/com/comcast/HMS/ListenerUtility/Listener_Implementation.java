package com.comcast.HMS.ListenerUtility;

/**
 * Listener_Implementation class is used to implement TestNG Listeners
 * such as ITestListener and ISuiteListener to generate Extent Reports.
 * 
 * This class automatically performs:
 * 
 * 1. Report configuration before suite execution
 * 2. Create test entries in report
 * 3. Capture screenshots on success and failure
 * 4. Log test status (PASS, FAIL, SKIP)
 * 5. Flush and save report after suite execution
 * 
 * This helps generate professional HTML reports with screenshots.
 * 
 * Uses ExtentReports and ExtentSparkReporter.
 * 
 * @author Mahan
 */

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.HMS.generic.WebDriverUtility.UtilityClassObject;

public class Listener_Implementation implements ITestListener, ISuiteListener {

	// ExtentSparkReporter is used to generate HTML report
	public ExtentSparkReporter spark;

	// ExtentReports is main report engine
	public ExtentReports report;

	// ExtentTest is used to log individual test steps
	public static ExtentTest test;

	/**
	 * This method executes before execution of test suite. Used to configure Extent
	 * Report settings.
	 */
	@Override
	public void onStart(ISuite suite) {

		System.out.println("=== ===> Report Configuration <=== ===");

		// Generate unique report name using date and time
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		// Specify report path
		spark = new ExtentSparkReporter("./AdvancedReport/PatientModule/report" + time + ".html");

		// Configure report details
		spark.config().setReportName("Appointment Module");
		spark.config().setDocumentTitle("HMS Test Suite Results");
		spark.config().setTheme(Theme.DARK);

		// Create ExtentReports object
		report = new ExtentReports();

		// Attach reporter
		report.attachReporter(spark);

		// Add system information
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("BROWSER", "FIREFOX");
	}

	/**
	 * This method executes after execution of entire test suite. Used to flush and
	 * save Extent Report.
	 */
	@Override
	public void onFinish(ISuite suite) {

		System.out.println("=== ===> Report BackUP <=== ===");

		// Save report
		report.flush();
	}

	/**
	 * This method executes when test method starts. Creates test entry in Extent
	 * Report.
	 */
	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("=== ===> " + result.getMethod().getMethodName() + " START <=== ===");

		// Create test entry in report
		test = report.createTest(result.getMethod().getMethodName());

		// Store test object in ThreadLocal
		UtilityClassObject.setTest(test);

		// Log test start
		test.log(Status.INFO, result.getMethod().getMethodName() + " STARTED");
	}

	/**
	 * This method executes when test passes. Captures screenshot and logs PASS
	 * status.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("=== ===> " + result.getMethod().getMethodName() + " END <=== ===");

		String testName = result.getMethod().getMethodName();

		// Get driver from ThreadLocal
		WebDriver driver = UtilityClassObject.getDriver();

		// Capture screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		String filePath = ts.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		// Attach screenshot to report
		test.addScreenCaptureFromBase64String(filePath, "Success : " + testName + "-" + time);

		// Log PASS status
		test.log(Status.PASS, testName + " COMPLETED");
	}

	/**
	 * This method executes when test fails. Captures screenshot and logs FAIL
	 * status.
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		WebDriver driver = UtilityClassObject.getDriver();

		TakesScreenshot ts = (TakesScreenshot) driver;

		String filePath = ts.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		// Attach screenshot
		test.addScreenCaptureFromBase64String(filePath, "Failure : " + testName + "-" + time);

		// Log FAIL status
		test.log(Status.FAIL, testName + " FAILED");
	}

	/**
	 * This method executes when test is skipped. Logs SKIP status in report.
	 */
	@Override
	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
	}

}
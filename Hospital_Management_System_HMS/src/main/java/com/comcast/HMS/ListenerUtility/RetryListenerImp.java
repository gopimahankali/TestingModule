package com.comcast.HMS.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryListenerImp class is used to retry failed test cases automatically.
 * 
 * This class implements TestNG's IRetryAnalyzer interface. It allows failed
 * test cases to be re-executed a specified number of times.
 * 
 * This is useful when test failures occur due to temporary issues like: -
 * Network issues - Browser loading delay - Synchronization issues - Environment
 * instability
 * 
 * This improves test reliability and reduces false failures.
 * 
 * Example: If limitcount = 5, failed test will retry maximum 5 times.
 * 
 * Used with @Test annotation:
 * 
 * @Test(retryAnalyzer = RetryListenerImp.class)
 * 
 * @author Mahan
 */
public class RetryListenerImp implements IRetryAnalyzer {

	// Counter to track number of retry attempts
	int count = 0;

	// Maximum retry limit
	int limitcount = 5;

	/**
	 * This method decides whether to retry failed test case or not.
	 * 
	 * @param result
	 * @return boolean true → retry test false → do not retry
	 */
	@Override
	public boolean retry(ITestResult result) {

		// Check if retry count is less than limit
		if (count < limitcount) {

			count++;

			return true; // Retry test case
		}

		return false; // Stop retrying
	}

}
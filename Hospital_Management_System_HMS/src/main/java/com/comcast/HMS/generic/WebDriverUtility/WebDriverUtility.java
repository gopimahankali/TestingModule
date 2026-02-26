package com.comcast.HMS.generic.WebDriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebDriverUtility class contains reusable methods to perform common WebDriver
 * operations.
 * 
 * This class helps to avoid duplicate code and improves reusability in Selenium
 * framework.
 * 
 * It provides methods for:
 * 
 * - Browser launch - Navigation - Wait handling (Implicit and Explicit wait) -
 * Window handling - Dropdown handling - Alert handling - Scrolling - JavaScript
 * click actions - Getting page title - Closing browser
 * 
 * These methods are used across BaseTest, PageObject classes, and Test classes.
 * 
 * @author Mahan
 */
public class WebDriverUtility {

	WebDriver driver;

	/**
	 * This method is used to launch browser based on browser name.
	 * 
	 * @param browser
	 * @return WebDriver
	 */
	public WebDriver launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else {

			driver = new FirefoxDriver();
		}

		return driver;
	}

	/**
	 * This method is used to open application URL.
	 * 
	 * @param driver
	 * @param url
	 */
	public void url(WebDriver driver, String url) {

		driver.get(url);
	}

	/**
	 * This method is used to maximize browser window.
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * This method is used to apply implicit wait.
	 * 
	 * @param driver
	 * @param seconds
	 */
	public void implicitWait(WebDriver driver, int seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * This method is used to apply explicit wait for element visibility.
	 * 
	 * @param driver
	 * @param element
	 * @param seconds
	 */
	public void explicitWait(WebDriver driver, WebElement element, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method gets parent window ID.
	 * 
	 * @param driver
	 * @return String
	 */
	public String getWindow(WebDriver driver) {

		String parent = driver.getWindowHandle();

		return parent;
	}

	/**
	 * This method switches control to child window.
	 * 
	 * @param driver
	 * @param parent
	 */
	public void switchWindow(WebDriver driver, String parent) {

		Set<String> windows = driver.getWindowHandles();

		for (String child : windows) {

			if (!parent.equals(child)) {

				driver.switchTo().window(child);
			}
		}
	}

	/**
	 * This method selects value from dropdown using value attribute.
	 * 
	 * @param element
	 * @param value
	 * @param driver
	 */
	public void dropDown(WebElement element, String value, WebDriver driver) {

		Select select = new Select(element);

		select.selectByValue(value);
	}

	/**
	 * This method performs scroll using keyboard TAB action.
	 * 
	 * @param driver
	 * @param element
	 */
	public void scroll(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.TAB).build().perform();
	}

	/**
	 * This method performs scroll and click using JavaScript Executor. Used when
	 * normal click does not work.
	 * 
	 * @param driver
	 * @param element
	 */
	public void argument(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", element);

		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method waits until element is present in DOM.
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForPresence(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element.getAttribute("id"))));
	}

	/**
	 * This method checks checkbox using JavaScript.
	 * 
	 * @param driver
	 * @param element
	 */
	public void arg(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].checked = true;", element);
	}

	/**
	 * This method handles alert popup and clicks OK button.
	 * 
	 * @param driver
	 */
	public void alert(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		alert.accept();
	}

	/**
	 * This method returns page title.
	 * 
	 * @param driver
	 * @return String
	 */
	public String getTitle(WebDriver driver) {

		String Title = driver.getTitle();

		return Title;
	}

	/**
	 * This method closes browser completely.
	 * 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {

		driver.quit();
	}

}
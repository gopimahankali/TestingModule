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

public class WebDriverUtility {
	
	WebDriver driver;
	public WebDriver launchBrowser(String browser) {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else {
			driver = new FirefoxDriver();
		}	
		return driver;
	}
	
	public void url(WebDriver driver, String url) {
		driver.get(url);
	}
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	
	}
	
	public void explicitWait(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public String getWindow(WebDriver driver) {
		 String parent = driver.getWindowHandle();
		return parent;
	}

	public void switchWindow(WebDriver driver, String parent) {
		Set<String> windows = driver.getWindowHandles();
		   for(String child : windows) {
			   if(!parent.equals(child)) {
				   driver.switchTo().window(child);
			   }
		   }   
	}
	
	public void dropDown(WebElement element, String value, WebDriver driver) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void scroll(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
	}
	public void argument(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		js.executeScript("arguments[0].click();",element);
		
	}
	
	public void waitForPresence(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.id(element.getAttribute("id"))
	    ));
	}
	
	public void arg(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].checked = true;", element);
		
	}
	public void alert(WebDriver driver) {
	Alert a = driver.switchTo().alert();
	a.accept();
	
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
}

package com.examsoft.auto.ios.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsDriver;

/**
 * This class contains common methods for pages and tests
 * 
 * @author Sanjyot
 *
 */
public class CommonUtils {
	public AppiumDriver<WebElement> driver;
	public ChromeDriver webDriver;
	public WindowsDriver<WebElement> winDriver;
	protected Properties prop;

	@FindBy(name = "Hide keyboard")
	public WebElement hideKeyboard;
	
	public CommonUtils(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	public CommonUtils(WindowsDriver<WebElement> winDriver) {
		this.winDriver = winDriver;
	}
	
	public CommonUtils(ChromeDriver webDriver) {
		this.webDriver = webDriver;
	}

	/**
	 * Wait for specified millisecond
	 * 
	 * @param millis
	 */
	public void waitFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Wait for element to visible long wait
	 * 
	 * @param element
	 */
	public void waitForElementLong(WebElement element) {
		long time = 240;
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Wait for element to visible
	 * 
	 * @param element
	 */
	public void waitForElement(WebElement element) {
		long time = 60;
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Is Element displayed on screen long wait
	 * 
	 * @return
	 * 
	 */
	public boolean isElementDiplayedlongwait(WebElement element) {
		waitForElementLong(element);
		return element.isDisplayed();

	}

	/**
	 * Is Element displayed on screen
	 * 
	 * @return
	 * 
	 */
	public boolean isElementDiplayed(WebElement element) {
		waitForElement(element);
		return element.isDisplayed();

	}

	/**
	 * Wait for element to visible for specified millisecond
	 * 
	 * @param element
	 * @param seconds
	 */
	public void waitForElement(WebElement element, long seconds) {
		List<WebElement> elements = new ArrayList<WebElement>();
		elements.add(element);
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * Wait for element to visible for specified millisecond
	 * 
	 * @param element
	 * @param seconds
	 */
	public void waitForElements(List<WebElement> elements, long seconds) {
		List<WebElement> elements1 = new ArrayList<WebElement>();
		elements1.addAll(elements);
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements1));
	}

	/**
	 * Wait for element to hide in specified millisecond
	 * 
	 * @param element
	 * @param seconds
	 */
	public void waitForElementHide(WebElement element, long seconds) {
		List<WebElement> elements = new ArrayList<WebElement>();
		elements.add(element);
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	/**
	 * hide keyboard
	 * 
	 */
	public void hideKeyboard() {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(hideKeyboard));
		hideKeyboard.click();
	}

	/**
	 * Loading properties form property file and setting it to prop variable.
	 * 
	 * @return
	 */
	public Properties loadProperties() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
			// Loading property file
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}

package com.examsoft.auto.ios.core.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.examsoft.auto.ios.utils.CommonUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.windows.WindowsDriver;

/**
 * This class is Base for All Pages. Have initiate Element required for
 * execution Page Object.
 * 
 * @author synerzip
 *
 */
public class PageBase extends Assert {
	protected AppiumDriver<WebElement> driver;
	protected static WindowsDriver<WebElement> winDriver;
	protected static ChromeDriver webDriver;

	protected Properties prop;
	protected CommonUtils common;

	@FindBy(name = "Hide keyboard")
	public WebElement hideKeyboard;

	/**
	 * This Constructor init the Page Object Element through Page Factory.
	 * 
	 * @param driver
	 */
	public PageBase(AppiumDriver<WebElement> driver) {
			common = new CommonUtils(driver);
			prop = common.loadProperties();
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	public PageBase(WindowsDriver<WebElement> winDriver) {
		common = new CommonUtils(winDriver);
		prop = common.loadProperties();
		this.winDriver = winDriver;
		PageFactory.initElements(winDriver, this);
	}
	
	public PageBase(ChromeDriver webDriver) {
		common = new CommonUtils(webDriver);
		prop = common.loadProperties();
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void hideKeyboard() {
		common.waitForElement(hideKeyboard);
		hideKeyboard.click();
	}

	public TouchAction touchActionNew(int startx, int starty, int endX, int endY) {
		return new IOSTouchAction(driver).press(startx, starty).waitAction(4000).moveTo(endX, endY).release().perform();
	}

}

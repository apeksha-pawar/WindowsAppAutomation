package com.examsoft.auto.ios.core.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.examsoft.auto.ios.utils.AppConstants;
import com.examsoft.auto.ios.utils.CommonUtils;
import com.examsoft.auto.ios.utils.TestUtils;
import com.google.gson.Gson;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.windows.WindowsDriver;

/**
 * This class is Base for All Tests. Have initiate Driver required for
 * execution.
 * 
 * @author Synerzip
 *
 */
public class BaseTest extends Assert {
	TestUtils testUtils;
	protected CommonUtils common;
	protected static AppiumDriver<WebElement> driver = null;
	protected static WindowsDriver<WebElement> winDriver = null;
	protected static ChromeDriver webDriver = null;
	public static Properties prop;
	DesiredCapabilities capabilities_device = new DesiredCapabilities();
	DesiredCapabilities winCapabilities = new DesiredCapabilities();

	@BeforeSuite
	public void setUp() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
		String platform = prop.getProperty("PLATFORM");
		testUtils = new TestUtils(driver);
		testUtils = new TestUtils(winDriver);
		common = new CommonUtils(driver);
		common = new CommonUtils(winDriver);
		prop = common.loadProperties();
		initDriver(platform);
	}

	@AfterSuite
	public void tearDown() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
		String platform = prop.getProperty("PLATFORM");
		if (platform.equals("WINDOWS")) {
			winDriver.quit();
		} else if (platform.equals("WEB")) {
			webDriver.close();
		} else
			driver.quit();
	}

	/**
	 * This method launch New Driver instance in driver is quit or close.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void launchNewDriver(String platform) throws FileNotFoundException, IOException {
		if (platform.equals("IOS")) {
			if (hasQuit(driver, webDriver, winDriver)) {
				initDriver(platform);
			} else {
				driver.quit();
				initDriver(platform);
			} 
		}
		if (platform.equals("WINDOWS")) {
			if (hasQuit(driver, webDriver, winDriver)) {
				initDriver(platform);
			} else {
				driver.quit();
				initDriver(platform);
			}
		}
		if (platform.equals("WEB")) {
			if (hasQuit(driver, webDriver, winDriver)) {
				initDriver(platform);
			} else {
				webDriver.quit();
				initDriver(platform);
			}
		}

	}

	/**
	 * This method initialize driver(windows + IOS) with setting required
	 * capabilities
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void initDriver(String platform) throws FileNotFoundException, IOException {
		if (platform.equals("IOS")) {
			Properties prop = new Properties();
			prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
			capabilities_device = setDesiredCapabilities();
			Gson g = new Gson();
			String str = g.toJson(capabilities_device);
			System.out.print(str);
			try {
				driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities_device);
				Thread.sleep(6000);

			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (platform.equals("WINDOWS")) {
			Properties prop = new Properties();
			prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
			winCapabilities = setWinDesiredCapabilities();
			Gson g = new Gson();
			String str = g.toJson(winCapabilities);
			System.out.println(str);
			winDriver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723/"), winCapabilities);
			winDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		}
		if(platform.equals("WEB")) {
			webDriver = new ChromeDriver();
		}
	}

	/**
	 * Check whether driver instance is present or not.
	 * 
	 * @param driver
	 * @return boolean
	 */
	public static boolean hasQuit(AppiumDriver<WebElement> driver, ChromeDriver webDriver, WindowsDriver<WebElement> winDriver) {
		try {
			driver.getTitle();
			winDriver.getTitle();
			return false;
		} catch (Throwable e) {
			return true;
		}
	}

	/**
	 * Setting up the desired property for the driver instance. The method took the
	 * device and install-able information form property file.
	 * 
	 * @return Capabilities
	 */
	public DesiredCapabilities setDesiredCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("usePrebuiltWDA", true);
		capabilities.setCapability("clearSystemFiles", true);
		capabilities.setCapability("xcodeOrgId", "5P9D4ESR3W");
		capabilities.setCapability("xcodeSigningId", "iPhone Developer");

		@SuppressWarnings("unused")
		String Device;
		switch (Device = testUtils.selectDevice) {
		case "iOS11iPadAirDevice":
			capabilities.setCapability("deviceName", "iPad air");
			capabilities.setCapability("platformVersion", "11.4");
			capabilities.setCapability("udid", "baf9f892931888b3a66e70511bc4d2d213afce46");
			capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ExamSoft.ipa");
			break;
		case "iOS10.2iPadPro":
			capabilities.setCapability("deviceName", "iPad pro");
			capabilities.setCapability("platformVersion", "10.2");
			capabilities.setCapability("udid", "8816152D-E75D-40E0-B35A-4CB3E9380EDE");
			// Simulator iMAC
			capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ExamSoft.ipa");
			break;
		case "iOS10.2iPadProDevice":
			capabilities.setCapability("deviceName", "iPad Pro");
			capabilities.setCapability("platformVersion", "10.2");
			capabilities.setCapability("udid", "c5f3733be0451aac3198692efaa06635836217d2");
			// ipad Pro UDID
			capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ExamSoft.ipa");
			break;
		case "iOS10.1iPad4Device":
			capabilities.setCapability("deviceName", "iPad 4");
			capabilities.setCapability("platformVersion", "10.1");
			capabilities.setCapability("udid", "4d0470ce0314108b26dea05050d2f4788b05465e");
			// ipad 4 UDID
			capabilities.setCapability("app",
					System.getProperty("user.dir") + "/src/main/resources/ExamSoft_220001.ipa");
			break;
		case "iOS9.3iPad4Device":
			capabilities.setCapability("deviceName", "iPad 4");
			capabilities.setCapability("platformVersion", "9.3");
			capabilities.setCapability("udid", "a2e4ed7cbf9e5ef704d25468eebccc561ee2bcb8");
			// ipad 4 UDID
			capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ExamSoft.ipa");
			break;
		case "iOS10.2iPadAirSImulator":
			capabilities.setCapability("deviceName", "iPad Air");
			capabilities.setCapability("platformVersion", "10.2");
			capabilities.setCapability("udid", "1B998496-C89C-4A4E-993D-27815373A7F7");
			// Simulator iMAC
			capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ExamSoft.app");
			break;

		case "iOS11.4iPadProSImulator":
			capabilities.setCapability("deviceName", "iPad Pro");
			capabilities.setCapability("platformVersion", "11.4 ");
			capabilities.setCapability("udid", "D1D99ADE-A8B0-41C5-849C-6E036B5D6C1A");
			// Simulator iMAC
			capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ExamSoft.app");
			break;

		case "iOS11.4iPadAirSImulator":
			capabilities.setCapability("deviceName", "iPad Air");
			capabilities.setCapability("platformVersion", "11.4");
			capabilities.setCapability("udid", "F3D1EFA6-28B4-42B0-B92C-C3F8352EBCB9");
			// Simulator iMAC
			capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ExamSoft.app");
			break;
		}
		capabilities.setCapability("autoAcceptAlerts", false);
		capabilities.setCapability("noReset", true);
		return capabilities;
	}

	public DesiredCapabilities setWinDesiredCapabilities() throws FileNotFoundException, IOException {
		DesiredCapabilities winCapabilities = new DesiredCapabilities();
		winCapabilities.setCapability("app", TestUtils.winAppLocation);
		winCapabilities.setCapability("deviceName", TestUtils.winDeviceName);
		return winCapabilities;
	}
}
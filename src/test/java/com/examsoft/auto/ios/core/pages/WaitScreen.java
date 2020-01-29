package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for WaitScreen before exam
 * 
 * @author Sanjyot
 *
 */
public class WaitScreen extends PageBase {

	@FindBy(name = "Do Not Start Until Instructed")
	public WebElement pleaseStopText;

	@FindBy(className = "XCUIElementTypeSwitch")
	public WebElement switchButton;

	@FindBy(id = "WaitScreenVC_startExam_btn")
	public WebElement startEaxmButton;

	String enterCodeMessageText;
	InExam inExam;

	public WaitScreen(AppiumDriver<WebElement> driver) {
		super(driver);
		inExam = new InExam(driver);
	}

	/**
	 * This method start exam after entering valid code on wait screen
	 */
	public void waitScreenBeforeExam() {
		common.waitForElement(startEaxmButton);
		startEaxmButton.click();
		common.waitForElement(pleaseStopText);
		common.waitForElement(switchButton);
		switchButton.click();
		common.waitForElement(startEaxmButton);
		startEaxmButton.click();
		common.waitFor(1000);
	}
}
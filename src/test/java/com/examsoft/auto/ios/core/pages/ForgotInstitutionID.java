package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Forgot Institution ID and Forgot ET details
 * 
 * @author Sanjyot
 *
 */
public class ForgotInstitutionID extends PageBase {

	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"Examplify\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
	public WebElement emailTxtField;

	@FindBy(name = "Send")
	public WebElement sendEmailButton;

	@FindBy(name = "The Login IDs and passwords have been emailed and should be received within a few minutes.")
	public WebElement successEmailMessage;

	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	public WebElement doneButtonOnForgotDetails;

	@FindBy(id = "Email Address:")
	public WebElement EmailText;

	public ForgotInstitutionID(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is sending email for forgotten ID/Login Details
	 */
	public void sendForgotInstitutionIDRequest(String email) {
		common.isElementDiplayed(EmailText);
		emailTxtField.click();
		emailTxtField.sendKeys(email);
		sendEmailButton.click();
		common.isElementDiplayed(successEmailMessage);
	}
}
package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for login of ET
 * 
 * @author Sanjyot
 *
 */
public class Login extends PageBase {

	@FindBy(name = "Sign In")
	public WebElement loginPageText;

	@FindBy(id = "LoginVC_userID_txtFld")
	public WebElement userNameTextField;

	@FindBy(id = "LoginVC_password_txtFld")
	public WebElement passwordTextField;

	@FindBy(name = "OK")
	public WebElement wrongPasswordAlertOk;

	@FindBy(id = "LoginVC_forgotUserID_btn")
	public WebElement forgotLoginDetails;

	@FindBy(id = "LoginVC_signIn_btn")
	public WebElement signInButton;

	@FindBy(id = "LoginVC_back_btn")
	public WebElement backButton;

	@FindBy(id = "LoginVC_forgotUserID_btn")
	public WebElement forgotUserID;

	@FindBy(name = "We were unable to validate your username and password. Please check your credentials and try again.")
	public WebElement wrongPasswordErrorMessage;

	@FindBy(name = "The exam taker has not yet agreed to the institution’s disclaimer.")
	public WebElement disclaimerErrorMessage;

	@FindBy(name = "Invalid institution provided.")
	public WebElement invalidInstitutionErrorMessage;

	@FindBy(name = "OK")
	public WebElement alertOKButton;

	String us = null;
	String psw = null;

	HomeMenu homeMenu;

	public Login(AppiumDriver<WebElement> driver) {
		super(driver);
		homeMenu = new HomeMenu(driver);
	}

	/**
	 * This method is for login ET with given parameter
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		common.isElementDiplayed(userNameTextField);
		userNameTextField.clear();
		userNameTextField.sendKeys(username);
		common.isElementDiplayed(passwordTextField);
		passwordTextField.click();
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		passwordTextField.sendKeys(Keys.RETURN);
	}

	public void invalidLogin(String username, String password) {
		common.isElementDiplayed(userNameTextField);
		userNameTextField.clear();
		userNameTextField.sendKeys(username);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		hideKeyboard();
		signInButton.click();
		common.isElementDiplayed(alertOKButton);
	}

	/**
	 * This method is for add userName in userName Textfield
	 * 
	 * @param username
	 */
	public void enterUserName(String username) {
		common.isElementDiplayed(userNameTextField);
		userNameTextField.clear();
		userNameTextField.sendKeys(username);
	}

	/**
	 * This method is for login with Pre-filled username
	 * 
	 * @param password
	 */
	public void enterPasswordAndSubmit(String password) {
		common.isElementDiplayed(userNameTextField);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		passwordTextField.sendKeys(Keys.RETURN);
	}

	/**
	 * This method is to verify error for Incorrect Institution
	 * 
	 */
	public void invalidInstitutionMessage() {
		common.isElementDiplayed(alertOKButton);
		alertOKButton.click();
	}

	/**
	 * This method is to verify error when ET have not accepted disclaimer
	 * 
	 */
	public void disclaimerMessage() {
		common.isElementDiplayed(alertOKButton);
		alertOKButton.click();
	}

	/**
	 * This method is to verify error for Incorrect password
	 * 
	 */
	public void wrongPasswordMessage() {
		common.isElementDiplayed(alertOKButton);
		alertOKButton.click();
	}

	/**
	 * This method is to click on Forget Login details link
	 * 
	 */
	public void clickForgotLoginDetails() {
		common.isElementDiplayed(forgotLoginDetails);
		forgotLoginDetails.click();
		common.waitFor(5000);
	}

	/**
	 * This method is to click on Forget UserID link
	 * 
	 */
	public void clickForgotUserID() {
		forgotUserID.click();
	}

	public void clickBackButton() {
		backButton.click();
	}
}
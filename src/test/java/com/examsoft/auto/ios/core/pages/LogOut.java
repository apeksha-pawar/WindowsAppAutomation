package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Logout option under Home menu
 * 
 * @author Sanjyot
 *
 */
public class LogOut extends PageBase {

	@FindBy(id = "alert_cancel_btn")
	public WebElement cancelButton;

	@FindBy(id = "alert_action_btn")
	public WebElement logoutButton;

	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;

	public LogOut(AppiumDriver<WebElement> driver) {
		super(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		homeMenu = new HomeMenu(driver);
	}

	/**
	 * This method is to logged out of current account
	 * 
	 */
	public void logout() {
		common.isElementDiplayed(logoutButton);
		logoutButton.click();
		common.waitForElement(chooseAnAccount.chooseAnAccountText);
	}

	/**
	 * This method is to cancel logout of current account
	 * 
	 */
	public void cancelLogout() {
		common.isElementDiplayed(cancelButton);
		cancelButton.click();
	}

}

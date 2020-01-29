package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This page is for EULA Cases: accept and cancel EULA
 * 
 * @author synerzip
 *
 */
public class EULA extends PageBase {

	@FindBy(id = "EULA_cancel_btn")
	public WebElement cancelEULAButton;

	@FindBy(name = "EULA_iAgree_btn")
	public WebElement agreeEULAButton;

	@FindBy(name = "Software License Agreement")
	public WebElement eulaTitle;

	@FindBy(id = "EULA_close_btn")
	public WebElement closeEULAButton;

	@FindBy(id = "PROPRIETARY RIGHTS")
	public WebElement elementOnEULA;

	public EULA(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is for cancel EULA before registering ET
	 */
	public void cancelEula() {
		common.isElementDiplayed(cancelEULAButton);
		cancelEULAButton.click();
	}

	/**
	 * This method is for accept EULA before registering ET
	 */
	public void acceptEula() {
		common.isElementDiplayedlongwait(agreeEULAButton);
		swipeEulaTillEnd();
		common.isElementDiplayed(agreeEULAButton);
		agreeEULAButton.click();
		common.waitFor(2000);
	}

	/**
	 * This method is to read EULA on ET home screen
	 */
	public void closeEula() {
		common.isElementDiplayed(closeEULAButton);
		swipeEulaOnce();
		closeEULAButton.click();
		common.waitForElementHide(eulaTitle, 10);
	}

	/**
	 * This method is for scroll EULA till the end
	 */
	public void swipeEulaTillEnd() {
		int startx = elementOnEULA.getLocation().x;
		int starty = elementOnEULA.getLocation().y;
		while (!agreeEULAButton.isEnabled()) {
			driver.performTouchAction(touchActionNew(startx, starty, -419, -3900));
		}
	}

	public void swipeEulaOnce() {
		int startx = elementOnEULA.getLocation().x;
		int starty = elementOnEULA.getLocation().y;
		driver.performTouchAction(touchActionNew(startx, starty, -419, -3900));
	}

}
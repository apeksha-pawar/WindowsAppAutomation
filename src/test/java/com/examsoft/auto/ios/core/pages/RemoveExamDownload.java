package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Removing downloaded exam
 * 
 * @author Sanjyot
 *
 */
public class RemoveExamDownload extends PageBase {

	@FindBy(id = "alert_switch_btn")
	WebElement acceptSwitch;

	@FindBy(id = "alert_action_btn")
	WebElement RemoveButton;

	@FindBy(id = "alert_cancel_btn")
	WebElement CancelButton;

	public RemoveExamDownload(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is to accept alert to remove exam
	 */
	public void acceptRemoveDownload() {

		common.isElementDiplayed(acceptSwitch);
		acceptSwitch.click();

	}

	public void clickRemoveDownload() {
		common.isElementDiplayed(RemoveButton);
		RemoveButton.click();
	}

	/**
	 * This method is to reject alert to remove exam
	 */
	public void cancelRemoveDownload() {
		common.isElementDiplayed(CancelButton);
		CancelButton.click();

	}

}

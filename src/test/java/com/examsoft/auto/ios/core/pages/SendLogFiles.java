package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Send Log Files functionality under Home Menu
 * 
 * @author Sanjyot
 *
 */
public class SendLogFiles extends PageBase {

	@FindBy(name = "Send Log Files. For review by support team.")
	public WebElement screenTitle;

	@FindBy(id = "SendLogFileVC_send_btn")
	public WebElement sendButton;

	@FindBy(id = "SendLogFileVC_cancel_btn")
	public WebElement cancelButton;

	@FindBy(name = "Progress") // check for value
	public WebElement progressBar;

	@FindBy(name = "Your log files were successfully sent.")
	public WebElement sucessMessage;

	public SendLogFiles(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is to cancel sending of log files on Send log files screen
	 */
	public void cancelSendlogFiles() {
		common.waitFor(5000);
		common.isElementDiplayed(cancelButton);
		cancelButton.click();

	}

	/**
	 * This method is to sending of log files on Send log files screen
	 */
	public void sendLog() {
		common.waitFor(5000);
		common.isElementDiplayed(sendButton);
		sendButton.click();
		common.isElementDiplayed(sucessMessage);
		sendButton.click();

	}

}

package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Notice Screen which appears before exam and can also
 * access during that exam
 * 
 * @author Sanjyot
 *
 */
public class NoticeScreen extends PageBase {

	@FindBy(xpath = "//*[contains(@name, '1 of ')]")
	public WebElement noticeScreenText;

	@FindBy(id = "NoticesVC_nextNotice_btn")
	public WebElement forwardArrow;

	@FindBy(id = "NoticesVC_previousNotice_btn")
	public WebElement backwardArrow;

	@FindBy(id = "NoticesVC_next_btn")
	public WebElement nextButton;

	public NoticeScreen(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is to check number of notice pages
	 * 
	 * @return
	 */
	public int getNoticePages() {
		common.waitFor(5000);
		String noticeText = noticeScreenText.getText();
		String[] parts = noticeText.split("1 of ");
		int pages = Integer.parseInt(parts[1]);
		return pages;
	}

	/**
	 * This method is to navigate till the last page of Notices
	 */
	public void moveAheadToEndNoticePage() {
		int pages = getNoticePages();
		for (int i = 1; i < pages; i++) {
			forwardArrow.click();
		}
	}

	/**
	 * This method is proceeds further in exam from notice screen
	 */
	public void clickNextButton() {
		common.waitForElement(nextButton, 60);
		nextButton.click();

	}
}
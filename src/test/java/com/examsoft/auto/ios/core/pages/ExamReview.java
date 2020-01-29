package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

public class ExamReview extends PageBase {

	@FindBy(id = "ExamReviewPwdVC_password_txtFd")
	public WebElement reviewPwdTxtField;

	@FindBy(id = "ExamReviewPwdVC_submit_btn")
	public WebElement startReviewButton;

	@FindBy(id = "ExamReviewPwdVC_cancel_btn")
	public WebElement cancelReviewButton;

	@FindBy(id = "ExamReviewPwdVC_exit_btn")
	public WebElement exitReviewButton;

	@FindBy(id = "ReviewNotPermittedVC_ok_btn")
	public WebElement ReviewNotPermittedOkBtn;

	@FindBy(xpath = "//*[contains(@name, 'correctly answered')] ")
	public WebElement reviewQueTitle;

	@FindBy(xpath = "//*[contains(@name, 'not answered')] ")
	public WebElement reviewQueTitleNotAns;

	@FindBy(id = "ExamControls_btn")
	public WebElement reviewMenuDropdown;

	@FindBy(id = "Exit Review")
	public WebElement submitReviewButton;

	public ExamReview(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	public void enteringInReview(String password) {
		common.isElementDiplayed(reviewPwdTxtField);
		reviewPwdTxtField.sendKeys(password);
		reviewPwdTxtField.sendKeys(Keys.RETURN);
		common.waitFor(3000);
	}

	public void cancelReview() {
		common.waitFor(100);
		common.isElementDiplayed(cancelReviewButton);
		cancelReviewButton.click();
	}

	public void exitReview() {
		common.isElementDiplayed(exitReviewButton);
		exitReviewButton.click();
	}

	public void closeIfNothingToReview() {
		common.isElementDiplayed(ReviewNotPermittedOkBtn);
		ReviewNotPermittedOkBtn.click();
	}

	public boolean incorrectlyAnsQue() {
		return reviewQueTitle.getText().contains("incorrectly answered");
	}

	public boolean correctlyAnsweredQue() {
		return reviewQueTitle.getText().contains("correctly answered");
	}

	public boolean notAnsQue() {
		return reviewQueTitleNotAns.getText().contains("not answered");
	}

	public void submitReview() {
		common.isElementDiplayed(reviewMenuDropdown);
		reviewMenuDropdown.click();
		common.isElementDiplayed(submitReviewButton);
		submitReviewButton.click();
	}

}

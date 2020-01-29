package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

public class CloseExam extends PageBase {

	@FindBy(id = "ConfirmExitExamVC_readyToExit_sw")
	public WebElement swichOnExitExam;

	@FindBy(id = "ConfirmExitExamVC_exit_btn")
	public WebElement exitExamButton;

	@FindBy(id = "ConfirmExitExamVC_returnToExam_btn")
	public WebElement returnToExamButton;

	@FindBy(id = "ScoringVC_continueToReview_btn")
	public WebElement UploadOnScoringButton;

	public CloseExam(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	public void ConfirmExitExam() {
		common.isElementDiplayed(swichOnExitExam);
		swichOnExitExam.click();
		exitExamButton.click();
	}

	public void ReturnToExam() {
		common.isElementDiplayed(swichOnExitExam);
		returnToExamButton.click();

	}

	public void VerifyUploadExamOnScoring() {
		common.isElementDiplayed(UploadOnScoringButton);
		UploadOnScoringButton.click();
	}

}

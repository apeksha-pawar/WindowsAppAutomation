package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is for Uploading Exams. Contains different cases of Upload
 * 
 * @author Sanjyot
 *
 */
public class UploadExam extends PageBase {

	@FindBy(id = "ConfirmExitExamVC_readyToExit_sw")
	public WebElement swichOnExitExam;

	@FindBy(id = "ConfirmExitExamVC_exit_btn")
	public WebElement exitExamButton;

	@FindBy(id = "ConfirmExitExamVC_returnToExam_btn")
	public WebElement returnToExamButton;

	@FindBy(id = "ScoringVC_continueToUpload_btn")
	public WebElement UploadOnScoringButton;

	public UploadExam(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method clicks on Upload exam with switching toggle button
	 */
	public void confirmExitExam() {
		common.isElementDiplayed(swichOnExitExam);
		swichOnExitExam.click();
		exitExamButton.click();
		common.waitFor(1000);
	}

	/**
	 * This method returns in exam without confirming upload exam
	 */
	public void returnToExam() {
		common.isElementDiplayed(swichOnExitExam);
		returnToExamButton.click();
		common.waitFor(1000);
	}

	/**
	 * This method click on Upload exam on scoring screen
	 */
	public void uploadExamOnScoring() {
		confirmExitExam();
		common.isElementDiplayed(UploadOnScoringButton);
		UploadOnScoringButton.click();
	}

}

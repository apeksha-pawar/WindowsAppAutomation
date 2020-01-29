package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This Class is for Successfully Uploaded Exam page.
 * 
 * @author Sanjyot
 *
 */
public class ExamUploadSuccessfull extends PageBase {

	@FindBy(id = "UploadSuccessVC_closeExam_btn")
	public WebElement closeExamButtonOnUploadedScreen;

	public ExamUploadSuccessfull(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is for successfully Uploaded exam
	 */
	public void closeUploadedExam() {
		common.isElementDiplayed(closeExamButtonOnUploadedScreen);
		closeExamButtonOnUploadedScreen.click();
		common.waitFor(3000);

	}

}

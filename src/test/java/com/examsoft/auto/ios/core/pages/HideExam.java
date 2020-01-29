package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Hide Exam ET can use this functionality during the
 * exam
 * 
 * @author Sanjyot
 *
 */
public class HideExam extends PageBase {
	public HideExam(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	@FindBy(id = "HideExamVC_resume_btn")
	public WebElement resumeExamButton;

	/**
	 * This method is for Resuming and continuing the exam
	 */
	public void ResumeExam() {
		common.waitForElement(resumeExamButton, 60);
		resumeExamButton.click();
	}

}

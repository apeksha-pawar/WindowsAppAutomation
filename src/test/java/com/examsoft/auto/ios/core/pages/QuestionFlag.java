package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Question flag during the exam
 * 
 * @author Sanjyot
 *
 */
public class QuestionFlag extends PageBase {

	@FindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
	public WebElement questionText;

	@FindBy(id = "ExamQuesAnswerVC_quesFlag_btn")
	public WebElement flagButton;

	@FindBy(xpath = "//*[contains(@label, 'flagged')]")
	public WebElement flaggedQue;

	@FindBy(xpath = "//*[contains(@label, 'un flagged')]")
	public WebElement unflaggedQue;

	public QuestionFlag(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is to flag the question
	 */
	public void flagQuestion() {
		common.isElementDiplayed(flagButton);
		flagButton.click();
		common.isElementDiplayed(flaggedQue);
	}

	/**
	 * * This method is to unflag the flagged question
	 */
	public void unflagQuestion() {
		common.isElementDiplayed(flaggedQue);
		flagButton.click();
		common.isElementDiplayed(unflaggedQue);
	}

}

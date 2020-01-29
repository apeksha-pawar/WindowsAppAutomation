package com.examsoft.auto.ios.core.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

/**
 * This Class is a page of Exam Home Screen. It contains Exam controls, Exam
 * Tool bar,.. etc.
 * 
 * @author Sanjyot
 *
 */
public class ExamHomeScreen extends PageBase {

	@FindBy(id = "ExamControls_btn")
	public WebElement examMenuDropdown;

	@FindBy(id = "Submit Exam")
	public WebElement submitButton;

	@FindBy(name = "Exam Incomplete")
	public WebElement missingAnswerReminderAlert;

	@FindBy(id = "Return")
	public WebElement returnToExamByAlert;

	@FindBy(id = "Close")
	public WebElement closeExamByAlert;

	@FindBy(id = "Hide Exam")
	public WebElement hideExamButton;

	@FindBy(id = "RightSidePanelVC_close_btn")
	public WebElement rightSidePanelCloseButton;

	@FindBy(id = "Attachment pop out icon")
	public WebElement questionAttachmentPopOut;

	@FindBy(id = "ExamExecutionVC_submitExit_btn")
	public WebElement submitAndExitButton;

	@FindBy(xpath = "//*[contains(@name, 'Attachments, count = ')] ")
	public WebElement examAttachmentButton;

	@FindBy(id = "AttachmentVC_full_btn")
	public WebElement examAttachmentFullScreentButton;

	@FindBy(id = "AttachmentVC_close_btn")
	public WebElement closeExamAttachmentButton;

	@FindBy(id = "LeftSidePanelVC_filterQues_btn")
	public WebElement filterIconButton;

	@FindBy(id = "FilterQuestionV_cell_0")
	public WebElement filterAllQuestion;

	@FindBy(id = "FilterQuestionV_cell_1")
	public WebElement filterAnsweredQuestion;

	@FindBy(id = "FilterQuestionV_cell_2")
	public WebElement filterUnansweredQuestion;

	@FindBy(id = "FilterQuestionV_cell_3")
	public WebElement filterFlaggedQuestion;

	@FindBy(id = "choice_cancel_btn")
	public WebElement returnToExam;

	@FindAll({
			@FindBy(xpath = "//XCUIElementTypeOther[@name=\"Lft_side_que_num_panel\"]/XCUIElementTypeTable/XCUIElementTypeCell") })
	public List<WebElement> leftsideTable;

	HideExam hideExam;

	public ExamHomeScreen(AppiumDriver<WebElement> driver) {
		super(driver);
		hideExam = new HideExam(driver);
	}

	/**
	 * This method is for submit exam under exam controls
	 */
	public void SubmitExamwithAlert() {
		common.waitForElement(examMenuDropdown, 60);
		examMenuDropdown.click();
		common.waitForElement(submitButton, 60);
		submitButton.click();
		common.waitForElement(closeExamByAlert, 60);
		closeExamByAlert.click();
	}

	/**
	 * This method is for Return exam with exam incomplete alert
	 */
	public void returnExamwithAlert() {
		common.waitForElement(examMenuDropdown, 60);
		examMenuDropdown.click();
		common.waitForElement(submitButton, 60);
		submitButton.click();
		common.waitForElement(returnToExamByAlert, 60);
		returnToExamByAlert.click();
		common.waitForElement(examMenuDropdown);
	}

	/**
	 * This method is for submit exam under exam controls
	 */
	public void SubmitExam() {
		common.waitForElement(examMenuDropdown, 60);
		examMenuDropdown.click();
		common.waitForElement(submitButton, 60);
		submitButton.click();
	}

	/**
	 * This method is for Hide Exam under exam controls
	 */
	public void HideExam() {
		common.waitForElement(examMenuDropdown);
		examMenuDropdown.click();
		common.waitForElement(hideExamButton, 60);
		hideExamButton.click();
	}

	public void examAttachmentDisplayed() {
		common.waitForElement(examMenuDropdown);
		examMenuDropdown.click();
		examAttachmentButton.click();
	}

	public void CloseExamAttachment() {
		closeExamAttachmentButton.click();
		common.waitForElement(examMenuDropdown);
	}

	public void FullScreenExamAttach() {
		common.isElementDiplayed(examAttachmentFullScreentButton);
		examAttachmentFullScreentButton.click();
		common.isElementDiplayed(closeExamAttachmentButton);
	}

	public void selectFilter() {
		common.waitForElement(filterIconButton);
		filterIconButton.click();
	}

	public void tryToSubmitExam() {
		try {
			SubmitExam();
		} catch (Exception e) {
		}
		touchAction(272, 213);

	}

	public void touchAction(int toX, int toY) {
		TouchAction action = new TouchAction(driver);
		int X = toX;
		int Y = toY;
		action.press(X, Y).release().perform();
	}
}

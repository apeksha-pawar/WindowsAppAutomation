package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.TestUtils;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Notes functionality during the exam
 * 
 * @author Sanjyot
 *
 */

public class NotesInExam extends PageBase {
	TestUtils testUtils;

	@FindBy(id = "RightSidePanelVC_notes_btn")
	public WebElement notesButtonFromPanel; // select Notes when right hand side
											// panel is open

	@FindBy(id = "Notes")
	public WebElement notesButtonInExam; // select notes field in the exam

	@FindBy(id = "Notes_requestFeedback_sw")
	public WebElement requestFeedbackButton; // turn ON/OFF feedback Button

	@FindBy(id = "NotesVC_txtFld")
	public WebElement notesTextField; // Notes text field

	@FindBy(name = "Hide keyboard")
	public WebElement hideKeyboard; // hide keyboard

	@FindBy(id = "Notes_requestFeedback_sw")
	public WebElement requestFbButton; // Request feedback

	@FindBy(id = "RightSidePanelVC_close_btn")
	public WebElement closeRightSidePanel;

	public int numInt;

	public NotesInExam(AppiumDriver<WebElement> driver) {
		super(driver);

		testUtils = new TestUtils(driver);
	}

	/**
	 * This method is to add maximum characters in the notes text field
	 * 
	 * @throws InterruptedException
	 */
	public void NotesMaxLimit() {
		common.isElementDiplayed(notesButtonInExam);
		notesButtonInExam.click();
		notesTextField.click();
		notesTextField.clear();
		notesTextField.sendKeys(TestUtils.notesMaxCharacters);
		common.waitFor(100);
		String num = notesTextField.getText();
		numInt = num.length();
	}

	/**
	 * This method is to write small string in notes section
	 */
	public void NotesCheck() {
		notesButtonInExam.click();
		notesTextField.click();
		notesTextField.sendKeys(TestUtils.notesStringA);
		String num = notesTextField.getText();
		numInt = num.length();
	}

	public void closeNotesPanel() {
		closeRightSidePanel.click();
		common.waitFor(4000);
	}
}
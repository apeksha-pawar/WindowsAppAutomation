package com.examsoft.auto.ios.core.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.TestUtils;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for general cases during the exam. like navigation and
 * answering questions.
 * 
 * @author Sanjyot
 *
 */
public class InExam extends PageBase {

	@FindBy(id = "ExamExecutionVC_nextQues_view")
	public WebElement nextQuestionButton;

	@FindBy(id = "ExamExecutionVC_previousQues_view")
	public WebElement previousQuestionButton;

	@FindAll({ @FindBy(xpath = "//*[contains(@name, 'Question')] ") })
	public List<WebElement> questionTitle;

	@FindBy(id = "question_text")
	public WebElement queText;

	@FindAll({
			@FindBy(xpath = "//XCUIElementTypeOther[@name=\"Lft_side_que_num_panel\"]/XCUIElementTypeTable/XCUIElementTypeCell") })
	public List<WebElement> leftSidePanel;

	@FindBy(id = "Tools")
	public WebElement toolsButton;

	@FindBy(name = "Please enter an answer")
	public WebElement requireAnswerText;

	@FindBy(name = "OK")
	public WebElement okButtonOnRequireAnswer;

	@FindBy(id = "Close")
	public WebElement closeButtonNotice;

	@FindBy(id = "Toolkit_btn")
	public WebElement toolKit;

	@FindBy(id = "7")
	public WebElement queSeven;

	@FindBy(id = "6")
	public WebElement queSix;

	@FindBy(id = "8")
	public WebElement queEight;

	@FindBy(id = "1")
	public WebElement queOne;

	@FindBy(id = "Calculator")
	public WebElement calculatorBtnOnPanel;

	public String questionText1;
	public String question;
	public int numOfQuestions;
	public int currentQue;
	public int a = 1;
	public String[] arr;
	public String[] arr1;
	public String typeOfQuestion;
	int number;
	int numberOfQuestions;
	public String examQuestionType;

	TestUtils testUtils;
	McqType mcqType;
	NotesInExam notesInExam;
	TrueFalseType trueFalseType;
	FiTBType fiTBType;
	EssayType essayType;
	ExamHomeScreen examHomeScreen;
	int answereEssayQuestion = 1;

	public InExam(AppiumDriver<WebElement> driver) {
		super(driver);

		testUtils = new TestUtils(driver);
		mcqType = new McqType(driver);
		trueFalseType = new TrueFalseType(driver);
		fiTBType = new FiTBType(driver);
		essayType = new EssayType(driver);
		notesInExam = new NotesInExam(driver);
		examHomeScreen = new ExamHomeScreen(driver);
	}

	/**
	 * This method is for answering questions during the exam
	 */
	public void AnsweringQuestions() {
		int size = questionTitle.size();
		System.out.println(size);
		questionText1 = questionTitle.get(1).getText();
		arr = questionText1.split("\\W+");
		numOfQuestions = Integer.parseInt(arr[3]);
	}

	/**
	 * This method is to check current question number
	 */
	public int CurrentQuestion() {
		questionText1 = questionTitle.get(1).getText();
		arr1 = questionText1.split("\\W+");
		currentQue = Integer.parseInt(arr1[1]);
		return currentQue;
	}

	/**
	 * Navigate and answer All Four types of questions
	 */

	public void navigateQuestionAndAnswerForAllFourTypes() {

		knowQuestionType();
		String[] array = typeOfQuestion.split("\\W+");

		for (int k = 0; k < array.length; k++) {
			if (array[k].matches(TestUtils.mcq)) {
				mcqType.numberOfChoices();// no verification option
				break;
			}

			else if (array[k].matches(TestUtils.tf)) {
				trueFalseType.selectTrueFalse();// no verification option
				break;
			}

			else if (array[k].matches(TestUtils.essay)) {
				if (answereEssayQuestion == 1) {
					essayType.writeUptoLimit();
					assertTrue(essayType.writtenCharacters > 0);
					essayType.undoRedo();
					assertTrue(essayType.length == essayType.writtenCharacters);
					essayType.subscriptAndSuperscript();
					assertTrue(essayType.writtenCharacters == 20);
					essayType.specialSymbols();
					assertTrue(essayType.writtenCharacters == 24);
					answereEssayQuestion++;
					break;
				}

				else {
					essayType.maximumLimitReached();
					assertTrue(essayType.essayTextfield.isDisplayed());
					essayType.writeUptoLimit();
					assertTrue(essayType.writtenCharacters > 0);
					break;
				}

			}

			else if (array[k].matches(TestUtils.fitb)) {
				fiTBType.answerFiTB();// no verification option
				break;
			}
		}
	}

	/**
	 * This method is for checking current question type
	 */
	public void knowQuestionType() {

		questionText1 = questionTitle.get(1).getText();
		arr = questionText1.split(",");
		typeOfQuestion = arr[1].toString();
	}

	/**
	 * This method is for navigating with left side panel during the exam
	 */
	public void verifyLeftSidePanel() {

		common.isElementDiplayed(questionTitle.get(1));
		questionText1 = questionTitle.get(1).getText();
		arr = questionText1.split("\\W+");
		int currentQuestionNumber = Integer.parseInt(arr[1]);
		numberOfQuestions = leftSidePanel.size();
		System.out.println("numberOfQuestions" + numberOfQuestions);
		for (number = currentQuestionNumber; (number >= 0 && number >= (currentQuestionNumber - 1)); number--) {
			leftSidePanel.get(number - 1).click();

		}
	}

	/**
	 * This method is for answring MCQ
	 * 
	 */

	public void answeringMcqQue() {
		common.waitFor(3000);
		common.waitForElement(examHomeScreen.examMenuDropdown);
		mcqType.numberOfChoices();
		nextQuestionButton.click();

	}

	/**
	 * This method is for backword navigation disable exam
	 */
	public void backwardNavigationDisable() {

		try {
			common.waitForElement(previousQuestionButton, 60);
		} catch (Exception e) {
		}

		queOne.click();
	}

	public void clickOnNextQuestion() {
		common.waitFor(3000);
		nextQuestionButton.click();
		nextQuestionButton.click();
		nextQuestionButton.click();
	}

	public void clickOkRequireAnswer() {
		common.waitForElement(requireAnswerText);
		okButtonOnRequireAnswer.click();
	}

	public void navigateWithoutAnswering() {
		nextQuestionButton.click();
		common.waitForElement(requireAnswerText);
		okButtonOnRequireAnswer.click();
	}

	public void tryToNavigatewithLeftsidePanel() {
		nextQuestionButton.click();
		try {
			common.waitForElement(previousQuestionButton);
		} catch (Exception e) {
		}
		common.waitForElement(examHomeScreen.examMenuDropdown);
		queOne.click();
	}

	public void rightSidePanelopen() {
		boolean toolsButton = false;
		try {
			toolsButton = notesInExam.notesButtonInExam.isDisplayed();
		} catch (Exception e) {

		}
		if (!toolsButton) {
			toolKit.click();
		}
	}

	public boolean CalculatorEnableDisable() {
		boolean isCalcPresent = false;
		try {
			isCalcPresent = calculatorBtnOnPanel.isDisplayed();
		} catch (Exception e) {

		}
		return isCalcPresent;
	}

	public void clearEssayque() {
		common.waitFor(500);
		queSeven.click();
		essayType.clearEssayTextField();
		hideKeyboard.click();
	}
}
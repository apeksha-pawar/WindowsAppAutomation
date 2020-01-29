package com.examsoft.auto.ios.core.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Logout option under Home menu
 * 
 * @author Sanjyot
 *
 */
public class McqType extends PageBase {

	@FindBy(id = "ExamQuesAnswerVC_answer_lbl")
	public WebElement mcqChoices;

	@FindAll({ @FindBy(id = "AnswerChoice") })
	public List<WebElement> answerChoice;

	@FindBy(name = "Choice F: , Hitman")
	public WebElement mcqChoiceF;

	public String mcqChoicesText1;
	public String mcqChoicesText2;
	public String mcqChoicesText3;
	public String mcqChoicesText4;
	public String mcqChoicesText5;
	public String mcqChoicesText6;
	String choicesinMCQ;
	String numberOfChoicesinMCQ;
	int countOfChoicesinMcq;
	String arr[] = null;
	char firstOption = 'A';
	char lastOption;
	char x = 0;
	int choice = 0;

	public McqType(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is check available number of choices for current MCQ
	 */
	public void numberOfChoices() {
		common.waitForElement(mcqChoices, 60);
		choicesinMCQ = mcqChoices.getText();
		arr = choicesinMCQ.split("\\W+");
		numberOfChoicesinMCQ = arr[3];
		lastOption = numberOfChoicesinMCQ.charAt(0);
		int a = 1;
		for (char x = firstOption; x < lastOption; x++) {
			firstOption += 1;
			a += 1;
		}
		for (choice = 0; choice < a; choice++) {
			common.waitForElement(mcqChoices, 60);
			answerChoice.get(choice).click();
		}
		choice = 0;
		a = 1;
		firstOption = 'A';
	}

	/**
	 * This method stores the choices for current MCQ Used in locked answer choice
	 * test
	 */
	public void choicesText() {
		mcqChoicesText1 = answerChoice.get(0).getText().trim();
		mcqChoicesText2 = answerChoice.get(1).getText().trim();
		mcqChoicesText3 = answerChoice.get(2).getText().trim();
		mcqChoicesText4 = answerChoice.get(3).getText().trim();
		mcqChoicesText5 = answerChoice.get(4).getText().trim();
		mcqChoicesText6 = answerChoice.get(5).getText().trim();
	}

	public void selectChoiceA() {
		common.waitForElement(mcqChoices, 60);
		answerChoice.get(choice).click();
	}
}

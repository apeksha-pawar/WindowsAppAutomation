package com.examsoft.auto.ios.core.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.TestUtils;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for FiTB type question functionality
 * 
 * @author Sanjyot
 *
 */
public class FiTBType extends PageBase {

	@FindBy(id = "ExamQuesAnswerVC_answer_lbl")
	public WebElement numberOfFitbChoices;

	@FindAll({ @FindBy(name = "FITBAnswerV_answerTxt_txtFd") })
	public List<WebElement> fiTBChoices;

	TestUtils testUtils;

	List<String> fiTBAnsList = new ArrayList<String>();

	String choiceFitb;
	String fitb;
	String arr[] = null;
	int numberOfChoices;
	int choice = 0;
	int maxLenghtFitb;
	int allowedLenghtFitb = 255;

	public FiTBType(AppiumDriver<WebElement> driver) {
		super(driver);
		testUtils = new TestUtils(driver);
		fiTBAnsList.add(TestUtils.fitbReviewAnswer1);
		fiTBAnsList.add(TestUtils.fitbReviewAnswer2);
		fiTBAnsList.add(TestUtils.fitbReviewAnswer3);

	}

	/**
	 * This method is get available number of blanks
	 */
	public void verifyNumberOfBlanks() {
		common.isElementDiplayed(numberOfFitbChoices);
		choiceFitb = numberOfFitbChoices.getText();
		arr = choiceFitb.split("\\W+");
		numberOfChoices = Integer.parseInt(arr[3]);
	}

	/**
	 * This method is for answering FiTB question
	 */
	public void answerFiTB() {
		verifyNumberOfBlanks();
		verifyFiTBLimit();
		for (choice = 1; choice < numberOfChoices; choice++) {
			common.isElementDiplayed(fiTBChoices.get(choice));
			fiTBChoices.get(choice).click();
			fiTBChoices.get(choice).clear();
			fiTBChoices.get(choice).sendKeys("Fill in the Blank");
			hideKeyboard();
		}
	}

	/**
	 * This method is to check maximum limit of FiTB which is 255
	 */
	public void verifyFiTBLimit() {
		common.isElementDiplayed(fiTBChoices.get(0));
		fiTBChoices.get(0).click();
		fiTBChoices.get(0).clear();
		fiTBChoices.get(0).sendKeys(TestUtils.fitbMaxCharacters);
		fitb = fiTBChoices.get(0).getText();
		maxLenghtFitb = fitb.length();
		hideKeyboard();
	}

	public void reviewAnswerFiTB() {
		verifyNumberOfBlanks();
		for (String answerFiTBQue : fiTBAnsList) {
			fiTBChoices.get(choice).click();
			fiTBChoices.get(choice).clear();
			fiTBChoices.get(choice).sendKeys(answerFiTBQue);
			fiTBChoices.get(choice).sendKeys(Keys.RETURN);
			choice = choice + 1;
		}

	}
}

package com.examsoft.auto.ios.core.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for True-False type question
 * 
 * @author Sanjyot
 *
 */
public class TrueFalseType extends PageBase {

	@FindAll({ @FindBy(id = "AnswerChoice") })
	public List<WebElement> answerChoice;

	@FindBy(xpath = "//XCUIElementTypeCell[@name=\"Choice A.True.\"]/XCUIElementTypeOther[1]")
	public WebElement choiceTrue;

	@FindBy(xpath = "//XCUIElementTypeCell[@name=\"Choice B.False.\"]/XCUIElementTypeOther[1]")
	public WebElement choiceFalse;

	public TrueFalseType(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * This method is to select answer choice in TF
	 */
	public void selectTrueFalse() {
		common.waitForElement(choiceTrue, 60);
		choiceTrue.click();
		common.waitFor(3000);
		choiceFalse.click();
		common.waitFor(3000);
	}

	public void selectTrue() {
		// common.waitForElement(choiceTrue, 60);
		choiceTrue.click();
		common.waitFor(3000);

	}
}

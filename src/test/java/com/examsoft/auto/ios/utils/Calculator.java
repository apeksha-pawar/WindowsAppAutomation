package com.examsoft.auto.ios.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

public class Calculator extends PageBase {
	@FindBy(name = "CalculatorVC_0_btn")
	public WebElement zeroButton;

	@FindBy(id = "CalculatorVC_1_btn")
	public WebElement oneButton;

	@FindBy(id = "CalculatorVC_2_btn")
	public WebElement twoButton;

	@FindBy(id = "CalculatorVC_3_btn")
	public WebElement threeButton;

	@FindBy(name = "CalculatorVC_4_btn")
	public WebElement fourButton;

	@FindBy(name = "CalculatorVC_5_btn")
	public WebElement fiveButton;

	@FindBy(id = "CalculatorVC_6_btn")
	public WebElement sixButton;

	@FindBy(id = "CalculatorVC_7_btn")
	public WebElement sevenButton;

	@FindBy(id = "CalculatorVC_8_btn")
	public WebElement eightButton;

	@FindBy(name = "CalculatorVC_9_btn")
	public WebElement nineButton;

	@FindBy(id = "CalculatorVC_plusMinus_btn")
	public WebElement plusMinusButton;

	@FindBy(id = "CalculatorVC_dot_btn")
	public WebElement dotButton;

	public Calculator(AppiumDriver<WebElement> driver) {
		super(driver);

	}

	WebElement button;
	String value;

	/**
	 * This method splits the given number and calls method selectvalue. also adds
	 * plusminus button
	 * 
	 * @param reqValue
	 */
	public void clickvalue(int reqValue) {
		int split = Math.abs(reqValue);
		String numasString[] = Integer.toString(split).split("");
		selectvalue(numasString);
		if (reqValue < 0)
			plusMinusButton.click();
	}

	/**
	 * This method clicks the number on calculator
	 * 
	 * @param digit
	 */
	public void selectvalue(String numasString[]) {
		for (int i = 0; i < numasString.length; i++) {
			value = numasString[i];
			clickdigits();
		}
	}

	public void clickdigits() {
		switch (value) {
		case "0":
			common.isElementDiplayedlongwait(zeroButton);
			zeroButton.click();
			break;

		case "1":
			common.isElementDiplayedlongwait(oneButton);
			oneButton.click();
			break;

		case "2":
			common.isElementDiplayedlongwait(twoButton);
			twoButton.click();
			break;

		case "3":
			common.isElementDiplayedlongwait(threeButton);
			threeButton.click();
			break;

		case "4":
			common.isElementDiplayedlongwait(fourButton);
			fourButton.click();
			break;

		case "5":
			common.isElementDiplayedlongwait(fiveButton);
			fiveButton.click();
			break;

		case "6":
			common.isElementDiplayedlongwait(sixButton);
			sixButton.click();
			break;

		case "7":
			common.isElementDiplayedlongwait(sevenButton);
			sevenButton.click();
			break;

		case "8":
			common.isElementDiplayedlongwait(eightButton);
			eightButton.click();
			break;

		case "9":
			common.isElementDiplayedlongwait(nineButton);
			nineButton.click();
			break;

		default:
			common.isElementDiplayedlongwait(dotButton);
			dotButton.click();
			break;

		}
	}

	public void clickDecimalNumbers(Double num) {
		Double num1 = Math.abs(num);
		String numasString[] = Double.toString(num1).split("");
		selectvalue(numasString);
		if (num < 0.0)
			plusMinusButton.click();

	}

}

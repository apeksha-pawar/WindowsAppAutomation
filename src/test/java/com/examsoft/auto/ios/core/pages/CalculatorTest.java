package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.Calculator;

import io.appium.java_client.AppiumDriver;

/**
 * This class is for calculator functionality It calculates with both tabs,
 * basic and scientific
 * 
 * @author sanjyot
 *
 */
public class CalculatorTest extends PageBase {

	@FindBy(id = "ExamQuesAnswerVC_calculator_btn")
	public WebElement calculatorBtnPanelOpen;

	@FindBy(id = "Calculator")
	public WebElement calculatorBtnOnPanel;

	@FindBy(id = "Basic")
	public WebElement basicCalculatorTab;

	@FindBy(id = "Scientific")
	public WebElement scientificCalculatorTab;

	@FindBy(id = "RightSidePanelVC_close_btn")
	public WebElement closeCalcButton;

	@FindBy(id = "CalculatorVC_result_btn")
	public WebElement calcResultDisplay;

	@FindBy(id = "CalculatorVC_equalTo_btn")
	public WebElement equalstoButton;

	@FindBy(id = "CalculatorVC_plus_btn")
	public WebElement plusButton;

	@FindBy(id = "CalculatorVC_minus_btn")
	public WebElement minusButton;

	@FindBy(id = "CalculatorVC_clear_btn")
	public WebElement clearCalcResultButton;

	@FindBy(id = "CalculatorVC_sine_btn")
	public WebElement sinButton;

	@FindBy(id = "CalculatorVC_cosine_btn")
	public WebElement cosinButton;

	@FindBy(id = "CalculatorVC_tangent_btn")
	public WebElement tanButton;

	@FindBy(id = "CalculatorVC_inverse_btn")
	public WebElement inverseButton;

	@FindBy(id = "CalculatorVC_exponential_btn")
	public WebElement exponentialButton;

	@FindBy(id = "CalculatorVC_delete_btn")
	public WebElement deleteButton;

	@FindBy(id = "CalculatorVC_naturalLog_btn")
	public WebElement naturalLogButton;

	@FindBy(id = "CalculatorVC_logarithm_btn")
	public WebElement logButton;

	@FindBy(id = "CalculatorVC_power_btn")
	public WebElement powerButton;

	@FindBy(id = "CalculatorVC_pi_btn")
	public WebElement piButton;

	@FindBy(id = "CalculatorVC_sqRoot_btn")
	public WebElement sqRootButton;

	@FindBy(id = "CalculatorVC_percent_btn")
	public WebElement percentButton;

	@FindBy(id = "CalculatorVC_memoryClear_btn")
	public WebElement memoryClearButton;

	@FindBy(id = "CalculatorVC_memoryReset_btn")
	public WebElement memoryResetButton;

	@FindBy(id = "CalculatorVC_memoryStore_btn")
	public WebElement memoryStoreButton;

	@FindBy(id = "CalculatorVC_memoryAdd_btn")
	public WebElement memoryAddButton;

	@FindBy(id = "CalculatorVC_memorySubtract_btn")
	public WebElement memorySubtractButton;

	@FindBy(id = "CalculatorVC_reciprocalKey_btn")
	public WebElement reciprocalButton;

	@FindBy(id = "CalculatorVC_nFactorial_btn")
	public WebElement nFactorialButton;

	@FindBy(id = "CalculatorVC_plusMinus_btn")
	public WebElement plusMinusButton;

	@FindBy(id = "CalculatorVC_degree_btn")
	public WebElement degreeButton;

	@FindBy(id = "CalculatorVC_basicDivideBy_btn")
	public WebElement basicDivideButton;

	@FindBy(id = "CalculatorVC_divideBy_btn")
	public WebElement divideButton;

	@FindBy(id = "CalculatorVC_basicMultiplyBy_btn")
	public WebElement basicMultiplyButton;

	@FindBy(id = "CalculatorVC_basicMinus_btn")
	public WebElement basicMinusButton;

	@FindBy(id = "CalculatorVC_basicAdd_btn")
	public WebElement basicAddButton;

	public String result = null;
	Calculator calculator;

	public CalculatorTest(AppiumDriver<WebElement> driver) {
		super(driver);
		calculator = new Calculator(driver);
	}

	/**
	 * This method opens calculator button when panel is open
	 */
	public void openCalculator() {
		calculatorBtnOnPanel.click();
		common.waitFor(5000);
	}

	/**
	 * This method close calculator tab
	 */
	public void closeCalculator() {
		closeCalcButton.click();
	}

	/**
	 * This method clicks on basic calculator tab
	 */
	public void clickOnBasiCalc() {
		common.isElementDiplayed(basicCalculatorTab);
		basicCalculatorTab.click();
		common.waitFor(5000);
	}

	/**
	 * This method performs addition of 79+83
	 */
	public void calculateAddition(int a, int b) {
		calculator.clickvalue(a);
		plusButton.click();
		calculator.clickvalue(b);
		equalstoButton.click();
	}

	/**
	 * This method verifies addition of 7+8
	 */
	public void verifyResult() {
		result = calcResultDisplay.getAttribute("value");
	}

	/**
	 * This method performs tan of 45
	 */
	public void calculateTan(int a) {
		clearCalcResultButton.click();
		calculator.clickvalue(a);
		tanButton.click();
	}

	/**
	 * This method Verifies tan of 45
	 */
	public void verifyTanInCalc() {
		result = calcResultDisplay.getAttribute("value");
	}

	/**
	 * This method performs Divide by zero
	 */

	public void divideByZero(int a, int b) {
		common.isElementDiplayedlongwait(clearCalcResultButton);
		clearCalcResultButton.click();
		calculator.clickvalue(a);
		divideButton.click();
		calculator.clickvalue(b);
		equalstoButton.click();
	}

	/**
	 * This method verifies Divide by zero
	 */
	public void verifyDivideByZero() {
		verifyResult();
	}

	/**
	 * This method calculates 47+48+90=185
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */

	public void addThreeNumbers(int a, int b, int c) {
		calculator.clickvalue(a);
		plusButton.click();
		calculator.clickvalue(b);
		plusButton.click();
		calculator.clickvalue(c);
		equalstoButton.click();
	}

	/**
	 * Perform following division 1000/85 = 11.764706
	 * 
	 */
	public void performDivision(int a, int b) {
		clearCalcResultButton.click();
		calculator.clickvalue(a);
		divideButton.click();
		calculator.clickvalue(b);
		equalstoButton.click();
	}

	/**
	 * Verify following division 1000/85 = 11.76470
	 * 
	 */
	public void verifyDivision() {
		verifyResult();
	}

	/**
	 * Perform following division 00000.35 / 00000.36 = 0.972222
	 * 
	 */
	public void performDecimalDivision(Double a, Double b) {
		clearCalcResultButton.click();
		calculator.clickDecimalNumbers(a);
		divideButton.click();
		calculator.clickDecimalNumbers(b);
		equalstoButton.click();
	}

	/**
	 * Verify following division 00000.35 / 00000.36 = 0.972222
	 * 
	 */
	public void verifyDecimalDivision() {
		verifyResult();
	}

	/**
	 * Verify operation 5^363 =5.322450e+253
	 * 
	 */
	public void performLongPowerFunction(int a, int b) {
		clearCalcResultButton.click();
		calculator.clickvalue(a);
		powerButton.click();
		calculator.clickvalue(b);
		equalstoButton.click();
	}

	/**
	 * Verify operation 6! =720
	 * 
	 */
	public void Nfacto(int a) {
		openCalculator();
		calculator.clickvalue(a);
		nFactorialButton.click();
	}

	/**
	 * Verify operation sq.rt of 81 =9
	 * 
	 */
	public void SquareRoot(int a) {
		openCalculator();
		calculator.clickvalue(a);
		sqRootButton.click();
		equalstoButton.click();
	}

	/**
	 * Verify operation sq.rt of sq.rt of 81 =3
	 * 
	 */
	public void ClickSquareRoot(int a) {
		sqRootButton.click();
	}

	/**
	 * Verify value of Pi =3.141593
	 * 
	 */
	public void ClickPi() {
		openCalculator();
		piButton.click();
	}

	/**
	 * Verify reciprocal value of Pi = 0.31831
	 * 
	 */
	public void ClickReciprocal() {
		reciprocalButton.click();
	}

	/**
	 * All values to check Trigonometric functions
	 */

	public void selectValue(int val) {
		switch (val) {
		case 0:
			calculator.clickvalue(0);
			break;
		case 45:
			calculator.clickvalue(45);
			break;
		case 90:
			calculator.clickvalue(90);
			break;
		case 180:
			calculator.clickvalue(180);
			break;
		case 270:
			calculator.clickvalue(270);
			break;
		case 360:
			calculator.clickvalue(360);
			break;
		}
	}

}

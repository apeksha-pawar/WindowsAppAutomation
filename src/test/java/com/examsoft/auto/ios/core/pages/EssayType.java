package com.examsoft.auto.ios.core.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;

/**
 * This is a class for Essay question type.
 * 
 * @author Sanjyot
 *
 */
public class EssayType extends PageBase {

	TestUtils testUtils;

	@FindBy(id = "ExamQuesAnswerVC_answer_lbl")
	public WebElement essayAnswer; // Total character limit

	@FindBy(id = "ExamEssayAnswerVC_essay_txtVw")
	public WebElement essayTextfield;// essay text field

	@FindBy(id = "ExamEssayAnswerVC_font_btn")
	public WebElement changeFontEssay; // change font button

	@FindBy(id = "ExamEssayAnswerVC_bold_btn")
	public WebElement boldFontEssay; // bold font button

	@FindBy(id = "ExamEssayAnswerVC_underline_btn")
	public WebElement underlineFontEssay; // underline font button

	@FindBy(id = "ExamEssayAnswerVC_italic_btn")
	public WebElement italicFontEssay; // italic font button

	@FindBy(id = "ExamEssayAnswerVC_superscript_btn")
	public WebElement superscriptFontEssay; // superscript font button

	@FindBy(id = "ExamEssayAnswerVC_subscript_btn")
	public WebElement subscriptFontEssay; // subscript font button

	@FindBy(id = "ExamEssayAnswerVC_leftAlign_btn")
	public WebElement leftAlignEssay; // Left align essay button

	@FindBy(id = "ExamEssayAnswerVC_centerAlign_btn")
	public WebElement centerAlignEssay; // center Align essay button

	@FindBy(id = "ExamEssayAnswerVC_rightAlign_btn")
	public WebElement rightAlignEssay; // Right Align essay button

	@FindBy(id = "ExamEssayAnswerVC_justify_btn")
	public WebElement justifyButtonEssay; // justify Button essay

	@FindBy(id = "ExamEssayAnswerVC_bullet_btn")
	public WebElement bulletButtonEssay; // bullet Button essay

	@FindBy(name = "Show Symbols")
	public WebElement showSymbolsEssay; // show Symbols essay button

	@FindBy(id = "ExamEssayAnswerVC_pgBk_btn")
	public WebElement pageBreakEssay; // page Break essay button

	@FindBy(id = "ExamEssayAnswerVC_spellCheck_btn")
	public WebElement spellCheckEssay; // spellCheck essay button

	@FindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeAlert[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
	public WebElement limitReachedButton; // Character limit reached button

	@FindBy(name = "MaxCharacterLimitReached")
	public WebElement limitReachedText; // Character limit reached text

	@FindBy(id = "ExamEssayAnswerVC_undo_btn")
	public WebElement undoButton; // Undo button essay

	@FindBy(id = "ExamEssayAnswerVC_redo_btn")
	public WebElement redoButton; // Redo button essay

	@FindBy(name = "Hide keyboard")
	public WebElement hideKeyboard;

	@FindBy(id = "SymbolsPopoverVC_copyRight_btn")
	public WebElement copyRightButton; // copy right button in show symbols

	@FindBy(id = "SymbolsPopoverVC_registered_btn")
	public WebElement registeredButton; // registered Button in show symbols

	@FindBy(id = "SymbolsPopoverVC_trademark_btn")
	public WebElement trademarkButton; // trademark button in show symbols

	@FindBy(id = "SymbolsPopoverVC_paragraph_btn")
	public WebElement paragraphButton; // paragraph button in show symbols

	@FindBy(id = "SymbolsPopoverVC_dot_btn")
	public WebElement dotButton; // dot button in show symbols

	@FindBy(id = "SymbolsPopoverVC_section_btn")
	public WebElement sectionButton; // section button in show symbols

	@FindBy(id = "SymbolsPopoverVC_dagger_btn")
	public WebElement daggerButton; // dagger button in show symbols

	@FindBy(id = "SymbolsPopoverVC_cents_btn")
	public WebElement centsButton; // cents button in show symbols

	@FindBy(id = "SymbolsPopoverVC_britishPound_btn")
	public WebElement britishPoundButton; // britishPoundt button in show
											// symbols

	@FindBy(id = "SymbolsPopoverVC_yen_btn")
	public WebElement yenButton; // yen button in show symbols

	@FindBy(id = "SymbolsPopoverVC_euro_btn")
	public WebElement euroButton; // euro button in show symbols

	@FindBy(id = "SymbolsPopoverVC_division_btn")
	public WebElement divisionButton; // division button in show symbols

	@FindBy(id = "SymbolsPopoverVC_plusOrMinus_btn")
	public WebElement plusOrMinusButton; // plusOrMinus button in show symbols

	@FindBy(id = "SymbolsPopoverVC_degrees_btn")
	public WebElement degreesButton; // degrees button in show symbols

	@FindBy(id = "SymbolsPopoverVC_negation_btn")
	public WebElement negationButton; // negation button in show symbols

	@FindBy(id = "SymbolsPopoverVC_micro_btn")
	public WebElement microButton; // micro button in show symbols

	@FindBy(id = "SymbolsPopoverVC_partialDerivative_btn")
	public WebElement partialDerivativeButton; // partialDerivative button in
												// show symbols

	@FindBy(id = "SymbolsPopoverVC_pi_btn")
	public WebElement piButton; // pi button in show symbols

	@FindBy(id = "SymbolsPopoverVC_delta_btn")
	public WebElement deltaButton; // delta Button in show symbols

	@FindBy(id = "SymbolsPopoverVC_integral_btn")
	public WebElement integralButton; // Integral button in show symbols

	@FindBy(id = "SymbolsPopoverVC_perMilli_btn")
	public WebElement perMilliButton; // perMilli button in show symbols

	@FindBy(id = "SymbolsPopoverVC_cedilla_btn")
	public WebElement cedillaButton; // cedilla button in show symbols

	@FindBy(id = "SymbolsPopoverVC_sharp_btn")
	public WebElement sharpButton; // sharp button in show symbols

	@FindBy(id = "SymbolsPopoverVC_nordic_btn")
	public WebElement nordicButton; // nordic button in show symbols

	@FindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeKeyboard[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
	public WebElement dismissButton; // keypad dismiss button

	@FindBy(id = "ExamEssayAnswerVC_spellCheck_btn")
	public WebElement spellCheckButton;

	@FindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeAlert[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
	public WebElement okToAlert;

	@FindBy(name = "You are about to delete 500 characters or more")
	public WebElement charDelete;

	@FindBy(name = "Select All")
	public WebElement slectAllChar;

	@FindBy(name = "Cut")
	public WebElement cutChar;

	public String charLimitEssay;
	public String writtenLimitEssay;
	public String totalArr[] = null; // totalArr[] is showing the maximum limit
										// for essay
	public String addedArr[] = null; // addedArr[] is showing the limit of
										// characters ET have Typed

	public int characterLimit; // Total character limit
	public int lenghtOfCharacters; // length of characters we are passing
	public int lenghtOfMinimumCharacters; // minimum length of characters we are
											// passing
	public int writtenCharacters; // Total written characters in essay
	public int a = 0;
	public int length;
	List<WebElement> specialSymbols = new ArrayList<WebElement>();

	public EssayType(AppiumDriver<WebElement> driver) {
		super(driver);
		testUtils = new TestUtils(driver);

		specialSymbols.add(cedillaButton);
		specialSymbols.add(centsButton);
		specialSymbols.add(daggerButton);
		specialSymbols.add(degreesButton);
		specialSymbols.add(deltaButton);
		specialSymbols.add(euroButton);
		specialSymbols.add(integralButton);
		specialSymbols.add(negationButton);
		specialSymbols.add(partialDerivativeButton);
		specialSymbols.add(perMilliButton);
		specialSymbols.add(registeredButton);
		specialSymbols.add(sectionButton);
		specialSymbols.add(trademarkButton);
		specialSymbols.add(yenButton);
		specialSymbols.add(britishPoundButton);
		specialSymbols.add(copyRightButton);
		specialSymbols.add(divisionButton);
		specialSymbols.add(dotButton);
		specialSymbols.add(nordicButton);
		specialSymbols.add(sharpButton);
		specialSymbols.add(piButton);
		specialSymbols.add(microButton);
		specialSymbols.add(plusOrMinusButton);
		specialSymbols.add(paragraphButton);
	}

	/**
	 * This method check the total available character limit in essay
	 */
	public void checkTotalCharacterLimit() {
		common.isElementDiplayed(essayTextfield);
		essayTextfield.click();
		essayTextfield.sendKeys("Hello");
		charLimitEssay = essayAnswer.getText();
		totalArr = charLimitEssay.split("\\W+");
		characterLimit = Integer.parseInt(totalArr[3]);
	}

	/**
	 * This method check the written character limit in essay
	 */
	public void checkWrittenCharacterLimit() {
		common.isElementDiplayed(essayAnswer);
		writtenLimitEssay = essayAnswer.getText();
		addedArr = writtenLimitEssay.split("\\W+"); // addedArr[2] is showing
													// the number of characters
													// ET have Typed
		writtenCharacters = Integer.parseInt(addedArr[2]);
	}

	/**
	 * This method write within the provided character limit in essay
	 */
	public void writeUptoLimit() {
		checkTotalCharacterLimit();
		common.isElementDiplayed(essayTextfield);
		essayTextfield.click();
		essayTextfield.clear();
		common.waitFor(1000);
		lenghtOfCharacters = TestUtils.essayCharacters.length();
		lenghtOfMinimumCharacters = TestUtils.essayMinimumCharacters.length();
		if (characterLimit > lenghtOfCharacters) {
			essayTextfield.sendKeys(TestUtils.essayCharacters);
			length = lenghtOfCharacters;
		} else {
			essayTextfield.sendKeys(TestUtils.essayMinimumCharacters);
			length = lenghtOfMinimumCharacters;
		}
		hideKeyboard();
		common.isElementDiplayed(essayAnswer);
		checkWrittenCharacterLimit();
	}

	/**
	 * This method select special symbol button and add all available symbols in
	 * essay
	 */
	public void specialSymbols() {
		common.isElementDiplayed(essayTextfield);
		essayTextfield.click();
		essayTextfield.clear();

		for (WebElement selectSymbol : specialSymbols) {
			common.isElementDiplayed(showSymbolsEssay);
			showSymbolsEssay.click();
			selectSymbol.click();
			hideKeyboard();
			essayTextfield.click();
		}
		hideKeyboard();
		checkWrittenCharacterLimit();
	}

	/**
	 * This method select subscript and add 0-9 characters then select superscript
	 * and again add 0-9 characters in essay
	 */
	public void subscriptAndSuperscript() {
		common.isElementDiplayed(essayTextfield);
		essayTextfield.clear();
		superscriptFontEssay.click();
		essayTextfield.click();
		essayTextfield.sendKeys("1234567890");
		common.isElementDiplayed(subscriptFontEssay);
		subscriptFontEssay.sendKeys("1234567890");
		hideKeyboard();
		common.isElementDiplayed(essayAnswer);
		checkWrittenCharacterLimit();
	}

	/**
	 * This method check the spell-check by misspelling max characters in essay
	 */
	public void spellCheck() {
		essayTextfield.click();
		essayTextfield.clear();
		essayTextfield.sendKeys(TestUtils.essayMisspelledCharacters1);
		common.isElementDiplayed(spellCheckButton);
		essayTextfield.sendKeys(TestUtils.essayMisspelledCharacters2);
		okToAlert.click();
		spellCheckButton.isEnabled();
		spellCheckButton.click();
		common.isElementDiplayed(spellCheckButton);
	}

	/**
	 * This method is for undo and redo in essay
	 */
	public void undoRedo() {
		common.isElementDiplayed(essayTextfield);
		essayTextfield.click();
		common.isElementDiplayed(undoButton);
		undoButton.click();
		hideKeyboard();
		checkWrittenCharacterLimit();
		essayTextfield.click();
		common.isElementDiplayed(redoButton);
		redoButton.click();
		hideKeyboard();
		checkWrittenCharacterLimit();
	}

	/**
	 * This method tries writes maximum characters than provided limit in essay
	 */
	public void maximumLimitReached() {
		checkTotalCharacterLimit();
		lenghtOfCharacters = TestUtils.essayCharacters.length();
		if (lenghtOfCharacters > characterLimit) {
			essayTextfield.click();
			essayTextfield.clear();
			essayTextfield.sendKeys(TestUtils.essayCharacters);
			common.isElementDiplayed(limitReachedButton);
			limitReachedButton.click();
		}
	}

	/**
	 * This method deletes more than 500 characters at once in essay
	 */
	public void largeCharacterDelete() {
		lenghtOfCharacters = TestUtils.essayLargeCharacters.length();
		if (lenghtOfCharacters > characterLimit) {
			essayTextfield.clear();
			essayTextfield.sendKeys(TestUtils.essayLargeCharacters);
			SelectWrittenCharacters();
			slectAllChar.click();
			common.waitFor(3000);
			cutChar.click();
			common.waitFor(3000);
		}
	}

	public void clearEssayTextField() {
		essayTextfield.click();
		essayTextfield.clear();
		common.hideKeyboard();
	}

	public void SelectWrittenCharacters() {
		driver.performTouchAction(touchActionNew(44, 254));
	}

	public TouchAction touchActionNew(int x, int y) {
		return new IOSTouchAction(driver).press(x, y).waitAction().release();
	}
}

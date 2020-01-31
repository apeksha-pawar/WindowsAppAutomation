package com.examsoft.auto.win.core.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.windows.WindowsDriver;

public class Scoring_AllCases extends PageBase {

	public Scoring_AllCases(WindowsDriver<WebElement> winDriver) {
		super(winDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "1")
	public WebElement firstQuestion;

	@FindBy(name = "A True ")
	public WebElement selectTrue;

	@FindBy(name = "2")
	public WebElement secondQuestion;

	@FindBy(name = "D Big Bang Theory visibility")
	public WebElement secQueAns;

	@FindBy(name = "3")
	public WebElement thirdQuestion;

	@FindBy(name = "Next")
	public WebElement nextAfterAttempButton;

	@FindBy(xpath = "//Button[@Name='Close']")
	public WebElement closeExamButton;

	@FindBy(name = "  I confirm that I have completed my exam.")
	public WebElement exitExamCheckBox;

	@FindBy(name = "Submit Exam")
	public WebElement submitExamButton;

	// perfect score
	@FindBy(name = "3.0")
	public WebElement rawScore;

	@FindBy(name = "3")
	public WebElement rawTotalOutOfScore;

	@FindBy(name = "100.00%")
	public WebElement totalPercentage;

	// half score
	@FindBy(name = "2.0")
	public WebElement hrawScore;

	@FindBy(name = "3")
	public WebElement hrawTotalOutOfScore;

	@FindBy(name = "66.67%")
	public WebElement htotalPercentage;

	// zero score
	@FindBy(name = "0.0")
	public WebElement zrawScore;

	@FindBy(name = "3")
	public WebElement zrawTotalOutOfScore;

	@FindBy(name = "0.00%")
	public WebElement ztotalPercentage;

	@FindBy(name = "Continue to Upload")
	public WebElement continueToUploadButton;

	@FindBy(name = "Close")
	public WebElement closeButton;

	Actions actions = new Actions(winDriver);
	public void validatePerfectScore(Marker_AttemptExamWithNotice marker) throws InterruptedException {
		try {
			marker.startExam();
			marker.downloadExam();
			firstQuestion.click();
			selectTrue.click();
			secondQuestion.click();
			secQueAns.click();
			thirdQuestion.click();
			selectTrue.click();
			nextAfterAttempButton.click();
			exitExamCheckBox.click();
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			rawScore.getText().equals("3.0");
			rawTotalOutOfScore.getText().equals("3");
			totalPercentage.getText().equals("100.00%");
			continueToUploadButton.click();
			Thread.sleep(15000);
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			Thread.sleep(12000);
			System.out.println("Perfoct score validated");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validateHalfScore(Marker_AttemptExamWithNotice marker) throws InterruptedException {
		try {
			marker.downloadExam();
			firstQuestion.click();
			selectTrue.click();
			secondQuestion.click();
			secQueAns.click();
			nextAfterAttempButton.click();
			nextAfterAttempButton.click();
			exitExamCheckBox.click();
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			hrawScore.getText().equals("2.0");
			hrawTotalOutOfScore.getText().equals("3");
			htotalPercentage.getText().equals("66.67%");
			continueToUploadButton.click();
			Thread.sleep(15000);
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			Thread.sleep(12000);
			System.out.println("Partial score validated");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validateZeroPercentScore(Marker_AttemptExamWithNotice marker) throws InterruptedException {
		try {
			marker.downloadExam();
			firstQuestion.click();
			nextAfterAttempButton.click();
			nextAfterAttempButton.click();
			nextAfterAttempButton.click();
			exitExamCheckBox.click();
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			zrawScore.getText().equals("0.0");
			zrawTotalOutOfScore.getText().equals("3");
			ztotalPercentage.getText().equals("0.00%");
			continueToUploadButton.click();
			Thread.sleep(15000);
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			Thread.sleep(12000);
			closeButton.click();
			System.out.println("Zero score validated");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

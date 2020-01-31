package com.examsoft.auto.win.core.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.windows.WindowsDriver;

/**
 * @author apekshap
 *
 */
public class Marker_AttemptExamWithNotice extends PageBase {

	@FindBy(name = "Add New Account")
	public WebElement addNewAccountButton;

	@FindBy(name = "Institution ID")
	public WebElement institutionIdTextField;

	@FindBy(name = "Demo - CBT (CBT)")
	public WebElement institutionIdSuggestion;

	@FindBy(name = "Next")
	public WebElement nextButton;

	@FindBy(name = "User ID")
	public WebElement userIdTextField;

	@FindBy(name = "Password")
	public WebElement passwordTextField;

	@FindBy(name = "Sign In")
	public WebElement signInButton;

	@FindBy(name = "READY FOR DOWNLOAD")
	public WebElement readyForDownloadText;

	@FindBy(name = "Au_Marker-S_WN Ready For Download file_download")
	public WebElement selectExamLink;

	@FindBy(name = "AllQT-NS")
	public WebElement downloadedExam;

	@FindBy(name = "Download Exam")
	public WebElement downloadExamButton;

	@FindBy(name = "DOWNLOADED")
	public WebElement txtDownloaded;

	@FindBy(name = "EXAM PASSWORD")
	public WebElement examPasswordText;

	@FindBy(name = "Enter")
	public WebElement enterExamButton;

	@FindBy(name = "Nextarrow_forward")
	public WebElement nextForwardArrow;

	@FindBy(name = "Continue")
	public WebElement ContinueButton;

	@FindBy(name = "I am authorized to start my exam.")
	public WebElement startExamCheckbox;

	@FindBy(name = "Start Exam")
	public WebElement startActualExamButton;

	@FindBy(name = "1")
	public WebElement firstQuestion;

	@FindBy(name = "2")
	public WebElement secondQuestion;

	@FindBy(name = "A True ")
	public WebElement selectTrue;

	@FindBy(name = "5")
	public WebElement fifthQuestion;

	@FindBy(name = "A True ")
	public WebElement selectTrue1;

	@FindBy(name = "Next")
	public WebElement nextAfterAttempButton;

	@FindBy(xpath = "//Button[@Name='Close']")
	public WebElement closeExamButton;

	@FindBy(name = "  I confirm that I have completed my exam.")
	public WebElement exitExamCheckBox;

	@FindBy(name = "Submit Exam")
	public WebElement submitExamButton;

	@FindBy(name = "Continue to Upload")
	public WebElement continueToUploadButton;

	@FindBy(name = "Close")
	public WebElement closeButton;

	@FindBy(name = "HOME MENUkeyboard_arrow_down")
	public WebElement homeMenuDropDown;

	@FindBy(name = "Logout")
	public WebElement logoutLink;

	@FindBy(name = "Logout")
	public WebElement logoutButton;

	public Marker_AttemptExamWithNotice(WindowsDriver<WebElement> winDriver) {
		super(winDriver);
	}

	Actions actions = new Actions(winDriver);

	public void startExam() throws InterruptedException {
		try {
			Thread.sleep(8000);
			winDriver.manage().window().maximize();
			addNewAccountButton.click();
			institutionIdTextField.click();
			institutionIdTextField.sendKeys("CBT");
			Thread.sleep(3000);
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			nextButton.click();
			userIdTextField.click();
			userIdTextField.sendKeys("pdeploy2");
			passwordTextField.click();
			passwordTextField.sendKeys("999999");
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			Thread.sleep(30000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void downloadExam() throws InterruptedException {
		try {
			downloadExamButton.click();
			Thread.sleep(25000);
			examPasswordText.click();
			examPasswordText.sendKeys("test123");
			enterExamButton.click();
			Thread.sleep(5000);
			nextForwardArrow.click();
			nextForwardArrow.click();
			nextForwardArrow.click();
			ContinueButton.click();
			ContinueButton.click();
			Thread.sleep(3000);
			startExamCheckbox.click();
			Thread.sleep(2000);
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void attemptExam() throws InterruptedException {
		try {
			startExam();
			downloadExam();
			firstQuestion.click();
			secondQuestion.click();
			selectTrue.click();
			fifthQuestion.click();
			selectTrue1.click();
			Thread.sleep(60000);
			nextAfterAttempButton.click();
			nextAfterAttempButton.click();
			exitExamCheckBox.click();
			Actions actions = new Actions(winDriver);
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			continueToUploadButton.click();
			Thread.sleep(15000);
			actions.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
			Thread.sleep(12000);
			homeMenuDropDown.click();
			Thread.sleep(3000);
			closeButton.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

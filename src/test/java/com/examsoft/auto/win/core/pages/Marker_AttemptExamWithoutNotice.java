package com.examsoft.auto.win.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.windows.WindowsDriver;

/**
 * @author apekshap
 *
 */
public class Marker_AttemptExamWithoutNotice extends PageBase {	
	
	@FindBy (name = "1")
	public WebElement firstQuestion;
	
	@FindBy (name = "2")
	public WebElement secondQuestion;
	
	@FindBy (name = "A True ")
	public WebElement selectTrue;
	
	@FindBy (name = "5")
	public WebElement fifthQuestion;
	
	@FindBy (name = "A True ")
	public WebElement selectTrue1;
	
	@FindBy (name = "Next")
	public WebElement nextAfterAttempButton;
	
	@FindBy(xpath = "//Button[@Name='Close']")
	public WebElement closeExamButton;
	
	@FindBy (name = "  I confirm that I have completed my exam.")
	public WebElement exitExamCheckBox;
	
	@FindBy (name = "Submit Exam")
	public WebElement submitExamButton;
	
	@FindBy (name = "Continue to Upload")
	public WebElement continueToUploadButton;
	
	@FindBy (name = "Close")
	public WebElement closeButton;
	
	@FindBy (name = "HOME MENUkeyboard_arrow_down")
	public WebElement homeMenuDropDown;
	
	@FindBy (name = "Logout")
	public WebElement logoutLink;
	
	@FindBy (name = "Logout")
	public WebElement logoutButton;
		
	public Marker_AttemptExamWithoutNotice(WindowsDriver<WebElement> winDriver) {
		super(winDriver);
	}

	public void attemptExam(Marker_AttemptExamWithNotice marker) throws InterruptedException {
		try {
		marker.startExam();
		marker.downloadExam();
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

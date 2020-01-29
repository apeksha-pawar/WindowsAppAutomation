package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for Help in Examplify-iPad
 * 
 * @author Sanjyot
 * @param <helpArticles>
 *
 */
public class Help extends PageBase {

	@FindBy(id = "HelpVC_welcome_btn")
	public WebElement welcomeButton;

	@FindBy(id = "HelpVC_backToDashboard_btn")
	public WebElement backToDashboard;

	@FindBy(name = "Authenticating User Accounts")
	public WebElement helpOnAuthenticatingButton;

	@FindBy(name = "Downloading and Removing Exams")
	public WebElement helpOnDownloadingButton;

	@FindBy(name = "Switching Users and Logging Out")
	public WebElement helpOnSwitchAccountButton;

	@FindBy(name = "Preparing for a Secure Exam")
	public WebElement helpOnBeforeExamButton;

	@FindBy(name = "Taking an Exam")
	public WebElement helpOnDuringExamButton;

	@FindBy(name = "Best Practices for Utilizing Examplify")
	public WebElement helpOnExamplifyButton;

	@FindBy(name = "Examplify for iPad: Authenticating User Accounts")
	public WebElement helpOnAuthenticating;

	@FindBy(name = "Examplify for iPad: Downloading & Removing Exams")
	public WebElement helpOnDownloading;

	@FindBy(name = "Examplify for iPad: Switching Users & Logging Out")
	public WebElement helpOnSwitchAccount;

	@FindBy(name = "Examplify for iPad: Preparing your iPad for a Secure Exam - 9.3.2 & Higher")
	public WebElement helpOnBeforeExam;

	@FindBy(name = "Examplify for iPad: Taking an Exam")
	public WebElement helpOnDuringExam;

	@FindBy(name = "Examplify for iPad: Best Practices for Students")
	public WebElement helpOnExamplify;

	@FindBy(name = "Welcome to Examplify Support")
	public WebElement welcomePageTitle;

	@FindBy(id = "HelpVC_helpChat_btn")
	public WebElement liveChatButton;

	@FindBy(id = "HelpVC_submitTicket_btn")
	public WebElement submitTicketButton;

	@FindBy(id = "HelpVC_support_btn")
	public WebElement supportButton;

	@FindBy(name = "Cannot Send Email")
	public WebElement alertErrorMessage;

	@FindBy(name = "OK")
	public WebElement alertOkButton;

	@FindBy(name = "EXAMPLIFY FOR IPAD")
	public WebElement WebPageText;

	public Help(AppiumDriver<WebElement> driver) {
		super(driver);

	}

	/**
	 * This method is opening Home page for Help
	 */
	public void openWelcomePage() {
		common.waitForElement(welcomeButton, 60);
		welcomeButton.click();
		common.waitForElement(welcomePageTitle, 60);
	}

	/**
	 * This method is for checking email link to support team
	 */
	public void submitTicket() {
		openWelcomePage();
		submitTicketButton.click();
		common.waitForElement(alertOkButton);
		alertOkButton.click();
	}

	/**
	 * This method is for closing Help section
	 */
	public void backToDashboardPage() {
		common.waitForElement(backToDashboard, 60);
		backToDashboard.click();
	}

	/**
	 * This method is for checking Help page on authentication of ET
	 */
	public void authenticationHelp() {
		common.waitForElement(helpOnAuthenticatingButton, 60);
		helpOnAuthenticatingButton.click();
		common.waitForElement(WebPageText, 60);
	}

	/**
	 * This method is for checking Help page on Exam Downloading cases
	 */
	public void examDownloadHelp() {
		common.waitForElement(helpOnDownloadingButton, 60);
		helpOnDownloadingButton.click();
		common.waitForElement(WebPageText, 120);
	}

	/**
	 * This method is for checking Help page on Switch/Logged Out account
	 */
	public void swichAccountHelp() {
		common.waitForElement(helpOnSwitchAccountButton, 60);
		helpOnSwitchAccountButton.click();
		common.waitForElement(WebPageText, 60);
	}

	/**
	 * This method is for checking Help page on Before Exam cases
	 */
	public void beforeExamHelp() {
		common.waitForElement(helpOnBeforeExamButton, 60);
		helpOnBeforeExamButton.click();
		common.waitForElement(WebPageText, 60);
	}

	/**
	 * This method is for checking Help page on Exam Downloading cases
	 */
	public void duringExamHelp() {
		common.waitForElement(helpOnDuringExamButton, 60);
		helpOnDuringExamButton.click();
		common.waitForElement(WebPageText, 60);
	}

	/**
	 * This method is for checking Help page on general scenarios in Examplify
	 */
	public void utilizingAppHelp() {
		common.waitForElement(helpOnExamplifyButton, 60);
		helpOnExamplifyButton.click();
		common.waitForElement(WebPageText, 60);
	}

}

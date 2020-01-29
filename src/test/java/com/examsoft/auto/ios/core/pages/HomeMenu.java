package com.examsoft.auto.ios.core.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

/**
 * This class is a page for Examplify Home Menu Home menu is having many tabs in
 * drop down like EULA, Help, Switch account,.. etc
 * 
 * @author Sanjyot
 *
 */
public class HomeMenu extends PageBase {

	@FindBy(id = "ExamHomeVC_homeMenu_btn")
	public WebElement homeMenuDropdown;

	@FindBy(id = "My Exams")
	public WebElement myExamText;

	@FindBy(id = "ExamListVC_refreshExamList_btn")
	public WebElement refreshExamListLink;

	@FindBy(id = "ExamDetailsVC_downloadExam_btn")
	public WebElement dowloadExamButton;

	@FindBy(name = "Ready For Download")
	public WebElement readyToDownalod;

	@FindBy(id = "ExamDetailsVC_downloadExam_btn")
	public WebElement cancelDownloadExamButton;

	@FindBy(name = "Downloading")
	public WebElement downloadingExamStatus;

	@FindBy(name = "License Agreement")
	public WebElement lisenceAggrementLink;

	@FindBy(name = "Logout")
	public WebElement logoutButton;

	@FindBy(name = "Send Log Files")
	public WebElement sendlogfiles;

	@FindBy(name = "Help")
	public WebElement helpLink;

	@FindBy(name = "Switch Account")
	public WebElement switchAccount;

	@FindBy(id = "ExamDetailsVC_examName_lbl")
	public WebElement examName;

	@FindBy(id = "ExamDetailsVC_examNumber_txtFld")
	public WebElement examNumberDetails;

	@FindBy(id = "ExamDetailsVC_password_txtFld")
	public WebElement examPassword;

	@FindBy(id = "ExamDetailsVC_startExam_btn")
	public WebElement startExamButton;

	@FindBy(name = "Invalid Password")
	public WebElement invalidPasswordMessage;

	@FindBy(name = "OK")
	public WebElement okBtnInvalidPwd;

	@FindBy(id = "ExamDetailsVC_reverseDownload_btn")
	public WebElement reverseDownloadButton;

	@FindBy(xpath = "//*[contains(@name, 'Exam ID:')] ")
	public WebElement examIdDetails;

	@FindBy(xpath = "//*[contains(@name, 'Exam Type:')] ")
	public WebElement examTypeDetails;

	@FindBy(xpath = "//*[contains(@name, 'Time Limit:')] ")
	public WebElement timeLimitDetails;

	@FindBy(xpath = "//*[contains(@name, 'Backward Navigation:')] ")
	public WebElement navigationSetting;

	@FindBy(xpath = "//*[contains(@name, 'Highlighting:')] ")
	public WebElement hightlightingSetting;

	@FindBy(xpath = "//*[contains(@name, 'Calculator:')] ")
	public WebElement calculatorSetting;

	@FindBy(xpath = "//*[contains(@name, 'Copy & Paste:')] ")
	public WebElement copyPasteSetting;

	@FindBy(xpath = "//*[contains(@name, 'Spell Check:')] ")
	public WebElement spellCheckSetting;

	@FindBy(className = "Table")
	public WebElement examsInList;

	@FindBy(name = "Delete")
	public WebElement deleteButton;

	@FindBy(xpath = "//*[contains(@name,'Exam was last successfully uploaded on:')]")
	public WebElement examFirstUploadTime;

	public String ExamFirstUploadTime;

	public static List<WebElement> examsCells = null;

	Dimension size;
	Help help;

	public HomeMenu(AppiumDriver<WebElement> driver) {
		super(driver);
		help = new Help(driver);
	}

	/**
	 * This method is for returning require exam.
	 * 
	 * @param Exam Name
	 * @return select exam
	 */
	public WebElement selectingExamfromList(String examName) {
		WebElement selectedExam = null;
		examsCells = examsInList.findElements(By.className("Cell"));

		for (WebElement exam : examsCells) {
			if (exam.getAttribute("name").contains(examName)) {
				selectedExam = exam;
				break;
			}
		}

		return selectedExam;
	}

	/**
	 * This method is for checking the exam is present in the list or not
	 * 
	 * @param Exam Name
	 * @return Boolean
	 */
	public boolean verifyExamPresentInList(String examName) {
		boolean findExam = false;
		examsCells = examsInList.findElements(By.className("Cell"));
		for (WebElement exam : examsCells) {
			if (exam.getAttribute("name").equals(examName)) {
				findExam = true;
				break;
			}
		}
		return findExam;
	}

	/**
	 * This method is for selecting exam from exam list
	 * 
	 * @param examName
	 * 
	 */
	public void selectExamFromList(String examName) {
		selectingExamfromList(examName).click();
	}

	/**
	 * Adding Exam settings and Details in the Hashmap
	 * 
	 * @param Hashmap
	 */
	public HashMap<String, String> addingDetailsIntoMap() {
		TestUtils.map.put("examName", examName.getText());
		TestUtils.map.put("examId", examIdDetails.getText());
		TestUtils.map.put("examType", examTypeDetails.getText());
		TestUtils.map.put("timeLimit", timeLimitDetails.getText());
		TestUtils.map.put("navigation", navigationSetting.getText());
		TestUtils.map.put("hightlighting", hightlightingSetting.getText());
		TestUtils.map.put("calculator", calculatorSetting.getText());
		TestUtils.map.put("copyPaste", copyPasteSetting.getText());
		TestUtils.map.put("spellCheck", spellCheckSetting.getText());

		return TestUtils.map;
	}

	/**
	 * This method is for verifying Exam details and settings by downloading an exam
	 */
	public boolean verifyExamDetails(HashMap<String, String> examMap) {
		addingDetailsIntoMap();
		boolean flag = false;
		if (((examMap.get("examName")).equalsIgnoreCase(TestUtils.map.get("examName")))
				&& ((examMap.get("examId")).equalsIgnoreCase(TestUtils.map.get("examId")))
				&& ((examMap.get("examType")).equalsIgnoreCase(TestUtils.map.get("examType")))
				&& ((examMap.get("timeLimit")).equalsIgnoreCase(TestUtils.map.get("timeLimit")))
				&& ((examMap.get("navigation")).equalsIgnoreCase(TestUtils.map.get("navigation")))
				&& ((examMap.get("hightlighting")).equalsIgnoreCase(TestUtils.map.get("hightlighting")))
				&& ((examMap.get("calculator")).equalsIgnoreCase(TestUtils.map.get("calculator")))
				&& ((examMap.get("copyPaste")).equalsIgnoreCase(TestUtils.map.get("copyPaste")))
				&& ((examMap.get("spellCheck")).equalsIgnoreCase(TestUtils.map.get("spellCheck"))))
			flag = true;
		else
			flag = false;
		return flag;
	}

	/**
	 * This method is for verifying the Exam is in Ready to download state
	 */
	public void examStateReadyToDwnld(String exam) {
		common.isElementDiplayed(dowloadExamButton);
		selectExamFromList(exam);
		common.isElementDiplayed(dowloadExamButton);
	}

	/**
	 * This method is for Downloading exam
	 */
	public void downloadExam(String exam) {
		common.isElementDiplayed(myExamText);
		selectExamFromList(exam);
		common.isElementDiplayed(dowloadExamButton);
		dowloadExamButton.click();
		common.isElementDiplayedlongwait(examPassword);
	}

	/**
	 * This method is for cancel Downloading exam
	 */
	public void checkCanceDownloadExam(String exam) {
		common.isElementDiplayed(myExamText);
		dowloadExamButton.click();
		common.waitFor(3000);
		cancelDownloadExamButton.click();
		common.waitFor(3000);
		common.isElementDiplayed(dowloadExamButton);

	}

	/**
	 * This method is for remove downloaded exam with Reverse download button
	 */
	public void reversedownloadExam(String exam) {
		common.isElementDiplayed(reverseDownloadButton);
		reverseDownloadButton.click();
	}

	/**
	 * This method is for remove downloaded exam with swipe
	 */
	public void reverseDownloadSwipe(String examName) {
		common.waitFor(3000);
		swipeHorizontlly(272, 213, 272, 211);
	}

	/**
	 * This method is for start exam
	 */
	public void downloadAndStartExam(String examNameForVerification, String ID, String password) {
		common.isElementDiplayedlongwait(myExamText);
		selectExamFromList(examNameForVerification);
		common.isElementDiplayed(dowloadExamButton);
		dowloadExamButton.click();
		common.waitFor(3000);
		common.isElementDiplayed(examNumberDetails);
		examNumberDetails.sendKeys(ID);
		common.isElementDiplayed(examPassword);
		examPassword.sendKeys(password);
		examPassword.sendKeys(Keys.RETURN);
		common.waitFor(3000);
	}

	/**
	 * This method starts exam without downloading and with entering password
	 */
	public void startExam(String ID, String password) {
		common.isElementDiplayed(examNumberDetails);
		examNumberDetails.sendKeys(ID);
		common.isElementDiplayed(examPassword);
		examPassword.sendKeys(password);
		examPassword.sendKeys(Keys.RETURN);
		common.waitFor(3000);
	}

	/**
	 * This method is for wrong password pop-up
	 */
	public void wrongpwdpopUp() {
		common.isElementDiplayed(invalidPasswordMessage);
		okBtnInvalidPwd.click();
	}

	/**
	 * This method is for Opening Home menu
	 */
	public void openHomeMenuOptions() {
		try {
			if (helpLink.isDisplayed()) {

			} else {
				common.isElementDiplayed(homeMenuDropdown);
				homeMenuDropdown.click();
				common.isElementDiplayed(helpLink);
			}
		} catch (NoSuchElementException e) {
			common.isElementDiplayed(homeMenuDropdown);
			homeMenuDropdown.click();
			common.isElementDiplayed(helpLink);
		}
	}

	/**
	 * This method is for closing Home Menu
	 */
	public void closeHomeMenuOptions() {
		try {
			if (helpLink.isDisplayed()) {

			} else {
				common.isElementDiplayed(homeMenuDropdown);
				homeMenuDropdown.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("No such element");
		}
	}

	/**
	 * This method is for opening LicenseAgreement from Home Menu
	 */
	public void clickOnLicenseAgreementLink() {
		common.isElementDiplayed(myExamText);
		openHomeMenuOptions();
		lisenceAggrementLink.click();
		common.waitFor(5000);
	}

	/**
	 * This method is for Sending log files from Home menu
	 */
	public void clickOnSendLogFiles() {
		common.isElementDiplayed(myExamText);
		openHomeMenuOptions();
		sendlogfiles.click();
		common.waitFor(5000);
	}

	/**
	 * This method is for opening help from Home Menu
	 */
	public void clickOnHelp() {
		common.isElementDiplayed(myExamText);
		openHomeMenuOptions();
		helpLink.click();
		common.isElementDiplayed(help.welcomeButton);
	}

	/**
	 * This method is for Switching account from Home menu
	 */
	public void clickOnSwitchAccount() {
		openHomeMenuOptions();
		switchAccount.click();
	}

	/**
	 * This method is for Logging out from Home menu
	 */
	public void clickOnLogout() {
		openHomeMenuOptions();
		logoutButton.click();
	}

	/**
	 * This method is for Refreshing Exam list on Home page
	 */
	public void refreshExamList() {
		common.isElementDiplayed(refreshExamListLink);
		refreshExamListLink.click();
	}

	/**
	 * This method is for getting the first upload time of exam
	 */
	public void firstUploadDate(String examNameForVerification) {
		common.isElementDiplayedlongwait(myExamText);
		selectExamFromList(examNameForVerification);
		common.isElementDiplayedlongwait(examFirstUploadTime);
		ExamFirstUploadTime = examFirstUploadTime.getText();
	}

	/**
	 * This method is for getting the device date and time
	 * 
	 * @return current device time
	 */

	public String getDeviceTime() throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy");
		DateFormat sdf3 = new SimpleDateFormat("KK:mm a");
		Date date = sdf1.parse(driver.getDeviceTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return "Exam was last successfully uploaded on:," + sdf2.format(cal.getTime()) + " at "
				+ sdf3.format(cal.getTime());
	}

	/**
	 * This method is for checking exam ID clears
	 */
	public void downloadTwoExams(String exam1NameForVerification, String exam2NameForVerification) {
		common.isElementDiplayedlongwait(myExamText);
		selectExamFromList(exam1NameForVerification);
		common.isElementDiplayed(dowloadExamButton);
		dowloadExamButton.click();
		common.isElementDiplayed(examPassword);
		selectExamFromList(exam2NameForVerification);
		common.isElementDiplayed(dowloadExamButton);
		dowloadExamButton.click();
		common.isElementDiplayed(examPassword);
	}

	public void insertExamID(String exam1NameForVerification, String exam2NameForVerification) {
		selectExamFromList(exam1NameForVerification);
		examNumberDetails.sendKeys("exam1 ID");
		selectExamFromList(exam1NameForVerification);
		examNumberDetails.sendKeys("exam2 ID");
		selectExamFromList(exam1NameForVerification);
		System.out.println(examNumberDetails.getText() + "ID is not here");
	}

	/**
	 * This method is for Swiping Horizontally on with given location. This is for
	 * reverse download exam
	 */
	public void swipeHorizontlly(int fromX, int fromY, int toX, int toY) {
		TouchAction action = new TouchAction(driver);
		int startY = fromY;
		int startX = fromX;
		int endX = toX;
		int endY = toY;
		action.press(startX, startY).waitAction(4000).moveTo(-endX, (-endY + 300)).release().perform();
	}
}

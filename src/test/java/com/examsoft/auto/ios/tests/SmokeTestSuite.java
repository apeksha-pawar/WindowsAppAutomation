package com.examsoft.auto.ios.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.AlarmExam;
import com.examsoft.auto.ios.core.pages.CalculatorTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.EssayType;
import com.examsoft.auto.ios.core.pages.ExamHomeScreen;
import com.examsoft.auto.ios.core.pages.ExamUploadSuccessfull;
import com.examsoft.auto.ios.core.pages.FiTBType;
import com.examsoft.auto.ios.core.pages.ForgotInstitutionID;
import com.examsoft.auto.ios.core.pages.Help;
import com.examsoft.auto.ios.core.pages.HideExam;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InExam;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.McqType;
import com.examsoft.auto.ios.core.pages.NotesInExam;
import com.examsoft.auto.ios.core.pages.NoticeScreen;
import com.examsoft.auto.ios.core.pages.QuestionFlag;
import com.examsoft.auto.ios.core.pages.RemoveExamDownload;
import com.examsoft.auto.ios.core.pages.SendLogFiles;
import com.examsoft.auto.ios.core.pages.TrueFalseType;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

/**
 * Created by synerzip on 16/11/16.
 */
public class SmokeTestSuite extends BaseTest {
	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ForgotInstitutionID forgotInstitutionID;
	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;
	LogOut logout;
	Help help;
	SendLogFiles sendLogFiles;
	RemoveExamDownload removeExamDownload;
	NoticeScreen noticeScreen;
	WaitScreen waitScreen;
	InExam inExam;
	ExamHomeScreen examHomeScreen;
	UploadExam uploadExam;
	ExamUploadSuccessfull examUploadSuccessfull;
	McqType mcqType;
	EssayType essayType;
	FiTBType fitbType;
	TrueFalseType trueFalseType;
	NotesInExam notesInExam;
	CalculatorTest calculatorTest;
	QuestionFlag questionFlag;
	AlarmExam alarmExam;
	HideExam hideExam;
	String time;

	List<WebElement> filterList = new ArrayList<WebElement>();
	int[] intArray = new int[] { 8, 1, 1, 9 };

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		forgotInstitutionID = new ForgotInstitutionID(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);
		help = new Help(driver);
		sendLogFiles = new SendLogFiles(driver);
		removeExamDownload = new RemoveExamDownload(driver);
		noticeScreen = new NoticeScreen(driver);
		waitScreen = new WaitScreen(driver);
		inExam = new InExam(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessfull = new ExamUploadSuccessfull(driver);
		mcqType = new McqType(driver);
		essayType = new EssayType(driver);
		fitbType = new FiTBType(driver);
		trueFalseType = new TrueFalseType(driver);
		notesInExam = new NotesInExam(driver);
		calculatorTest = new CalculatorTest(driver);
		questionFlag = new QuestionFlag(driver);
		alarmExam = new AlarmExam(driver);
		hideExam = new HideExam(driver);

		filterList.add(examHomeScreen.filterAnsweredQuestion);
		filterList.add(examHomeScreen.filterUnansweredQuestion);
		filterList.add(examHomeScreen.filterFlaggedQuestion);
		filterList.add(examHomeScreen.filterAllQuestion);
		chooseAnAccount.acceptEULAOnEULAbychooseAcc();

	}

	@Test(priority = 1, enabled = true)
	public void AcceptEULA() throws Exception {
		agreeEULA.acceptEula();
		assertTrue(common.isElementDiplayed(institutionId.clickNextButton));
	}

	@Test(priority = 2, enabled = true)
	public void SelectionOfLADAPInstitutionID() throws Exception {
		institutionId.selectInstitute(TestUtils.ldapSchool, TestUtils.ldapSchoolID);
		assertTrue(login.signInButton.isDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void LDAPLogin() throws Exception {
		login.login(TestUtils.ldapET, TestUtils.ldapPassword);
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(common.isElementDiplayed(chooseAnAccount.addNewAccountButton));
	}

	@Test(priority = 4, enabled = true)
	public void SelectionOfInstitutionID() throws Exception {
		chooseAnAccount.addNewAccount();
		institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
		assertTrue(login.signInButton.isDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void SuccessfulLogin() throws Exception {
		login.login(TestUtils.defaultUsername, TestUtils.defaultPassword);
		assertTrue(homeMenu.homeMenuDropdown.isEnabled());
	}

	@Test(priority = 6, enabled = true)
	public void SwitchAccount() {
		homeMenu.openHomeMenuOptions();
		assertTrue(homeMenu.helpLink.isDisplayed());
		homeMenu.clickOnSwitchAccount();
		assertTrue(common.isElementDiplayed(chooseAnAccount.addNewAccountButton));
		chooseAnAccount.chooseSameAccountAfterSwitching(TestUtils.defaultUsername);
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
	}

	@Test(priority = 7, enabled = true)
	public void DownloadExam() {
		homeMenu.downloadExam(TestUtils.bigExamWithoutStatus);
		homeMenu.verifyExamDetails(TestUtils.bigExamMap);
		assertTrue(homeMenu.verifyExamDetails(TestUtils.bigExamMap));
	}

	@Test(priority = 8, enabled = true)
	public void RevereDownloadExam() {
		homeMenu.reversedownloadExam(TestUtils.bigExamWithoutStatus);
		removeExamDownload.acceptRemoveDownload();
		removeExamDownload.clickRemoveDownload();
		homeMenu.examStateReadyToDwnld(TestUtils.bigExamWithoutStatus);
		assertTrue(homeMenu.dowloadExamButton.isDisplayed());
	}

	@Test(priority = 9, enabled = true)
	public void HelpSupportPages() {
		homeMenu.clickOnHelp();
		assertTrue(help.welcomeButton.isDisplayed());
		help.openWelcomePage();
		assertTrue(help.liveChatButton.isDisplayed());
		help.authenticationHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.examDownloadHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.beforeExamHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.swichAccountHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.duringExamHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.utilizingAppHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.backToDashboardPage();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

	@Test(priority = 10, enabled = false)
	public void LicenseAggrementPage() {
		homeMenu.clickOnLicenseAgreementLink();
		agreeEULA.closeEula();
		assertTrue(homeMenu.homeMenuDropdown.isDisplayed());
	}

	@Test(priority = 11, enabled = true)
	public void SendLogs() {
		homeMenu.clickOnSendLogFiles();
		sendLogFiles.sendLog();
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
	}

	@Test(priority = 12, enabled = true)
	public void NoticeScreenBeforeExam() throws Exception {
		homeMenu.downloadAndStartExam(TestUtils.bigExamWithoutStatus, "ID", "test01");
		noticeScreen.moveAheadToEndNoticePage();
		noticeScreen.clickNextButton();
		assertFalse(waitScreen.startEaxmButton.isEnabled());
		waitScreen.waitScreenBeforeExam();
		assertTrue(inExam.closeButtonNotice.isDisplayed());
	}

	@Test(priority = 13, enabled = true)
	public void AnsweringQuestions() throws Exception {
		inExam.closeButtonNotice.click();
		inExam.AnsweringQuestions();
		for (int j = 0; j <= (inExam.numOfQuestions - 1); j++) {
			String question = String.valueOf(j);
			inExam.navigateQuestionAndAnswerForAllFourTypes();
			TestUtils.map.put(question, inExam.examQuestionType);
			inExam.nextQuestionButton.click();
		}
		common.isElementDiplayed(examHomeScreen.returnToExam);
		examHomeScreen.returnToExam.click();
	}

	@Test(priority = 14, enabled = true)
	public void HideExam() throws Exception {
		examHomeScreen.HideExam();
		hideExam.ResumeExam();
		AssertJUnit.assertTrue(common.isElementDiplayed(examHomeScreen.examMenuDropdown));
	}

	@Test(priority = 15, enabled = true)
	public void examNotes() throws Exception {
		inExam.rightSidePanelopen();
		notesInExam.NotesMaxLimit();
		assertTrue(notesInExam.numInt == 1070);
		notesInExam.closeNotesPanel();
		inExam.previousQuestionButton.click();
		inExam.rightSidePanelopen();
		notesInExam.NotesCheck();
		assertTrue(notesInExam.numInt > 0);
		notesInExam.closeNotesPanel();
		inExam.previousQuestionButton.click();
	}

	@Test(priority = 16, enabled = true)
	public void examCalculator() throws Exception {
		inExam.queEight.click();
		inExam.rightSidePanelopen();
		calculatorTest.openCalculator();
		calculatorTest.calculateAddition(79, 83);
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals("162"));
		calculatorTest.calculateTan(45);
		calculatorTest.verifyTanInCalc();
		assertTrue(calculatorTest.result.equals("1"));
	}

	@Test(priority = 17, enabled = true)
	public void examFlag() throws Exception {
		inExam.previousQuestionButton.click();
		questionFlag.flagQuestion();
		assertTrue(questionFlag.flaggedQue.isDisplayed());
		questionFlag.unflagQuestion();
		assertTrue(questionFlag.unflaggedQue.isDisplayed());
		questionFlag.flagQuestion();
		assertTrue(questionFlag.flaggedQue.isDisplayed());
	}

	@Test(priority = 18, enabled = true)
	public void questionFilter() throws Exception {
		inExam.clearEssayque();
		int counter = 1;
		for (WebElement filter : filterList) {
			examHomeScreen.selectFilter();
			common.waitFor(500);
			filter.click();
			assertTrue(examHomeScreen.leftsideTable.size() == intArray[counter - 1]);
			counter++;
		}
	}

	@Test(priority = 19, enabled = true)
	public void addAlarm() throws Exception {
		inExam.queEight.click();
		inExam.rightSidePanelopen();
		alarmExam.addAlarm("2", "11", "20");
		assertTrue(alarmExam.verifysetAlarm("02", "10"));
	}

	@Test(priority = 20, enabled = true)
	public void deleteAlarm() throws Exception {
		inExam.queOne.click();
		inExam.rightSidePanelopen();
		alarmExam.deleteAlarm();
		assertTrue(alarmExam.verifyDeleteAlarm());
	}

	@Test(priority = 21, enabled = true)
	public void submitExam() throws Exception {
		examHomeScreen.SubmitExamwithAlert();
		uploadExam.uploadExamOnScoring();
		time = homeMenu.getDeviceTime();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
	}

	@Test(priority = 22, enabled = true)
	public void verifyExamUpload() throws Exception {
		homeMenu.firstUploadDate(TestUtils.bigExamWithoutStatus);
		assertTrue(homeMenu.ExamFirstUploadTime.equals(time));
	}

	@Test(priority = 23, enabled = true)
	public void SuccessfulLogout() throws Exception {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(common.isElementDiplayed(chooseAnAccount.chooseAnAccountText));
	}

}
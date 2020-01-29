package com.examsoft.auto.ios.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.AlarmExam;
import com.examsoft.auto.ios.core.pages.CalculatorTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.DashBoardInfo;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.EssayType;
import com.examsoft.auto.ios.core.pages.ExamHomeScreen;
import com.examsoft.auto.ios.core.pages.ExamUploadSuccessfull;
import com.examsoft.auto.ios.core.pages.FiTBType;
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
import com.examsoft.auto.ios.core.pages.TrueFalseType;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_NonSecure_Exam extends BaseTest {
	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;
	LogOut logout;
	RemoveExamDownload removeExamDownload;
	NoticeScreen noticeScreen;
	WaitScreen waitScreen;
	InExam inExam;
	ExamHomeScreen examHomeScreen;
	UploadExam uploadExam;
	ExamUploadSuccessfull examUploadSuccessfull;
	InExam VerifyStartExam;
	McqType mcqType;
	EssayType essayType;
	FiTBType fitbType;
	TrueFalseType trueFalseType;
	NotesInExam notesInExam;
	CalculatorTest calculatorTest;
	QuestionFlag questionFlag;
	AlarmExam alarmExam;
	HideExam hideExam;
	DashBoardInfo dashBoardInfo;
	String time;

	List<WebElement> filterList = new ArrayList<WebElement>();
	int[] intArray = new int[] { 8, 1, 1, 9 };

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);
		removeExamDownload = new RemoveExamDownload(driver);
		noticeScreen = new NoticeScreen(driver);
		waitScreen = new WaitScreen(driver);
		inExam = new InExam(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessfull = new ExamUploadSuccessfull(driver);
		VerifyStartExam = new InExam(driver);
		mcqType = new McqType(driver);
		essayType = new EssayType(driver);
		fitbType = new FiTBType(driver);
		trueFalseType = new TrueFalseType(driver);
		notesInExam = new NotesInExam(driver);
		calculatorTest = new CalculatorTest(driver);
		questionFlag = new QuestionFlag(driver);
		alarmExam = new AlarmExam(driver);
		hideExam = new HideExam(driver);
		dashBoardInfo = new DashBoardInfo(driver);

		filterList.add(examHomeScreen.filterAnsweredQuestion);
		filterList.add(examHomeScreen.filterUnansweredQuestion);
		filterList.add(examHomeScreen.filterFlaggedQuestion);
		filterList.add(examHomeScreen.filterAllQuestion);

		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(true, true);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.addNewAccountButton.isDisplayed());
	}

	@Test(priority = 1, enabled = true)
	public void noticeScreenBeforeExam() throws Exception {
		homeMenu.downloadAndStartExam(TestUtils.bigExamWithoutStatus, "ID", "test01");
		noticeScreen.moveAheadToEndNoticePage();
		noticeScreen.clickNextButton();
		waitScreen.waitScreenBeforeExam();
	}

	@Test(priority = 2, enabled = true)
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

	@Test(priority = 3, enabled = true)
	public void HideExam() throws Exception {
		examHomeScreen.HideExam();
		hideExam.ResumeExam();
		assertTrue(common.isElementDiplayed(examHomeScreen.examMenuDropdown));
	}

	@Test(priority = 4, enabled = true)
	public void Verify_HideShowQue() {
		dashBoardInfo.hideQue();
		dashBoardInfo.showQue();
		assertTrue(dashBoardInfo.QueText.isDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void examFlag() throws Exception {
		inExam.previousQuestionButton.click();
		questionFlag.flagQuestion();
		assertTrue(questionFlag.flaggedQue.isDisplayed());
		questionFlag.unflagQuestion();
		assertTrue(questionFlag.unflaggedQue.isDisplayed());
		questionFlag.flagQuestion();
		assertTrue(questionFlag.flaggedQue.isDisplayed());
	}

	@Test(priority = 6, enabled = true)
	public void questionFilter() throws Exception {
		inExam.queSeven.click();
		essayType.clearEssayTextField();
		inExam.clickOnNextQuestion();
		int counter = 1;
		for (WebElement filter : filterList) {
			examHomeScreen.selectFilter();
			filter.click();
			assertTrue(inExam.leftSidePanel.size() == intArray[counter - 1]);
			counter++;
		}
	}

	@Test(priority = 7, enabled = true)
	public void returnSubmitExam() throws Exception {
		examHomeScreen.returnExamwithAlert();
		assertTrue(examHomeScreen.examMenuDropdown.isDisplayed());
	}

	@Test(priority = 8, enabled = true)
	public void returnExam() throws Exception {
		examHomeScreen.SubmitExamwithAlert();
		uploadExam.returnToExam();
		assertTrue(examHomeScreen.examMenuDropdown.isDisplayed());
	}

	@Test(priority = 9, enabled = true)
	public void submitExam() throws Exception {
		examHomeScreen.SubmitExamwithAlert();
		uploadExam.uploadExamOnScoring();
		time = homeMenu.getDeviceTime();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

	@Test(priority = 10, enabled = true)
	public void verifyExamUpload() throws Exception {
		homeMenu.firstUploadDate(TestUtils.bigExamWithoutStatus);
		assertTrue(homeMenu.ExamFirstUploadTime.equals(time));
	}

}
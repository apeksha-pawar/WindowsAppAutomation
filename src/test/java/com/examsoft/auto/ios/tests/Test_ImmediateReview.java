package com.examsoft.auto.ios.tests;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.EssayType;
import com.examsoft.auto.ios.core.pages.ExamHomeScreen;
import com.examsoft.auto.ios.core.pages.ExamReview;
import com.examsoft.auto.ios.core.pages.ExamUploadSuccessfull;
import com.examsoft.auto.ios.core.pages.FiTBType;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InExam;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.McqType;
import com.examsoft.auto.ios.core.pages.TrueFalseType;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_ImmediateReview extends BaseTest {
	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;
	LogOut logout;
	TrueFalseType trueFalseType;
	ExamReview examReview;
	WaitScreen waitScreen;
	ExamHomeScreen examHomeScreen;
	UploadExam uploadExam;
	ExamUploadSuccessfull examUploadSuccessfull;
	McqType mcqType;
	EssayType essayType;
	FiTBType fiTBType;
	InExam inExam;

	public HashMap<String, String> accMap = new HashMap<String, String>();
	public HashMap<String, String> normalMap = new HashMap<String, String>();
	String examTypeAccET = null;
	String examType = null;
	String examSpellCheck = null;
	String examSpellCheckAccET = null;
	String examTimerAccET = null;
	String examTimer = null;

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);
		mcqType = new McqType(driver);
		trueFalseType = new TrueFalseType(driver);
		essayType = new EssayType(driver);
		fiTBType = new FiTBType(driver);
		inExam = new InExam(driver);
		examReview = new ExamReview(driver);
		waitScreen = new WaitScreen(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessfull = new ExamUploadSuccessfull(driver);

		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(false, false);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(common.isElementDiplayed(chooseAnAccount.chooseAnAccountText));
	}

	@Test(priority = 1, enabled = true)
	public void loginAccommodationET() {
		institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
		assertTrue(login.signInButton.isDisplayed());
		login.login(TestUtils.AccommodationET, TestUtils.AccommodationPwd);
		common.waitForElementLong(homeMenu.myExamText);
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

	@Test(priority = 2, enabled = true)
	public void downloadImmediateReviewExam() {
		homeMenu.downloadExam(TestUtils.immediateReviewExam);
		homeMenu.startExam("ID", "test01");
		waitScreen.waitScreenBeforeExam();
		mcqType.selectChoiceA();
		inExam.nextQuestionButton.click();
		essayType.writeUptoLimit();
		inExam.nextQuestionButton.click();
		fiTBType.reviewAnswerFiTB();
		inExam.nextQuestionButton.click();
		trueFalseType.selectTrue();
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		assertTrue(examReview.cancelReviewButton.isDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void ImmediateExamReview() {
		examReview.enteringInReview("test01");
		assertTrue(examReview.correctlyAnsweredQue());
		inExam.nextQuestionButton.click();
		essayType.checkWrittenCharacterLimit();
		assertTrue(essayType.writtenCharacters > 0);
		inExam.nextQuestionButton.click();
		assertTrue(examReview.correctlyAnsweredQue());
		inExam.nextQuestionButton.click();
		assertTrue(examReview.correctlyAnsweredQue());
		examReview.submitReview();
		uploadExam.confirmExitExam();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

}

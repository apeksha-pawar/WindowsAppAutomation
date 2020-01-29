package com.examsoft.auto.ios.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.ExamHomeScreen;
import com.examsoft.auto.ios.core.pages.ExamReview;
import com.examsoft.auto.ios.core.pages.ExamUploadSuccessfull;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InExam;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.TrueFalseType;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_WrongAnsOnlyReview_ExitReview extends BaseTest {
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
	InExam inExam;

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);
		trueFalseType = new TrueFalseType(driver);
		examReview = new ExamReview(driver);
		waitScreen = new WaitScreen(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessfull = new ExamUploadSuccessfull(driver);
		inExam = new InExam(driver);

		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(false, false);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.addNewAccountButton.isDisplayed());
	}

	@Test(priority = 1, enabled = true)
	public void loginAccommodationET() {
		institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
		assertTrue(login.signInButton.isDisplayed());
		login.login(TestUtils.AccommodationET, TestUtils.AccommodationPwd);
		common.isElementDiplayedlongwait(homeMenu.homeMenuDropdown);
		assertTrue(homeMenu.homeMenuDropdown.isDisplayed());
	}

	@Test(priority = 2, enabled = true)
	public void exitReviewWithWrongPwd() {
		homeMenu.downloadExam(TestUtils.examToCheckRules);
		homeMenu.startExam("ID", "test01");
		waitScreen.waitScreenBeforeExam();
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		assertTrue(examReview.startReviewButton.isDisplayed());
		for (int i = 0; i <= 2; i++) {
			examReview.enteringInReview("wrongpassword");
			assertTrue(homeMenu.invalidPasswordMessage.isDisplayed());
			homeMenu.okBtnInvalidPwd.click();
		}
		examReview.exitReview();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void wrongAnsOnlyReviewWithRightAns() {
		homeMenu.downloadExam(TestUtils.examToCheckRules);
		homeMenu.startExam("ID", "test01");
		waitScreen.waitScreenBeforeExam();
		trueFalseType.selectTrue();
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		assertTrue(examReview.startReviewButton.isDisplayed());
		examReview.enteringInReview("test01");
		examReview.closeIfNothingToReview();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

	@Test(priority = 4, enabled = true)
	public void wrongAnsOnlyReviewWithWrongAns() {
		homeMenu.downloadExam(TestUtils.examToCheckRules);
		homeMenu.startExam("ID", "test01");
		waitScreen.waitScreenBeforeExam();
		trueFalseType.selectTrueFalse();
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		assertTrue(examReview.startReviewButton.isDisplayed());
		examReview.enteringInReview("test01");
		assertTrue(examReview.incorrectlyAnsQue());
		examReview.submitReview();
		uploadExam.confirmExitExam();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void wrongAnsOnlyReviewWithNotAns() {
		homeMenu.downloadExam(TestUtils.examToCheckRules);
		homeMenu.startExam("ID", "test01");
		waitScreen.waitScreenBeforeExam();
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		assertTrue(examReview.startReviewButton.isDisplayed());
		examReview.enteringInReview("test01");
		assertTrue(examReview.notAnsQue());
		examReview.submitReview();
		uploadExam.confirmExitExam();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}
}

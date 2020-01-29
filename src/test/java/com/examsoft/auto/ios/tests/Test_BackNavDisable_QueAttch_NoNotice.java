package com.examsoft.auto.ios.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.ExamHomeScreen;
import com.examsoft.auto.ios.core.pages.ExamUploadSuccessfull;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InExam;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

/**
 * 
 * @author Sanjyot
 * 
 *         (Non-secure pw is exam123
 *
 */
public class Test_BackNavDisable_QueAttch_NoNotice extends BaseTest {
	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;
	LogOut logout;
	WaitScreen waitScreen;
	InExam inExam;
	ExamHomeScreen examHomeScreen;
	UploadExam uploadExam;
	ExamUploadSuccessfull examUploadSuccessful;

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);
		waitScreen = new WaitScreen(driver);
		inExam = new InExam(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessful = new ExamUploadSuccessfull(driver);
		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(true, true);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.chooseAnAccountText.isDisplayed());
	}

	@Test(priority = 1, enabled = true)
	public void examWithoutNoticeScreen() throws Exception {
		homeMenu.downloadAndStartExam(TestUtils.smallExamWithoutStatus, "ID", "test01");
		waitScreen.waitScreenBeforeExam();
	}

	@Test(priority = 2, enabled = true)
	public void examWithBackwardNavigationDisable() throws Exception {
		inExam.answeringMcqQue();
		int currentNumBefore = inExam.CurrentQuestion();
		inExam.backwardNavigationDisable();
		int currentNum = inExam.CurrentQuestion();
		assertTrue(currentNumBefore == currentNum);
	}

	@Test(priority = 3, enabled = true)
	public void calcDisable() throws Exception {
		assertFalse(inExam.CalculatorEnableDisable());

	}

	@Test(priority = 4, enabled = true)
	public void questionAttachmentAutoOpen() throws Exception {
		assertTrue((examHomeScreen.rightSidePanelCloseButton.isDisplayed())
				&& (examHomeScreen.questionAttachmentPopOut.isDisplayed()));
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		examUploadSuccessful.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}
}
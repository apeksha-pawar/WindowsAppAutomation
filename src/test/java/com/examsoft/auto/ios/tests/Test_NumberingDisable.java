package com.examsoft.auto.ios.tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
import com.examsoft.auto.ios.core.pages.NoticeScreen;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_NumberingDisable extends BaseTest {

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
	ExamUploadSuccessfull examUploadSuccessfull;
	NoticeScreen noticeScreen;

	List<String> questionTextList = new ArrayList<String>();
	static Logger log = Logger.getLogger(SmokeTestSuite.class.getName());

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);
		noticeScreen = new NoticeScreen(driver);
		waitScreen = new WaitScreen(driver);
		inExam = new InExam(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessfull = new ExamUploadSuccessfull(driver);

		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(true, true);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(common.isElementDiplayed(chooseAnAccount.chooseAnAccountText));
	}

	@Test
	public void numberingDisableExam() throws Exception {
		homeMenu.downloadAndStartExam(TestUtils.numberingOffExam, "ID", "test01");
		waitScreen.waitScreenBeforeExam();
		inExam.closeButtonNotice.click();
		try {
			examHomeScreen.selectFilter();
			assertFalse(examHomeScreen.filterIconButton.isDisplayed());
		} catch (Exception e) {

		}

		try {
			inExam.CurrentQuestion();
			int i = 1;
			assertFalse(inExam.CurrentQuestion() == i);
		} catch (Exception e) {
		}
		assertFalse(inExam.queOne.isDisplayed());
		inExam.nextQuestionButton.click();
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}
}

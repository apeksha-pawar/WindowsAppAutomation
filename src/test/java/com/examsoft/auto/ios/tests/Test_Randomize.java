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

public class Test_Randomize extends BaseTest {

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

		questionTextList.add(TestUtils.Randomization_off1);
		questionTextList.add(TestUtils.Randomization_off2);
		questionTextList.add(TestUtils.Randomization_off3);
		questionTextList.add(TestUtils.Randomization_off4);
		questionTextList.add(TestUtils.Randomization_off5);
		questionTextList.add(TestUtils.Randomization_off6);
		questionTextList.add(TestUtils.Randomization_off7);
		questionTextList.add(TestUtils.Randomization_off8);
		questionTextList.add(TestUtils.Randomization_off9);
		questionTextList.add(TestUtils.Randomization_off10);
		questionTextList.add(TestUtils.Randomization_off11);
		questionTextList.add(TestUtils.Randomization_off12);
		questionTextList.add(TestUtils.Randomization_off13);
		questionTextList.add(TestUtils.Randomization_off14);

		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(true, true);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.addNewAccountButton.isDisplayed());
	}

	@Test(priority = 1, enabled = true) // Randomize Exam
	public void randomizeONExam() throws Exception {
		int flag = 0;
		homeMenu.downloadAndStartExam(TestUtils.randomizeExam, "ID", "test01");
		noticeScreen.moveAheadToEndNoticePage();
		assertTrue(noticeScreen.nextButton.isEnabled());
		noticeScreen.clickNextButton();
		waitScreen.waitScreenBeforeExam();
		inExam.closeButtonNotice.click();
		for (String questionText : questionTextList) {
			if (questionText.equalsIgnoreCase(inExam.queText.getText())) {
				inExam.nextQuestionButton.click();
				continue;
			} else {
				flag = 1;
				break;
			}
		}
		assertTrue(flag == 1);
	}

	@Test(priority = 2, enabled = true)
	public void submitExam() throws Exception {
		examHomeScreen.SubmitExamwithAlert();
		uploadExam.uploadExamOnScoring();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}
}
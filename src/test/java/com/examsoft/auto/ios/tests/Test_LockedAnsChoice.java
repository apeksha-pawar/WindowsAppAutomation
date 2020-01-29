package com.examsoft.auto.ios.tests;

import java.util.ArrayList;
import java.util.List;

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
import com.examsoft.auto.ios.core.pages.McqType;
import com.examsoft.auto.ios.core.pages.NoticeScreen;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_LockedAnsChoice extends BaseTest {

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
	McqType mcqType;

	List<String> questionTextList = new ArrayList<String>();

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
		mcqType = new McqType(driver);

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

	@Test(priority = 1, enabled = true) // Locked Answer choices in the exam
	public void lockedAnswerChoice() throws Exception {
		homeMenu.downloadAndStartExam(TestUtils.randomizeExam, "ID", "test01");
		noticeScreen.moveAheadToEndNoticePage();
		noticeScreen.clickNextButton();
		waitScreen.waitScreenBeforeExam();
		inExam.closeButtonNotice.click();
		for (@SuppressWarnings("unused")
		String questionText : questionTextList) {
			if (TestUtils.Randomization_off14.equalsIgnoreCase(inExam.queText.getText())) {
				mcqType.choicesText();
				break;
			} else {
				inExam.nextQuestionButton.click();
				continue;
			}
		}
		assertTrue((mcqType.mcqChoicesText1.equalsIgnoreCase(TestUtils.lockedChoice1)
				&& mcqType.mcqChoicesText2.equalsIgnoreCase(TestUtils.lockedChoice2))
				&& ((mcqType.mcqChoicesText3 != TestUtils.lockedChoice3)
						|| (mcqType.mcqChoicesText4 != TestUtils.lockedChoice4)
						|| (mcqType.mcqChoicesText5 != TestUtils.lockedChoice5)
						|| (mcqType.mcqChoicesText6 != TestUtils.lockedChoice6)));
	}

	@Test(priority = 2, enabled = true)
	public void submitExam() throws Exception {
		examHomeScreen.SubmitExamwithAlert();
		uploadExam.uploadExamOnScoring();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
	}
}
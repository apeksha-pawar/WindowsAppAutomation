package com.examsoft.auto.ios.tests;

import java.util.HashMap;

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
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.RemoveExamDownload;
import com.examsoft.auto.ios.core.pages.TrueFalseType;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

/**
 * 
 * @author Sanjyot This test is to test Accommodation Rules of ET with examType,
 *         spellCheck, timeLimit. Comparison of the Accommodation ET with
 *         Regular ET and process to cancel review
 * 
 *         Pre-requisite- Exam should be in list
 *         (Accommodation_Review_WrongAns_2 min_spellOff_sec
 *
 */
public class Test_Accommodation_Rules_CancelReview extends BaseTest {
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
	RemoveExamDownload removeExamDownload;

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
		trueFalseType = new TrueFalseType(driver);
		examReview = new ExamReview(driver);
		waitScreen = new WaitScreen(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessfull = new ExamUploadSuccessfull(driver);
		removeExamDownload = new RemoveExamDownload(driver);
		chooseAnAccount.acceptEULAOnEULAbychooseAcc();
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(common.isElementDiplayed(chooseAnAccount.chooseAnAccountText));
	}

	@Test(priority = 1, enabled = true)
	public void AcceptEULA() throws Exception {
		agreeEULA.acceptEula();
		assertTrue(common.isElementDiplayed(institutionId.clickNextButton));
	}

	@Test(priority = 2, enabled = true)
	public void loginAccommodationET() {
		institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
		assertTrue(login.signInButton.isDisplayed());
		login.login(TestUtils.AccommodationET, TestUtils.AccommodationPwd);
		homeMenu.downloadExam(TestUtils.examToCheckRules);
		homeMenu.verifyExamDetails(TestUtils.accommodationRulesExamMap);
		assertTrue(homeMenu.verifyExamDetails(TestUtils.accommodationRulesExamMap));
		accMap = homeMenu.addingDetailsIntoMap();
		examTypeAccET = accMap.get("examType");
		examSpellCheckAccET = accMap.get("spellCheck");
		examTimerAccET = accMap.get("timeLimit");
	}

	@Test(priority = 3, enabled = true)
	public void wrongAnsOnlyReviewCancelReview() {
		homeMenu.startExam("ID", "test01");
		waitScreen.waitScreenBeforeExam();
		trueFalseType.selectTrue();
		examHomeScreen.SubmitExam();
		uploadExam.confirmExitExam();
		examReview.cancelReview();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
		homeMenu.clickOnSwitchAccount();
		assertTrue(chooseAnAccount.addNewAccountButton.isDisplayed());
	}

	@Test(priority = 4, enabled = true)
	public void checkExamRulesNormalET() {
		chooseAnAccount.addNewAccount();
		institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
		login.login(TestUtils.defaultUsername, TestUtils.defaultPassword);
		homeMenu.downloadExam(TestUtils.examToCheckRules);
		homeMenu.verifyExamDetails(TestUtils.normalExamMap);
		assertTrue(homeMenu.verifyExamDetails(TestUtils.normalExamMap));
		normalMap = homeMenu.addingDetailsIntoMap();
		examType = normalMap.get("examType");
		examSpellCheck = normalMap.get("spellCheck");
		examTimer = normalMap.get("timeLimit");
		homeMenu.reversedownloadExam(TestUtils.examToCheckRules);
		removeExamDownload.acceptRemoveDownload();
		removeExamDownload.clickRemoveDownload();
		homeMenu.examStateReadyToDwnld(TestUtils.examToCheckRules);
		assertTrue(homeMenu.dowloadExamButton.isDisplayed());

	}

	@Test(priority = 5, enabled = true)
	public void compareAccommodationWithNormal() {
		boolean isAllAccommodationApplied = false;
		if ((examTypeAccET.equalsIgnoreCase(examType)) && (examSpellCheckAccET.equalsIgnoreCase(examSpellCheck))
				&& (examTimerAccET.equalsIgnoreCase(examTimer))) {
			isAllAccommodationApplied = false;
		} else {
			isAllAccommodationApplied = true;
		}
		assertTrue(isAllAccommodationApplied);
	}
}
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
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.ExamHomeScreen;
import com.examsoft.auto.ios.core.pages.ExamUploadSuccessfull;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InExam;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.NotesInExam;
import com.examsoft.auto.ios.core.pages.NoticeScreen;
import com.examsoft.auto.ios.core.pages.UploadExam;
import com.examsoft.auto.ios.core.pages.WaitScreen;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_RightHandSidePanel extends BaseTest {
	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;
	LogOut logout;
	NoticeScreen noticeScreen;
	WaitScreen waitScreen;
	InExam inExam;
	ExamHomeScreen examHomeScreen;
	UploadExam uploadExam;
	ExamUploadSuccessfull examUploadSuccessfull;
	InExam VerifyStartExam;
	NotesInExam notesInExam;
	CalculatorTest calculatorTest;
	AlarmExam alarmExam;
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
		noticeScreen = new NoticeScreen(driver);
		waitScreen = new WaitScreen(driver);
		inExam = new InExam(driver);
		examHomeScreen = new ExamHomeScreen(driver);
		uploadExam = new UploadExam(driver);
		examUploadSuccessfull = new ExamUploadSuccessfull(driver);
		VerifyStartExam = new InExam(driver);
		notesInExam = new NotesInExam(driver);
		calculatorTest = new CalculatorTest(driver);
		alarmExam = new AlarmExam(driver);

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
		inExam.closeButtonNotice.click();
	}

	@Test(priority = 2, enabled = true)
	public void examNotes() throws Exception {
		inExam.queSeven.click();
		notesInExam.NotesMaxLimit();
		assertTrue(notesInExam.numInt == 1070);
		notesInExam.closeNotesPanel();
		inExam.verifyLeftSidePanel();
		notesInExam.NotesCheck();
		assertTrue(notesInExam.numInt > 0);
		notesInExam.closeNotesPanel();
		inExam.previousQuestionButton.click();
	}

	/**
	 * This test verifies addition of 79+83=162 and tan of 45 =1
	 */
	@Test(priority = 3, enabled = true)
	public void examCalculator() throws Exception {
		inExam.queEight.click();
		inExam.rightSidePanelopen();
		calculatorTest.openCalculator();
		calculatorTest.calculateAddition(TestUtils.add2num1, TestUtils.add2num2);
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.add2numResult));
		calculatorTest.calculateTan(TestUtils.tanNum);
		calculatorTest.verifyTanInCalc();
		assertTrue(calculatorTest.result.equals(TestUtils.tannumResult));
	}

	// This test verifies Divide by zero
	@Test(priority = 4, enabled = true)
	public void divideByZero() {
		int i = 0;
		do {
			calculatorTest.divideByZero(TestUtils.divideBy0num1, TestUtils.divideBy0);
			calculatorTest.verifyDivideByZero();
			assertTrue(calculatorTest.result.equals(TestUtils.divideBy0Result));
			i++;
		} while (i < 2);
	}

	@Test(priority = 5, enabled = true)
	public void basicFunctions() {
		// Verify Operation 47+48+90=185
		calculatorTest.addThreeNumbers(TestUtils.add3num1, TestUtils.add3num2, TestUtils.add3num3);
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.add3numResult));
		// Verify Operation 1000/85 = 11.764706
		calculatorTest.performDivision(TestUtils.div2num1, TestUtils.div2num2);
		calculatorTest.verifyDivision();
		assertTrue(calculatorTest.result.equals(TestUtils.div2numResult));

	}

	@Test(priority = 6, enabled = true)
	public void complexFunctions() {
		// Verifying division 00000.35 / 00000.36 = 0.972222
		calculatorTest.performDecimalDivision(TestUtils.divDeci2num1, TestUtils.divDesi2num2);
		calculatorTest.verifyDecimalDivision();
		assertTrue(calculatorTest.result.equals(TestUtils.divDeci2numResult));

		// Verify operation 6! =720
		calculatorTest.Nfacto(TestUtils.factoNum);
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.factoNumResult));

		// Verify operation sq.rt of 81 =9
		calculatorTest.SquareRoot(TestUtils.sqrtNum);
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.sqrtNumResult));

		// Verify operation sq.rt of sq.rt of 81 =3
		calculatorTest.ClickSquareRoot(TestUtils.sqrtNum2);
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.sqrtSqrtNumResult));

		// Verify value of Pi =3.141593
		calculatorTest.ClickPi();
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.piResult));

		// Verify reciprocal value of Pi = 0.31831
		calculatorTest.ClickReciprocal();
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.piReciprocalResult));

		// Verify operation 5^363 = 5.322450e+253
		calculatorTest.performLongPowerFunction(TestUtils.powFunNum1, TestUtils.powFunNum2);
		calculatorTest.verifyResult();
		assertTrue(calculatorTest.result.equals(TestUtils.powFunResult));
	}

	@Test(priority = 7, enabled = true)
	public void addNewAlarm() throws Exception {
		inExam.queEight.click();
		inExam.rightSidePanelopen();
		alarmExam.addAlarm(TestUtils.hour1, TestUtils.min1, TestUtils.sec1);
		assertTrue(alarmExam.verifysetAlarm(TestUtils.hour1Verify, TestUtils.min1Verify));
	}

	@Test(priority = 8, enabled = true)
	public void cancelEditcancelNewAlarm() throws Exception {
		alarmExam.cancelEditAlarm();
		assertTrue(alarmExam.addAlarmBtn.isEnabled());
		alarmExam.cancelAddAlarm();
		assertTrue(alarmExam.addAlarmBtn.isEnabled());
	}

	@Test(priority = 9, enabled = true)
	public void addSecondAlarm() throws Exception {
		alarmExam.addAlarm(TestUtils.hour2, TestUtils.min2, TestUtils.sec2);
		assertTrue(alarmExam.verifysetAlarm(TestUtils.hour2Verify, TestUtils.min2Verify));
	}

	@Test(priority = 10, enabled = true)
	public void editFirstAlarm() throws Exception {
		alarmExam.editAlarm(0, TestUtils.hour3, TestUtils.min3, TestUtils.sec3);
		assertTrue(alarmExam.verifysetAlarm(TestUtils.hour3Verify, TestUtils.min3Verify));
	}

	@Test(priority = 11, enabled = true)
	public void editSecondAlarm() throws Exception {
		alarmExam.editAlarm(1, TestUtils.hour4, TestUtils.min4, TestUtils.sec4);
		assertTrue(alarmExam.verifysetAlarm(TestUtils.hour4Verify, TestUtils.min4Verify));
	}

	@Test(priority = 12, enabled = true)
	public void deleteAlarm() throws Exception {
		inExam.queOne.click();
		inExam.rightSidePanelopen();
		alarmExam.deleteAlarm();
		assertTrue(alarmExam.verifyDeleteAlarm());
	}

	@Test(priority = 13, enabled = true)
	public void submitExam() throws Exception {
		examHomeScreen.SubmitExamwithAlert();
		uploadExam.uploadExamOnScoring();
		time = homeMenu.getDeviceTime();
		examUploadSuccessfull.closeUploadedExam();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

}

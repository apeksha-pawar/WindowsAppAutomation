package com.examsoft.auto.ios.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.ForgotInstitutionID;
import com.examsoft.auto.ios.core.pages.Help;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.RemoveExamDownload;
import com.examsoft.auto.ios.core.pages.SendLogFiles;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_BeforeExam extends BaseTest {
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
		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(true, true);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.addNewAccountButton.isDisplayed());
	}

	@Test(priority = 1, enabled = true)
	public void CancelDownloadExam() {
		homeMenu.checkCanceDownloadExam(TestUtils.bigExamWithoutStatus);
	}

	@Test(priority = 2, enabled = true)
	public void DownloadExam() {
		homeMenu.downloadExam(TestUtils.bigExamWithoutStatus);
		homeMenu.verifyExamDetails(TestUtils.bigExamMap);
		assertTrue(homeMenu.verifyExamDetails(TestUtils.bigExamMap));
	}

	@Test(priority = 3, enabled = true)
	public void WrongPassword() throws Exception {
		homeMenu.startExam("ID", "1231232");
		homeMenu.wrongpwdpopUp();
		assertFalse(homeMenu.startExamButton.isEnabled());
	}

	@Test(priority = 4, enabled = true)
	public void RevereDownloadExam() {
		homeMenu.reversedownloadExam(TestUtils.bigExamWithoutStatus);
		removeExamDownload.acceptRemoveDownload();
		removeExamDownload.clickRemoveDownload();
		homeMenu.examStateReadyToDwnld(TestUtils.bigExamWithoutStatus);
		assertTrue(homeMenu.dowloadExamButton.isDisplayed());
	}
}
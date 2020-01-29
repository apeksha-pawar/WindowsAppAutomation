package com.examsoft.auto.ios.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.DashBoardInfo;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.Help;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.core.pages.RemoveExamDownload;
import com.examsoft.auto.ios.core.pages.SendLogFiles;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_HomeMenu extends BaseTest {
	EULA agreeEULA;
	ChooseAnAccount chooseAnAccount;
	InstitutionID institutionId;
	Login login;
	HomeMenu homeMenu;
	LogOut logout;
	Help help;
	SendLogFiles sendLogFiles;
	RemoveExamDownload removeExamDownload;
	DashBoardInfo dashBoardInfo;

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);
		help = new Help(driver);
		sendLogFiles = new SendLogFiles(driver);
		removeExamDownload = new RemoveExamDownload(driver);
		institutionId = new InstitutionID(driver);
		dashBoardInfo = new DashBoardInfo(driver);
		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(true, true);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(common.isElementDiplayed(chooseAnAccount.chooseAnAccountText));
	}

	@Test(priority = 1, enabled = true)
	public void revereDownloadSwipeExam() {
		homeMenu.downloadExam(TestUtils.bigExamWithoutStatus);
		assertTrue(homeMenu.startExamButton.isDisplayed());
		homeMenu.reverseDownloadSwipe(TestUtils.bigExamWithoutStatus);
		removeExamDownload.acceptRemoveDownload();
		removeExamDownload.clickRemoveDownload();
		homeMenu.examStateReadyToDwnld(TestUtils.bigExamWithoutStatus);
		assertTrue(homeMenu.dowloadExamButton.isDisplayed());
	}

	@Test(priority = 2, enabled = true)
	public void VerifyDashBoardInfo() throws Exception {
		dashBoardInfo.titleBar();
		assertTrue(dashBoardInfo.wifiPresent.isDisplayed());
		assertTrue(dashBoardInfo.Battery.isDisplayed());
		dashBoardInfo.footer();
		assertTrue(dashBoardInfo.versionExpireDate.isDisplayed());
		assertTrue(dashBoardInfo.copyright.isDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void helpSupportPages() {
		homeMenu.clickOnHelp();
		assertTrue(help.welcomeButton.isDisplayed());
		help.openWelcomePage();
		assertTrue(help.liveChatButton.isDisplayed());
		help.authenticationHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.examDownloadHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.beforeExamHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.swichAccountHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.duringExamHelp();
		assertTrue(help.WebPageText.isDisplayed());
		help.utilizingAppHelp();
		assertTrue(help.WebPageText.isDisplayed());
	}

	@Test(priority = 4, enabled = true)
	public void submitTicket() {
		help.openWelcomePage();
		assertTrue(help.liveChatButton.isDisplayed());
		help.openWelcomePage();
		assertTrue(help.welcomePageTitle.isDisplayed());
		help.submitTicket();
		help.backToDashboardPage();
		assertTrue(homeMenu.myExamText.isDisplayed());
	}

	@Test(priority = 5, enabled = false)
	public void licenseAggrementPage() {
		homeMenu.clickOnLicenseAgreementLink();
		assertTrue(agreeEULA.closeEULAButton.isDisplayed());
		assertFalse(homeMenu.homeMenuDropdown.isDisplayed());
		agreeEULA.closeEula();
		assertTrue(homeMenu.homeMenuDropdown.isDisplayed());
	}

	@Test(priority = 6, enabled = true)
	public void cancelSendLogs() {
		homeMenu.clickOnSendLogFiles();
		sendLogFiles.cancelSendlogFiles();
		assertTrue(homeMenu.homeMenuDropdown.isDisplayed());
	}

	@Test(priority = 7, enabled = true)
	public void sendLogs() {
		homeMenu.clickOnSendLogFiles();
		sendLogFiles.sendLog();
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
	}

	@Test(priority = 8, enabled = true)
	public void switchAccount() {
		homeMenu.clickOnSwitchAccount();
		assertTrue(common.isElementDiplayed(chooseAnAccount.addNewAccountButton));
	}

	@Test(priority = 9, enabled = true)
	public void cancelLogout() throws Exception {
		chooseAnAccount.chooseSameAccountAfterSwitching(TestUtils.defaultUsername);
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
		homeMenu.clickOnLogout();
		logout.cancelLogout();
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
	}

	@Test(priority = 10, enabled = true)
	public void prefilledLogin() throws Exception {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(common.isElementDiplayed(chooseAnAccount.chooseAnAccountText));
		chooseAnAccount.chooseAddedAcoountAndLogin(TestUtils.defaultUsername, TestUtils.defaultPassword);
		assertTrue(common.isElementDiplayed(homeMenu.myExamText));
	}
}

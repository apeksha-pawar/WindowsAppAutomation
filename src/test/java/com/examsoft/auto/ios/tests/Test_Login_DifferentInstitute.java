package com.examsoft.auto.ios.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_Login_DifferentInstitute extends BaseTest {
	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;
	LogOut logout;

	@BeforeClass
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		homeMenu = new HomeMenu(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		logout = new LogOut(driver);

		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(false, false);
	}

	@AfterClass
	public void teardown() {
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.addNewAccountButton.isDisplayed());
	}

	@Test(priority = 1, enabled = true)
	public void LDAPLogin() throws Exception {
		institutionId.selectInstitute(TestUtils.ldapSchool, TestUtils.ldapSchoolID);
		assertTrue(login.signInButton.isDisplayed());
		login.login(TestUtils.ldapET, TestUtils.ldapPassword);
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.addNewAccountButton.isDisplayed());
	}

	@Test(priority = 2, enabled = true)
	public void selectionOfLDAPOverrideInstitutionID() throws Exception {
		chooseAnAccount.addNewAccount();
		institutionId.selectInstitute(TestUtils.ldapSchoolOverride, TestUtils.ldapSchoolIDOverride);
		assertTrue(login.signInButton.isDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void ldapOverrideLogin() throws Exception {
		login.login(TestUtils.ldapETOverride, TestUtils.ldapPasswordOverride);
		common.isElementDiplayedlongwait(homeMenu.homeMenuDropdown);
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.chooseAnAccountText.isDisplayed());
	}

	@Test(priority = 4, enabled = true)
	public void selectionOfApacInstitutionID() throws Exception {
		chooseAnAccount.addNewAccount();
		institutionId.selectInstitute(TestUtils.apacSchool, TestUtils.apacSchoolID);
		assertTrue(login.signInButton.isDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void apacLogin() throws Exception {
		login.login(TestUtils.apacET, TestUtils.apacPassword);
		common.isElementDiplayedlongwait(homeMenu.homeMenuDropdown);
		homeMenu.clickOnLogout();
		logout.logout();
		assertTrue(chooseAnAccount.chooseAnAccountText.isDisplayed());
	}

	@Test(priority = 6, enabled = true)
	public void SelectionOfInstitutionID() throws Exception {
		chooseAnAccount.addNewAccount();
		institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
		assertTrue(login.signInButton.isDisplayed());
	}

	@Test(priority = 7, enabled = true)
	public void successfulLogin() throws Exception {
		login.login(TestUtils.defaultUsername, TestUtils.defaultPassword);
		common.isElementDiplayedlongwait(homeMenu.homeMenuDropdown);
		assertTrue(homeMenu.homeMenuDropdown.isDisplayed());
	}

	@Test(priority = 8, enabled = true)
	public void homeMenuButton() throws Exception {
		homeMenu.openHomeMenuOptions();
		assertTrue(homeMenu.helpLink.isDisplayed());
		assertTrue(homeMenu.lisenceAggrementLink.isDisplayed());
		assertTrue(homeMenu.switchAccount.isDisplayed());
		assertTrue(homeMenu.logoutButton.isDisplayed());
		assertTrue(homeMenu.sendlogfiles.isDisplayed());
		homeMenu.closeHomeMenuOptions();
	}

}
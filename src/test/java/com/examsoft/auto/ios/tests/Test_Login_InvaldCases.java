package com.examsoft.auto.ios.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.ForgotInstitutionID;
import com.examsoft.auto.ios.core.pages.HomeMenu;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.LogOut;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_Login_InvaldCases extends BaseTest {
	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ForgotInstitutionID forgotInstitutionID;
	ChooseAnAccount chooseAnAccount;
	HomeMenu homeMenu;
	LogOut logout;

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

		chooseAnAccount.acceptEulaOrChooseAccountWithLogin(false, false);

	}

	@AfterClass
	public void teardown() {
	}

	@Test(priority = 1, enabled = true)
	public void ipadDisableInstitute() throws Exception {
		assertTrue(institutionId.nonIpadInstitute(TestUtils.nonIpadSchool, TestUtils.nonIpadSchoolID));
	}

	@Test(priority = 2, enabled = true)
	public void ipadDisableInstituteNewPortal() throws Exception {
		assertTrue(
				institutionId.nonIpadInstitute(TestUtils.nonIpadSchoolNewPortal, TestUtils.nonIpadSchoolIDNewPortal));
	}

	@Test(priority = 3, enabled = true)
	public void selectionOfInstitutionID() throws Exception {
		institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
		assertTrue(common.isElementDiplayed(login.signInButton));
	}

	@Test(priority = 4, enabled = true)
	public void invalidInstitution() throws Exception {
		login.invalidLogin(TestUtils.wrongInstitutionUsername, TestUtils.wrongInstitutionPassword);
		assertTrue(login.invalidInstitutionErrorMessage.isDisplayed());
		login.invalidInstitutionMessage();
	}

	@Test(priority = 5, enabled = false)
	public void disclaimer() throws Exception { // Server team removed the disclaimer condition from UIDemo
		login.login(TestUtils.disclaimerUsername, TestUtils.disclaimerPassword);
		assertTrue(login.disclaimerErrorMessage.isDisplayed());
		login.disclaimerMessage();
	}

	@Test(priority = 6, enabled = true)
	public void invalidUserIdAndPassword() throws Exception {
		login.invalidLogin(TestUtils.invalidUsername, TestUtils.invalidPassword);
		assertTrue(login.wrongPasswordErrorMessage.isDisplayed());
		login.wrongPasswordMessage();
	}
}
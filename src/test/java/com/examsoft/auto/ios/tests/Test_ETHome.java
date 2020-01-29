package com.examsoft.auto.ios.tests;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.pages.ChooseAnAccount;
import com.examsoft.auto.ios.core.pages.DashBoardInfo;
import com.examsoft.auto.ios.core.pages.EULA;
import com.examsoft.auto.ios.core.pages.ForgotInstitutionID;
import com.examsoft.auto.ios.core.pages.InstitutionID;
import com.examsoft.auto.ios.core.pages.Login;
import com.examsoft.auto.ios.utils.TestUtils;

public class Test_ETHome extends BaseTest {

	Login login;
	EULA agreeEULA;
	InstitutionID institutionId;
	ChooseAnAccount chooseAnAccount;
	ForgotInstitutionID forgotInstitutionID;
	DashBoardInfo dashBoardInfo;

	@BeforeTest
	public void testSetup() {
		// Initializing Pages
		agreeEULA = new EULA(driver);
		login = new Login(driver);
		institutionId = new InstitutionID(driver);
		chooseAnAccount = new ChooseAnAccount(driver);
		forgotInstitutionID = new ForgotInstitutionID(driver);
		dashBoardInfo = new DashBoardInfo(driver);

		boolean isAccountPresent = false;
		try {
			isAccountPresent = chooseAnAccount.addNewAccountButton.isDisplayed();
		} catch (Exception e) {

		}
		if (isAccountPresent) {
			chooseAnAccount.addNewAccountButton.click();
		}
	}

	@Test(priority = 1, enabled = false)
	public void cancelEULA() throws Exception {
		agreeEULA.cancelEula();
		boolean isDriverClose = false;
		try {
			driver.getTitle();
		} catch (WebDriverException e) {
			isDriverClose = true;
		}
		assertTrue(isDriverClose);
	}

	@Test(priority = 2, enabled = true)
	public void acceptEULA() throws Exception {
		agreeEULA.acceptEula();
		assertTrue(common.isElementDiplayed(institutionId.addNewAccountBtn));
	}

	@Test(priority = 4, enabled = true)
	public void SelectionOfLADAPInstitutionID() throws Exception {
		institutionId.selectInstitute(TestUtils.ldapSchool, TestUtils.ldapSchoolID);
		assertTrue(login.signInButton.isDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void ForgotLoginDetails() throws Exception {
		login.clickForgotLoginDetails();
		forgotInstitutionID.sendForgotInstitutionIDRequest("sanjyot.jagtap@synerzip.com");
		assertTrue(forgotInstitutionID.successEmailMessage.isDisplayed());
		forgotInstitutionID.doneButtonOnForgotDetails.click();
		assertTrue(common.isElementDiplayed(login.userNameTextField));
	}

}

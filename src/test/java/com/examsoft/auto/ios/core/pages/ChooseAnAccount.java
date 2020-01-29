package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.TestUtils;

import io.appium.java_client.AppiumDriver;

/**
 * This class is for 'Choose an account' page
 * 
 * @author Sanjyot
 *
 * 
 */
public class ChooseAnAccount extends PageBase {

	@FindBy(id = "AccountListVC_addNewAccount_btn")
	public WebElement addNewAccountButton;

	@FindBy(name = "Choose an Account")
	public WebElement chooseAnAccountText;

	EULA checkEULA;
	InstitutionID institutionId;
	Login login;
	HomeMenu homeMenu;

	TestUtils testUtils;

	public ChooseAnAccount(AppiumDriver<WebElement> driver) {
		super(driver);
		checkEULA = new EULA(driver);
		institutionId = new InstitutionID(driver);
		login = new Login(driver);
		testUtils = new TestUtils(driver);
		homeMenu = new HomeMenu(driver);

	}

	/**
	 * This method is to verify that EULA is appearing after clicking 'Add new
	 * account' button
	 */
	public void verifyEULAPage() {
		common.isElementDiplayed(checkEULA.cancelEULAButton);
	}

	/**
	 * This method is for 'Adding new account' by accepting EULA
	 */
	public void addNewAccount() {
		common.isElementDiplayed(addNewAccountButton);
		addNewAccountButton.click();
		verifyEULAPage();
		checkEULA.acceptEula();
		common.isElementDiplayed(institutionId.backButton);
	}

	/**
	 * This method is for choosing previously added account
	 */
	public void chooseAddedAcoountAndLogin(String account, String password) {
		common.isElementDiplayed(chooseAnAccountText);
		driver.findElement(By.id("AccountListVC_cell_" + account)).click();
		assertTrue(login.userNameTextField.getAttribute("value").equals(account));
		login.enterPasswordAndSubmit(password);

	}

	/**
	 * This method is for choosing same account after switching
	 */
	public void chooseSameAccountAfterSwitching(String account) {
		common.isElementDiplayed(chooseAnAccountText);
		driver.findElement(By.id("AccountListVC_cell_" + account)).click();
	}

	public void acceptEULAOnEULAbychooseAcc() {
		boolean isAccountPresent = false;

		try {
			isAccountPresent = addNewAccountButton.isDisplayed();
		} catch (Exception e) {

		}
		if (isAccountPresent) {
			addNewAccountButton.click();
		}
	}

	public void acceptEulaOrChooseAccountWithLogin(boolean selectInstitute, boolean doLogin) {
		boolean isEulaScreenPresent = false;
		boolean isAccountPresent = false;
		common.waitFor(5000);

		try {
			isEulaScreenPresent = checkEULA.cancelEULAButton.isDisplayed();
		} catch (Exception e) {
			isEulaScreenPresent = false;
		}
		if (isEulaScreenPresent) {
			checkEULA.acceptEula();
			common.isElementDiplayed(institutionId.addNewAccountBtn);
		} else {

			try {
				isAccountPresent = driver.findElement(By.id("AccountListVC_cell_" + TestUtils.defaultUsername))
						.isDisplayed();
			} catch (Exception e) {

			}
			if (selectInstitute && isAccountPresent) {
				common.isElementDiplayed(chooseAnAccountText);
				driver.findElement(By.id("AccountListVC_cell_" + TestUtils.defaultUsername)).click();
			} else {
				addNewAccount();
				common.isElementDiplayed(institutionId.addNewAccountBtn);
			}
		}
		if (selectInstitute && !isAccountPresent) {
			institutionId.selectInstitute(TestUtils.school, TestUtils.schoolId);
			common.isElementDiplayed(login.forgotLoginDetails);
			login.enterUserName(TestUtils.defaultUsername);
		}

		if (doLogin) {
			common.isElementDiplayed(login.userNameTextField);
			login.enterPasswordAndSubmit(TestUtils.defaultPassword);
		}
	}

}

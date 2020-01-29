package com.examsoft.auto.ios.core.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.AppConstants;

import io.appium.java_client.AppiumDriver;

/**
 * This class is a page for selection of Institution before registration of ET
 * 
 * @author Sanjyot
 *
 */
public class InstitutionID extends PageBase {

	@FindBy(id = "SelectSchoolVC_instituteID_txtFld")
	public WebElement selectSchoolTextField;

	@FindBy(id = "Add New Account")
	public WebElement addNewAccountBtn;

	@FindBy(className = "Table")
	public WebElement selectSchoolTable;

	@FindBy(id = "SelectSchoolVC_next_btn")
	public WebElement clickNextButton;

	@FindBy(id = "SelectSchoolVC_back_btn")
	public WebElement backButton;

	public List<WebElement> shcoolIdList;

	String school = null;
	String school_id = null;

	Login checkLogin;

	public InstitutionID(AppiumDriver<WebElement> driver) {
		super(driver);

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		school = prop.getProperty("SCHOOL");
		school_id = prop.getProperty("SCHOOL_ID");
		checkLogin = new Login(driver);

	}

	/**
	 * This method is for Filtering Institute list
	 * 
	 * @param SchoolID
	 * @param SchoolName
	 */
	public void selectInstitute(String school, String school_id) {
		common.waitFor(1000);
		selectSchoolTextField.click();
		selectSchoolTextField.sendKeys(school);
		selectSchoolFromList(school_id);
		// 1st from dropdown
		clickNextButton.click(); // next button
		common.waitForElement(hideKeyboard);
		hideKeyboard.click();
		common.waitForElement(checkLogin.loginPageText, 60);
	}

	/**
	 * This method is for selecting Institute from the list
	 * 
	 * @param SchoolID
	 */
	public void selectSchoolFromList(String schoolId) {
		common.waitForElement(selectSchoolTable, 60);
		shcoolIdList = selectSchoolTable.findElements(By.className("Cell"));
		WebElement selectedSchoolId = null;
		for (WebElement id : shcoolIdList) {
			WebElement staticText = id.findElement(By.className("StaticText"));
			if (staticText.getText().equals(schoolId)) {
				selectedSchoolId = id;
				break;
			}

		}
		selectedSchoolId.click();
	}

	/**
	 * This method is for clicking back button to choose account from list
	 */
	public void clickBackButton() {
		backButton.click();

	}

	public boolean nonIpadInstitute(String school, String school_id) {
		boolean schoolPresent = true;
		common.waitFor(1000);
		selectSchoolTextField.click();
		selectSchoolTextField.clear();
		selectSchoolTextField.sendKeys(school);
		try {
			selectSchoolFromList(school_id);
			schoolPresent = true;
		} catch (Exception e) {
			schoolPresent = false;
		}
		return !schoolPresent;
	}

}

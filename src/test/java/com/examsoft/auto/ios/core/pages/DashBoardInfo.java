package com.examsoft.auto.ios.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

public class DashBoardInfo extends PageBase {

	@FindBy(id = "3 of 3 Wi-Fi bars")
	public WebElement wifiPresent;

	@FindBy(xpath = "//*[contains(@name, 'battery power')] ")
	public WebElement Battery;

	@FindBy(id = "VERSION 3.7, expires on 11/12/2023")
	public WebElement versionExpireDate;

	@FindBy(id = "© 1998-2019 ExamSoft Worldwide, Inc. All Rights Reserved.")
	public WebElement copyright;

	@FindBy(id = "Collapse Question Stem")
	public WebElement HideShowQueBtn;

	@FindBy(id = "question_text")
	public WebElement QueText;

	public DashBoardInfo(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void titleBar() {
		common.waitForElementLong(wifiPresent);
		wifiPresent.isDisplayed();
		common.waitForElementLong(Battery);
		Battery.isDisplayed();
	}

	public void footer() {
		common.waitForElementLong(versionExpireDate);
		versionExpireDate.isDisplayed();
		common.waitForElementLong(copyright);
		copyright.isDisplayed();
	}

	public void hideQue() {
		if (QueText.isDisplayed())
			HideShowQueBtn.click();
		else {
			try {
				HideShowQueBtn.click();
				common.waitForElementLong(QueText);
				HideShowQueBtn.click();
				common.waitForElementHide(QueText,10);
			} catch (Exception e) {
			}
		}

	}

	public void showQue() {
			try {
				if (QueText.isDisplayed()) {
				HideShowQueBtn.click();
				common.waitForElementLong(QueText);
				HideShowQueBtn.click();
				}

			} catch (Exception e) {
				HideShowQueBtn.click();
			}
			common.isElementDiplayedlongwait(QueText);
	
	}

}

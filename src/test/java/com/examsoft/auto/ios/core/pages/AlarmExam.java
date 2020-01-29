package com.examsoft.auto.ios.core.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

/**
 * This class is a page for Alarm functionality
 * 
 * @author sanjyot
 *
 */

public class AlarmExam extends PageBase {

	@FindBy(id = "Add alarm")
	public WebElement addAlarmBtn;

	@FindBy(name = "Hours")
	public WebElement hoursButton;

	@FindBy(name = "Cancel")
	WebElement cancelButton;

	@FindAll({ @FindBy(className = "XCUIElementTypePickerWheel") })
	public List<WebElement> pickerWheel;

	@FindBy(name = "Add")
	public WebElement AddBtn;

	@FindAll({ @FindBy(xpath = "//*[contains(@name, 'More Info')] ") })
	public List<WebElement> editAlrmBtn;

	@FindAll({ @FindBy(xpath = "//*[contains(@name, 'Second left')] ") })
	public List<WebElement> readAlarm;

	@FindBy(id = "Save")
	public WebElement saveAlarmBtn;

	@FindBy(id = "Cancel")
	public WebElement cancelAlarmBtn;

	public AlarmExam(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	public void cancelAddAlarm() {
		common.isElementDiplayed(addAlarmBtn);
		if (addAlarmBtn.isEnabled()) {
			addAlarmBtn.click();
			common.isElementDiplayed(cancelAlarmBtn);
			cancelAlarmBtn.click();
		}
	}

	public void setTimer(String Hours, String minutes, String seconds) {
		common.waitFor(500);
		pickerWheel.get(0).sendKeys(Hours + "Hours");
		pickerWheel.get(1).sendKeys(minutes + "Minutes");
		pickerWheel.get(2).sendKeys(seconds + "Seconds");
	}

	public void addAlarm(String Hours, String minutes, String seconds) {
		common.isElementDiplayed(addAlarmBtn);
		if (addAlarmBtn.isEnabled()) {
			addAlarmBtn.click();
			setTimer(Hours, minutes, seconds);
		} else {
			deleteAlarm();
		}
		common.isElementDiplayed(AddBtn);
		AddBtn.click();
	}

	public boolean verifysetAlarm(String Hours, String minutes) {
		boolean alarmFound = false;
		for (int i = 0; i < readAlarm.size(); i++) {
			if (readAlarm.get(i).getText().contains("Alarm" + Hours + " Hour " + minutes + " Minute")) {
				alarmFound = true;
				break;
			}
		}
		return alarmFound;
	}

	public void cancelEditAlarm() {
		common.isElementDiplayed(editAlrmBtn.get(0));
		editAlrmBtn.get(0).click();
		common.isElementDiplayed(cancelAlarmBtn);
		cancelAlarmBtn.click();
	}

	public void setEditAlarm(String Hours, String minutes, String seconds) {
		setTimer(Hours, minutes, seconds);
		common.isElementDiplayed(saveAlarmBtn);
		saveAlarmBtn.click();
	}

	public void editAlarm(int index, String Hours, String minutes, String seconds) {
		common.isElementDiplayed(editAlrmBtn.get(index));
		editAlrmBtn.get(0).click();
		setEditAlarm(Hours, minutes, seconds);
	}

	public void delete() {
		driver.performTouchAction(touchActionNew(991, 191, 729, 191));
	}

	public void touchAction(int toX, int toY) {
		TouchAction action = new TouchAction(driver);
		int X = toX;
		int Y = toY;
		action.press(X, Y).waitAction(4000).moveTo(729, 191).release().perform();
	}

	public void deleteAlarm() {
		if (readAlarm.size() > 2) {
			delete();
			common.isElementDiplayed(readAlarm.get(0));
			delete();
		} else
			delete();
	}

	public boolean verifyDeleteAlarm() {
		boolean isAlarmpresent = true;

		if (readAlarm.size() > 0)
			isAlarmpresent = true;
		else
			isAlarmpresent = false;
		return !isAlarmpresent;

	}
}

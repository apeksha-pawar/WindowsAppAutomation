package com.examsoft.auto.ios.tests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;


public class Ap_Wordpad_test extends BaseTest {
	@Test
	public void basicFunctions() throws Exception {
		try {
			winDriver.findElementByName("Add New Account");
//			WebElement textArea = winDriver.findElementByName("Rich Text Window");
//			winDriver.manage().window().maximize();
//			textArea.sendKeys("Examsoft");
//			Actions actions = new Actions(winDriver);
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a")).build().perform();
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"b")).build().perform();
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"i")).build().perform();
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"u")).build().perform();
//			actions.moveToElement(textArea).doubleClick().build().perform();
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a")).build().perform();
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "c")).build().perform();
//			actions.sendKeys(Keys.chord(Keys.ENTER));
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a")).build().perform();
//			actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "x")).build().perform();
//			winDriver.findElementByName("Close").click();
//			winDriver.findElementByName("Don't Save").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
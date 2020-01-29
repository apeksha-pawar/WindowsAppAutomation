package com.examsoft.auto.win.core.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.support.ManagedArray;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.utils.AppConstants;
import com.examsoft.auto.ios.utils.GetLocalExamLogs;
import com.examsoft.auto.win.core.pages.Marker_AttemptExamWithNotice;
import com.examsoft.auto.win.core.pages.Marker_AttemptExamWithoutNotice;
import com.examsoft.auto.win.core.pages.Marker_GetPortalLogs;

public class Test_MarkerWithoutNoticeLogs extends BaseTest {
	Marker_AttemptExamWithoutNotice login;;
	GetLocalExamLogs localLogs;
	Properties prop = new Properties();			
	Marker_GetPortalLogs portalLogs;
	
	@BeforeMethod
	public void testSetup() throws FileNotFoundException, IOException {
		login = new Marker_AttemptExamWithoutNotice(winDriver); 
		localLogs = new GetLocalExamLogs();
		portalLogs = new Marker_GetPortalLogs(webDriver);
	}
	
	@AfterClass
	public void teardown() {
	}

	@Test
	public void loginw() throws Exception {
		Thread.sleep(8000);
		String examType = "withoutnotice";
//		login.loginToApp();
//		localLogs.findLogsFromLocal();		
		portalLogs.getLogsFromPortal(examType);
	}
}
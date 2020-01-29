package com.examsoft.auto.win.core.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.utils.GetLocalExamLogs;
import com.examsoft.auto.win.core.pages.Marker_AttemptExamWithNotice;
import com.examsoft.auto.win.core.pages.Marker_GetPortalLogs;

public class Test_MarkerWithNoticeLogs extends BaseTest {
	Marker_AttemptExamWithNotice login;;
	GetLocalExamLogs localLogs;
	Properties prop = new Properties();			
	Marker_GetPortalLogs portalLogs;
	
	@BeforeMethod
	public void testSetup() throws FileNotFoundException, IOException {
		login = new Marker_AttemptExamWithNotice(winDriver); 
		localLogs = new GetLocalExamLogs();
		portalLogs = new Marker_GetPortalLogs(webDriver);
	}
	
	@AfterClass
	public void teardown() {
	}

	@Test
	public void loginw() throws Exception {
		String examType = "withnotice";
		Thread.sleep(8000);
		login.loginToApp();
		localLogs.findLogsFromLocal();		
		portalLogs.getLogsFromPortal(examType);
	}
}
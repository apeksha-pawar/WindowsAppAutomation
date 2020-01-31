package com.examsoft.auto.win.core.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Factory;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.ios.core.base.PageBase;
import com.examsoft.auto.ios.utils.AppConstants;
import com.examsoft.auto.ios.utils.TestUtils;

import io.appium.java_client.windows.WindowsDriver;

public class Marker_GetPortalLogs extends PageBase {

	public Marker_GetPortalLogs(ChromeDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "userid")
	public WebElement userId;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "emLoginLink")
	public WebElement loginButton;

	@FindBy(xpath = "//a[text()='Assessments']")
	public WebElement tabAssessments;

	@FindBy(id = "examIdOrName")
	public WebElement examNameText;

	@FindBy(id = "numDaysFromPostingEnd")
	public WebElement postingDropdown;

	@FindBy(id = "btnDoExamsBasicSearch")
	public WebElement examSearchButton;

	@FindBy(xpath = "//*[@id=\"examsTable\"]/tbody/tr[1]/td[2]/a")
	public WebElement searchedExam;

	@FindBy(xpath = "//a[text()='Exam Taker Activity']")
	public WebElement tabExamTaker;

	@FindBy(xpath = "//table[@id=\"examstrackinggrid\"]//th[2]")
	public WebElement examTakerTableHeading;

	@FindBy(xpath = "//*[@id=\"examstrackinggrid\"]/tbody/tr[32]/td[2]/a")
	public WebElement examTakerName;

	@FindBy(xpath = "//*[@id=\"examstrackinggrid\"]/tbody/tr[17]/td[12]/a[3]/img")
	public WebElement examTakerSnapShot;

	@FindBy(xpath = "//*[@id=\"snapshotgrid\"]/tbody/tr[1]/td[5]")
	public WebElement examStartTime;

	@FindBy(xpath = "//*[@id=\"snapshotgrid\"]/tbody/tr[14]/td[5]")
	public WebElement examEndTime;

	@FindBy(xpath = "/html/body/div[10]/div[1]/a/span/img")
	public WebElement snapShotCloseButton;

	@FindBy(xpath = "//a[@class=\"accountnav\"]/span")
	public WebElement userAccount;

	@FindBy(xpath = "//a[@class=\"accountnav\"]//following-sibling::ul/li[5]/a")
	public WebElement logOutLink;

	public String[] getLogsFromPortal(String examType) throws FileNotFoundException, IOException, InterruptedException {
		String timeStamp[] = new String[2];
		try {
			Properties prop = new Properties();
			Thread.sleep(3000);
			prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
			String url = prop.getProperty("PORTAL_URL");
			System.out.println("URL" + url);
			webDriver.get(prop.getProperty("PORTAL_URL"));
			webDriver.manage().window().maximize();
			Thread.sleep(7000);
			userId.click();
			userId.sendKeys("vrushalee.ajotikar@synerzip.com");
			password.click();
			password.sendKeys("999999");
			loginButton.click();
			Thread.sleep(3000);
			tabAssessments.click();
			Thread.sleep(4000);
			examNameText.click();
			if (examType.equals("withnotice")) {
				examNameText.sendKeys("Auto_Test_Marker");
			} else
				examNameText.sendKeys("Auto_Test_Marker_woNotice");

			Select dropDown = new Select(postingDropdown);
			dropDown.selectByVisibleText("All Postings");
			examSearchButton.click();
			Thread.sleep(3000);
			searchedExam.click();
			Thread.sleep(5000);
			tabExamTaker.click();
			Thread.sleep(2000);
			examTakerTableHeading.click();
			Thread.sleep(2000);
			examTakerSnapShot.click();
			webDriver.switchTo().frame("fSnapshotViewer");
			Thread.sleep(8000);
			timeStamp[0] = examStartTime.getText();
			System.out.println("startExamTime : " + timeStamp[0]);
			timeStamp[1] = examEndTime.getText();
			System.out.println("examEndTime : " + timeStamp[1]);
			webDriver.switchTo().parentFrame();
			webDriver.switchTo().defaultContent();
			snapShotCloseButton.click();
			userAccount.click();
			logOutLink.click();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return timeStamp;
	}
}

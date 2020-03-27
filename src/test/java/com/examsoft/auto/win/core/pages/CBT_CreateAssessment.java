package com.examsoft.auto.win.core.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.examsoft.auto.ios.utils.AppConstants;

public class CBT_CreateAssessment {

	Properties prop = new Properties();
	WebDriver webDriver = new ChromeDriver();	
	
	public void loginToPortal() throws FileNotFoundException, IOException, InterruptedException {
		prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
		webDriver.get(prop.getProperty("PORTAL_URL"));
		String account = prop.getProperty("ACCOUNT");	
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		if (account.equals("QATWO")) {
			webDriver.findElement(By.id("userid")).sendKeys("rvarela+3@examsoft.com");
			webDriver.findElement(By.id("password")).sendKeys("password1");
		} else {
			webDriver.findElement(By.id("userid")).sendKeys("vrushalee.ajotikar@synerzip.com");
			webDriver.findElement(By.id("password")).sendKeys("999999");
		}
		webDriver.findElement(By.id("emLoginLink")).click();
		Thread.sleep(3000);
	}

	public void createSecureExam() throws InterruptedException, FileNotFoundException, IOException {
		loginToPortal();
		prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
		String assessment_count = prop.getProperty("ASSESSMENT_COUNT");
		String assessment_type = prop.getProperty("ASSESSMENT_TYPE");
		String account = prop.getProperty("ACCOUNT");	
		createMultipleExams(webDriver, assessment_count, assessment_type, account);
		webDriver.findElement(By.xpath("//*[@id=\"accountbar\"]/ul/li/a/img")).click();
		webDriver.findElement(By.xpath("//*[@id=\"logoutLink\"]")).click();
		System.out.println(assessment_count + " assessment/s created successfully.");
	}

	public void createMultipleExams(WebDriver webDriver, String assessment_count, String assessment_type,
			String account) throws InterruptedException {
		Random random = new Random();		
		Actions action = new Actions(webDriver);
		for (int i = 0; i < Integer.parseInt(assessment_count); i++) {
			int randomNumber = random.nextInt(900) + 100;
			webDriver.findElement(By.xpath("//a[text()='Assessments']")).click();
			Thread.sleep(15000);
			webDriver.findElement(By.id("createAssessment")).click();
			webDriver.findElement(By.xpath("//*[@id=\"advanced\"]/a")).click();
			Thread.sleep(2000);
			if (assessment_type.equals("nsbi")) {
				webDriver.findElement(By.id("examTitle")).sendKeys("Nsbi_Auto_" + randomNumber);
			} else if (assessment_type.equals("non-secure")) {
				webDriver.findElement(By.id("examTitle")).sendKeys("Non-Secure_Auto_" + randomNumber);
			} else {
				webDriver.findElement(By.id("examTitle")).sendKeys("SecureDefaultScoring_Auto_" + randomNumber);
			}
			Thread.sleep(2000);
			webDriver.findElement(By.id("selectExamFolderOpen")).click();
			Thread.sleep(2000);
			if (account.equals("QATWO")) {
				webDriver.findElement(By.xpath("//*[@id=\"selectFolderTree\"]/tbody/tr[3]/td[1]/span")).click();
			} else {
				webDriver.findElement(By.xpath("//*[@id=\"selectFolderTree\"]/tbody/tr[3]/td[1]/span")).click();
			}
			Thread.sleep(3000);
			webDriver.findElement(By.xpath("//span[text()='Percentage']//preceding-sibling::input[2]")).click();
			webDriver.findElement(By.xpath("//span[text()='Raw Score']//preceding-sibling::input[2]")).click();
			if (assessment_type.equals("nsbi")) {
				webDriver.findElement(By.xpath("//*[@id=\"mangle\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"blockInternet\"]")).click();
			} else if (assessment_type.equals("non-secure")) {
				webDriver.findElement(By.xpath("//*[@id=\"mangle\"]")).click();
			}
			webDriver.findElement(By.xpath("//*[@id=\"createtabs\"]/section/div[1]/a[1]")).click();
			if (account.equals("QATWO")) {
				webDriver.findElement(By.xpath("//*[@id=\"qSelectCheckAll\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"selectQuestionFA_ip-118715765183930349914\"]")).click();

			} else if (account.equals("DefaultScoring")) {
				webDriver.findElement(By.xpath("//*[@id=\"btnAdvancedSearchText\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"omniSearchInput\"]")).sendKeys("AuDefaultScoring");
				webDriver.findElement(By.xpath("//*[@id=\"btnDoQuestionsAdvancedSearch\"]")).click();
				Thread.sleep(3000);
				webDriver.findElement(By.xpath("//*[@id=\"qSelectCheckAll\"]")).click();
			} else {
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716516676397374XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716516386732355XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716511930522826XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716511629526491XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716511310609813XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716507271537570XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716504992132210XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716504290301791XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716496779814131XX")).click();
				webDriver.findElement(By.id("selectQuestionFA_lnxp115716496583007841XX")).click();
			}
			webDriver.findElement(By.xpath("//*[@id=\"NumberSelectedRows\"]/div/div/a")).click();
			Thread.sleep(5000);
			webDriver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr/td[3]/div[2]/a")).click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(0,300)");
			webDriver.findElement(By.xpath("//*[@id=\"examCreateEdit\"]/table/tbody/tr/td[3]/div[2]/a[2]")).click();
			Thread.sleep(15000);
			js.executeScript("window.scrollBy(0,400)");
			Thread.sleep(3000);
			webDriver.findElement(By.xpath("//*[@id=\"examCreateEdit\"]/table/tbody/tr/td[3]/div[2]/a[6]")).click();
			Thread.sleep(3000);
			if (assessment_type.equals("nsbi")) {
				String parentWindowHandler = webDriver.getWindowHandle();
				String subWindowHandler = null;

				Set<String> handles = webDriver.getWindowHandles();
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()) {
					subWindowHandler = iterator.next();
				}
				webDriver.switchTo().window(subWindowHandler);
				webDriver.findElement(By.xpath("//div[@id=\"postConfirmForIpad\"]//table//div[2]//a[2]")).click();
				webDriver.switchTo().window(parentWindowHandler);
			}
			Thread.sleep(3000);
			webDriver.findElement(By.xpath("//*[@id=\"examPassword\"]")).click();
			webDriver.findElement(By.xpath("//*[@id=\"examPassword\"]")).sendKeys("test123");
			Thread.sleep(2000);
			WebElement courseDropDown = webDriver.findElement(By.xpath("//*[@id=\"courseID\"]/input[1]"));
			courseDropDown.click();
			Thread.sleep(1000);
			courseDropDown.sendKeys(Keys.ARROW_DOWN);
			courseDropDown.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			webDriver.findElement(By.xpath("//*[@id=\"viewPostExam\"]")).click();
			Thread.sleep(5000);
			try {
				boolean isPresent = webDriver.findElements(By.xpath("\"//span[text()='WARNING! ']\"")).size() > 0;
				if (isPresent) {
					String parentWindowHandler = webDriver.getWindowHandle();
					String subWindowHandler = null;

					Set<String> handles = webDriver.getWindowHandles();
					Iterator<String> iterator = handles.iterator();
					while (iterator.hasNext()) {
						subWindowHandler = iterator.next();
					}
					webDriver.switchTo().window(subWindowHandler);
					webDriver.findElement(By.xpath("//div[@id=\"delayStartTimePopup\"]//div/a[2]")).click();
					webDriver.switchTo().window(parentWindowHandler);
				} else {
					Alert alert = webDriver.switchTo().alert();
					alert.accept();
				}
			} catch (Exception ex) {
				Alert alert = webDriver.switchTo().alert();
				alert.accept();
			}
			Thread.sleep(15000);
			String verifyExamCreatedMsg = webDriver
					.findElement(By.xpath("//*[@id=\"globalMessageDiv\"]/div[2]/table/tbody/tr/td[2]/span")).getText();
			Assert.assertEquals(verifyExamCreatedMsg, "The assessment was posted.");
			Thread.sleep(3000);
		}
	}
}

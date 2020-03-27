package com.examsoft.auto.win.core.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.examsoft.auto.ios.utils.AppConstants;

public class Create_Questions {
	Properties prop = new Properties();	
	WebDriver webDriver = new ChromeDriver();
	
	public void CreateDefaultScoringQuestions() throws FileNotFoundException, IOException, InterruptedException {
		prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
		webDriver.get(prop.getProperty("PORTAL_URL"));
		String account = prop.getProperty("ACCOUNT");	
		String weightMCQ = prop.getProperty("SCORING_WEIGHT_MCQ");
		String weightTF = prop.getProperty("SCORING_WEIGHT_TF");
		String weightESSAY = prop.getProperty("SCORING_WEIGHT_ESSAY");
		String weightFITB = prop.getProperty("SCORING_WEIGHT_FITB");	
		
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		if (account.equals("QATWO")) {
			webDriver.findElement(By.id("userid")).sendKeys("rvarela+3@examsoft.com");
			webDriver.findElement(By.id("password")).sendKeys("password1");
		} else {
			webDriver.findElement(By.id("userid")).sendKeys("vrushalee.ajotikar@synerzip.com");
			webDriver.findElement(By.id("password")).sendKeys("999999");
		}
		webDriver.findElement(By.id("emLoginLink")).click();
		Thread.sleep(3000);
		createMCQ(weightMCQ, "MCQ");
		createTF(weightTF, "TF");
		createEssay(weightESSAY, "Essay");
		createFITB(weightFITB, "FITB");
		webDriver.findElement(By.xpath("//*[@id=\"accountbar\"]/ul/li/a/img")).click();
		webDriver.findElement(By.xpath("//*[@id=\"logoutLink\"]")).click();
		System.out.println("Default scoring questions created successfully");
	}

	public void createMCQ(String weightMCQ, String queType) throws InterruptedException, FileNotFoundException, IOException {
		webDriver.findElement(By.xpath("//a[text()='Questions']")).click();
		webDriver.findElement(By.xpath("//*[@id=\"websitebody\"]/table[1]/tbody/tr/td[1]/a[1]")).click();
		createQuePage(webDriver,queType);
		WebElement weightTxtbx = webDriver.findElement(By.xpath("//*[@id=\"weight\"]"));
		weightTxtbx.click();
		weightTxtbx.clear();
		weightTxtbx.sendKeys(weightMCQ +".0");

		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"cke_contents_questionRichText\"]/iframe")));
		WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Test MCQ question");
		webDriver.switchTo().defaultContent();		

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//table[@id=\"mcqChoices\"]//tr[3]/td[@class=\"mcqLetter\"]/following-sibling::td[1]//table//tr[2]/td/iframe")));
		body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Option1");
		webDriver.switchTo().defaultContent();	
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//table[@id=\"mcqChoices\"]//tr[4]/td[@class=\"mcqLetter\"]/following-sibling::td[1]//table//tr[2]/td/iframe")));
		body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Option2");
		webDriver.switchTo().defaultContent();	
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//table[@id=\"mcqChoices\"]//tr[5]/td[@class=\"mcqLetter\"]/following-sibling::td[1]//table//tr[2]/td/iframe")));
		body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Option3");
		webDriver.switchTo().defaultContent();	
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//table[@id=\"mcqChoices\"]//tr[6]/td[@class=\"mcqLetter\"]/following-sibling::td[1]//table//tr[2]/td/iframe")));
		body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Option4");
		webDriver.switchTo().defaultContent();			
		webDriver.findElement(By.xpath("//*[@id=\"correctBool\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"mcqSaveItem\"]")).click();
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//a[text()='Approve']")).click();
		Thread.sleep(3000);
		String actualApproveMsg = webDriver
				.findElement(By.xpath("//*[@id=\"globalMessageDiv\"]/div[2]/table/tbody/tr/td[2]/span/ul/li"))
				.getText();
		Assert.assertEquals(actualApproveMsg, "This question was successfully approved");
	}

	public void createTF(String weightTF,String queType) throws FileNotFoundException, InterruptedException, IOException {
		webDriver.findElement(By.xpath("//a[text()='Questions']")).click();
		webDriver.findElement(By.xpath("//*[@id=\"websitebody\"]/table[1]/tbody/tr/td[1]/a[2]")).click();
		createQuePage(webDriver, queType);
		WebElement weightTxtbx = webDriver.findElement(By.xpath("//*[@id=\"weight\"]"));
		weightTxtbx.click();
		weightTxtbx.clear();
		weightTxtbx.sendKeys(weightTF +".0");
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"cke_contents_questionRichText\"]/iframe")));
		WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Test True or False question");
		webDriver.switchTo().defaultContent();	
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"tfSaveItem\"]")).click();
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//a[text()='Approve']")).click();
		Thread.sleep(3000);
		String actualApproveMsg = webDriver
				.findElement(By.xpath("//*[@id=\"globalMessageDiv\"]/div[2]/table/tbody/tr/td[2]/span/ul/li"))
				.getText();
		Assert.assertEquals(actualApproveMsg, "This question was successfully approved");
	}

	public void createEssay(String weightESSAY, String queType) throws FileNotFoundException, InterruptedException, IOException {
		webDriver.findElement(By.xpath("//a[text()='Questions']")).click();
		webDriver.findElement(By.xpath("//*[@id=\"websitebody\"]/table[1]/tbody/tr/td[1]/a[3]")).click();
		createQuePage(webDriver,queType);
		WebElement weightTxtbx = webDriver.findElement(By.xpath("//*[@id=\"weight\"]"));
		weightTxtbx.click();
		weightTxtbx.clear();
		weightTxtbx.sendKeys(weightESSAY +".0");
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"cke_contents_questionRichText\"]/iframe")));
		WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Test essay question");
		webDriver.switchTo().defaultContent();	
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"essaySaveItem\"]")).click();
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//a[text()='Approve']")).click();
		Thread.sleep(3000);
		String actualApproveMsg = webDriver
				.findElement(By.xpath("//*[@id=\"globalMessageDiv\"]/div[2]/table/tbody/tr/td[2]/span/ul/li"))
				.getText();
		Assert.assertEquals(actualApproveMsg, "This question was successfully approved");
	}

	public void createFITB(String weightFITB,String queType) throws InterruptedException, FileNotFoundException, IOException {
		webDriver.findElement(By.xpath("//a[text()='Questions']")).click();
		webDriver.findElement(By.xpath("//*[@id=\"websitebody\"]/table[1]/tbody/tr/td[1]/a[4]")).click();
		createQuePage(webDriver,queType);
		WebElement weightTxtbx = webDriver.findElement(By.xpath("//*[@id=\"weight\"]"));
		weightTxtbx.click();
		weightTxtbx.clear();
		weightTxtbx.sendKeys(weightFITB +".0");
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"cke_contents_questionRichText\"]/iframe")));
		WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		body.sendKeys("Test FITB question");
		webDriver.switchTo().defaultContent();	
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"addNewBlank\"]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"blankText1\"]")).sendKeys("Answer");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"fitbSaveItem\"]")).click();
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//a[text()='Approve']")).click();
		Thread.sleep(3000);
		String actualApproveMsg = webDriver
				.findElement(By.xpath("//*[@id=\"globalMessageDiv\"]/div[2]/table/tbody/tr/td[2]/span/ul/li"))
				.getText();
		Assert.assertEquals(actualApproveMsg, "This question was successfully approved");		
	}

	public void createQuePage(WebDriver webDriver, String queType) throws InterruptedException, FileNotFoundException, IOException {
		prop.load(new FileInputStream(AppConstants.PROPERTY_FILE));
		String scoreType = prop.getProperty("SCORING_TYPE");
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"displayText\"]")).sendKeys("Au" + scoreType + queType);
		webDriver.findElement(By.xpath("//*[@id=\"selectQuestionFolderOpen\"]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"selectFolderTree\"]/tbody/tr[2]/td[1]/span/span[2]")).click();
		Thread.sleep(3000);	
	}
}

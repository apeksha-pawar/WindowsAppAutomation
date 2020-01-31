package com.examsoft.auto.ios.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.windows.WindowsDriver;

public class GetLocalExamLogs {


	public String[] findLogsFromLocal() throws IOException {
		String dir = "C:\\ProgramData\\Examplify";
		String latestFolder = findFoldersInDirectory(dir).get(findFoldersInDirectory(dir).size() - 5);
		List<String> allFilesFromLatestFolder = getFilesInFolder(dir, latestFolder);
		String [] timeStamp = getTimeStamp(allFilesFromLatestFolder);
		System.out.println("Latest Folder = " + latestFolder);
		return timeStamp;		
	}

	public List<String> findFoldersInDirectory(String directoryPath) {
		File directory = new File(directoryPath);

		FileFilter directoryFileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
		List<String> foldersInDirectory = new ArrayList<String>(directoryListAsFile.length);
		for (File directoryAsFile : directoryListAsFile) {
			foldersInDirectory.add(directoryAsFile.getName());
		}
		return foldersInDirectory;
	}

	public List<String> getFilesInFolder(String directoryPath, String latestFolder) {
		List<String> results = new ArrayList<String>();
		File[] files = new File(directoryPath + "\\" + latestFolder).listFiles();
		for (File file : files) {
			if (file.isFile()) {
				results.add(directoryPath + "\\" + latestFolder + "\\" + file.getName());
			}
		}
		return results;
	}

	public String[] getTimeStamp(List<String> allFilesFromLatestFolder) throws IOException {
		String fileName = null;
		//String timeStamp = null;
		String timeStamp[]=new String[4];
		for (int i = 0; i < allFilesFromLatestFolder.size(); i++) {
			File file = new File(allFilesFromLatestFolder.get(i));
			String str1 = "assessment starts";
			String str2 = "assessment ends";
			final Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				final String lineFromFile = scanner.nextLine();
				if (lineFromFile.contains(str1) && !lineFromFile.matches("^(?:\\p{L}\\p{M}*|[\\-])*$")) {
					System.out.println(str1 + " in file = " + file.getName());
					fileName = file.getName();
					timeStamp[0] = lineFromFile;
				}

				if (lineFromFile.contains(str2) && !lineFromFile.matches("^(?:\\p{L}\\p{M}*|[\\-])*$")) {
					System.out.println(str2 + " in file = " + file.getName());
					fileName = file.getName();
					timeStamp[1] = lineFromFile;
				}
			}
		}
		timeStamp[0] = timeStamp[0].substring(timeStamp[0].indexOf("[INFO]") + 6, timeStamp[0].indexOf("(") - 1);
		timeStamp[1] = timeStamp[1].substring(timeStamp[1].indexOf("[INFO]") + 6, timeStamp[1].indexOf("(") - 1);
		//timeStamp = "Exam start time " + startTime + "Exam end time " + endTime;
		return timeStamp ;
	}	
	
	public void compareLocalAndPortalLogs(String localTimestamp[], String portalTimestamp[]) {
		Date dt = new Date();
		String localLogStartTime = localTimestamp[0];
		String localEndTimeTime = localTimestamp[1];
		String portalLogStartTime = portalTimestamp[0];
		String portalLogEndTime = portalTimestamp[1];
		
		String getLocalStartTime = localLogStartTime.substring(localLogStartTime.indexOf(Integer.toString(dt.getDate()))+2,
				localLogStartTime.indexOf(Integer.toString(dt.getYear()+1900))-4);
		String getLocalEndTime = localEndTimeTime.substring(localEndTimeTime.indexOf(Integer.toString(dt.getDate()))+2,
				localEndTimeTime.indexOf(Integer.toString(dt.getYear()+1900))-4);
		System.out.println("date1 is " + getLocalStartTime.replace(" ", ""));
		System.out.println("date2 is " + getLocalEndTime.replace(" ", ""));
		
		String getPortalStartTime = portalLogStartTime.substring(0,portalLogStartTime.indexOf("PM")-4);
		String getPortalEndTime = portalLogEndTime.substring(0,portalLogEndTime.indexOf("PM")-4);
		System.out.println("date12 is " + getPortalStartTime);
		System.out.println("date22 is " + getPortalEndTime);
		
		if(getLocalStartTime.replace(" ", "").equals(getPortalStartTime))
			System.out.println("Exam start time matched");
		else System.out.println("Exam start time not matched");
		if(localEndTimeTime.replace(" ", "").equals(getPortalEndTime)) 
			System.out.println("Exam end time matched");
			else System.out.println("Exam end time not matched");
	}
}

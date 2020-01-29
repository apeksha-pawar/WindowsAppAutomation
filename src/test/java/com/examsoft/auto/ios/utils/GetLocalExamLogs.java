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


	public void findLogsFromLocal() throws IOException {
		String dir = "C:\\ProgramData\\Examplify";
		String latestFolder = findFoldersInDirectory(dir).get(findFoldersInDirectory(dir).size() - 5);
		List<String> allFilesFromLatestFolder = getFilesInFolder(dir, latestFolder);
		System.out.println("Latest Folder = " + latestFolder);
		String timeStamp = getTimeStamp(allFilesFromLatestFolder);
		System.out.println(timeStamp);
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

	public String getTimeStamp(List<String> allFilesFromLatestFolder) throws IOException {
		String fileName = null;
		String startTime = null;
		String endTime = null;
		String timeStamp = null;
		for (int i = 0; i < allFilesFromLatestFolder.size(); i++) {
			File file = new File(allFilesFromLatestFolder.get(i));
			String str1 = "assessment starts";
			String str2 = "assessment ends";
			final Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				final String lineFromFile = scanner.nextLine();
				if (lineFromFile.contains(str1) && !lineFromFile.matches("^(?:\\p{L}\\p{M}*|[\\-])*$")) {
					System.out.println("-----I found " + str1 + " in file = " + file.getName());
					fileName = file.getName();
					startTime = lineFromFile;
				}

				if (lineFromFile.contains(str2) && !lineFromFile.matches("^(?:\\p{L}\\p{M}*|[\\-])*$")) {
					System.out.println("-----I found " + str2 + " in file = " + file.getName());
					fileName = file.getName();
					endTime = lineFromFile;
				}
			}
		}
		startTime = startTime.substring(startTime.indexOf("[INFO]") + 6, startTime.indexOf("(") - 1);
		endTime = endTime.substring(endTime.indexOf("[INFO]") + 6, endTime.indexOf("(") - 1);
		timeStamp = "Exam start time " + startTime + "Exam end time " + endTime;
		return timeStamp = "Exam start time " + startTime + '\n' + "Exam end time " + endTime;
	}
}

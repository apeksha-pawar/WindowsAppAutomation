package com.examsoft.auto.win.core.tests;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
public class TestMethods {

	public static void main(String[] args) {
//		String line = "[Thread ID:65032][INFO]	Mon Jan 27 11:56:40 2020:(1580106400309)	 UI: assessment starts";
//		String op = line.substring(line.indexOf("[INFO]")+6,line.indexOf("(")-1);
//		System.out.println(op);
//		Properties prop = new Properties();
//		prop.put("PLATFORM", "WEB");
//		prop.setProperty("PLATFORM", "WEB");
//		System.out.println(prop.getProperty("PORTAL_URL"));
		Date dt = new Date();
		System.out.println("Date " + dt.getYear()+1900);
		String localLogStartTime = "Tue Jan 30 12:11:10 2020";
		String localEndTimeTime = "Tue Jan 30 12:11:31 2020";
		String portalLogStartTime = "12:11:14 PM";
		String portalLogEndTime = "12:11:32 PM";
		
		String str1st = localLogStartTime.substring(localLogStartTime.indexOf(Integer.toString(dt.getDate()))+2,
				localLogStartTime.indexOf(Integer.toString(dt.getYear()+1900))-4);
		String str1et = localEndTimeTime.substring(localEndTimeTime.indexOf(Integer.toString(dt.getDate()))+2,
				localEndTimeTime.indexOf(Integer.toString(dt.getYear()+1900))-4);
		System.out.println("date1 is " + str1st.replace(" ", ""));
		System.out.println("date2 is " + str1et.replace(" ", ""));
		
		String str2st = portalLogStartTime.substring(0,portalLogStartTime.indexOf("PM")-4);
		String str2et = portalLogEndTime.substring(0,portalLogEndTime.indexOf("PM")-4);
		System.out.println("date12 is " + str2st);
		System.out.println("date22 is " + str2et);
		
		if(str1st.replace(" ", "").equals(str2st))
			System.out.println("Exam start time matched");
		else System.out.println("Exam start time not matched");
		if(str1et.replace(" ", "").equals(str2et)) 
			System.out.println("Exam end time matched");
			else System.out.println("Exam end time not matched");
	}
	
}

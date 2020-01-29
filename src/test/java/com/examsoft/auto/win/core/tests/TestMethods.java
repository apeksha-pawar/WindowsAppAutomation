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
		Properties prop = new Properties();
		prop.put("PLATFORM", "WEB");
		prop.setProperty("PLATFORM", "WEB");
		System.out.println(prop.getProperty("PORTAL_URL"));
	}

}

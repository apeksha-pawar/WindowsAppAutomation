package com.examsoft.auto.ios.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.examsoft.auto.ios.core.base.PageBase;

import io.appium.java_client.AppiumDriver;

public class TestUtils extends PageBase {
	public String selectDevice;
	public static String ldapSchool;
	public static String ldapSchoolID;
	public static String ldapET;
	public static String ldapPassword;
	public static String ldapSchoolIDOverride;
	public static String ldapSchoolOverride;
	public static String ldapETOverride;
	public static String ldapPasswordOverride;
	public static String wrongInstitutionUsername;
	public static String wrongInstitutionPassword;
	public static String school;
	public static String schoolId;
	public static String disclaimerUsername;
	public static String disclaimerPassword;
	public static String defaultUsername;
	public static String defaultPassword;
	public static String invalidUsername;
	public static String invalidPassword;
	public static String labAccountUsername;
	public static String labAccountPassword;
	public static String AccommodationET;
	public static String AccommodationPwd;
	public static String nonIpadSchoolID;
	public static String nonIpadSchool;
	public static String nonIpadSchoolIDNewPortal;
	public static String nonIpadSchoolNewPortal;
	public static String apacSchool;
	public static String apacSchoolID;
	public static String apacET;
	public static String apacPassword;
	public static String essayMinimumCharacters;
	public static String essayCharacters;
	public static String essayLargeCharacters;
	public static String essayMisspelledCharacters1;
	public static String essayMisspelledCharacters2;
	public static String fitbMaxCharacters;
	public static String fitbReviewAnswer1;
	public static String fitbReviewAnswer2;
	public static String fitbReviewAnswer3;
	public static String notesStringA;
	public static String notesStringB;
	public static String notesStringC;
	public static String notesMaxCharacters;
	public static String questionTextBackwardDisable;
	public static String questionTextRequireAnswerEnable;
	public static String requireAnswerEnableExam;
	public static String mcq;
	public static String tf;
	public static String fitb;
	public static String essay;
	public static String Randomization_on1;
	public static String Randomization_on2;
	public static String Randomization_on3;
	public static String Randomization_on4;
	public static String Randomization_on5;
	public static String Randomization_on6;
	public static String Randomization_on7;
	public static String Randomization_off1;
	public static String Randomization_off2;
	public static String Randomization_off3;
	public static String Randomization_off4;
	public static String Randomization_off5;
	public static String Randomization_off6;
	public static String Randomization_off7;
	public static String Randomization_off8;
	public static String Randomization_off9;
	public static String Randomization_off10;
	public static String Randomization_off11;
	public static String Randomization_off12;
	public static String Randomization_off13;
	public static String Randomization_off14;
	public static String Randomization_off15;
	public static String Randomization_off16;

	public static HashMap<String, String> bigExamMap = new HashMap<String, String>();
	public static HashMap<String, String> normalExamMap = new HashMap<String, String>();
	public static HashMap<String, String> accommodationRulesExamMap = new HashMap<String, String>();
	public static HashMap<String, String> map = new HashMap<String, String>();

	public static List<String> examList = new ArrayList<String>();
	public static String smallExam;
	public static String bigExam;
	public static String examToCheckRules;
	public static String examToCheckRulesVerify;
	public static String smallExamWithoutStatus;
	public static String bigExamWithoutStatus;
	public static String randomizeExam;
	public static String numberingOffExam;
	public static String immediateReviewExam;
	public static String lockedChoice1;
	public static String lockedChoice2;
	public static String lockedChoice3;
	public static String lockedChoice4;
	public static String lockedChoice5;
	public static String lockedChoice6;

	public static int add2num1;
	public static int add2num2;
	public static String add2numResult;

	public static int tanNum;
	public static String tannumResult;

	public static int divideBy0num1;
	public static int divideBy0;
	public static String divideBy0Result;

	public static int add3num1;
	public static int add3num2;
	public static int add3num3;
	public static String add3numResult;

	public static int div2num1;
	public static int div2num2;
	public static String div2numResult;

	public static Double divDeci2num1;
	public static Double divDesi2num2;
	public static String divDeci2numResult;

	public static int factoNum;
	public static String factoNumResult;

	public static int sqrtNum;
	public static String sqrtNumResult;
	public static int sqrtNum2;
	public static String sqrtSqrtNumResult;

	public static String piResult;

	public static String piReciprocalResult;

	public static int powFunNum1;
	public static int powFunNum2;
	public static String powFunResult;

	public static String hour1;
	public static String min1;
	public static String sec1;
	public static String hour1Verify;
	public static String min1Verify;
	public static String hour2;
	public static String min2;
	public static String sec2;
	public static String hour2Verify;
	public static String min2Verify;
	public static String hour3;
	public static String min3;
	public static String sec3;
	public static String hour3Verify;
	public static String min3Verify;
	public static String hour4;
	public static String min4;
	public static String sec4;
	public static String hour4Verify;
	public static String min4Verify;
	
	public static String winAppLocation;
	public static String winDeviceName;
	public static String platform;

	public TestUtils(AppiumDriver<WebElement> driver) {
		super(driver);

		selectDevice = prop.getProperty("DEVICE");

		// UserName Fields
		school = prop.getProperty("SCHOOL");
		schoolId = prop.getProperty("SCHOOL_ID");

		wrongInstitutionUsername = prop.getProperty("WRONG_INSTITUTION_USERNAME");
		wrongInstitutionPassword = prop.getProperty("WRONG_INSTITUTION_PASSWORD");

		disclaimerUsername = prop.getProperty("DISCLAIMER_ET_USERNAME");
		disclaimerPassword = prop.getProperty("DISCLAIMER_ET_PASSWORD");

		defaultUsername = prop.getProperty("USERNAME");
		defaultPassword = prop.getProperty("PASSWORD");

		invalidUsername = prop.getProperty("WRONG_USERNAME");
		invalidPassword = prop.getProperty("WRONG_PASSWORD");

		labAccountUsername = prop.getProperty("LAB_USERNAME");
		labAccountPassword = prop.getProperty("LAB_PASSWORD");

		AccommodationET = prop.getProperty("ACCOMMODATION_USERNAME");
		AccommodationPwd = prop.getProperty("ACCOMMODATION_PWD");

		ldapSchoolID = prop.getProperty("LDAP_SCHOOL_ID");
		ldapSchool = prop.getProperty("LDAP_SCHOOL");
		ldapET = prop.getProperty("LDAP_USERNAME");
		ldapPassword = prop.getProperty("LDAP_PASSWORD");
		ldapSchoolIDOverride = prop.getProperty("LDAP_OVERRIDE_SCHOOL_ID");
		ldapSchoolOverride = prop.getProperty("LDAP_OVERRIDE_SCHOOL");
		ldapETOverride = prop.getProperty("LDAP_OVERRIDE_USERNAME");
		ldapPasswordOverride = prop.getProperty("LDAP_OVERRIDE_PASSWORD");

		nonIpadSchoolID = prop.getProperty("NON_IPAD_SCHOOL_ID");
		nonIpadSchool = prop.getProperty("NON_IPAD_SCHOOL");

		nonIpadSchoolIDNewPortal = prop.getProperty("NON_IPAD_SCHOOL_ID_NEW_PORTAL");
		nonIpadSchoolNewPortal = prop.getProperty("NON_IPAD_SCHOOL_NEW_PORTAL");

		apacSchool = prop.getProperty("APAC_SCHOOL");
		apacSchoolID = prop.getProperty("APAC_SCHOOL_ID");
		apacET = prop.getProperty("APAC_USERNAME");
		apacPassword = prop.getProperty("APAC_PASSWORD");

		smallExam = prop.getProperty("SMALLEXAM");
		bigExam = prop.getProperty("BIGEXAM");
		examToCheckRules = prop.getProperty("ACCOMMODATION_RULES_EXAM");
		examToCheckRulesVerify = prop.getProperty("ACCOMMODATION_RULES_EXAM_VERIFICATION");
		requireAnswerEnableExam = prop.getProperty("REQUIRE_ANSWER_ENABLE_EXAM");
		randomizeExam = prop.getProperty("RANDOMIZE_EXAM");
		numberingOffExam = prop.getProperty("NUMBERINGOFF_EXAM");
		immediateReviewExam = prop.getProperty("IMMEDIATE_REVIEW_EXAM");

		examList.add(smallExam);
		examList.add(bigExam);
		smallExamWithoutStatus = smallExam.split(",")[0];
		bigExamWithoutStatus = bigExam.split(",")[0];

		bigExamMap.put("examName", bigExamWithoutStatus);
		bigExamMap.put("examId", "Exam ID: 1391351");
		bigExamMap.put("examType", "Exam Type: Non-Secure");
		bigExamMap.put("timeLimit", "Time Limit: No Limit");
		bigExamMap.put("navigation", "Backward Navigation: ON");
		bigExamMap.put("hightlighting", "Highlighting: ON");
		bigExamMap.put("calculator", "Calculator: ON");
		bigExamMap.put("copyPaste", "Copy & Paste: ON");
		bigExamMap.put("spellCheck", "Spell Check: ON");

		normalExamMap.put("examName", examToCheckRulesVerify);
		normalExamMap.put("examId", "Exam ID: 1096056");
		normalExamMap.put("examType", "Exam Type: Secure");
		normalExamMap.put("timeLimit", "Time Limit: 2 Minutes");
		normalExamMap.put("navigation", "Backward Navigation: ON");
		normalExamMap.put("hightlighting", "Highlighting: OFF");
		normalExamMap.put("calculator", "Calculator: OFF");
		normalExamMap.put("copyPaste", "Copy & Paste: OFF");
		normalExamMap.put("spellCheck", "Spell Check: OFF");

		accommodationRulesExamMap.put("examName", examToCheckRulesVerify);
		accommodationRulesExamMap.put("examId", "Exam ID: 1096056");
		accommodationRulesExamMap.put("examType", "Exam Type: Non-Secure");
		accommodationRulesExamMap.put("timeLimit", "Time Limit: 6 Minutes");
		accommodationRulesExamMap.put("navigation", "Backward Navigation: ON");
		accommodationRulesExamMap.put("hightlighting", "Highlighting: OFF");
		accommodationRulesExamMap.put("calculator", "Calculator: OFF");
		accommodationRulesExamMap.put("copyPaste", "Copy & Paste: OFF");
		accommodationRulesExamMap.put("spellCheck", "Spell Check: ON");

		// Question Type
		mcq = prop.getProperty("QUESTION_TYPE_MCQ");
		tf = prop.getProperty("QUESTION_TYPE_TF");
		essay = prop.getProperty("QUESTION_TYPE_ESSAY");
		fitb = prop.getProperty("QUESTION_TYPE_FITB");

		// Question Text for backward navigation OFF
		questionTextBackwardDisable = prop.getProperty("QUESTION_TEXT_BACKWARD_DISABLE");
		questionTextRequireAnswerEnable = prop.getProperty("QUESTION_TEXT_REQUIRE_ANSWER_ENABLE");

		// Essay textField
		essayCharacters = prop.getProperty("INPUT_CHARACTERS");
		essayMinimumCharacters = prop.getProperty("INPUT_MIN_CHARACTERS");
		essayLargeCharacters = prop.getProperty("INPUT_LARGE_DELETE");
		essayMisspelledCharacters1 = prop.getProperty("INPUT_MISSPELLED_CHARACTERS");
		essayMisspelledCharacters2 = prop.getProperty("INPUT_MISSPELLED_CHARACTERS_FIFTY");

		// FiTb textField
		fitbMaxCharacters = prop.getProperty("INPUT_MAX_FITB");
		fitbReviewAnswer1 = prop.getProperty("FITB_ANS_REVIEW1");
		fitbReviewAnswer2 = prop.getProperty("FITB_ANS_REVIEW2");
		fitbReviewAnswer3 = prop.getProperty("FITB_ANS_REVIEW3");

		// Notes textfield
		notesStringA = prop.getProperty("NOTES_CHARACTERS_A");
		notesStringB = prop.getProperty("NOTES_CHARACTERS_B");
		notesStringC = prop.getProperty("NOTES_CHARACTERS_C");
		notesMaxCharacters = prop.getProperty("NOTES_MAX_CHARACTERS");

		// Randomization OFF Exam
		Randomization_on1 = prop.getProperty("NO_RANDOM1");
		Randomization_on2 = prop.getProperty("NO_RANDOM2");
		Randomization_on3 = prop.getProperty("NO_RANDOM3");
		Randomization_on4 = prop.getProperty("NO_RANDOM4");
		Randomization_on5 = prop.getProperty("NO_RANDOM5");
		Randomization_on6 = prop.getProperty("NO_RANDOM6");
		Randomization_on7 = prop.getProperty("NO_RANDOM7");

		// Randomization ON Exam
		Randomization_off1 = prop.getProperty("RANDOM1");
		Randomization_off2 = prop.getProperty("RANDOM2");
		Randomization_off3 = prop.getProperty("RANDOM3");
		Randomization_off4 = prop.getProperty("RANDOM4");
		Randomization_off5 = prop.getProperty("RANDOM5");
		Randomization_off6 = prop.getProperty("RANDOM6");
		Randomization_off7 = prop.getProperty("RANDOM7");
		Randomization_off8 = prop.getProperty("RANDOM8");
		Randomization_off9 = prop.getProperty("RANDOM9");
		Randomization_off10 = prop.getProperty("RANDOM10");
		Randomization_off11 = prop.getProperty("RANDOM11");
		Randomization_off12 = prop.getProperty("RANDOM12");
		Randomization_off13 = prop.getProperty("RANDOM13");
		Randomization_off14 = prop.getProperty("RANDOM14");

		// Answer choices Locked
		lockedChoice1 = prop.getProperty("LOCKED_CHOICE1");
		lockedChoice2 = prop.getProperty("LOCKED_CHOICE2");
		lockedChoice3 = prop.getProperty("LOCKED_CHOICE3");
		lockedChoice4 = prop.getProperty("LOCKED_CHOICE4");
		lockedChoice5 = prop.getProperty("LOCKED_CHOICE5");
		lockedChoice6 = prop.getProperty("LOCKED_CHOICE6");

		add2num1 = Integer.parseInt((prop.getProperty("CALC_ADD_TWO_NUM1")));
		add2num2 = Integer.parseInt(prop.getProperty("CALC_ADD_TWO_NUM2"));
		add2numResult = prop.getProperty("CALC_ADD_TWO_RESULT");

		tanNum = Integer.parseInt(prop.getProperty("CALC_TAN_NUM"));
		tannumResult = prop.getProperty("CALC_TAN_RESULT");

		divideBy0num1 = Integer.parseInt(prop.getProperty("DIVIDE_BY_ZERO_NUM"));
		divideBy0 = Integer.parseInt(prop.getProperty("DIVIDE_BY_ZERO"));
		divideBy0Result = prop.getProperty("DIVIDE_BY_ZERO_RESULT");

		add3num1 = Integer.parseInt(prop.getProperty("CALC_ADD_3_NUM1"));
		add3num2 = Integer.parseInt(prop.getProperty("CALC_ADD_3_NUM2"));
		add3num3 = Integer.parseInt(prop.getProperty("CALC_ADD_3_NUM3"));
		add3numResult = prop.getProperty("CALC_ADD_3_RESULT");

		div2num1 = Integer.parseInt(prop.getProperty("CALC_DIV_NUM1"));
		div2num2 = Integer.parseInt(prop.getProperty("CALC_DIV_NUM2"));
		div2numResult = prop.getProperty("CALC_DIV_RESULT");

		divDeci2num1 = Double.parseDouble(prop.getProperty("CALC_DECIMAL_DIV_NUM1"));
		divDesi2num2 = Double.parseDouble(prop.getProperty("CALC_DECIMAL_DIV_NUM2"));
		divDeci2numResult = prop.getProperty("CALC_DECIMAL_DIV_RESULT");

		factoNum = Integer.parseInt(prop.getProperty("CALC_FACTO"));
		factoNumResult = prop.getProperty("CALC_FACTO_RESULT");

		sqrtNum = Integer.parseInt(prop.getProperty("CALC_SQRT_NUM1"));
		sqrtNumResult = prop.getProperty("CALC_SQRT_RESULT");
		sqrtNum2 = Integer.parseInt(prop.getProperty("CALC_SQRT_NUM2"));
		sqrtSqrtNumResult = prop.getProperty("CALC_SQRT_SQRT_RESULT");

		piResult = prop.getProperty("PI_VALUE");
		piReciprocalResult = prop.getProperty("PI_RECIPROCAL_VAL");
		powFunNum1 = Integer.parseInt(prop.getProperty("POWER_FUN_NUM1"));
		powFunNum2 = Integer.parseInt(prop.getProperty("POWER_FUN_NUM2"));
		powFunResult = prop.getProperty("POWER_FUN_RESULT");

		// Alarm Timer and verification
		hour1 = prop.getProperty("TIMER_HR1");
		min1 = prop.getProperty("TIMER_MIN1");
		sec1 = prop.getProperty("TIMER_SEC1");
		hour1Verify = prop.getProperty("TIMER_HR1_VERIFY");
		min1Verify = prop.getProperty("TIMER_MIN1_VERIFY");
		hour2 = prop.getProperty("TIMER_HR2");
		min2 = prop.getProperty("TIMER_MIN2");
		sec2 = prop.getProperty("TIMER_SEC2");
		hour2Verify = prop.getProperty("TIMER_HR2_VERIFY");
		min2Verify = prop.getProperty("TIMER_MIN2_VERIFY");
		hour3 = prop.getProperty("TIMER_HR3");
		min3 = prop.getProperty("TIMER_MIN3");
		sec3 = prop.getProperty("TIMER_SEC3");
		hour3Verify = prop.getProperty("TIMER_HR3_VERIFY");
		min3Verify = prop.getProperty("TIMER_MIN3_VERIFY");
		hour4 = prop.getProperty("TIMER_HR4");
		min4 = prop.getProperty("TIMER_MIN4");
		sec4 = prop.getProperty("TIMER_SEC4");
		hour4Verify = prop.getProperty("TIMER_HR4_VERIFY");
		min4Verify = prop.getProperty("TIMER_MIN4_VERIFY");
		
		winAppLocation = prop.getProperty("APP_LOCATION");
		winDeviceName = prop.getProperty("WIN_DEVICE_NAME");

	}
}
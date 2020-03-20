package com.examsoft.auto.win.core.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.examsoft.auto.win.core.pages.CBT_CreateAssessment;

public class Test_CreateAssessments {
	CBT_CreateAssessment exams;
	
	@BeforeMethod
	public void setUp() {
		exams = new CBT_CreateAssessment();
	}
	
	@Test
	public void createNewExam() throws FileNotFoundException, InterruptedException, IOException {
		exams.createSecureExam();
	}
}

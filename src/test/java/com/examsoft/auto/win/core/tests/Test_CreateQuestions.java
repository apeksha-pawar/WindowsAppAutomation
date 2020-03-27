package com.examsoft.auto.win.core.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.examsoft.auto.win.core.pages.Create_Questions;

public class Test_CreateQuestions {
	Create_Questions que;
	
	@BeforeMethod
	public void setUp() {
		que = new Create_Questions();
	}
	
	@Test
	public void createQue() throws FileNotFoundException, IOException, InterruptedException {
		que.CreateDefaultScoringQuestions();
	}
}

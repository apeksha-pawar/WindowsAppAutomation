package com.examsoft.auto.win.core.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.examsoft.auto.ios.core.base.BaseTest;
import com.examsoft.auto.win.core.pages.Marker_AttemptExamWithNotice;
import com.examsoft.auto.win.core.pages.Scoring_AllCases;

public class Test_Scoring extends BaseTest {
	Scoring_AllCases score;
	Marker_AttemptExamWithNotice marker;
	
	@BeforeMethod
	public void  testSetup() {
		score = new Scoring_AllCases(winDriver);
		marker = new Marker_AttemptExamWithNotice(winDriver);
	}
	
	@Test
	public void validateAllScore() throws InterruptedException {
		score.validatePerfectScore(marker);
		score.validateHalfScore(marker);
		score.validateZeroPercentScore(marker);
	}
}

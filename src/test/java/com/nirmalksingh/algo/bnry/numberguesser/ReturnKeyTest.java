package com.nirmalksingh.algo.bnry.numberguesser;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author nirmalksingh
 *
 */

@RunWith(JUnit4.class)
public class ReturnKeyTest{
	

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test for a series of carriage returns entered by the user.
	 */
	@Test
	public void testCarriageReturns() {
			SetUserInputScanner.testType = "makeReady";
			SetUserInputScanner.setScanner("makeReady");
			String userInput = UserAnswerValidator.makeReady();
			assertEquals(GuessRevealerConstants.READY, userInput);
	}
	
}

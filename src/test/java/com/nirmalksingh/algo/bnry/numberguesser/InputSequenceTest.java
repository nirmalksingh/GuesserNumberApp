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
public class InputSequenceTest{
	

	
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
	 * Test for a wrong sequence of higher and lower indicator values entered by user.
	 * 
	 */
	@Test
	public void testSequence() {
		SetUserInputScanner.testType = "sequenceTest";
		SetUserInputScanner.setScanner("sequenceTest");
		GuessRevealerApp.guessUserNumber();
		assertEquals(GuessRevealerConstants.END, SetUserInputScanner.userInput);	
	}	
	
}

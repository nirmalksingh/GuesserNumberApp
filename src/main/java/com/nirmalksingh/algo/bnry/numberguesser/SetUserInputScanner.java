package com.nirmalksingh.algo.bnry.numberguesser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author nirmalksingh
 *
 */

public class SetUserInputScanner {

	static Scanner inputScanner = MyInputScanner.INSTANCE;
	
	static int noOfReturns;
	public static String testType;
	public static ArrayList<Object> makeReadyEnters;
	private static int enterCount;
	private static int enterTestCount=0;
	public static ArrayList<Object> wrongSequenceAnswers;
	public static int wrongSeqCount;
	public static int sequenceTestCount=0;
	public static String userInput;

	private static ArrayList<Object> randomKeys;
	private static int randomCount;
	private static int randomTestCount=0;

	public static void setScanner(String testName) {
		testType = testName;
	}

	/*
	 * This block decides whether the test run or the application
	 * Sets the input scanner or the data sets as data for the guessing game program.
	 */
	public static String getUserInput() {
		if (testType == null) {
			userInput = inputScanner.nextLine();
		} else if (testType.equalsIgnoreCase("makeReady")) {
			createEnterTestSet();
			if (enterTestCount < enterCount)
				userInput = (String) makeReadyEnters.get(enterTestCount++);
		}else if (testType.equalsIgnoreCase("sequenceTest")) {
			createWrongSequenceTestSet();
			if (sequenceTestCount<wrongSeqCount)
				userInput = (String) wrongSequenceAnswers.get(sequenceTestCount++);
		}
		else if (testType.equalsIgnoreCase("randomKeyPress")) {
			createPlayfulSet();
			if (randomTestCount<randomCount)
				userInput = (String) randomKeys.get(randomTestCount++);
		}

		return userInput;
	}

	/*
	 * Data sets for user input of carriage returns and "end"
	 */
	private static void createEnterTestSet() {

		makeReadyEnters = new ArrayList<>();

		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.NEW_LINE);
		makeReadyEnters.add(GuessRevealerConstants.READY);

		enterCount = makeReadyEnters.size();

	}

	/*
	 * Data sets for user input of wrong sequence of lower and higher markers
	 * for the computer generated guess.
	 */
	private static void createWrongSequenceTestSet() {
		
		wrongSequenceAnswers = new ArrayList<>();
		
		wrongSequenceAnswers.add(GuessRevealerConstants.READY);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.HIGHER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.HIGHER);
		wrongSequenceAnswers.add(GuessRevealerConstants.HIGHER);
		wrongSequenceAnswers.add(GuessRevealerConstants.HIGHER);
		wrongSequenceAnswers.add(GuessRevealerConstants.LOWER);
		wrongSequenceAnswers.add(GuessRevealerConstants.HIGHER);
		wrongSequenceAnswers.add(GuessRevealerConstants.END);
		
		wrongSeqCount = wrongSequenceAnswers.size();
		
	}
	
	/*
	 * Data sets for user input of random key presses other than expected values.
	 */
	private static void createPlayfulSet() {

		randomKeys = new ArrayList<>();

		randomKeys.add(GuessRevealerConstants.RANDOM_TEXT1);
		randomKeys.add(GuessRevealerConstants.RANDOM_TEXT2);
		randomKeys.add(GuessRevealerConstants.RANDOM_TEXT3);
		randomKeys.add(GuessRevealerConstants.RANDOM_TEXT4);
		randomKeys.add(GuessRevealerConstants.RANDOM_TEXT5);
		randomKeys.add(GuessRevealerConstants.RANDOM_TEXT6);
		randomKeys.add(GuessRevealerConstants.RANDOM_TEXT7);
		randomKeys.add(GuessRevealerConstants.END);

		randomCount = randomKeys.size();

	}
	
}

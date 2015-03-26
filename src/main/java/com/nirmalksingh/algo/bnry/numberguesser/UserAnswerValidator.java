package com.nirmalksingh.algo.bnry.numberguesser;

import java.util.Scanner;

/**
 * @author nirmalksingh
 */

public class UserAnswerValidator {

	static String userInput;

	static Scanner inputScanner = MyInputScanner.INSTANCE;

	/*
	 * Loops for useful answer in beginning for either ready or end. 
	 * Returns to calling method.
	 */
	public static String makeReady() {
		
		System.out.println(GuessRevealerConstants.READY_BEGIN_END);
		
		/**
		 * Unit tests setup "testType" to the type of test 
		 * If testType null, proceed with execution.
		 */
		if(SetUserInputScanner.testType==null){
			userInput = inputScanner.nextLine();
		}else{
			userInput = SetUserInputScanner.getUserInput();
			System.out.println(userInput);
		}
		
		/**
		 * Take only "ready", "end" as argument, all others will make program to keep looping here.
		 */
		while (!userInput.equalsIgnoreCase(GuessRevealerConstants.READY)){
			
			/**
			 * returns to calling method when the user is ready.
			 * User can still not be ready after returning from here.
			 * The calling method will catch such activity.
			 */
			if(userInput.equalsIgnoreCase(GuessRevealerConstants.READY)){
				
				break;
			
				/**
				 * End the execution and return if user enters end.
				 */
			}else if (userInput.equalsIgnoreCase(GuessRevealerConstants.END)){
				
				System.out.println(GuessRevealerConstants.ENTERED_END_EXITING);
				return userInput;
			
			}else{
				
				System.out.println(GuessRevealerConstants.READY_BEGIN_END);
				if(SetUserInputScanner.testType==null){
					userInput = inputScanner.nextLine();
				}else{
					userInput = SetUserInputScanner.getUserInput();
					System.out.println(userInput);
				}
			}
		}
		return userInput;
	}
	
	/*
	 * Method for user answer; loops for useful answer and
	 * returns to calling to calling method.
	 */
	
//	public static String higherLowerYesEnd(int guess) {
	public static String higherLowerYesEnd() {
		if(inputScanner==null){
			inputScanner = MyInputScanner.INSTANCE; 
		}
		System.out.println(GuessRevealerConstants.IS_HIGHER_LOWER_EQUAL_TO+GuessRange.guess+ GuessRevealerConstants.YES_FOR_RIGHT_HIGHER_LOWER);
		if(SetUserInputScanner.testType==null){
			userInput = inputScanner.nextLine();
		}else{
			userInput = SetUserInputScanner.getUserInput();
			System.out.println(userInput);
		}
//		userInput=SetUserInputScanner.getUserInput();
//		System.out.println(userInput);
		/*
		while(!userInput.equalsIgnoreCase(GuessRevealerConstants.HIGHER)
				&&!userInput.equalsIgnoreCase(GuessRevealerConstants.LOWER)
				&&!userInput.equalsIgnoreCase(GuessRevealerConstants.YES)){
			
//			userInput=makeReady();
//			userInput=higherLowerYesEnd(guess);
			SetUserInputScanner.testType="makeReady";
			userInput=SetUserInputScanner.getUserInput();
//			userInput=SetUserInputScanner.getUserInput();
			
		}
		*/
		while (!userInput.equalsIgnoreCase(GuessRevealerConstants.HIGHER)
				&&!userInput.equalsIgnoreCase(GuessRevealerConstants.LOWER)
				&&!userInput.equalsIgnoreCase(GuessRevealerConstants.YES)){
				
			
			if(userInput.equalsIgnoreCase(GuessRevealerConstants.HIGHER)
					||userInput.equalsIgnoreCase(GuessRevealerConstants.LOWER)
					||userInput.equalsIgnoreCase(GuessRevealerConstants.YES)){
				
				break;
			
			}else if (userInput.equalsIgnoreCase(GuessRevealerConstants.END)){
				
				System.out.println(GuessRevealerConstants.ENTERED_END_EXITING);
				return userInput;
			
			}else{
				
				System.out.println(GuessRevealerConstants.HIGHER_LOWER_YESR_END);
				if(SetUserInputScanner.testType==null){
					userInput = inputScanner.nextLine();
				}else{
					userInput = SetUserInputScanner.getUserInput();
					System.out.println(userInput);
				}
			}
		}
		return userInput;
	}
}

package com.nirmalksingh.algo.bnry.numberguesser;

/**
 * 
 * @author nirmalksingh
 *
 */

public class GuessRevealerApp {

	public static void main(String[] args) {
		/**
		 * The method to set range and determine how to adjust range for guessing number
		 * Uses Binary Search algorithm.
		 */
		guessUserNumber();
	}

	public static void guessUserNumber() {

		String userInput = null;

		/**
		 * Check for test mode or program execution mode.
		 * Unit test setup "testType" with the name for the test.
		 */
		if (SetUserInputScanner.testType == null) {
			userInput = UserAnswerValidator.makeReady();
			if (userInput.equalsIgnoreCase(GuessRevealerConstants.END)) {
				return;
			}
		} else {
			userInput = SetUserInputScanner.getUserInput();
			System.out.println(userInput);
		}

		/**
		 * 
		 * One point Change in range will be made only in GuessRange.java
		 * 
		 */
		GuessRange.setRange();

		do {
			/**
			 * Offer user with initial guess of mid point number from the range.
			 * Binary search algorithm is employed.
			 */
			GuessRange.guess = GuessRange.calculateGuess();

			userInput = UserAnswerValidator.higherLowerYesEnd();
			if (userInput.equals(GuessRevealerConstants.HIGHER)) {

				/**
				 * adjust the range based on user input of higher or lower.
				 */
				userInput = adjustBinarySearchRange(GuessRevealerConstants.HIGHER);

			} else if (userInput.equals(GuessRevealerConstants.LOWER)) {

				userInput = adjustBinarySearchRange(GuessRevealerConstants.LOWER);

				/**
				 * Return if guess is reached.
				 */
			} else if (userInput.equalsIgnoreCase(GuessRevealerConstants.YES)) {

				System.out.println(GuessRevealerConstants.CONGRATULATIONS
						+ GuessRange.guess + GuessRevealerConstants.COUNT
						+ GuessRange.numberOfGuesses);
				return;
			}

		} while (!userInput.equals(GuessRevealerConstants.END));

		System.out.println(userInput);
		return;
	}

	private static String adjustBinarySearchRange(String key) {
		String userInput = key;
		if (key.equalsIgnoreCase(GuessRevealerConstants.HIGHER)) {
			
			/**
			 * Check for erroneous user answer, reset range for low high Restart
			 * the guessing game
			 */
			if (GuessRange.guess == GuessRange.high
					|| GuessRange.guess == GuessRange.low) {
				System.out.println(GuessRevealerConstants.INCORRECT_USER_ANSWER);

				GuessRange.setRange();
				GuessRange.errorCount++;

				if (GuessRange.errorCount > 0) {
					userInput = UserAnswerValidator.makeReady();
					GuessRange.numberOfGuesses = 1;
				}
				
				/**
				 *Switch low to search the other half.
				 */
			} else {
				GuessRange.low = GuessRange.guess;
				GuessRange.numberOfGuesses++;
			}

		} else if (key.equalsIgnoreCase(GuessRevealerConstants.LOWER)) {

			/**
			 * Check for erroneous user answer, reset to original range for low
			 * high Restart the guessing game, keep count of arrival at same guess 
			 * Reset range, notify user 
			 */
			if (GuessRange.guess == GuessRange.low
					|| GuessRange.guess == GuessRange.high) {
				System.out.println(GuessRevealerConstants.INCORRECT_USER_ANSWER);

				/**
				 * Reset range
				 */
				GuessRange.setRange();
				GuessRange.errorCount++;

				/**
				 * Notify user if guess arrives at previously ignored guess by the user
				 * Query the user for readiness.
				 */
				if (GuessRange.errorCount > 0) {
					userInput = UserAnswerValidator.makeReady();
					GuessRange.numberOfGuesses = 1;
				}
				
				/**
				 *Switch high to search the other half.
				 */
			} else {
				GuessRange.high = GuessRange.guess;
				GuessRange.numberOfGuesses++;
			}
		}
		return userInput;
	}
}
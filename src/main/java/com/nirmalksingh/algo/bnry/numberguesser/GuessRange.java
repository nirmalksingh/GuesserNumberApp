package com.nirmalksingh.algo.bnry.numberguesser;


public class GuessRange {
	
	protected static int guess;
	protected static int low;
	protected static int high;
	protected static int numberOfGuesses=1;
	protected static int errorCount=0;
	
	public final static GuessRange INSTANCE = new GuessRange();
	private GuessRange() {
		// bloc instantiation with this custom constructor.
	}
	
	protected static void setRange(){
		low =0;
		high=100000;
		guess = (low + high)/2;
	}

	protected static int calculateGuess() {
		guess = (low+high)/2;
		return guess;
	}

}

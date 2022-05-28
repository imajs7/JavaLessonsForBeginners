package com.jsclasses.practice;

public class FinalValueAfterOperations {
	
	/**
	 * There is a programming language with only four operations and one variable X:
	 * ++X and X++ increments the value of the variable X by 1.
	 * --X and X-- decrements the value of the variable X by 1.
	 * Initially, the value of X is 0.
	 * 
	 * Given an array of strings operations containing a list of operations, 
	 * return the final value of X after performing all the operations.
	 * 
	 */

	public static void main(String[] args) {
		
		String[] input = {"++X","++X","X++"};
		
		int ans = finalValueAfterOperations(input);
		
		System.out.println( ans );

	}
	
	public static int finalValueAfterOperations(String[] operations) {
		int x = 0;
		int i = 0;
		while(i < operations.length) {
			switch(operations[i]) {
				case "--X": --x; break;
				case "X--": x--; break;
				case "++X": ++x; break;
				case "X++": x++; break;
				default: 
			}
			i++;
		}
		return x;
    }

}

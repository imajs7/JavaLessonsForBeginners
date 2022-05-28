package com.jsclasses.corejava;

public class ReverseNumber {

	public static void main(String[] args) {
		
		/*
		 * LeetCode Question: Given a signed 32-bit integer x, return x with 
		 * its digits reversed. If reversing x causes the value to go outside 
		 * the signed 32-bit integer range [-231, 231 - 1], then return 0.
		 * 
		 * https://leetcode.com/problems/reverse-integer/
		 */
		
		int num = -5674574;
		
		ReverseNumber rn = new ReverseNumber();
		
		System.out.println( rn.reverse(num) );
		
				
	}
	
	private int reverse(int num) {
		
		int rev = 0;
		
		if(num > 2147483647 || num < -2147483648 ) {
			return 0;
		} else {
			
			
			while(num != 0) {
				rev = rev * 10 + num % 10;
				num = num / 10;
			}
			
			return rev;
			
		}
		
	}

}

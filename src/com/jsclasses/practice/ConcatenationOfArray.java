package com.jsclasses.practice;

import java.util.Arrays;

public class ConcatenationOfArray {

	/**
	 * Given an integer array nums of length n, you want to create an array ans of length 2n 
	 * where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed). 
	 * Specifically, ans is the concatenation of two nums arrays.
	 * Return the array ans.
	 * 
	 * Strategy :
	 * ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
	 */
	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 1};
		
		int[] ans = getConcatenation(nums);
		
		System.out.println( Arrays.toString(ans) );

	}
	
	public static int[] getConcatenation(int[] nums) {
		
		int n = nums.length;
		
		int[] ans = new int[2*n];
        
		for(int i  = 0; i < n; i++) {
			ans[i] = nums[i];
			ans[i + n] = nums[i];
		}
		
		return ans;
    }

}

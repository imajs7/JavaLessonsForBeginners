package com.jsclasses.practice;

import java.util.Arrays;

public class RunningSumof1DArray {
	
	/**
	 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
	 * 
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 2};
		
		int[] runningSum = runningSum(nums);
		
		System.out.println( Arrays.toString(runningSum) );

	}

	public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
        	sum = sum + nums[i];
        	nums[i] = sum;
        }
		return nums;
    }

}

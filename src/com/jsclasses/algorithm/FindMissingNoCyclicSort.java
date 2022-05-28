package com.jsclasses.algorithm;

import java.util.Arrays;

public class FindMissingNoCyclicSort {

	public static void main(String[] args) {

		FindMissingNoCyclicSort num = new FindMissingNoCyclicSort();
		
		int[] arr = {4, 5, 7, 1, 2, 6};
		
		int missing = num.findMissing(arr);
		
		System.out.println("Missing number in the series is "+missing);

	}
	
	private void display(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	private int findMissing(int[] arr) {
		
		Arrays.sort(arr);
		
		display(arr);
		
		int i = 0;
		while( i < arr.length ) {
			if( arr[i] - 1 != i ) {
				return i+1;
			}
			i++;
		}
		return -1;
		
	}

}

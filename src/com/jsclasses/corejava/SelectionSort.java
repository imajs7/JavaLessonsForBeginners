package com.jsclasses.corejava;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		SelectionSort ss = new SelectionSort();
		
		int[] arr = {2, 7, 4, 3, 5, 6, 1};
		
		if( ! ss.checkStatus(arr) ) {
			System.out.println("Unsorted Array");
			ss.printValues(arr);
			ss.selectionSort(arr);
		}
		
		System.out.println("Sorted Array");		
		ss.printValues(arr);

	}
	
	private void printValues(int[] arr) {
		System.out.println( Arrays.toString(arr) );
	}
	
	private int[] selectionSort(int[] arr) {
		
		/*
		 * placing i-th smallest value at i-th index
		 */
		
		int index, temp;

		for(int i = 0; i < arr.length; i++) {
			
			index = i;
			
			for(int j = i; j < arr.length - 1; j++) {
				
				if(arr[j+1] < arr[index]) {  // finding index of smallest value

					index = j + 1;
					
				}
				
			}
			
			// swapping smallest value with i-th index value
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
				
		}
		
		
		return arr;
	}
	
	private boolean checkStatus(int[] arr) {
		
		boolean sorted = true;
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i + 1])
				sorted = false;
		}
		
		return sorted;
	}

}

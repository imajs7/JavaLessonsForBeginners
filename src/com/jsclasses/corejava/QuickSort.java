package com.jsclasses.corejava;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		QuickSort service = new QuickSort();

		int[] arr = {34, 25, 67, 5, 4, 36, 2, 90};
		
		System.out.println("Unsorted Array!");
		service.printValues(arr);
		
		service.quickSort(arr, 0, arr.length -1);
		
		System.out.println("Sorted Array!");
		service.printValues(arr);

	}
	
	private void quickSort(int[] arr, int left, int right) {
		
		/*
		 * finding pivot and place at its correct place then split the array into two
		 * halves where the counters stopped
		 */
		
		if(left >= right) {
			return;
		}
		
		int start = left;
		int end = right;
		int mid = start + (end - start)/2;		
		int pivot = arr[mid];
		
		while(start <= end) {

			while(arr[start] < pivot) {
				start++;
			}
			
			while(arr[end] > pivot) {
				end--;
			}
			
			if(start <= end) {
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;
				start++;
				end--;
			}
			
		}
		
		// sort left side of pivot & right side of pivot
		quickSort(arr, left, end);
		quickSort(arr, start, right);
		
	}
	
	private void printValues(int[] arr) {
		System.out.println( Arrays.toString(arr) );
	}

}

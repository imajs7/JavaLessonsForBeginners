package com.jsclasses.corejava;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		InsertionSort service = new InsertionSort();
		
		int[] arr = {45, 34, 82, 32, 21, 2, 94};
		
		System.out.println("Unsorted Array!");
		service.printValues(arr);
		
		arr = service.insertionSort(arr);
		
		System.out.println("Sorted Array!");
		service.printValues(arr);

	}
	
	private void printValues(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	private int[] insertionSort(int arr[]) {
		
		int j, axis;
		
		for(int i = 1; i < arr.length; i++) {
			j = i - 1;
			while( j >= 0 && arr[j + 1] < arr[j] ) {
				axis = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = axis;
				j--;
			}
		}
    
	    return arr;
	}

}

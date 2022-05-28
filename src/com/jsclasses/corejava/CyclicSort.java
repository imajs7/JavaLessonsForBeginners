package com.jsclasses.corejava;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
		
		CyclicSort cs = new CyclicSort();

		int[] arr = {2, 7, 4, 3, 5, 6, 1};
		
		System.out.println("Unsorted Array");
		cs.display(arr);
		
		cs.cyclicSort(arr);
		
		System.out.println("Sorted Array");
		cs.display(arr);

	}
	
	private void display(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	private void cyclicSort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			
			while(arr[i] - 1 != i) {
				int temp = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = temp;
			}
			
		}
		
	}

}

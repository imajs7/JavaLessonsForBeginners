package com.jsclasses.corejava;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {131, 27, 81, 239, 43, 55, 211};
		
		BubbleSort bs = new BubbleSort();
		
		System.out.println("Unsorted Array");
		bs.traverseArray(arr);
		
		bs.bubbleSort(arr);
		
		System.out.println("Sorted Array");
		bs.traverseArray(arr);

	}
	
	private void bubbleSort(int[] arr) {
	
		int temp;
		int flag;
		
		for(int i = arr.length - 1; i > 0; i--) {
			
			flag = 0;
			
			for(int j = 0; j < i; j++) {
				
				if(arr[j] > arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					flag = 1;
				}
				
			}
			
			if(flag == 0) break;
		}
			
	}
		
	private void traverseArray(int[] arr){
		System.out.println( Arrays.toString( arr ) );
	}
		
}
